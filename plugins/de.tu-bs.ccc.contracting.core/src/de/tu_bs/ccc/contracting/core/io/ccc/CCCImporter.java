package de.tu_bs.ccc.contracting.core.io.ccc;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.namespace.QName;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Filter;
import de.tu_bs.ccc.contracting.Verification.Function;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Mux;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.Protocol;
import de.tu_bs.ccc.contracting.Verification.ProviderType;
import de.tu_bs.ccc.contracting.Verification.Proxy;
import de.tu_bs.ccc.contracting.core.io.ccc.CompositeType.Pattern;
import de.tu_bs.ccc.contracting.core.io.ccc.ProvidesType.Service;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.core.util.SaveModuleToFile;

public class CCCImporter {
	private Map<String, Object> _services = new HashMap<String, Object>();
	private Map<String, Component> _components = new HashMap<String, Component>();

	private ObjectFactory factory = new ObjectFactory();

	private IFolder srcFolder;
	private IFolder systemFolder;
	private IFolder repositoryFolder;
	private IFolder serviceFolder;

	public CCCImporter() {

	}

	private void createServiceStubs() {
		IFile services = serviceFolder.getFile("services.cidl");

		String str = "package services\n\n";

		for (String ser : _services.keySet()) {
			str += "interface " + ser + " {}\n\n";
		}

		try {
			InputStream source = new ByteArrayInputStream(str.getBytes());
			if (services.exists()) {
				services.setContents(source, IResource.FORCE, new NullProgressMonitor());
			} else {
				services.create(source, IResource.FORCE, new NullProgressMonitor());
			}
			services.refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void initStructure() {
		IProject project = CoreUtil.getCurrentProject();

		srcFolder = project.getFolder("src");
		systemFolder = project.getFolder("src/system");
		repositoryFolder = project.getFolder("src/repository");
		serviceFolder = project.getFolder("src/services");

		try {
			if (!srcFolder.exists()) {
				srcFolder.create(false, true, null);
			}
			if (!repositoryFolder.exists()) {
				repositoryFolder.create(false, true, null);
			}
			if (!systemFolder.exists()) {
				systemFolder.create(false, true, null);
			}
			if (!serviceFolder.exists()) {
				serviceFolder.create(false, true, null);
			}
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void saveModule(Module m, IFolder folder) throws Exception {
		ResourceSet rSet = new ResourceSetImpl();
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(rSet);
		if (editingDomain == null) {
			// Not yet existing, create one
			editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(rSet);
		}

		SaveModuleToFile operation = new SaveModuleToFile(editingDomain, folder, m);
		editingDomain.getCommandStack().execute(operation);

		editingDomain.dispose();
	}

	public void createCompound(CompositeType ct) {
		Compound c = MmFactory.eINSTANCE.createCompound();

		c.setName(ct.getName());
		c.setDescription("");

		if (ct.getFunction() != null) {
			Function f = MmFactory.eINSTANCE.createFunction();
			f.setFunction(ct.getFunction().getName());
			c.setModuleType(f);
		} else if (ct.getProxy() != null) {
			// Proxy
			Proxy p = MmFactory.eINSTANCE.createProxy();
			p.setCarrier(ct.getProxy().getCarrier());
			c.setModuleType(p);
		} else if (ct.getMux() != null) {
			// Mux
			Mux m = MmFactory.eINSTANCE.createMux();
			m.setService(ct.getMux().getService());
			c.setModuleType(m);
		} else if (ct.getFilter() != null) {
			// Filter
			Filter f = MmFactory.eINSTANCE.createFilter();
			for (Object e : ct.getFilter().getAddOrRemoveOrReset()) {
				if (e instanceof FilterType.Add) {
					f.setAdd(((FilterType.Add) e).getTag());
				} else if (e instanceof FilterType.Remove) {
					f.setRemove(((FilterType.Remove) e).getTag());
				} else if (e instanceof FilterType.Reset) {
					f.setReset(((FilterType.Reset) e).getTag());
				}
			}
			f.setAlias(ct.getFilter().getAlias());
			c.setModuleType(f);
		} else if (ct.getProtocol() != null) {
			// Protocol
			// TODO does not seem to be correct... can there be more than one protocol?
			for (ProtocolType pt : ct.getProtocol()) {
				Protocol p = MmFactory.eINSTANCE.createProtocol();
				p.setFrom(pt.getFrom());
				p.setTo(pt.getTo());
				c.setModuleType(p);
			}
		}

		////// Provided services
		for (CompositeType.Provides.Service service : ct.getProvides().getService()) {
			Ports provided = MmFactory.eINSTANCE.createPorts();
			provided.setOuterDirection(DirectionType.EXTERNAL);

			String ref = service.getRef();
			if (service.getRef() == null) {
				ref = service.getName().toLowerCase() + "_out";
			}
			provided.setName(ref);

			provided.setType(PortType.SERVICE);
			provided.setService(service.getName());
			if (!_services.containsKey(service.getName()))
				_services.put(service.getName(), null);

			if (service.getMaxClients() != null)
				provided.setMaxClients(Integer.getInteger(service.getMaxClients()));

			provided.setFilter(service.getFilter() != null ? service.getFilter() : "");

			provided.setModule(c);
			c.getPorts().add(provided);
		}

		///// Required services
		for (CompositeRequiresType.Service service : ct.getRequires().getService()) {
			// TODO exclude componnents
			Ports required = MmFactory.eINSTANCE.createPorts();
			required.setOuterDirection(DirectionType.INTERNAL);

			String ref = service.getRef();
			if (service.getRef() == null) {
				ref = service.getName().toLowerCase() + "_in";
			}
			required.setName(ref);

			required.setType(PortType.SERVICE);
			required.setService(service.getName());
			if (!_services.containsKey(service.getName()))
				_services.put(service.getName(), null);

			required.setLabel(service.getLabel());
			required.setFilter(service.getFilter());
			required.setFunction(service.getFunction());

			required.setModule(c);
			c.getPorts().add(required);

		}

		///// Add modules (interfaces?)
		for (Pattern pt : ct.getPattern()) {
			for (PatternComponentType pct : pt.getComponent()) {
				Component sub = _components.get(pct.getName());
				sub.setModule(c);
				c.getConsistsOf().add(sub);

				// pct.get
			}
		}

		c.setVersion("1.0");
	}

	public void createComponent(ComponentType ct) {
		Component c = MmFactory.eINSTANCE.createComponent();

		c.setName(ct.getName());
		c.setDescription("");

		if (ct.getFunction() != null) {
			Function f = MmFactory.eINSTANCE.createFunction();
			f.setFunction(ct.getFunction().getName());
			c.setModuleType(f);
		} else if (ct.getProxy() != null) {
			// Proxy
			Proxy p = MmFactory.eINSTANCE.createProxy();
			p.setCarrier(ct.getProxy().getCarrier());
			c.setModuleType(p);
		} else if (ct.getMux() != null) {
			// Mux
			Mux m = MmFactory.eINSTANCE.createMux();
			m.setService(ct.getMux().getService());
			c.setModuleType(m);
		} else if (ct.getFilter() != null) {
			// Filter
			Filter f = MmFactory.eINSTANCE.createFilter();
			for (Object e : ct.getFilter().getAddOrRemoveOrReset()) {
				if (e instanceof FilterType.Add) {
					f.setAdd(((FilterType.Add) e).getTag());
				} else if (e instanceof FilterType.Remove) {
					f.setRemove(((FilterType.Remove) e).getTag());
				} else if (e instanceof FilterType.Reset) {
					f.setReset(((FilterType.Reset) e).getTag());
				}
			}
			f.setAlias(ct.getFilter().getAlias());
			c.setModuleType(f);
		} else if (ct.getProtocol() != null) {
			// Protocol
			// TODO does not seem to be correct... can there be more than one protocol?
			for (ProtocolType pt : ct.getProtocol()) {
				Protocol p = MmFactory.eINSTANCE.createProtocol();
				p.setFrom(pt.getFrom());
				p.setTo(pt.getTo());
				c.setModuleType(p);
			}
		}

		////// Provided services
		for (Service service : ct.getProvides().getService()) {
			Ports provided = MmFactory.eINSTANCE.createPorts();
			provided.setOuterDirection(DirectionType.EXTERNAL);

			String ref = service.getRef();
			if (service.getRef() == null) {
				ref = service.getName().toLowerCase() + "_out";
			}
			provided.setName(ref);

			provided.setType(PortType.SERVICE);
			provided.setService(service.getName());
			if (!_services.containsKey(service.getName()))
				_services.put(service.getName(), null);

			if (service.getMaxClients() != null)
				provided.setMaxClients(service.getMaxClients().intValue());

			provided.setFilter(service.getFilter() != null ? service.getFilter() : "");

			if (service.getType().equals("legacy")) {
				provided.setProviderType(ProviderType.LEGACY);
			} else if (service.getType().equals("network")) {
				provided.setProviderType(ProviderType.NETWORK);
			} else {
				provided.setProviderType(ProviderType.NATIVE);
			}
			provided.setModule(c);
			c.getPorts().add(provided);
		}

		///// Required services
		for (JAXBElement<?> element : ct.getRequires().getServiceOrRteOrSpec()) {

			if (element.getName().equals(new QName("service"))) {
				RequiresType.Service service = (RequiresType.Service) element.getValue();

				// TODO exclude componnents

				Ports required = MmFactory.eINSTANCE.createPorts();
				required.setOuterDirection(DirectionType.INTERNAL);

				String ref = service.getRef();
				if (service.getRef() == null) {
					ref = service.getName().toLowerCase() + "_in";
				}
				required.setName(ref);

				required.setType(PortType.SERVICE);
				required.setService(service.getName());
				if (!_services.containsKey(service.getName()))
					_services.put(service.getName(), null);

				required.setLabel(service.getLabel());
				required.setFilter(service.getFilter());
				required.setFunction(service.getFunction());

				required.setModule(c);
				c.getPorts().add(required);

			} else if (element.getName().equals(new QName("rte"))) {
				c.setRte(((NameType) element.getValue()).getName());
			} else if (element.getName().equals(new QName("spec"))) {
				c.setSpec(((NameType) element.getValue()).getName());
			} else if (element.getName().equals(new QName("ram"))) {
				c.setRam(((QuantumType) element.getValue()).getQuantum());
			} else if (element.getName().equals(new QName("caps"))) {
				c.setCaps(((QuantumType) element.getValue()).getQuantum());
			}
		}
		// c.setBinary(value);

		c.setVersion(ct.getVersion() != null ? ct.getVersion() : "1.0");
		c.setSingleton(ct.isSingleton() != null ? ct.isSingleton() : false);

		try {
			saveModule(c, repositoryFolder);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		_components.put(c.getName(), c);
	}

	public void handleRepository(RepositoryType repo) {
		// Start with binaries
		List<BinaryType> binaries = repo.getBinaryOrComponentOrComposite().stream().filter(x -> x instanceof BinaryType)
				.map(x -> (BinaryType) x).collect(Collectors.toList());
		List<ComponentType> components = repo.getBinaryOrComponentOrComposite().stream()
				.filter(x -> x instanceof ComponentType).map(x -> (ComponentType) x).collect(Collectors.toList());
		List<CompositeType> compounds = repo.getBinaryOrComponentOrComposite().stream()
				.filter(x -> x instanceof CompositeType).map(x -> (CompositeType) x).collect(Collectors.toList());

		for (BinaryType bt : binaries) {
			System.out.println(bt.getName());
		}

		components.forEach(this::createComponent);
	}

	public void handleSystem(SystemType sys) {
		// for(List<List<Object>> elements : repo.getBinaryOrComponentOrComposite()) {
		//
		// }
	}

	public void createFiles(IProject p) {

		try {
			FileDialog dialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
			dialog.setFilterExtensions(new String[] { "*.xml" });
			dialog.setFilterPath("c:\\temp");
			String result = dialog.open();
			java.lang.System.out.println(result);
			File file = new File(result);
			JAXBContext jaxbContext = JAXBContext.newInstance(Xml.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			initStructure();

			Xml xml = (Xml) jaxbUnmarshaller.unmarshal(file);

			// Handle the repository
			handleRepository(xml.getRepository());
			// Handle the system
			handleSystem(xml.getSystem());

			createServiceStubs();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			File file = new File("example_object_recognition.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Xml.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

			Xml xml = (Xml) jaxbUnmarshaller.unmarshal(file);

			CCCImporter imp = new CCCImporter();
			// Handle the repository
			imp.handleRepository(xml.getRepository());
			// Handle the system
			imp.handleSystem(xml.getSystem());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
