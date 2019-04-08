package de.tu_bs.ccc.contracting.core.io.ccc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.tu_bs.ccc.contracting.Verification.Abstract;
import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Filter;
import de.tu_bs.ccc.contracting.Verification.Function;
import de.tu_bs.ccc.contracting.Verification.MmFactory;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.ModuleType;
import de.tu_bs.ccc.contracting.Verification.Mux;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.Protocol;
import de.tu_bs.ccc.contracting.Verification.Proxy;
import de.tu_bs.ccc.contracting.Verification.System;
import de.tu_bs.ccc.contracting.core.io.AbstractObjectWriter;

public class CCCExporter extends AbstractObjectWriter<System> {
	private ObjectFactory factory = new ObjectFactory();

	public CCCExporter(System m) {
		setObject(m);
	}

	public List<Module> getModules(System sys) {
		List<Module> result = new ArrayList<Module>();

		for (Module m : sys.getConsistsOf()) {
			result.addAll(getModules(m));
		}

		return result;
	}

	public List<Module> getModules(Module m) {
		List<Module> result = new ArrayList<Module>();
		result.add(m);

		if (m instanceof Compound) {
			Module ref = (Module) EcoreUtil.resolve(m.getModule(), m);

			for (Module child : ((Compound) ref).getConsistsOf()) {
				result.addAll(getModules(child));
			}
		}

		return result;
	}

	protected ProvidesType getProvidesType(Module m) {
		ProvidesType provides = new ProvidesType();

		for (Ports p : m.getPorts()) {

			if (p.getOuterDirection() == DirectionType.EXTERNAL) {
				ProvidesType.Service service = new ProvidesType.Service();
				if (p.getType() == PortType.SERVICE)
					service.setName(p.getService());
				else
					service.setName(p.getType().getLiteral());
				service.setMaxClients(BigInteger.valueOf(p.getMaxClients()));
				service.setFilter(p.getFilter());
				service.setType(p.getProviderType().getName().toLowerCase());
				service.setRef(p.getName());
				provides.getService().add(service);
			}
		}

		return provides;
	}

	protected RequiresType getRequiresType(Module m) {
		RequiresType requires = new RequiresType();

		for (Ports p : m.getPorts()) {
			if (p.getOuterDirection() == DirectionType.INTERNAL) {
				RequiresType.Service service = new RequiresType.Service();
				if (p.getType() == PortType.SERVICE)
					service.setName(p.getService());
				else
					service.setName(p.getType().getLiteral());
				service.setLabel(p.getLabel());
				service.setFilter(p.getFilter());
				service.setFunction(p.getFunction());
				service.setRef(p.getName());

				requires.getServiceOrRteOrSpec().add(factory.createRequiresTypeService(service));
			}
		}

		NameType rte = new NameType();
		rte.setName(m.getRte());
		NameType spec = new NameType();
		spec.setName(m.getSpec());
		QuantumType ram = new QuantumType();
		ram.setQuantum(m.getRam());
		QuantumType caps = new QuantumType();
		caps.setQuantum(m.getCaps());

		requires.getServiceOrRteOrSpec().add(factory.createRequiresTypeRte(rte));
		requires.getServiceOrRteOrSpec().add(factory.createRequiresTypeSpec(rte));
		requires.getServiceOrRteOrSpec().add(factory.createRequiresTypeRam(ram));
		requires.getServiceOrRteOrSpec().add(factory.createRequiresTypeCaps(caps));

		return requires;
	}

	protected CompositeRequiresType getCompositeRequiresType(Module m) {
		CompositeRequiresType requires = new CompositeRequiresType();

		for (Ports p : m.getPorts()) {
			if (p.getOuterDirection() == DirectionType.INTERNAL) {
				CompositeRequiresType.Service service = new CompositeRequiresType.Service();
				if (p.getType() == PortType.SERVICE)
					service.setName(p.getService());
				else
					service.setName(p.getType().getLiteral());
				service.setLabel(p.getLabel());
				service.setFilter(p.getFilter());
				service.setFunction(p.getFunction());
				service.setRef(p.getName());

				requires.getService().add(service);
			}
		}
		return requires;
	}

	protected CompositeType.Provides getCompositeProvidesType(Module m) {
		CompositeType.Provides provides = new CompositeType.Provides();

		for (Ports p : m.getPorts()) {

			if (p.getOuterDirection() == DirectionType.EXTERNAL) {
				CompositeType.Provides.Service service = new CompositeType.Provides.Service();
				if (p.getType() == PortType.SERVICE)
					service.setName(p.getService());
				else
					service.setName(p.getType().getLiteral());
				service.setMaxClients(p.getMaxClients() + ""); // TODO should be integer
				service.setFilter(p.getFilter());
				service.setRef(p.getName());
				provides.getService().add(service);
			}
		}

		return provides;
	}

	protected TimingType getCompositeTimingType(Module m) {
		TimingType timing = new TimingType();

		// TaskType task = new TaskType();

		TaskType.Task t1 = new TaskType.Task();
		t1.setBcet(BigInteger.ZERO);
		t1.setWcet(BigInteger.ZERO);

		TaskType.Signal t2 = new TaskType.Signal();
		t2.setToRef("");

		TaskType.Call t3 = new TaskType.Call();
		t3.setToRef("");
		t3.setMethod("");

		// task.getTaskOrSignalOrCall().add(t1);
		// task.getTaskOrSignalOrCall().add(t2);
		// task.getTaskOrSignalOrCall().add(t3); //TODO really unbounded?

		TimingType.OnTime ontime = new TimingType.OnTime();
		ontime.getTaskOrSignalOrCall().add(t1);
		ontime.setPeriod(BigInteger.ONE);

		TimingType.OnSignal onsignal = new TimingType.OnSignal();
		onsignal.getTaskOrSignalOrCall().add(t2);
		onsignal.setFromRef("");

		TimingType.OnRpc onrpc = new TimingType.OnRpc();
		onrpc.getTaskOrSignalOrCall().add(t3);
		onrpc.setFromRef("");
		onrpc.setMethod("");

		timing.getOnTimeOrOnSignalOrOnRpc().add(ontime);
		timing.getOnTimeOrOnSignalOrOnRpc().add(onsignal);
		timing.getOnTimeOrOnSignalOrOnRpc().add(onrpc);

		return timing;
	}

	protected List<PatternComponentType> getPatternComponentType(Compound m) {

		List<PatternComponentType> comps = new ArrayList<PatternComponentType>();

		for (Module child : m.getConsistsOf()) {
			PatternComponentType pattern = new PatternComponentType();
			pattern.setName(child.getName());
			pattern.setConfig(null); //TODO

			for (Ports port : child.getPorts()) {
				if (port.getOuterDirection() == DirectionType.INTERNAL) {
					PatternComponentType.Route route = new PatternComponentType.Route();
					PatternComponentType.Route.Service service = new PatternComponentType.Route.Service();
					service.setName(port.getService());
					service.setRef(port.getName());

					if (port.getInsidePortseOpposite() != null) {
						RefType ref = new RefType();
						ref.setRef(port.getInsidePortseOpposite().getName());
						service.setExternal(ref);
					} else if (port.getPortseOpposite() != null) {
						NameType n = new NameType();
						n.setName(port.getPortseOpposite().getModule().getName());
						service.setChild(n);
					}

					route.getService().add(service);
					pattern.setRoute(route);
				} else {

					for (Ports outside : port.getInsidePorts()) {
						PatternComponentType.Expose expose = new PatternComponentType.Expose();
						expose.setRef(outside.getName());

						ServiceType st = new ServiceType();
						st.setName(port.getService());
						st.setRef(port.getName());
						expose.setService(st);
						pattern.getExpose().add(expose);
					}

				}
			}

			comps.add(pattern);
		}

		return comps;
	}

	PlatformType getPlatformType() {
		PlatformType pt = new PlatformType();
		// add subsystem zynq
		SubsystemType sub_zynq = new SubsystemType();
		sub_zynq.setName("zynq");

		// Provides spec
		SubsystemType.Provides provides = new SubsystemType.Provides();
		NameType spec = new NameType();
		spec.setName("zync");
		provides.getRteAndSpecAndRam().add(factory.createSubsystemTypeProvidesSpec(spec));

		// Requires comm
		SubsystemType.Requires requires = new SubsystemType.Requires();
		NameType comm = new NameType();
		comm.setName("Network");
		requires.getComm().add(comm);

		// Config
		NameType config = new NameType();
		config.setName("zynq.config");

		sub_zynq.setProvides(provides);
		sub_zynq.setRequires(requires);
		sub_zynq.setConfig(config);

		//pt.getSubsystem().add(sub_zynq);

		CommType ct = new CommType();
		ct.setName("Network");
		pt.getComm().add(ct);
		
		/*Subsystems are now in components*/

		return pt;
	}

	protected void setModuleTypeComponent(ComponentType component, Module m) {
		if (m.getModuleType() instanceof Function) {
			NameType value = new NameType();
			value.setName(((Function) m.getModuleType()).getFunction());
			component.setFunction(value);
		} else if (m.getModuleType() instanceof Proxy) {
			ProxyType value = new ProxyType();
			value.setCarrier(((Proxy) m.getModuleType()).getCarrier());
			component.setProxy(value);
		} else if (m.getModuleType() instanceof Mux) {
			MuxType value = new MuxType();
			value.setService(((Mux) m.getModuleType()).getService());
			component.setMux(value);
		} else if (m.getModuleType() instanceof Filter) {
			FilterType value = new FilterType();
			value.setAlias(((Filter) m.getModuleType()).getAlias());
			value.getAddOrRemoveOrReset().add(((Filter) m.getModuleType()).getAdd());
			value.getAddOrRemoveOrReset().add(((Filter) m.getModuleType()).getRemove());
			value.getAddOrRemoveOrReset().add(((Filter) m.getModuleType()).getReset());
			component.setFilter(value);
		} else if (m.getModuleType() instanceof Protocol) {
			ProtocolType value = new ProtocolType();
			value.setFrom(((Protocol) m.getModuleType()).getFrom());
			value.setTo(((Protocol) m.getModuleType()).getTo());
			component.getProtocol().add(value); // TODO only one protocol right now...
		}
	}

	// TODO code clone...
	protected void setModuleTypeComposite(CompositeType component, Module m) {
		if (m.getModuleType() instanceof Function) {
			NameType value = new NameType();
			value.setName(((Function) m.getModuleType()).getFunction());
			component.setFunction(value);
		} else if (m.getModuleType() instanceof Proxy) {
			ProxyType value = new ProxyType();
			value.setCarrier(((Proxy) m.getModuleType()).getCarrier());
			component.setProxy(value);
		} else if (m.getModuleType() instanceof Mux) {
			MuxType value = new MuxType();
			value.setService(((Mux) m.getModuleType()).getService());
			component.setMux(value);
		} else if (m.getModuleType() instanceof Filter) {
			FilterType value = new FilterType();
			value.setAlias(((Filter) m.getModuleType()).getAlias());
			value.getAddOrRemoveOrReset().add(((Filter) m.getModuleType()).getAdd());
			value.getAddOrRemoveOrReset().add(((Filter) m.getModuleType()).getRemove());
			value.getAddOrRemoveOrReset().add(((Filter) m.getModuleType()).getReset());
			component.setFilter(value);
		} else if (m.getModuleType() instanceof Protocol) {
			ProtocolType value = new ProtocolType();
			value.setFrom(((Protocol) m.getModuleType()).getFrom());
			value.setTo(((Protocol) m.getModuleType()).getTo());
			component.getProtocol().add(value); // TODO only one protocol right now...
		}
	}
	
	private void addComponentToRepository(RepositoryType repo, Module m) {
		if (m instanceof Component) {
			ComponentType component = new ComponentType();
			component.setName(m.getName());
			component.setSingleton(((Component) m).isSingleton());
			component.setVersion(m.getVersion());

			setModuleTypeComponent(component, m);

			component.setRequires(getRequiresType(m));
			component.setProvides(getProvidesType(m));

			repo.getBinaryOrComponentOrComposite().add(component);
		} else if (m instanceof Compound) {

			Module ref = (Module) EcoreUtil.resolve(m.getModule(), m);

			CompositeType composite = new CompositeType();
			composite.setName(ref.getName());

			setModuleTypeComposite(composite, m);

			composite.setRequires(getCompositeRequiresType(ref));
			composite.setProvides(getCompositeProvidesType(ref));
			// composite.setTiming(getCompositeTimingType(m)); //TODO

			CompositeType.Pattern pattern = new CompositeType.Pattern(); // TODO only a single pattern at the
																			// moment...

			pattern.getComponent().addAll(getPatternComponentType((Compound) ref));

			composite.getPattern().add(pattern);

			repo.getBinaryOrComponentOrComposite().add(composite);
		} else if(m instanceof Abstract) {
			Abstract ref = (Abstract) EcoreUtil.resolve(m.getModule(), m);
			for(Module realizer : ref.getRealizes()) {
//				if(realizer instanceof Component) {
//					Compound compound = MmFactory.eINSTANCE.createCompound();
//					compound.setName(ref.getName());
//					compound.setDescription(ref.getDescription());
//					compound.getPorts().addAll(ref.getPorts());
//					compound.setModuleType(ref.getModuleType());
//				}
				if(realizer instanceof Compound) {
					addComponentToRepository(repo, realizer);//TODO currently, realizations are only allowed for compound components
				}
			}
		}
	}

	@Override
	protected String writeToString() {

		if (!(getObject() instanceof System))
			return "";

		System sys = (System) getObject();

		try {

			File file = new File("file.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Xml.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			Xml xml = new Xml();
			RepositoryType repo = new RepositoryType();
			SystemType system = new SystemType();

			// Add binaries
			Map<String, List<Module>> modules = new HashMap<String, List<Module>>();

			getModules(sys).forEach(m -> {
				if (m instanceof Component) {
					if (modules.get(((Component) m).getBinary()) == null)
						modules.put(((Component) m).getBinary(), new ArrayList<Module>());
					modules.get(((Component) m).getBinary()).add(m);
				}
			});

			for (Entry<String, List<Module>> pair : modules.entrySet()) {
				if (pair.getValue().size() == 1 || pair.getKey() == null || pair.getKey() == "") {
					pair.getValue().forEach(m -> {
						BinaryType binary = new BinaryType();
						binary.setName(m.getName());
						repo.getBinaryOrComponentOrComposite().add(binary);
					});
				} else {
					BinaryType binary = new BinaryType();
					binary.setName(pair.getKey());

					pair.getValue().forEach(m -> {
						BinaryType.Component component = new BinaryType.Component();
						component.setName(m.getName());
						component.setVersion(m.getVersion());
						binary.getComponent().add(component);
					});
					repo.getBinaryOrComponentOrComposite().add(binary);
				}
			}

			// Add components
			for (Module m : getModules(sys)) {
				addComponentToRepository(repo, m);
			}

			system.setName(sys.getName());

			for (Module m : sys.getConsistsOf()) {
				SystemType.Child child = new SystemType.Child();
				child.setName(m.getName());

				for (Ports port : m.getPorts()) {
					if (port.getOuterDirection() == DirectionType.INTERNAL) {
						if (port.getPortseOpposite() != null) {
							SystemType.Child.Dependency dep = new SystemType.Child.Dependency();

							SystemType.Child.Dependency.Child2 c2 = new SystemType.Child.Dependency.Child2();
							c2.setName(port.getPortseOpposite().getModule().getName());
							dep.getChildOrFunction().add(c2);
							child.setDependency(dep);
						}
					}
				}

				NameType function = new NameType();
				function.setName("");
				child.setFunction(function);

				system.getChild().add(child);
			}

			xml.setRepository(repo);
			xml.setSystem(system);
			xml.setPlatform(getPlatformType()); // TODO only zynq for now

			jaxbMarshaller.marshal(xml, file);
			jaxbMarshaller.marshal(xml, java.lang.System.out);

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			jaxbMarshaller.marshal(xml, stream);
			return stream.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;

	}
}
