package de.tu_bs.ccc.contracting.core.localization;

public class StringTable {
	public static final String DIAGRAM_FILE_EXTENSION = "cide";
	public static final String MODEL_FILE_EXTENSION = "model";
	public static final String PROJECT_SRC = "src";
	public static final String PROJECT_SRC_SYSTEM = "src/system";
	public static final String PROJECT_SRC_MODEL = "src/repository";

	// Create Feature Strings (on mouse over)
		public static final String CREATE_ABSTRACT_NAME = "Create Abstract";
		public static final String CREATE_ABSTRACT_DESC = "Create an Abstract Component";
		public static final String CREATE_ABSTRACT_DEFAULTNAME= "Default Interface";
		public static final String CREATE_COMPONENT_NAME = "Component";
		public static final String CREATE_COMPONENT_DESC = "Create a normal Component";
		public static final String CREATE_COMPONENT_DEFAULT_NAME = "new Component";
		public static final String CREATE_COMPONENT_DEFAULT_DESC = "default";
		public static final String CREATE_SYSTEM_NAME = "System";
		public static final String CREATE_SYSTEM_DESC = "Create a new System";
		public static final String CREATE_SYSTEM_DEFAULT_NAME = "DEFAULT_NAME";
		public static final String CREATE_CONTRACT_CONNECTION_NAME = "Connect Contract";
		public static final String CREATE_CONTRACT_CONNECTION_DESC = "Connect Contract with Module";
		public static final String CREATE_PORT_NAME = "Port";
		public static final String CREATE_PORT_DEFAULT_NAME = "port";
		public static final String CREATE_PORT_DESC = "Adds a Port to a Module";
		public static final String CREATE_PORT_NOT = "You can not add ports to a component with instances!";
		public static final String CREATE_CONTRACT_NAME = "Contract";
		public static final String CREATE_CONTRACT_DESC = "Create Contract";
		public static final String CREATE_CONTRACT_WINDOW_TEXT = "Chose Contract Dimension";
		public static final String CREATE_CONTRACT_WINDOW_TITLE = "Diemnsion";
		public static final String CONTRACT_ASSUMPTION_DEFAULT_FUNC = "true";
		public static final String CONTRACT_ASSUMPTION_DEFAULT_TIME = "true";
		public static final String CONTRACT_ASSUMPTION_DEFAULT_MEMORY = "true";
		public static final String CONTRACT_GUARANTEE_DEFAULT_FUNC = "true";
		public static final String CONTRACT_GUARANTEE_DEFAULT_MEMORY = "Memory > 0";
		public static final String CONTRACT_GUARANTEE_DEFAULT_TIME = "Minduration > 0";
		public static final String CREATE_PORT_CONNECTION_NAME = "Connect Ports";
		public static final String CREATE_PORT_CONNECTION_DESC = "Use to connect two ports";		
		
		public static final String CONTRACT_GUARANTEES = "Guarantees";

	// GUI-Feature Strings (on mouse over)
		public static final String COLLAPSE_NAME = "Collapse";
		public static final String COLLAPSE_DESC =  "Collapse Figure";
		public static final String EDIT_ABSTRACT_NAME= "Edit Abstract";
		public static final String EDIT_ABSTRACT_DESC = "Edit Abstract Assingment";
	//	noText so far for edit module
	//	public static final String EDIT_MODULE = "cide";
	//	public static final String EDIT_MODULE_SHORT = "cide";
		public static final String EDIT_DESCRIPTION_NAME = "Description";
		public static final String EDIT_DESCRIPTION_DESC = "Edits the Description";
		public static final String COMPONENT_USED= "Component already used";
		public static final String COMPONENT_USED_DELETE = "This component already has instances, do you really want to change it?";
		public static final String COMPONENT_INSTANCE ="Component is an Instance";
		public static final String COMPONENT_INSTANCE_DELETE_PORT="This component is an instance, you shouldn't delete Ports as it this could cause synch problems?";
		public static final String EDIT_PORT_WINDOW_TEXT= "This compoent already has instances, do you really want to change its ports?";
		public static final String EDIT_CONTRACT_WINDOW_TEXT= "This component already has instances, do you really want to change its contracts?";
		public static final String OPEN_EDITOR_REPLACE= "/resource";
		public static final String OPEN_EDITOR_DESC = "Open Module in new Editor";
		public static final String OPEN_EDITOR_NAME= "Open Module";
		public static final String RELOAD_IMPORT_DESC= "Update the Import";
		public static final String VIEWPOINT_VERIFICATION_NAME = "Verify";
		public static final String VIEWPOINT_VERIFICATION_DESC = "Verify Figure";
		public static final String ASSIGN_ABSTRACT = "Assign a Module to a Abstract Component";
		public static final String ASSIGN_ABSTRACT_SHORT = "Assign to Abstract";
		public static final String LOAD_MODULE = "Adds component or interface to a compound.";
		public static final String LOAD_MODULE_SHORT = "Load Module";
	// Update-Feature Reasons Strings (on mouse over)
		public static final String UPDATE_CONTRACT_REASON_TRUE = "Wrong Constraint";
		public static final String UPDATE_CONTRACT_REASON_FALSE = "Name is out of date";
		public static final String UPDATE_MODULE_REASON_PORT = "Port doesn't exist";
		public static final String UPDATE_MODULE_REASON_NOTSYNCHED = "Instance is not synchronized with its original";
		public static final String UPDATE_MODULE_REASON_NAME = "Name or version is out of date!";
		public static final String UPDATE_MODULE_REASON_CONTRACT = "Contract doesn't exist";
		public static final String UPDATE_PORT_REASON = "Name is out of date";

}