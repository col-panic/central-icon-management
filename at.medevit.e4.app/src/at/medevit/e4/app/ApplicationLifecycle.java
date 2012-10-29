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
package at.medevit.e4.app;

import org.eclipse.e4.ui.workbench.lifecycle.ProcessAdditions;

import at.medevit.icons.urihandler.IconURLStreamHandlerService;

public class ApplicationLifecycle {

	@ProcessAdditions
	public void processAdditions() {
		IconURLStreamHandlerService.getInstance().register();
	}
}
