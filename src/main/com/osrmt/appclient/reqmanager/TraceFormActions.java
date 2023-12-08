/*
    //usage

    Copyright (C) 2006  Aron Lancout Smith

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program; if not, write to the Free Software
    Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA

*/package com.osrmt.appclient.reqmanager;

import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

import com.osrmt.modellibrary.reqmanager.*;
import com.osrmt.appclient.system.*;
import com.osrmt.appclient.services.*;
import com.osframework.appclient.ui.common.*;
import com.osframework.appclient.ui.listeners.*;
import com.osframework.appclient.ui.controls.*;
import com.osframework.modellibrary.reference.common.*;
import com.osrmt.modellibrary.reference.group.*;
import com.osframework.framework.logging.*;
import com.osframework.framework.utility.*;
import com.osframework.appclient.services.*;


/**
null
*/
public class TraceFormActions {

	private TraceFormController controller;

	public ApplicationActionList getActions(TraceFormController c) {
 	controller = c;

		ApplicationActionList actions = new ApplicationActionList();
		/* EXAMPLE 
		actions.addApplicationAction(new ApplicationAction(ActionGroup.REQMGRFILECLOSE,
			new ControlState(){
				public boolean getEnabled() {
					return ApplicationObject.getApplicationProductRefId()>0;
				}
			},
			new UIActionListener(controller.ui) {
			public void actionExecuted(ActionEvent ae) throws Exception {
				ApplicationObject ao = (ApplicationObject) Application.getObject();
				ao.setProductRefId(0);
				controller.buildTree();
			}
		})); */
		return actions;
	}

}