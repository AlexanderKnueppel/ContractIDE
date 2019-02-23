package de.tu_bs.ccc.contracting.core.mapping;

public class ProjectMapping {
	private static ProjektsImportMapping mapPro= new ProjektsImportMapping();

	public static ProjektsImportMapping getMapPro() {
		return mapPro;
	}

	public static void setMapPro(ProjektsImportMapping mapPro) {
		ProjectMapping.mapPro = mapPro;
	}

	public ProjectMapping() {
		
	}

}
