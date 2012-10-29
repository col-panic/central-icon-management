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
package at.medevit.plugin.beta.processor;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.ui.menu.ItemType;
import org.eclipse.e4.ui.model.application.ui.menu.MDirectMenuItem;
import org.eclipse.e4.ui.model.application.ui.menu.MMenuFactory;
import org.eclipse.e4.ui.model.application.ui.menu.MPopupMenu;

import at.medevit.icons.core.Icon;

public class Processor {

	@Inject
	@Named("at.medevit.e4.main.part.table.popupmenu")
	MPopupMenu popupMenu;

	@Execute
	public void execute() {
		MDirectMenuItem deleteItem = MMenuFactory.INSTANCE
				.createDirectMenuItem();
		deleteItem.setType(ItemType.PUSH);
		deleteItem.setLabel("delete item");
		deleteItem.setIconURI(Icon.COMMAND_DELETE.getIconURI());
		deleteItem
				.setContributionURI("bundleclass://at.medevit.plugin.beta/at.medevit.plugin.beta.handler.DeleteHandler");

		popupMenu.getChildren().add(deleteItem);
	}
}
