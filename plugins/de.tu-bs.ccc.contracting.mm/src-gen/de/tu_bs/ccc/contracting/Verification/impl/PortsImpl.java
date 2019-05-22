/**
 */
package de.tu_bs.ccc.contracting.Verification.impl;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.MmPackage;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;

import de.tu_bs.ccc.contracting.Verification.ProviderType;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Ports</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getType <em>Type</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getPorts <em>Ports</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getPortseOpposite <em>Portse Opposite</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getModule <em>Module</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getInsidePorts <em>Inside Ports</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getInsidePortseOpposite <em>Inside Portse Opposite</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getService <em>Service</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getOuterDirection <em>Outer Direction</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getMaxClients <em>Max Clients</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getFunction <em>Function</em>}</li>
 *   <li>{@link de.tu_bs.ccc.contracting.Verification.impl.PortsImpl#getProviderType <em>Provider Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PortsImpl extends MinimalEObjectImpl.Container implements Ports {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final PortType TYPE_EDEFAULT = PortType.JAVA;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected PortType type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPorts() <em>Ports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Ports> ports;

	/**
	 * The cached value of the '{@link #getPortseOpposite() <em>Portse Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPortseOpposite()
	 * @generated
	 * @ordered
	 */
	protected Ports portseOpposite;

	/**
	 * The cached value of the '{@link #getInsidePorts() <em>Inside Ports</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsidePorts()
	 * @generated
	 * @ordered
	 */
	protected EList<Ports> insidePorts;

	/**
	 * The cached value of the '{@link #getInsidePortseOpposite() <em>Inside Portse Opposite</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInsidePortseOpposite()
	 * @generated
	 * @ordered
	 */
	protected Ports insidePortseOpposite;

	/**
	 * The default value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected String service = SERVICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getOuterDirection() <em>Outer Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterDirection()
	 * @generated
	 * @ordered
	 */
	protected static final DirectionType OUTER_DIRECTION_EDEFAULT = DirectionType.INTERNAL;

	/**
	 * The cached value of the '{@link #getOuterDirection() <em>Outer Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterDirection()
	 * @generated
	 * @ordered
	 */
	protected DirectionType outerDirection = OUTER_DIRECTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxClients() <em>Max Clients</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxClients()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_CLIENTS_EDEFAULT = -1;

	/**
	 * The cached value of the '{@link #getMaxClients() <em>Max Clients</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxClients()
	 * @generated
	 * @ordered
	 */
	protected int maxClients = MAX_CLIENTS_EDEFAULT;

	/**
	 * The default value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String FILTER_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected String filter = FILTER_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getFunction() <em>Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getFunction() <em>Function</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunction()
	 * @generated
	 * @ordered
	 */
	protected String function = FUNCTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProviderType() <em>Provider Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderType()
	 * @generated
	 * @ordered
	 */
	protected static final ProviderType PROVIDER_TYPE_EDEFAULT = ProviderType.NATIVE;

	/**
	 * The cached value of the '{@link #getProviderType() <em>Provider Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProviderType()
	 * @generated
	 * @ordered
	 */
	protected ProviderType providerType = PROVIDER_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MmPackage.Literals.PORTS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PortType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(PortType newType) {
		PortType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Ports> getPorts() {
		if (ports == null) {
			ports = new EObjectWithInverseResolvingEList<Ports>(Ports.class, this, MmPackage.PORTS__PORTS,
					MmPackage.PORTS__PORTSE_OPPOSITE);
		}
		return ports;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Ports getPortseOpposite() {
		if (portseOpposite != null && portseOpposite.eIsProxy()) {
			InternalEObject oldPortseOpposite = (InternalEObject) portseOpposite;
			portseOpposite = (Ports) eResolveProxy(oldPortseOpposite);
			if (portseOpposite != oldPortseOpposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MmPackage.PORTS__PORTSE_OPPOSITE,
							oldPortseOpposite, portseOpposite));
			}
		}
		return portseOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ports basicGetPortseOpposite() {
		return portseOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPortseOpposite(Ports newPortseOpposite, NotificationChain msgs) {
		Ports oldPortseOpposite = portseOpposite;
		portseOpposite = newPortseOpposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MmPackage.PORTS__PORTSE_OPPOSITE, oldPortseOpposite, newPortseOpposite);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPortseOpposite(Ports newPortseOpposite) {
		if (newPortseOpposite != portseOpposite) {
			NotificationChain msgs = null;
			if (portseOpposite != null)
				msgs = ((InternalEObject) portseOpposite).eInverseRemove(this, MmPackage.PORTS__PORTS, Ports.class,
						msgs);
			if (newPortseOpposite != null)
				msgs = ((InternalEObject) newPortseOpposite).eInverseAdd(this, MmPackage.PORTS__PORTS, Ports.class,
						msgs);
			msgs = basicSetPortseOpposite(newPortseOpposite, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__PORTSE_OPPOSITE, newPortseOpposite,
					newPortseOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Module getModule() {
		if (eContainerFeatureID() != MmPackage.PORTS__MODULE)
			return null;
		return (Module) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetModule(Module newModule, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newModule, MmPackage.PORTS__MODULE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setModule(Module newModule) {
		if (newModule != eInternalContainer()
				|| (eContainerFeatureID() != MmPackage.PORTS__MODULE && newModule != null)) {
			if (EcoreUtil.isAncestor(this, newModule))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newModule != null)
				msgs = ((InternalEObject) newModule).eInverseAdd(this, MmPackage.MODULE__PORTS, Module.class, msgs);
			msgs = basicSetModule(newModule, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__MODULE, newModule, newModule));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Ports> getInsidePorts() {
		if (insidePorts == null) {
			insidePorts = new EObjectWithInverseResolvingEList<Ports>(Ports.class, this, MmPackage.PORTS__INSIDE_PORTS,
					MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE);
		}
		return insidePorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Ports getInsidePortseOpposite() {
		if (insidePortseOpposite != null && insidePortseOpposite.eIsProxy()) {
			InternalEObject oldInsidePortseOpposite = (InternalEObject) insidePortseOpposite;
			insidePortseOpposite = (Ports) eResolveProxy(oldInsidePortseOpposite);
			if (insidePortseOpposite != oldInsidePortseOpposite) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE,
							oldInsidePortseOpposite, insidePortseOpposite));
			}
		}
		return insidePortseOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ports basicGetInsidePortseOpposite() {
		return insidePortseOpposite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInsidePortseOpposite(Ports newInsidePortseOpposite, NotificationChain msgs) {
		Ports oldInsidePortseOpposite = insidePortseOpposite;
		insidePortseOpposite = newInsidePortseOpposite;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE, oldInsidePortseOpposite, newInsidePortseOpposite);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInsidePortseOpposite(Ports newInsidePortseOpposite) {
		if (newInsidePortseOpposite != insidePortseOpposite) {
			NotificationChain msgs = null;
			if (insidePortseOpposite != null)
				msgs = ((InternalEObject) insidePortseOpposite).eInverseRemove(this, MmPackage.PORTS__INSIDE_PORTS,
						Ports.class, msgs);
			if (newInsidePortseOpposite != null)
				msgs = ((InternalEObject) newInsidePortseOpposite).eInverseAdd(this, MmPackage.PORTS__INSIDE_PORTS,
						Ports.class, msgs);
			msgs = basicSetInsidePortseOpposite(newInsidePortseOpposite, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE,
					newInsidePortseOpposite, newInsidePortseOpposite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setService(String newService) {
		String oldService = service;
		service = newService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__SERVICE, oldService, service));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DirectionType getOuterDirection() {
		return outerDirection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOuterDirection(DirectionType newOuterDirection) {
		DirectionType oldOuterDirection = outerDirection;
		outerDirection = newOuterDirection == null ? OUTER_DIRECTION_EDEFAULT : newOuterDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__OUTER_DIRECTION, oldOuterDirection,
					outerDirection));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMaxClients() {
		return maxClients;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxClients(int newMaxClients) {
		int oldMaxClients = maxClients;
		maxClients = newMaxClients;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__MAX_CLIENTS, oldMaxClients,
					maxClients));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFilter() {
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilter(String newFilter) {
		String oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__FILTER, oldFilter, filter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__LABEL, oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFunction() {
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFunction(String newFunction) {
		String oldFunction = function;
		function = newFunction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__FUNCTION, oldFunction, function));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProviderType getProviderType() {
		return providerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProviderType(ProviderType newProviderType) {
		ProviderType oldProviderType = providerType;
		providerType = newProviderType == null ? PROVIDER_TYPE_EDEFAULT : newProviderType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MmPackage.PORTS__PROVIDER_TYPE, oldProviderType,
					providerType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MmPackage.PORTS__PORTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getPorts()).basicAdd(otherEnd, msgs);
		case MmPackage.PORTS__PORTSE_OPPOSITE:
			if (portseOpposite != null)
				msgs = ((InternalEObject) portseOpposite).eInverseRemove(this, MmPackage.PORTS__PORTS, Ports.class,
						msgs);
			return basicSetPortseOpposite((Ports) otherEnd, msgs);
		case MmPackage.PORTS__MODULE:
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			return basicSetModule((Module) otherEnd, msgs);
		case MmPackage.PORTS__INSIDE_PORTS:
			return ((InternalEList<InternalEObject>) (InternalEList<?>) getInsidePorts()).basicAdd(otherEnd, msgs);
		case MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE:
			if (insidePortseOpposite != null)
				msgs = ((InternalEObject) insidePortseOpposite).eInverseRemove(this, MmPackage.PORTS__INSIDE_PORTS,
						Ports.class, msgs);
			return basicSetInsidePortseOpposite((Ports) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MmPackage.PORTS__PORTS:
			return ((InternalEList<?>) getPorts()).basicRemove(otherEnd, msgs);
		case MmPackage.PORTS__PORTSE_OPPOSITE:
			return basicSetPortseOpposite(null, msgs);
		case MmPackage.PORTS__MODULE:
			return basicSetModule(null, msgs);
		case MmPackage.PORTS__INSIDE_PORTS:
			return ((InternalEList<?>) getInsidePorts()).basicRemove(otherEnd, msgs);
		case MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE:
			return basicSetInsidePortseOpposite(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
		case MmPackage.PORTS__MODULE:
			return eInternalContainer().eInverseRemove(this, MmPackage.MODULE__PORTS, Module.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case MmPackage.PORTS__NAME:
			return getName();
		case MmPackage.PORTS__TYPE:
			return getType();
		case MmPackage.PORTS__PORTS:
			return getPorts();
		case MmPackage.PORTS__PORTSE_OPPOSITE:
			if (resolve)
				return getPortseOpposite();
			return basicGetPortseOpposite();
		case MmPackage.PORTS__MODULE:
			return getModule();
		case MmPackage.PORTS__INSIDE_PORTS:
			return getInsidePorts();
		case MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE:
			if (resolve)
				return getInsidePortseOpposite();
			return basicGetInsidePortseOpposite();
		case MmPackage.PORTS__SERVICE:
			return getService();
		case MmPackage.PORTS__OUTER_DIRECTION:
			return getOuterDirection();
		case MmPackage.PORTS__MAX_CLIENTS:
			return getMaxClients();
		case MmPackage.PORTS__FILTER:
			return getFilter();
		case MmPackage.PORTS__LABEL:
			return getLabel();
		case MmPackage.PORTS__FUNCTION:
			return getFunction();
		case MmPackage.PORTS__PROVIDER_TYPE:
			return getProviderType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case MmPackage.PORTS__NAME:
			setName((String) newValue);
			return;
		case MmPackage.PORTS__TYPE:
			setType((PortType) newValue);
			return;
		case MmPackage.PORTS__PORTS:
			getPorts().clear();
			getPorts().addAll((Collection<? extends Ports>) newValue);
			return;
		case MmPackage.PORTS__PORTSE_OPPOSITE:
			setPortseOpposite((Ports) newValue);
			return;
		case MmPackage.PORTS__MODULE:
			setModule((Module) newValue);
			return;
		case MmPackage.PORTS__INSIDE_PORTS:
			getInsidePorts().clear();
			getInsidePorts().addAll((Collection<? extends Ports>) newValue);
			return;
		case MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE:
			setInsidePortseOpposite((Ports) newValue);
			return;
		case MmPackage.PORTS__SERVICE:
			setService((String) newValue);
			return;
		case MmPackage.PORTS__OUTER_DIRECTION:
			setOuterDirection((DirectionType) newValue);
			return;
		case MmPackage.PORTS__MAX_CLIENTS:
			setMaxClients((Integer) newValue);
			return;
		case MmPackage.PORTS__FILTER:
			setFilter((String) newValue);
			return;
		case MmPackage.PORTS__LABEL:
			setLabel((String) newValue);
			return;
		case MmPackage.PORTS__FUNCTION:
			setFunction((String) newValue);
			return;
		case MmPackage.PORTS__PROVIDER_TYPE:
			setProviderType((ProviderType) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case MmPackage.PORTS__NAME:
			setName(NAME_EDEFAULT);
			return;
		case MmPackage.PORTS__TYPE:
			setType(TYPE_EDEFAULT);
			return;
		case MmPackage.PORTS__PORTS:
			getPorts().clear();
			return;
		case MmPackage.PORTS__PORTSE_OPPOSITE:
			setPortseOpposite((Ports) null);
			return;
		case MmPackage.PORTS__MODULE:
			setModule((Module) null);
			return;
		case MmPackage.PORTS__INSIDE_PORTS:
			getInsidePorts().clear();
			return;
		case MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE:
			setInsidePortseOpposite((Ports) null);
			return;
		case MmPackage.PORTS__SERVICE:
			setService(SERVICE_EDEFAULT);
			return;
		case MmPackage.PORTS__OUTER_DIRECTION:
			setOuterDirection(OUTER_DIRECTION_EDEFAULT);
			return;
		case MmPackage.PORTS__MAX_CLIENTS:
			setMaxClients(MAX_CLIENTS_EDEFAULT);
			return;
		case MmPackage.PORTS__FILTER:
			setFilter(FILTER_EDEFAULT);
			return;
		case MmPackage.PORTS__LABEL:
			setLabel(LABEL_EDEFAULT);
			return;
		case MmPackage.PORTS__FUNCTION:
			setFunction(FUNCTION_EDEFAULT);
			return;
		case MmPackage.PORTS__PROVIDER_TYPE:
			setProviderType(PROVIDER_TYPE_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case MmPackage.PORTS__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case MmPackage.PORTS__TYPE:
			return type != TYPE_EDEFAULT;
		case MmPackage.PORTS__PORTS:
			return ports != null && !ports.isEmpty();
		case MmPackage.PORTS__PORTSE_OPPOSITE:
			return portseOpposite != null;
		case MmPackage.PORTS__MODULE:
			return getModule() != null;
		case MmPackage.PORTS__INSIDE_PORTS:
			return insidePorts != null && !insidePorts.isEmpty();
		case MmPackage.PORTS__INSIDE_PORTSE_OPPOSITE:
			return insidePortseOpposite != null;
		case MmPackage.PORTS__SERVICE:
			return SERVICE_EDEFAULT == null ? service != null : !SERVICE_EDEFAULT.equals(service);
		case MmPackage.PORTS__OUTER_DIRECTION:
			return outerDirection != OUTER_DIRECTION_EDEFAULT;
		case MmPackage.PORTS__MAX_CLIENTS:
			return maxClients != MAX_CLIENTS_EDEFAULT;
		case MmPackage.PORTS__FILTER:
			return FILTER_EDEFAULT == null ? filter != null : !FILTER_EDEFAULT.equals(filter);
		case MmPackage.PORTS__LABEL:
			return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
		case MmPackage.PORTS__FUNCTION:
			return FUNCTION_EDEFAULT == null ? function != null : !FUNCTION_EDEFAULT.equals(function);
		case MmPackage.PORTS__PROVIDER_TYPE:
			return providerType != PROVIDER_TYPE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", service: ");
		result.append(service);
		result.append(", OuterDirection: ");
		result.append(outerDirection);
		result.append(", maxClients: ");
		result.append(maxClients);
		result.append(", filter: ");
		result.append(filter);
		result.append(", label: ");
		result.append(label);
		result.append(", function: ");
		result.append(function);
		result.append(", providerType: ");
		result.append(providerType);
		result.append(')');
		return result.toString();
	}

} //PortsImpl
