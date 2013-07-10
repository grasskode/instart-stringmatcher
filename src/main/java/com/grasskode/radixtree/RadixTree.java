package com.grasskode.radixtree;

import java.util.LinkedList;
import java.util.List;

public class RadixTree {
	
	RadixTreeNode root;
	
	public RadixTree() {
		root = new RadixTreeNode(null);
	}
	
	public boolean add(String str, int val){
		return root.add(0, str, val);
	}
	
	public List<RadixTreeNode> lookup(String str){
		return root.lookup(0, str, new LinkedList<RadixTreeNode>());
	}
	
	public static String getString(List<RadixTreeNode> lst) {
		StringBuilder sb = new StringBuilder();
		for(RadixTreeNode rtn : lst) {
			if(rtn.key != null)
				sb.append(rtn.key);
		}
		return sb.toString();
	}

}
