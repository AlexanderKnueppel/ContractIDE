package de.tu_bs.ccc.contracting.ui.views.verification;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableColorProvider;
import org.eclipse.jface.viewers.ITableFontProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import de.tu_bs.ccc.contracting.ui.ImageProvider;

public class VerificationViewLabelProvider implements ITableLabelProvider, ITableFontProvider, ITableColorProvider {

	private static Color colorSuccess = new Color(Display.getCurrent(), 131, 247, 175);
	private static Color colorFailure = new Color(Display.getCurrent(), 249, 167, 167);

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		if (element instanceof VerificationViewElement) {
			switch (columnIndex) {
			case 1:
				return ((VerificationViewElement) element).getComponent();
			case 2:
				return ((VerificationViewElement) element).viewPointToString();
			case 3:
				return ((VerificationViewElement) element).propertyToString();
			case 4:
				return ((VerificationViewElement) element).getClause();
			default:
				break;
			}
		} else if (element instanceof VerificationTopElement) {
			switch (columnIndex) {
			case 1:
				return ((VerificationTopElement) element).title();
			default:
				break;
			}
		}
		return null;
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {

		if (element instanceof VerificationViewElement || element instanceof VerificationTopElement) {
			String filename = "";

			if (element instanceof VerificationViewElement) {
				if (((VerificationViewElement) element).success())
					filename = ImageProvider.IMG_ICON_VERIFICATION_SUCCESS;
				else
					filename = ImageProvider.IMG_ICON_VERIFICATION_FAILED;
			} else if (element instanceof VerificationTopElement) {
				if (((VerificationTopElement) element).success())
					filename = ImageProvider.IMG_ICON_VERIFICATION_SUCCESS;
				else
					filename = ImageProvider.IMG_ICON_VERIFICATION_FAILED;
			}

			switch (columnIndex) {
			case 0:
				Bundle bundle = FrameworkUtil.getBundle(this.getClass());
				URL url = FileLocator.find(bundle, new Path(filename), null);
				return resize(ImageDescriptor.createFromURL(url).createImage(), 16, 16);
			default:
				break;
			}
		}
		return null;
	}

	private Image resize(Image image, int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(image, 0, 0, image.getBounds().width, image.getBounds().height, 0, 0, width, height);
		gc.dispose();
		image.dispose(); // don't forget about me!
		return scaled;
	}

	@Override
	public Color getForeground(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getBackground(Object element, int columnIndex) {

		if (element instanceof VerificationViewElement && columnIndex != 0) {
			if (((VerificationViewElement) element).success())
				return colorSuccess;
			else
				return colorFailure;
		} else if (element instanceof VerificationTopElement && columnIndex != 0) {
			if (((VerificationTopElement) element).success())
				return colorSuccess;
			else
				return colorFailure;
		}

		return null;
	}

	@Override
	public Font getFont(Object element, int columnIndex) {
		// ResourceManager resourceManager = new
		// LocalResourceManager(JFaceResources.getResources());
		if (element instanceof VerificationTopElement && columnIndex != 0) {
			return JFaceResources.getFontRegistry().getItalic(JFaceResources.DIALOG_FONT);
		}
		return null;
	}

}
