package de.tu_bs.ccc.contracting.core.util;

import java.util.ArrayList;
import java.util.List;

public class PortTypeManager {

	public static List<String> getTypes() {
		List<String> result = new ArrayList<String>();
		result.add("int");
		result.add("int[]");
		result.add("real");
		result.add("real[]");
		result.add("bool");
		result.add("bool[]");
		result.add("String");
		result.add("String[]");
		return result;
	}
}
