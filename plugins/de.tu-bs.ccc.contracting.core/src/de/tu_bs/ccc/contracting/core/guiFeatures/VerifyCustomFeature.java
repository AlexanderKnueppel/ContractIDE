package de.tu_bs.ccc.contracting.core.guiFeatures;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import solver.CompoundSolver;
import solver.InterfaceSolver;

public class VerifyCustomFeature extends AbstractCustomFeature {

	public VerifyCustomFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		boolean ret = false;
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Module) {
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public String getName() {
		return "Verify";
	}

	@Override
	public String getDescription() {

		return "Verify Figure";
	}

	@Override
	public String getImageId() {
		return IPlatformImageConstants.IMG_ECLIPSE_INFORMATION;
	}

	@Override
	public boolean isAvailable(IContext context) {
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);
			if (bo instanceof Compound) {
				Compound c = (Compound) bo;
				CompoundSolver solver = new CompoundSolver(c);
				long startTime = System.currentTimeMillis();
				solver.checkCompound();
				long stopTime = System.currentTimeMillis();
				long elapsedTime = stopTime - startTime;
				System.out.println(elapsedTime);

				if (solver.checkCompound()) {
					JOptionPane.showMessageDialog(null, "The Component " + c.getName() + " is valid composed",
							"Legal Composition", JOptionPane.INFORMATION_MESSAGE);
				} else {

					{
						JOptionPane.showMessageDialog(null, "The Component " + c.getName()
								+ " is not valid composed! You can Look into the Info file to see a counteraxmple.",
								"Illegal Composition", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else if (bo instanceof Abstract) {
				Abstract intface = (Abstract) bo;
				if (intface.getRealizes().size() != 0) {
					for (Module m : intface.getRealizes()) {

						InterfaceSolver solver = new InterfaceSolver(m, intface);
						long startTime = System.currentTimeMillis();
						boolean valid = solver.validInstance();
						long stopTime = System.currentTimeMillis();
						long elapsedTime = stopTime - startTime;
						System.out.println(elapsedTime);

						if (!valid) {
							JOptionPane.showMessageDialog(null,
									"The Component " + m.getName() + " doesn't  refine Interface " + intface.getName(),
									"No refinenment", JOptionPane.ERROR_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"The Component " + m.getName() + "   refines Interface " + intface.getName(),
									"Refinenment", JOptionPane.INFORMATION_MESSAGE);

						}
					}
				}

				else {
					JOptionPane.showMessageDialog(null, "No Component implments the Interface" + intface.getName(),
							"No refinenment", JOptionPane.ERROR_MESSAGE);

				}
			}
			if (bo instanceof Component || bo instanceof Compound) {
				Module mo = (Module) bo;
				if (mo.getGetsrealized().size() != 0) {
					for (Module m : mo.getGetsrealized()) {

						InterfaceSolver solver = new InterfaceSolver(mo, (Abstract) m);
						long startTime = System.currentTimeMillis();
						boolean valid = solver.validInstance();
						long stopTime = System.currentTimeMillis();
						long elapsedTime = stopTime - startTime;
						System.out.println(elapsedTime);

						if (!valid) {
							JOptionPane.showMessageDialog(null,
									"The Component " + mo.getName() + " doesn't  refine Interface " + m.getName(),
									"No refinenment", JOptionPane.ERROR_MESSAGE);

						} else {
							JOptionPane.showMessageDialog(null,
									"The Component " + mo.getName() + "   refines Interface " + m.getName(),
									"Refinenment", JOptionPane.INFORMATION_MESSAGE);

						}
					}
				}

			}
		}
		List<MemoryPoolMXBean> pools = ManagementFactory.getMemoryPoolMXBeans();
		long total = 0;
		for (MemoryPoolMXBean memoryPoolMXBean : pools) {
			if (memoryPoolMXBean.getType() == MemoryType.HEAP) {
				long peakUsed = memoryPoolMXBean.getPeakUsage().getUsed();
				System.out.println("Peak used for: " + memoryPoolMXBean.getName() + " is: " + peakUsed);
				total = total + peakUsed;
			}
		}

		System.out.println("Total heap peak used: " + total);
	}
}
