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
package at.medevit.icons.urihandler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.MissingResourceException;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;

import at.medevit.icons.Activator;
import at.medevit.icons.core.Icon;
import at.medevit.icons.core.IconSize;

public class IconURLConnection extends URLConnection {

	String iconName;

	protected IconURLConnection(URL url) {
		super(url);
		iconName = url.getAuthority();
	}

	@Override
	public InputStream getInputStream() throws IOException {
		try {
			Icon selectedIcon = Icon.valueOf(iconName);
			InputStream is = selectedIcon
					.getImageAsInputStream(IconSize._16x16_DefaultIconSize);
			return is;
		} catch (MissingResourceException | IllegalArgumentException e) {
			System.out
					.println("[ERROR] " + IconURLConnection.class.getName()
							+ " " + iconName
							+ " not found, replacing with empty icon.");
			return FileLocator.find(Activator.getDefault().getBundle(),
					new Path("icons/empty.png"), null).openStream();
		}
	}

	@Override
	public void connect() throws IOException {
	}
}
