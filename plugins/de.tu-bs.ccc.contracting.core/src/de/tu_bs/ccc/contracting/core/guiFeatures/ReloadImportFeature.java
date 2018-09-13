package de.tu_bs.ccc.contracting.core.guiFeatures;

import java.io.IOException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.platform.IPlatformImageConstants;import com.microsoft.z3.Context;

import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Contract;
import de.tu_bs.ccc.contracting.Verification.Module;

public class ReloadImportFeature extends AbstractCustomFeature {

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Update the Import";
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
		return (bo instanceof Compound&&context.getPictogramElements().length==1);
	}



	@Override
	public String getImageId() {
		// TODO Auto-generated method stub
		return IPlatformImageConstants.IMG_EDIT_EXPAND;
	}

	public ReloadImportFeature(IFeatureProvider fp) {
		super(fp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(ICustomContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElements()[0]);
		if (bo instanceof Compound) {

			 try {
				this.recursiveUpdateCompound((Compound) bo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public boolean recursiveUpdateCompound(Compound m) throws IOException {
		for (Object x : m.getConsitsOf()) {
			
			if (x instanceof Module) {
				Module theMod = (Module) x;

				if (theMod.getModule() != null) {
					System.out.println(((Module) x).getName());
					Module original2 = theMod.getModule();
					org.eclipse.emf.common.util.URI u = original2.eResource().getURI();
					// original2.eResource().unload();

					ResourceSet rSet = new ResourceSetImpl();

					final Resource resource = rSet.getResource(u, true);
					Module original = (Module) resource.getContents().get(0);

					if (original != null) {
						if (original.getContract().size() > theMod.getContract().size()) {
							for (int i = 0; i < original.getContract().size(); i++) {

								Contract c = EcoreUtil.copy(original.getContract().get(i));

								theMod.getContract().add(c);
								System.out.println(c.getModule().toString());
								System.out.println(theMod.toString());
								if (i < theMod.getContract().size()) {

									replaceContract(theMod.getContract().get(0), c);

									EcoreUtil.delete(theMod.getContract().get(0));
								}
							}

						} else if (original.getContract().size() == theMod.getContract().size()) {
							for (int i = 0; i < original.getContract().size(); i++) {

								Contract c = EcoreUtil.copy(original.getContract().get(i));

								theMod.getContract().add(c);

								replaceContract(theMod.getContract().get(0), c);

								EcoreUtil.delete(theMod.getContract().get(0));

							}
						} else if (original.getContract().size() < theMod.getContract().size()) {
							int size = theMod.getContract().size();

							for (int i = 0; i < size; i++) {
								if (i < original.getContract().size()) {
									Contract c = EcoreUtil.copy(original.getContract().get(i));

									theMod.getContract().add(c);

									replaceContract(theMod.getContract().get(0), c);
								}

								EcoreUtil.delete(theMod.getContract().get(0));

							}
						}
					}
				}

			}
			for (PictogramLink p : getDiagram().getPictogramLinks()) {
				if (p.getBusinessObjects().get(0) == x) {
					updatePictogramElement(p.getPictogramElement());
				}
			}
		}
		
		return true;

	}

	public void replaceContract(Contract remove, Contract newContract) {

		for (PictogramLink p : getDiagram().getPictogramLinks()) {
			if (p.getBusinessObjects().get(0) == remove) {
				p.getBusinessObjects().set(0, newContract);
			}
		}
	}

}
