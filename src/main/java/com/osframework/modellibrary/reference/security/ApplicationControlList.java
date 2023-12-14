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

*/
package com.osframework.modellibrary.reference.security;

import java.util.*;
import javax.swing.*;
import javax.swing.event.*;
import com.osframework.modellibrary.common.*;
import com.osframework.modellibrary.reference.common.*;
import com.osframework.modellibrary.reference.security.*;
import com.osframework.ejb.reference.security.*;
import com.osframework.ejb.reference.common.*;
import com.osframework.framework.logging.*;

/**
null
*/
public class ApplicationControlList extends ResultList implements  Enumeration, java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Vector list = new Vector();
	private ResultColumnList columns = ApplicationControlModel.getResultColumnList();
	private transient Enumeration enumeration = list.elements();
	
	public ApplicationControlList() {
	
	} 

	public ApplicationControlList(int initialCapacity) {
		list = new Vector(initialCapacity);
	}

	public Enumeration elements() {
		enumeration = list.elements();
		return enumeration;
	}
	
	public Object nextElement() {
		return enumeration.nextElement();
	}
	
	public boolean hasMoreElements() {
		return enumeration.hasMoreElements();
	}
	
	
	public void sort() {
		Collections.sort(list);
		
	}

	public void sortList() {
			Collections.sort(list);
		}

	public void add(ApplicationControlModel m) {
		this.list.add(m);
		
	}
	public void addAll(ApplicationControlList list) {
		Enumeration e1 = list.elements();
		while (e1.hasMoreElements()) {
			ApplicationControlModel m = (ApplicationControlModel) e1.nextElement();
			this.list.add(m);
		}
		
	}

	public int size() {
		return this.list.size();
	}

	public int getRowCount() {
		return list.size();
	}

	public int getColumnCount() {
		return columns.getColumnCount();
	}

	public ApplicationControlModel elementAt(int rowIndex) {
			return (ApplicationControlModel) list.get(rowIndex);
	}

	public void remove(ApplicationControlModel m) {
			list.remove(m);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		try {
			ApplicationControlModel m = (ApplicationControlModel) list.get(rowIndex);
			int position = columns.getOriginalPosition(columnIndex);
			return m.getDataAt(position);
		} catch (ResultColumnException e) {
			Debug.LogException(this, e);
			return null;
		}
	}

	public void setModelValueAt(Object o, int rowIndex, int columnIndex) {
		try {
			ApplicationControlModel m = (ApplicationControlModel) list.get(rowIndex);
			int position = columns.getOriginalPosition(columnIndex);
			m.setDataAt(o, position);
		} catch (ResultColumnException e) {
			Debug.LogException(this, e);
		}
	}

	public Comparable getValueAt(int rowIndex) {
		ApplicationControlModel m = (ApplicationControlModel) list.get(rowIndex);
		return m;
	}

	public Class[] getClasses() {
		return columns.getClasses();
	}
	
	public Vector getColumnNames() {
		return columns.getColumnNames();
	}

	public ApplicationControlModel getFirst() {
		if (list.size() > 0) {
			return (ApplicationControlModel) list.elementAt(0);
		} else {
			return new ApplicationControlModel();
		}
	}

	public void setReferenceDisplay(IReferenceMap reference, ISecurity security) {
		Enumeration e1 = list.elements();
		while (e1.hasMoreElements()) {
			ApplicationControlModel m = (ApplicationControlModel) e1.nextElement();
 			m.setReferenceDisplay(reference, security);
		}
	}

	public void setColumnOrder(ApplicationControlList fields) throws ResultColumnException { 
		Enumeration e1 = fields.elements();
		int pos=0;
		while (e1.hasMoreElements()){
			ApplicationControlModel acm = (ApplicationControlModel) e1.nextElement();
			columns.updatePosition(acm.getControlRefDisplay(), pos, acm.getControlText());
			pos++;
		}
		columns.setColumnCount(fields.size());
		if (fields.size()==0) {
			Debug.LogWarning(this, "No columns found, check application security and controls");
		}
	}

	public void resetModified() {
		Enumeration e1 = list.elements();
		while (e1.hasMoreElements()) {
			ApplicationControlModel m = (ApplicationControlModel) e1.nextElement();
 		m.resetModified();
		}
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("ApplicationControlList");
		sb.append("\r\n");
		Enumeration e1 = list.elements();
		while (e1.hasMoreElements()) {
			ApplicationControlModel m = (ApplicationControlModel) e1.nextElement();
				sb.append(m);
				sb.append("\r\n");
		}
		return sb.toString();
	}
}