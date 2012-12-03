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

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.swt.graphics.Image;

import at.medevit.icons.Activator;
import at.medevit.icons.urihandler.IconURLConnection;

public enum Icon {
	// @formatter:off
	PART_MAIN, 
	PART_ALPHA, 
	PART_BETA, 
	COMMAND_ADD, 
	COMMAND_EDIT, 
	COMMAND_DELETE,
	DIALOG_FUN, 
	ICON_EMPTY, 
	ICON_SAMPLE, 
	ICON_SAVE_EDIT,
	OVERLAY_ERROR;
	// @formatter:on

	private Icon() {
	}

	/**
	 * Returns an image. Clients do not need to dispose the image, it will be
	 * disposed automatically.
	 * 
	 * @return an {@link Image}
	 */
	public Image getImage(IconSize is) {
		Image image = JFaceResources.getImageRegistry().get(this.name());
		if (image == null) {
			addIconImageDescriptor(this.name(), is);
			image = JFaceResources.getImageRegistry().get(this.name());
		}
		return image;
	}

	/**
	 * @return {@link ImageDescriptor} for the current image
	 */
	public ImageDescriptor getImageDescriptor(IconSize is) {
		ImageDescriptor id = null;
		id = JFaceResources.getImageRegistry().getDescriptor(this.name());
		if (id == null) {
			addIconImageDescriptor(this.name(), is);
			id = JFaceResources.getImageRegistry().getDescriptor(this.name());
		}
		return id;
	}

	/**
	 * @return a string to be embedded as iconURI, see beta plugin process for
	 *         an example
	 */
	public String getIconURI() {
		return "icon://" + name();
	}

	/**
	 * Get the Icon as {@link InputStream}; used by the
	 * {@link IconURLConnection}
	 * 
	 * @param is
	 * @return <code>null</code> if any error in resolving the image
	 * @throws IOException
	 */
	public InputStream getImageAsInputStream(IconSize is) throws IOException {
		InputStream ret = null;

		ResourceBundle iconsetProperties = ResourceBundle.getBundle("iconset");
		String fileName = iconsetProperties.getString(this.name());
		URL url = FileLocator.find(Activator.getDefault().getBundle(),
				new Path("icons/" + is.name + "/" + fileName), null);
		ret = url.openConnection().getInputStream();
		
		return ret;
	}

	/**
	 * Add an image descriptor for a specific key and {@link IconSize} to the
	 * global {@link ImageRegistry}
	 * 
	 * @param name
	 * @param is
	 * @return <code>true</code> if successfully added, else <code>false</code>
	 */
	private static boolean addIconImageDescriptor(String name, IconSize is) {
		try {
			ResourceBundle iconsetProperties = ResourceBundle
					.getBundle("iconset");
			String fileName = iconsetProperties.getString(name);
			URL fileLocation = FileLocator.find(Activator.getDefault()
					.getBundle(),
					new Path("icons/" + is.name + "/" + fileName), null);
			ImageDescriptor id = ImageDescriptor.createFromURL(fileLocation);
			JFaceResources.getImageRegistry().put(name, id);
		} catch (MissingResourceException | IllegalArgumentException e) {
			return false;
		}
		return true;
	}
}
