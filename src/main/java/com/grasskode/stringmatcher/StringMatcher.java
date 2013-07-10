package com.grasskode.stringmatcher;

import java.util.List;

import com.grasskode.radixtree.RadixTree;
import com.grasskode.radixtree.RadixTreeNode;

public class StringMatcher {
	
	RadixTree exact;
	RadixTree prefix;
	
	public StringMatcher() {
		exact = new RadixTree();
		prefix = new RadixTree();
	}
	
	public boolean addExactMatch(String str, int id){
		return exact.add(str, id);
	}
	
	public boolean addPrefixMatch(String str, int id) {
		return prefix.add(str, id);
	}
	
	public int lookup(String str) {
		RadixTreeNode res = null;
		List<RadixTreeNode> result = exact.lookup(str);
		String match = RadixTree.getString(result);
//		System.out.println("exact match : "+match);
		if(str.equals(match) && result.get(result.size()-1).getValue() >= 0){
			res = result.get(result.size()-1);
		} else {
			result = prefix.lookup(str);
//			match = RadixTree.getString(result);
//			System.out.println("prefix match : "+match);
			for(int i = result.size()-1; i>=0; i--){
				if(result.get(i).getValue() >= 0){
					res = result.get(i);
					break;
				}
			}
		}
		if(res == null)
			return -1;
		return res.getValue();
	}
	
	public boolean deleteExactMatch(String str) {
		List<RadixTreeNode> result = exact.lookup(str);
		String match = RadixTree.getString(result);
//		System.out.println("exact match : "+match);
		if(str.equals(match) && result.get(result.size()-1).getValue() >= 0){
			result.get(result.size()-1).setValue(-1);
			return true;
		} 
		return false;
	}
	
	public boolean deletePrefixMatch(String str) {
		List<RadixTreeNode> result = prefix.lookup(str);
		String match = RadixTree.getString(result);
//		System.out.println("exact match : "+match);
		if(str.equals(match) && result.get(result.size()-1).getValue() >= 0){
			result.get(result.size()-1).setValue(-1);
			return true;
		} 
		return false;
	}

}
