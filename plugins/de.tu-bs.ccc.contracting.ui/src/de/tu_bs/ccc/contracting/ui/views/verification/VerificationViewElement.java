package de.tu_bs.ccc.contracting.ui.views.verification;

import de.tu_bs.ccc.contracting.Verification.ViewPoint;

public class VerificationViewElement {
	public enum Result {
	    SUCCESS, FAILED
	}
	
	public enum Property {
	    REALIZABILITY, SUBSTITUTABILITY, WELLFORMEDNESS
	}
	
	private int vp = ViewPoint.FUNCTIONAL_VALUE;
	private String clause = "";
	private String component = "";
	private Object object = null; //object??
	private Result result = Result.FAILED;
	private Property property = Property.REALIZABILITY;
	
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public VerificationViewElement(int vp, String clause, String component, Object object, Result res, Property p) {
		super();
		this.vp = vp;
		this.clause = clause;
		this.component = component;
		this.object = object;
		this.result = res;
		this.property = p;
	}
	
	public boolean success() {
		return result == Result.SUCCESS;
	}
	
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public int getVp() {
		return vp;
	}
	public void setVp(int vp) {
		this.vp = vp;
	}
	public String getClause() {
		return clause;
	}
	public void setClause(String clause) {
		this.clause = clause;
	}
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}

	public String viewPointToString() {
		switch(vp) {
		case ViewPoint.FUNCTIONAL_VALUE:
			return "Functional";
		case ViewPoint.TIMING_VALUE:
			return "Timing";
		case ViewPoint.MEMORY_VALUE:
			return "Memory";
		}
		return "Unknown";
	}
	
	public String propertyToString() {
		switch(property) {
		case REALIZABILITY:
			return "Realizable";
		case SUBSTITUTABILITY:
			return "Substitutable";
		case WELLFORMEDNESS:
			return "Well-formed";
		}
		return "Unknown";
	}

}
