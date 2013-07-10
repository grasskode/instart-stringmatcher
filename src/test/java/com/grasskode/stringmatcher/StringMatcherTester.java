package com.grasskode.stringmatcher;

public class StringMatcherTester {
	
	public static void main(String[] args) {
		StringMatcher matcher = new StringMatcher();
//		System.out.println(matcher.addExactMatch("contactus", 1));
//		System.out.println(matcher.lookup("contactus"));
//		
//		matcher = new StringMatcher();
//		System.out.println(matcher.addPrefixMatch("img", 1));
//		System.out.println(matcher.lookup("imgcutepuppy"));
//		System.out.println(matcher.lookup("htmlcutepuppy"));
//		
//		matcher = new StringMatcher();
//		System.out.println(matcher.addPrefixMatch("img", 1));
//		System.out.println(matcher.addPrefixMatch("imghd", 2));
//		System.out.println(matcher.lookup("imgcutepuppy"));
//		System.out.println(matcher.lookup("imghdcutepuppy"));
		
		matcher = new StringMatcher();
		matcher.addExactMatch("abc", 908);
		matcher.addPrefixMatch("fas", 907);
		matcher.addPrefixMatch("abc", 901);

		System.out.println(matcher.lookup("abc"));
		System.out.println(matcher.lookup("fast"));

		System.out.println(matcher.deleteExactMatch("abc"));
		System.out.println(matcher.lookup("abc"));
		System.out.println(matcher.deletePrefixMatch("abc"));
		System.out.println(matcher.lookup("abc"));
	}

}
