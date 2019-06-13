package de.tu_bs.ccc.contracting.builder.spring;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

import de.tu_bs.ccc.contracting.Verification.DirectionType;
import de.tu_bs.ccc.contracting.Verification.Module;
import de.tu_bs.ccc.contracting.Verification.PortType;
import de.tu_bs.ccc.contracting.Verification.Ports;
import de.tu_bs.ccc.contracting.core.util.CoreUtil;
import de.tu_bs.ccc.contracting.idl.CidlPersistenceManager;
import de.tu_bs.ccc.contracting.idl.cidl.Argument;
import de.tu_bs.ccc.contracting.idl.cidl.Interface;
import de.tu_bs.ccc.contracting.idl.cidl.Method;
import de.tu_bs.ccc.contracting.idl.cidl.Model;
import de.tu_bs.ccc.contracting.idl.cidl.TypeRef;

public class SpringModelBuilder {

	private IProject newProject, oldProject;
	private List<Module> modules;

	public SpringModelBuilder(IProject newProject, IProject oldProject, List<Module> modules,
			Map<String, String> implementationMap) {
		if (newProject == null || oldProject == null) {
			return;
		}
		this.newProject = newProject;
		this.oldProject = oldProject;
		this.modules = new ArrayList<Module>(modules);
	}

	public void buildModel() throws CoreException, UnsupportedEncodingException {
		for (Module module : modules) {
			for (Ports p : module.getPorts().stream().filter(p -> p.getOuterDirection() == DirectionType.EXTERNAL)
					.collect(Collectors.toList())) {

				// String fqn = module.getName() + "." + p.getName();
				String packageName = module.getName().substring(0, 1) + module.getName().substring(1);
				String controllerName = p.getName().substring(0, 1).toUpperCase() + p.getName().substring(1)
						+ "Controller";

				buildController(packageName, controllerName, p);
			}
		}
	}

	private void buildController(String packageName, String controllerName, Ports p)
			throws CoreException, UnsupportedEncodingException {
		IFolder packageFolder = newProject.getFolder("src/main/java/app").getFolder(packageName);
		if (!packageFolder.exists()) {
			packageFolder.create(false, true, null);
		}

		IFile controller = packageFolder.getFile(controllerName + ".java");
		StringBuilder builder = new StringBuilder();

		builder.append("package app." + packageName + ";\n\n");
		builder.append("import org.springframework.web.bind.annotation.RequestMapping;\n");
		builder.append("import org.springframework.web.bind.annotation.RequestParam;\n");
		builder.append("import org.springframework.web.bind.annotation.RestController;\n\n");

		builder.append("@RestController\n");
		builder.append("public class " + controllerName + " {\n\n");

		if (p.getType().equals(PortType.DATA)) {
			// difficult...
		} else if (p.getType().equals(PortType.SERVICE)) {
			List<Interface> interfaces = CidlPersistenceManager.getIdlModels(oldProject).stream()
					.map(m -> ((Model) m).getInterfaces()).flatMap(i -> i.stream()).collect(Collectors.toList());

			Interface service = interfaces.stream().filter(i -> i.getName().equals(p.getService()))
					.collect(Collectors.toList()).get(0);

			for (Method method : service.getMethods()) {
				String filename = buildDataModel(packageName, packageFolder, method);

				String signature = "";
				for (Argument argument : method.getInArgs()) {
					signature += ", @RequestParam(value=\"" + argument.getName() + "\", defaultValue=\""
							+ defaultValue(argument.getType(), argument.isArray()) + "\") "
							+ decodeType(argument.getType(), argument.isArray()) + " " + argument.getName();
				}

				builder.append("	@RequestMapping(\"/" + packageName + "/" + p.getName() + "/"
						+ method.getName().toLowerCase() + "\")\n");
				builder.append("	public " + filename + " " + method.getName().toLowerCase() + "("
						+ signature.substring(2) + ") {\n");

				signature = "";
				for (Argument argument : method.getOutArgs()) {
					builder.append(
							"		" + decodeType(argument.getType(), argument.isArray()) + " " + argument.getName()
									+ " = " + defaultValue(argument.getType(), argument.isArray()) + ";\n");
					signature += ", " + argument.getName();
				}

				builder.append("		return new " + filename + "(" + signature.substring(2) + ");\n");

				builder.append("	}\n\n");
			}

		}

		builder.append("}");

		byte[] bytes = builder.toString().getBytes(controller.getCharset());
		InputStream source = new ByteArrayInputStream(bytes);
		controller.create(source, IResource.FORCE, null);
	}

	private String buildDataModel(String packageName, IFolder packageFolder, Method method)
			throws UnsupportedEncodingException, CoreException {
		String filename = method.getName().substring(0, 1).toUpperCase() + method.getName().toLowerCase().substring(1);
		IFile controller = packageFolder.getFile(filename + ".java");
		StringBuilder builder = new StringBuilder();

		builder.append("package app." + packageName + ";\n\n");
		builder.append("public class " + filename + " {\n");

		String signature = "";
		for (Argument argument : method.getOutArgs()) {
			builder.append("	private final " + decodeType(argument.getType(), argument.isArray()) + " "
					+ argument.getName() + ";\n");
			signature += ", " + decodeType(argument.getType(), argument.isArray()) + " " + argument.getName();
		}
		builder.append("\n");

		builder.append("	public " + filename + "(" + signature.substring(2) + ") {\n");
		for (Argument argument : method.getOutArgs()) {
			builder.append("		this." + argument.getName() + " = " + argument.getName() + ";\n");
		}
		builder.append("	}\n\n");

		for (Argument argument : method.getOutArgs()) {
			builder.append("	public " + decodeType(argument.getType(), argument.isArray()) + " get"
					+ argument.getName() + "() {\n");
			builder.append("		return " + argument.getName() + ";\n");
			builder.append("	}\n\n");
		}

		builder.append("}\n");

		byte[] bytes = builder.toString().getBytes(controller.getCharset());
		InputStream source = new ByteArrayInputStream(bytes);
		controller.create(source, IResource.FORCE, null);

		return filename;
	}

	private String decodeType(TypeRef type, boolean array) {
		String ex = (!array) ? "" : "[]";

		if (type.getPredefined() != null) {
			switch (type.getPredefined().getName()) {
			case "Int8":
			case "UInt8":
			case "Int16":
			case "UInt16":
			case "Int32":
			case "UInt32":
				return "int" + ex;
			case "Int64":
			case "UInt64":
				return "long" + ex;
			case "Boolean":
				return "boolean" + ex;
			case "String":
				return "string" + ex;
			case "Float":
				return "float" + ex;
			case "Double":
				return "double" + ex;
			case "ByteBuffer":
				return "Byte[]";
			}
		}

		return "";
	}

	private String defaultValue(TypeRef type, boolean array) {
		if (array)
			return "null";

		if (type.getPredefined() != null) {
			switch (type.getPredefined().getName()) {
			case "Int8":
			case "UInt8":
			case "Int16":
			case "UInt16":
			case "Int32":
			case "UInt32":
			case "Int64":
			case "UInt64":
			case "Float":
			case "Double":
				return "0";
			case "Boolean":
				return "true";
			case "String":
				return "";
			case "ByteBuffer":
				return "null";
			}
		}

		return "";
	}
}
