package de.tu_bs.ccc.contracting.core.io.ccc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import de.tu_bs.ccc.contracting.Verification.Component;
import de.tu_bs.ccc.contracting.Verification.Compound;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.core.io.AbstractObjectWriter;
import de.tu_bs.ccc.contracting.core.io.ccc.CompositeType.Pattern;

public class CCCExporter extends AbstractObjectWriter<Module> {

	private ObjectFactory factory = new ObjectFactory();

	public CCCExporter(Module m) {
		setObject(m);
	}

	public List<Module> getModules(Module m) {
		List<Module> result = new ArrayList<Module>();
		result.add(m);

		if (m instanceof Compound) {
			for (Module child : ((Compound) m).getConsistsOf()) {
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
				service.setName(p.getName());
				service.setMaxClients(BigInteger.ONE);
				service.setFilter("");
				service.setType("native");
				service.setRef("");
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
				service.setName(p.getName());
				service.setLabel("");
				service.setFilter("");
				service.setFunction("");
				service.setRef("ref");

				requires.getServiceOrRteOrSpec().add(factory.createRequiresTypeService(service));
			}
		}

		NameType rte = new NameType();
		rte.setName("");
		NameType spec = new NameType();
		spec.setName("");
		QuantumType ram = new QuantumType();
		ram.setQuantum(BigInteger.ZERO);
		QuantumType caps = new QuantumType();
		caps.setQuantum(BigInteger.ZERO);

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
				service.setName(p.getName());
				service.setLabel("");
				service.setFilter("");
				service.setFunction("");
				service.setRef("ref");

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
				service.setName(p.getName());
				service.setMaxClients("1"); // TODO should be integer
				service.setFilter("");
				service.setRef("");
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

	protected PatternComponentType getPatternComponentType(Module m) {
		PatternComponentType pattern = new PatternComponentType();

		for (Module child : ((Compound) m).getConsistsOf()) {
			if (child instanceof Compound)
				pattern.setRequires(getCompositeRequiresType(child));
			pattern.setName(child.getName());
			pattern.setConfig(null);

			PatternComponentType.Expose expose = new PatternComponentType.Expose();
			expose.setRef("");
			// expose.getService().add(...)????? //TODO
			pattern.setExpose(expose);

			PatternComponentType.Route route = new PatternComponentType.Route();

			PatternComponentType.Route.Service service = new PatternComponentType.Route.Service();
			NameType n = new NameType();
			n.setName("Child");
			service.setChild(n);
			service.setName("service_name");
			service.setRef("Ref");
			RefType ref = new RefType();
			ref.setRef("External");
			service.setExternal(ref);

			route.getService().add(service);
			
			pattern.setRoute(route);
		}

		return pattern;
	}

	@Override
	protected String writeToString() {

		if (!(getObject() instanceof Compound))
			return "";

		Compound c = (Compound) getObject();

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
			for (Module m : getModules(c)) {
				BinaryType binary = new BinaryType();
				binary.setName(m.getName());
				BinaryType.Component component = new BinaryType.Component();
				component.setName(m.getName());
				component.setVersion(m.getVersion());
				repo.getBinaryOrComponentOrComposite().add(binary);
			}

			// Add components
			for (Module m : getModules(c)) {

				if (m instanceof Component) {
					ComponentType component = new ComponentType();
					component.setName(m.getName());
					component.setSingleton(true);
					component.setVersion(m.getVersion());

					// TODO function, filter and stuff

					component.setRequires(getRequiresType(m));
					component.setProvides(getProvidesType(m));

					repo.getBinaryOrComponentOrComposite().add(component);
				} else if (m instanceof Compound) {
					CompositeType composite = new CompositeType();
					composite.setName(m.getName());

					composite.setRequires(getCompositeRequiresType(m));
					composite.setProvides(getCompositeProvidesType(m));
					composite.setTiming(getCompositeTimingType(m));
					
					CompositeType.Pattern pattern = new CompositeType.Pattern();
					pattern.getComponent().add(getPatternComponentType(m));
					composite.getPattern().add(pattern);
					
					repo.getBinaryOrComponentOrComposite().add(composite);
				}
			}
			
			system.setName("");

			xml.setRepository(repo);
			xml.setSystem(system);

			jaxbMarshaller.marshal(xml, file);
			jaxbMarshaller.marshal(xml, System.out);

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			jaxbMarshaller.marshal(xml, stream);
			return stream.toString();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] str) {
		new CCCExporter(null).writeToFile(new File("./export.xml"));
	}

}
