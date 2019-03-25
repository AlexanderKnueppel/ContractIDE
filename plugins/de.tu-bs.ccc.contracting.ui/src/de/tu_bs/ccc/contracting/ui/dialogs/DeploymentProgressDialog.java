package de.tu_bs.ccc.contracting.ui.dialogs;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import de.tu_bs.ccc.contracting.ui.ImageProvider;

public class DeploymentProgressDialog extends TitleAreaDialog {
	private static long SLEEP_MILLISECONDS = 1;
	private static int FREQUENCY = 100;

	private Map<String, Integer> dummyChecks = new LinkedHashMap<String, Integer>();
	private Queue<ProgressBar> tasks = new LinkedList<ProgressBar>();
	private Queue<Label> labels = new LinkedList<Label>();

	private Label success;
	private boolean error = false;
	
	private int nDone = 0;

	public DeploymentProgressDialog(Shell parentShell) {
		super(parentShell);

		dummyChecks.put("Compute Delta...", 14);
		dummyChecks.put("Check Well-formedness...", 25);
		dummyChecks.put("Start Re-verification...", 25);
		dummyChecks.put("Check Consistency...", 8);

	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);

		setTitleImage(getShell().getDisplay().getSystemImage(SWT.ICON_WORKING));
		setMessage("Click on the deploy button to start the following checks!", IMessageProvider.INFORMATION);

		setTitle("Deploying to CCC context");

		contents.setSize(300, 300);
		contents.pack();

		return contents;
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

	protected void createButtonsForButtonBar(Composite parent) {
		Button deploy = createButton(parent, IDialogConstants.NO_ID, "Deploy...", false);
		Button ok = createButton(parent, IDialogConstants.OK_ID, "Close", true);

		deploy.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				deploy.setEnabled(false);
				// ok.setEnabled(false);

				while (!tasks.isEmpty()) {
					ProgressBar indicator = tasks.poll();
					Label result = labels.poll();

					for (int i = 0; i < indicator.getMaximum(); i++) {
						indicator.getDisplay().asyncExec(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								if (!indicator.isDisposed()) {
									indicator.setSelection(indicator.getSelection() + 1);
									indicator.update();
									
								}
								try {
									Thread.sleep(FREQUENCY);
								} catch (Throwable th) {
									// Nothing
								}

								Bundle bundle = FrameworkUtil.getBundle(this.getClass());
								URL url = FileLocator.find(bundle,
										new Path(ImageProvider.IMG_ICON_VERIFICATION_SUCCESS), null);
								
								URL failurl = FileLocator.find(bundle,
										new Path(ImageProvider.IMG_ICON_VERIFICATION_FAILED), null);

								if (!result.isDisposed() && indicator.getSelection() == indicator.getMaximum()) {
									try {
										Thread.sleep(FREQUENCY);
									} catch (Throwable th) {
										// Nothing
									}
									
									nDone++;
									
									if(error && nDone == 4) {
										result.setImage(resize(ImageDescriptor.createFromURL(failurl).createImage(), 16, 16));
										indicator.setState(SWT.ERROR);
									} else {
										result.setImage(resize(ImageDescriptor.createFromURL(url).createImage(), 16, 16));
									}
									
									System.out.println(nDone);
									
									if(nDone == dummyChecks.size()) {
										if(!error) {
											MessageBox messageBox = new MessageBox(Display.getDefault().getActiveShell(), SWT.ICON_INFORMATION | SWT.OK);
										    messageBox.setMessage("All static analyses successful and deployment completed!");
										    messageBox.setText("Verification Successful!");
										    int response = messageBox.open();
										} else {
											MessageBox messageBox = new MessageBox(Display.getDefault().getActiveShell(), SWT.ICON_ERROR | SWT.OK);
										    messageBox.setMessage("Static analyses failed and deployment is canceled!");
										    messageBox.setText("Verification Failed!");
										    int response = messageBox.open();
										}
										
									}
								}
							}
						});

					}

				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite contents = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(contents, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout gridLayout = new GridLayout(3, false);
		// gridLayout.numColumns = 3;
		container.setLayout(gridLayout);
		gridLayout.marginHeight = 30;
		gridLayout.marginWidth = 30;

		dummyChecks.forEach((k, v) -> {

			Label result = new Label(container, SWT.NONE);
			result.setText("     ");
			Bundle bundle = FrameworkUtil.getBundle(this.getClass());
			URL url = FileLocator.find(bundle, new Path("icons/watch.png"), null);
			result.setImage(resize(ImageDescriptor.createFromURL(url).createImage(), 16, 16));

			Label label = new Label(container, SWT.NONE);
			label.setText(k);

			ProgressBar indicator = new ProgressBar(container, SWT.SMOOTH);
			indicator.setMaximum(v);

			// result.setText("......");

			tasks.add(indicator);
			labels.add(result);

			GridData gridData1 = new GridData();
			gridData1.minimumWidth = 16;
			GridData gridData2 = new GridData(GridData.FILL_HORIZONTAL);
			GridData gridData3 = new GridData();
			gridData3.grabExcessHorizontalSpace = true;
			gridData3.horizontalAlignment = GridData.FILL;

			//result.setLayoutData(gridData1);
			//label.setLayoutData(gridData2);
			indicator.setLayoutData(gridData3);
		});

		success = new Label(contents, SWT.NONE);
		success.setText("                                                                                    Success!");
		success.setVisible(false);
		success.setForeground(new Color(Display.getDefault(), 0, 100, 0));

		// this.getShell().pack();

		return contents;
	}

	// @Override
	// protected void buttonPressed(int buttonId) {
	// // TODO Auto-generated method stub
	// super.buttonPressed(buttonId);
	// close();
	// }
}