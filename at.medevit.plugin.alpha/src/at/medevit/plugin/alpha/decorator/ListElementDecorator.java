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
package at.medevit.plugin.alpha.decorator;

import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelDecorator;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

import at.medevit.icons.core.Icon;
import at.medevit.icons.core.IconSize;
import at.medevit.plugin.alpha.part.PartAlpha;

public class ListElementDecorator implements ILabelDecorator {

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
	public Image decorateImage(Image image, Object element) {
		if (element.equals(PartAlpha.objects[1])) {
			return new DecorationOverlayIcon(image,
					Icon.OVERLAY_ERROR
							.getImageDescriptor(IconSize._7x8_OverlayIconSize),
					IDecoration.BOTTOM_RIGHT).createImage();
		}
		return null;
	}

	@Override
	public String decorateText(String text, Object element) {
		if (element.equals(PartAlpha.objects[1])) {
			return ">" + text;
		}
		return null;
	}

}
