package de.tu_bs.ccc.contracting.ui.views.verification;

import java.util.List;

public class VerificationTopElement {
	private List<VerificationViewElement> children;

	public List<VerificationViewElement> getChildren() {
		return children;
	}

	public void setChildren(List<VerificationViewElement> children) {
		this.children = children;
	}

	public VerificationTopElement(List<VerificationViewElement> children) {
		super();
		this.children = children;
	}

	public boolean success() {
		return !children.stream().anyMatch(c -> !c.success());
	}

	public String title() {
		return children.get(0).getComponent() + " ( " + children.size() + " element"
				+ ((children.size() == 1) ? "" : "s") + ")";
	}
}
