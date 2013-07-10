package com.grasskode.radixtree;

import java.util.LinkedList;
import java.util.List;

public class RadixTreeNode {
	
	String key;
	int value;
	List<RadixTreeNode> children;
	
	public RadixTreeNode(String key, int value) {
		this.key = key;
		this.value = value;
		this.children = new LinkedList<RadixTreeNode>();
	}
	
	public RadixTreeNode(String key) {
		this.key = key;
		this.value = -1;
		this.children = new LinkedList<RadixTreeNode>();
	}
	
	public String getKey() {
		return key;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean add(int index, String str, int val) {
		String currentkey = String.valueOf(str.charAt(index));
		RadixTreeNode here = null;
		for(RadixTreeNode rtn : children) {
			if(rtn.key.equals(currentkey)){
				here = rtn;
				break;
			}
		}
		
		if(here == null) {
			here = new RadixTreeNode(currentkey);
			children.add(here);
		}
		
		index++;
		if(str.length() == index){
			if(here.value < 0){
				here.value = val;
				return true;
			}
			else return false;
		}
		else
			return here.add(index, str, val);
	}

	public List<RadixTreeNode> lookup(int index, String str, List<RadixTreeNode> result) {
		String currentkey = String.valueOf(str.charAt(index));
		RadixTreeNode here = null;
		for(RadixTreeNode rtn : children) {
			if(rtn.key.equals(currentkey)){
				here = rtn;
				break;
			}
		}
		if(here == null) 
			return result;
		
		result.add(here);
		index++;
		if(index >= str.length())
			return result;
		else
			return here.lookup(index, str, result);
	}

}
