//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.02.11 um 10:27:32 AM CET 
//


package de.tu_bs.ccc.contracting.core.io.ccc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.tu_bs.ccc.contracting.core.io.ccc package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SubsystemTypeProvidesRte_QNAME = new QName("", "rte");
    private final static QName _SubsystemTypeProvidesSpec_QNAME = new QName("", "spec");
    private final static QName _SubsystemTypeProvidesRam_QNAME = new QName("", "ram");
    private final static QName _SubsystemTypeProvidesCaps_QNAME = new QName("", "caps");
    private final static QName _RequiresTypeService_QNAME = new QName("", "service");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.tu_bs.ccc.contracting.core.io.ccc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CompositeType }
     * 
     */
    public CompositeType createCompositeType() {
        return new CompositeType();
    }

    /**
     * Create an instance of {@link CompositeType.Provides }
     * 
     */
    public CompositeType.Provides createCompositeTypeProvides() {
        return new CompositeType.Provides();
    }

    /**
     * Create an instance of {@link CompositeRequiresType }
     * 
     */
    public CompositeRequiresType createCompositeRequiresType() {
        return new CompositeRequiresType();
    }

    /**
     * Create an instance of {@link ProvidesType }
     * 
     */
    public ProvidesType createProvidesType() {
        return new ProvidesType();
    }

    /**
     * Create an instance of {@link FilterType }
     * 
     */
    public FilterType createFilterType() {
        return new FilterType();
    }

    /**
     * Create an instance of {@link BinaryType }
     * 
     */
    public BinaryType createBinaryType() {
        return new BinaryType();
    }

    /**
     * Create an instance of {@link RequiresType }
     * 
     */
    public RequiresType createRequiresType() {
        return new RequiresType();
    }

    /**
     * Create an instance of {@link SubsystemType }
     * 
     */
    public SubsystemType createSubsystemType() {
        return new SubsystemType();
    }

    /**
     * Create an instance of {@link PatternComponentType }
     * 
     */
    public PatternComponentType createPatternComponentType() {
        return new PatternComponentType();
    }

    /**
     * Create an instance of {@link PatternComponentType.Route }
     * 
     */
    public PatternComponentType.Route createPatternComponentTypeRoute() {
        return new PatternComponentType.Route();
    }

    /**
     * Create an instance of {@link TaskType }
     * 
     */
    public TaskType createTaskType() {
        return new TaskType();
    }

    /**
     * Create an instance of {@link TimingType }
     * 
     */
    public TimingType createTimingType() {
        return new TimingType();
    }

    /**
     * Create an instance of {@link SystemType }
     * 
     */
    public SystemType createSystemType() {
        return new SystemType();
    }

    /**
     * Create an instance of {@link SystemType.Child }
     * 
     */
    public SystemType.Child createSystemTypeChild() {
        return new SystemType.Child();
    }

    /**
     * Create an instance of {@link SystemType.Child.Dependency }
     * 
     */
    public SystemType.Child.Dependency createSystemTypeChildDependency() {
        return new SystemType.Child.Dependency();
    }

    /**
     * Create an instance of {@link Xml }
     * 
     */
    public Xml createXml() {
        return new Xml();
    }

    /**
     * Create an instance of {@link RepositoryType }
     * 
     */
    public RepositoryType createRepositoryType() {
        return new RepositoryType();
    }

    /**
     * Create an instance of {@link PlatformType }
     * 
     */
    public PlatformType createPlatformType() {
        return new PlatformType();
    }

    /**
     * Create an instance of {@link ServiceTrafficType }
     * 
     */
    public ServiceTrafficType createServiceTrafficType() {
        return new ServiceTrafficType();
    }

    /**
     * Create an instance of {@link NameType }
     * 
     */
    public NameType createNameType() {
        return new NameType();
    }

    /**
     * Create an instance of {@link RefType }
     * 
     */
    public RefType createRefType() {
        return new RefType();
    }

    /**
     * Create an instance of {@link ServiceType }
     * 
     */
    public ServiceType createServiceType() {
        return new ServiceType();
    }

    /**
     * Create an instance of {@link TrafficType }
     * 
     */
    public TrafficType createTrafficType() {
        return new TrafficType();
    }

    /**
     * Create an instance of {@link PlatformComponentType }
     * 
     */
    public PlatformComponentType createPlatformComponentType() {
        return new PlatformComponentType();
    }

    /**
     * Create an instance of {@link ComponentType }
     * 
     */
    public ComponentType createComponentType() {
        return new ComponentType();
    }

    /**
     * Create an instance of {@link MuxType }
     * 
     */
    public MuxType createMuxType() {
        return new MuxType();
    }

    /**
     * Create an instance of {@link QuantumType }
     * 
     */
    public QuantumType createQuantumType() {
        return new QuantumType();
    }

    /**
     * Create an instance of {@link CommType }
     * 
     */
    public CommType createCommType() {
        return new CommType();
    }

    /**
     * Create an instance of {@link ProtocolType }
     * 
     */
    public ProtocolType createProtocolType() {
        return new ProtocolType();
    }

    /**
     * Create an instance of {@link ProxyType }
     * 
     */
    public ProxyType createProxyType() {
        return new ProxyType();
    }

    /**
     * Create an instance of {@link CompositeType.Pattern }
     * 
     */
    public CompositeType.Pattern createCompositeTypePattern() {
        return new CompositeType.Pattern();
    }

    /**
     * Create an instance of {@link CompositeType.Provides.Service }
     * 
     */
    public CompositeType.Provides.Service createCompositeTypeProvidesService() {
        return new CompositeType.Provides.Service();
    }

    /**
     * Create an instance of {@link CompositeRequiresType.Service }
     * 
     */
    public CompositeRequiresType.Service createCompositeRequiresTypeService() {
        return new CompositeRequiresType.Service();
    }

    /**
     * Create an instance of {@link ProvidesType.Service }
     * 
     */
    public ProvidesType.Service createProvidesTypeService() {
        return new ProvidesType.Service();
    }

    /**
     * Create an instance of {@link FilterType.Add }
     * 
     */
    public FilterType.Add createFilterTypeAdd() {
        return new FilterType.Add();
    }

    /**
     * Create an instance of {@link FilterType.Remove }
     * 
     */
    public FilterType.Remove createFilterTypeRemove() {
        return new FilterType.Remove();
    }

    /**
     * Create an instance of {@link FilterType.Reset }
     * 
     */
    public FilterType.Reset createFilterTypeReset() {
        return new FilterType.Reset();
    }

    /**
     * Create an instance of {@link BinaryType.Component }
     * 
     */
    public BinaryType.Component createBinaryTypeComponent() {
        return new BinaryType.Component();
    }

    /**
     * Create an instance of {@link RequiresType.Service }
     * 
     */
    public RequiresType.Service createRequiresTypeService() {
        return new RequiresType.Service();
    }

    /**
     * Create an instance of {@link SubsystemType.Provides }
     * 
     */
    public SubsystemType.Provides createSubsystemTypeProvides() {
        return new SubsystemType.Provides();
    }

    /**
     * Create an instance of {@link SubsystemType.Requires }
     * 
     */
    public SubsystemType.Requires createSubsystemTypeRequires() {
        return new SubsystemType.Requires();
    }

    /**
     * Create an instance of {@link PatternComponentType.Expose }
     * 
     */
    public PatternComponentType.Expose createPatternComponentTypeExpose() {
        return new PatternComponentType.Expose();
    }

    /**
     * Create an instance of {@link PatternComponentType.Route.Service }
     * 
     */
    public PatternComponentType.Route.Service createPatternComponentTypeRouteService() {
        return new PatternComponentType.Route.Service();
    }

    /**
     * Create an instance of {@link TaskType.Task }
     * 
     */
    public TaskType.Task createTaskTypeTask() {
        return new TaskType.Task();
    }

    /**
     * Create an instance of {@link TaskType.Signal }
     * 
     */
    public TaskType.Signal createTaskTypeSignal() {
        return new TaskType.Signal();
    }

    /**
     * Create an instance of {@link TaskType.Call }
     * 
     */
    public TaskType.Call createTaskTypeCall() {
        return new TaskType.Call();
    }

    /**
     * Create an instance of {@link TimingType.OnTime }
     * 
     */
    public TimingType.OnTime createTimingTypeOnTime() {
        return new TimingType.OnTime();
    }

    /**
     * Create an instance of {@link TimingType.OnSignal }
     * 
     */
    public TimingType.OnSignal createTimingTypeOnSignal() {
        return new TimingType.OnSignal();
    }

    /**
     * Create an instance of {@link TimingType.OnRpc }
     * 
     */
    public TimingType.OnRpc createTimingTypeOnRpc() {
        return new TimingType.OnRpc();
    }

    /**
     * Create an instance of {@link TimingType.Junction }
     * 
     */
    public TimingType.Junction createTimingTypeJunction() {
        return new TimingType.Junction();
    }

    /**
     * Create an instance of {@link SystemType.Child.Dependency.Child }
     * 
     */
    public SystemType.Child.Dependency.Child2 createSystemTypeChildDependencyChild() {
        return new SystemType.Child.Dependency.Child2();
    }

    /**
     * Create an instance of {@link SystemType.Child.Dependency.Function }
     * 
     */
    public SystemType.Child.Dependency.Function createSystemTypeChildDependencyFunction() {
        return new SystemType.Child.Dependency.Function();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rte", scope = SubsystemType.Provides.class)
    public JAXBElement<NameType> createSubsystemTypeProvidesRte(NameType value) {
        return new JAXBElement<NameType>(_SubsystemTypeProvidesRte_QNAME, NameType.class, SubsystemType.Provides.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "spec", scope = SubsystemType.Provides.class)
    public JAXBElement<NameType> createSubsystemTypeProvidesSpec(NameType value) {
        return new JAXBElement<NameType>(_SubsystemTypeProvidesSpec_QNAME, NameType.class, SubsystemType.Provides.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ram", scope = SubsystemType.Provides.class)
    public JAXBElement<QuantumType> createSubsystemTypeProvidesRam(QuantumType value) {
        return new JAXBElement<QuantumType>(_SubsystemTypeProvidesRam_QNAME, QuantumType.class, SubsystemType.Provides.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "caps", scope = SubsystemType.Provides.class)
    public JAXBElement<QuantumType> createSubsystemTypeProvidesCaps(QuantumType value) {
        return new JAXBElement<QuantumType>(_SubsystemTypeProvidesCaps_QNAME, QuantumType.class, SubsystemType.Provides.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "rte", scope = RequiresType.class)
    public JAXBElement<NameType> createRequiresTypeRte(NameType value) {
        return new JAXBElement<NameType>(_SubsystemTypeProvidesRte_QNAME, NameType.class, RequiresType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequiresType.Service }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "service", scope = RequiresType.class)
    public JAXBElement<RequiresType.Service> createRequiresTypeService(RequiresType.Service value) {
        return new JAXBElement<RequiresType.Service>(_RequiresTypeService_QNAME, RequiresType.Service.class, RequiresType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link NameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "spec", scope = RequiresType.class)
    public JAXBElement<NameType> createRequiresTypeSpec(NameType value) {
        return new JAXBElement<NameType>(_SubsystemTypeProvidesSpec_QNAME, NameType.class, RequiresType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "ram", scope = RequiresType.class)
    public JAXBElement<QuantumType> createRequiresTypeRam(QuantumType value) {
        return new JAXBElement<QuantumType>(_SubsystemTypeProvidesRam_QNAME, QuantumType.class, RequiresType.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QuantumType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "caps", scope = RequiresType.class)
    public JAXBElement<QuantumType> createRequiresTypeCaps(QuantumType value) {
        return new JAXBElement<QuantumType>(_SubsystemTypeProvidesCaps_QNAME, QuantumType.class, RequiresType.class, value);
    }

}
