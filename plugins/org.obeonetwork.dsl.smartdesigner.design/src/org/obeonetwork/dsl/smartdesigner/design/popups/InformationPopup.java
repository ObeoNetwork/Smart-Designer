/**
 * Copyright (c) 2013 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 * 
 */
package org.obeonetwork.dsl.smartdesigner.design.popups;

import org.eclipse.jface.dialogs.PopupDialog;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Popup showing an informative text.
 * 
 * This class redefines the getInitialLocation method to show the popup relative
 * to cursor
 * 
 * @author Stephane Drapeau - Obeo
 * 
 */
public class InformationPopup extends PopupDialog {

	/**
	 * Constructs a new instance of <code>PopupDialog</code>.
	 * 
	 * @param parent
	 *            The parent shell.
	 * @param shellStyle
	 *            The shell style.
	 * @param takeFocusOnOpen
	 *            A boolean indicating whether focus should be taken by this
	 *            popup when it opens.
	 * @param persistSize
	 *            A boolean indicating whether the size should be persisted upon
	 *            close of the dialog. The size can only be persisted if the
	 *            dialog settings for persisting the bounds are also specified.
	 *            If a menu action will be provided that allows the user to
	 *            control this feature and the user hasn't changed that setting,
	 *            then this flag is used as initial default for the menu.
	 * @param persistLocation
	 *            A boolean indicating whether the location should be persisted
	 *            upon close of the dialog. The location can only be persisted
	 *            if the dialog settings for persisting the bounds are also
	 *            specified. If a menu action will be provided that allows the
	 *            user to control this feature and the user hasn't changed that
	 *            setting, then this flag is used as initial default for the
	 *            menu. default for the menu until the user changed it.
	 * @param showDialogMenu
	 *            A boolean indicating whether a menu for moving and resizing
	 *            the popup should be provided.
	 * @param showPersistActions
	 *            A boolean indicating whether actions allowing the user to
	 *            control the persisting of the dialog bounds and location
	 *            should be shown in the dialog menu. This parameter has no
	 *            effect if <code>showDialogMenu</code> is <code>false</code>.
	 * @param titleText
	 *            Text to be shown in an upper title area, or <code>null</code>
	 *            if there is no title.
	 * @param infoText
	 *            Text to be shown in a lower info area, or <code>null</code> if
	 *            there is no info area.
	 * 
	 */
	public InformationPopup(Shell parent, int shellStyle,
			boolean takeFocusOnOpen, boolean persistSize,
			boolean persistLocation, boolean showDialogMenu,
			boolean showPersistActions, String titleText, String infoText) {
		super(parent, shellStyle, takeFocusOnOpen, persistSize,
				persistLocation, showDialogMenu, showPersistActions, titleText,
				infoText);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.jface.dialogs.PopupDialog#getInitialLocation(org.eclipse.swt.graphics.Point)
	 */
	@Override
	protected Point getInitialLocation(Point initialSize) {
		// show popup relative to cursor
		Display display = getShell().getDisplay();
		Point location = display.getCursorLocation();
		final int cursorSize = 15;
		location.x += cursorSize;
		location.y += cursorSize;
		return location;
	}

}
