package de.tu_bs.ccc.contracting.ui.views.verification;

import java.util.List;

import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;

public class VerificationViewContentProvider implements ITreeContentProvider {
	private ColumnViewer viewer;

	VerificationViewContentProvider(ColumnViewer viewer) {
		this.viewer = viewer;
	}

	public ColumnViewer getViewer() {
		return viewer;
	}

	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof VerificationTopElement)
			return ((VerificationTopElement) object).getChildren().toArray();
		return null;
	}

	@Override
	public Object[] getElements(Object object) {
		if (object instanceof List<?>)
			return ((List<?>) object).toArray();
		return null;
	}

	@Override
	public Object getParent(Object object) {
		return null;
	}

	@Override
	public boolean hasChildren(Object object) {
		if (object instanceof VerificationTopElement)
			return true;
		return false;
	}
}
