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
package at.medevit.icons.core;

public enum IconSize {
	_16x16_DefaultIconSize("16x16"), 
	_75x66_TitleDialogIconSize("75x66"), 
	_7x8_OverlayIconSize("7x8");

	public String name;

	private IconSize(String name) {
		this.name = name;
	}
}
