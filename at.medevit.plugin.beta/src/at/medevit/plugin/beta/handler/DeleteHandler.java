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
package at.medevit.plugin.beta.handler;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;

public class DeleteHandler {
	@Execute
	public void execute() {
		System.out.println(DeleteHandler.class.getName()
				+ " says: \"You're messin' with my Zen-thing man!\"");
	}

	@CanExecute
	public boolean canExecute() {
		return true;
	}

}
