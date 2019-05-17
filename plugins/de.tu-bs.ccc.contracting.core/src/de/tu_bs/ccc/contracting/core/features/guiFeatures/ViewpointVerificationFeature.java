package de.tu_bs.ccc.contracting.core.features.guiFeatures;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.MemoryType;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.platform.IPlatformImageConstants;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.core.verification.IViewpointSolver;
import de.tu_bs.ccc.contracting.core.verification.MemorySolver;
import de.tu_bs.ccc.contracting.ui.views.ViewUtil;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationTopElement;
import de.tu_bs.ccc.contracting.ui.views.verification.VerificationViewElement;

public class ViewpointVerificationFeature extends AbstractCustomFeature {

	public ViewpointVerificationFeature(IFeatureProvider fp) {
		super(fp);
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

	private ArrayList<VerificationViewElement> verifyModule(Module m) {
		List<IViewpointSolver> solvers = new ArrayList<IViewpointSolver>();

		// Register solver
		solvers.add(new MemorySolver());

		ArrayList<VerificationViewElement> results = new ArrayList<VerificationViewElement>();
		for (IViewpointSolver s : solvers) {
			System.out.println(s.getName());

			System.out.print("Substitutability: ");
			long startTime = System.currentTimeMillis();
			if (m instanceof Compound) {
				s.checkSubstitutability((Compound) m);
			}
			long stopTime = System.currentTimeMillis();
			System.out.println(stopTime - startTime + "ms");

			startTime = System.currentTimeMillis();
			System.out.print("WellFormedness: ");
			s.checkWellFormedness((Module) m);
			stopTime = System.currentTimeMillis();
			System.out.println(stopTime - startTime + "ms");

			startTime = System.currentTimeMillis();
			System.out.print("Realizability: ");
			if (!((Module) m).getRealizedBy().isEmpty())
				s.checkRealizability((Module) m);
			stopTime = System.currentTimeMillis();
			System.out.println(stopTime - startTime + "ms\n");

			if (!s.getSummary().isEmpty())
				results.addAll(s.getSummary());
		}
		return results;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement[] pes = context.getPictogramElements();
		if (pes != null && pes.length == 1) {
			Object bo = getBusinessObjectForPictogramElement(pes[0]);

			if (!(bo instanceof Module))
				return;

			ArrayList<VerificationTopElement> results = new ArrayList<VerificationTopElement>();
			
			ArrayList<VerificationViewElement> elems = verifyModule((Module) bo);
			if(!elems.isEmpty())
				results.add(new VerificationTopElement(elems));

			if (bo instanceof Compound) {
				for (Module child : ((Compound) bo).getConsistsOf()) {
					elems = verifyModule(child);
					if(!elems.isEmpty())
						results.add(new VerificationTopElement(elems));
				}
			}
			// Errors first
			results.sort((a, b) -> a.success() ? -1 : 1);
			ViewUtil.updateVerificationView(results);
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

		System.out.println("\nTotal heap peak used: " + total);
	}
}