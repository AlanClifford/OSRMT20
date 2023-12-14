package com.osframework.appclient.ui.tree;

import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;

import javax.swing.*;
import javax.swing.tree.*;

import com.osframework.appclient.services.ReferenceServices;
import com.osframework.framework.logging.Debug;

public abstract class UIDragDropListener implements DropTargetListener {
	
	private UIScrollTree tree;
	private DragSource dragSource = DragSource.getDefaultDragSource() ;

	public UIDragDropListener(UIScrollTree tree) {
		super();
		this.tree = tree;
	}

	public void dragEnter(DropTargetDragEvent dtde) {
	}

	public void dragOver(DropTargetDragEvent dtde) {
	}

	public void dropActionChanged(DropTargetDragEvent dtde) {
	}

	public void dragExit(DropTargetEvent dte) {
	}

	public void drop(DropTargetDropEvent e) {
		try {
	      Point loc = e.getLocation();
	      TreePath destinationPath = tree.getTree().getPathForLocation(loc.x, loc.y);
	      if (destinationPath != null) {
		      UITreeNode newparent =
			        (UITreeNode) destinationPath.getLastPathComponent();
		      if (tree.getSelectedNodes() != null) {
		    	  UITreeNode[] nodes = new UITreeNode[tree.getSelectedNodes().length];
		    	  for (int i=0; i< tree.getSelectedNodes().length; i++) {
		    		  nodes[i] = (UITreeNode) tree.getSelectedNodes()[i];
		    	  }
			      if (!dropTarget(newparent, nodes )) {
			    	  e.rejectDrop();
			      }
		      }
	      } else {
	    	  e.rejectDrop();
	      }
		} catch (Exception ex) {
			Debug.LogException(this, ex);
		}
	}
		  
	public abstract boolean dropTarget(UITreeNode newparent, UITreeNode[] nodesDragged);

}
