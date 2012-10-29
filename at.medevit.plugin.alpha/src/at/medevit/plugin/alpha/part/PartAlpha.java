/*******************************************************************************
 * Copyright (c) 2012 Marco Descher.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Marco Descher - initial API and implementation
 ******************************************************************************/
package at.medevit.plugin.alpha.part;

import javax.annotation.PostConstruct;

import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import at.medevit.icons.core.Icon;
import at.medevit.icons.core.IconSize;
import at.medevit.plugin.alpha.decorator.ListElementDecorator;
import at.medevit.plugin.alpha.dialog.FunTitleAreaDialog;

public class PartAlpha {
	final public static String[] objects = new String[] { "abc", "def", "ghi",
			"jkl", "mno" };

	@PostConstruct
	public void createComposite(Composite parent) {
		final Shell shell = parent.getShell();
		parent.setLayout(new FillLayout(SWT.VERTICAL));

		Label labelImage = new Label(parent, SWT.None);
		labelImage.setImage(Icon.PART_BETA
				.getImage(IconSize._16x16_DefaultIconSize));

		Button dialogButton = new Button(parent, SWT.None);
		dialogButton.setText("Open Dialog");

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new TableColumnLayout());

		// ---- Decorated Label Provider demonstration
		TableViewer tableViewer = new TableViewer(composite, SWT.BORDER
				| SWT.FULL_SELECTION);
		dialogButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FunTitleAreaDialog ftad = new FunTitleAreaDialog(shell);
				ftad.open();
			}
		});
		tableViewer.setContentProvider(ArrayContentProvider.getInstance());
		ILabelProvider baseLabelProvider = new LabelProvider() {
			@Override
			public Image getImage(Object element) {
				return Icon.ICON_SAMPLE
						.getImage(IconSize._16x16_DefaultIconSize);
			}
		};
		ILabelDecorator decorator = new ListElementDecorator();
		tableViewer.setLabelProvider(new DecoratingLabelProvider(
				baseLabelProvider, decorator));
		tableViewer.setInput(objects);
		// ---- Decorated Label Provider demonstration
	}
}
