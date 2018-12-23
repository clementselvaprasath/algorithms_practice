package datastructure.test;

import datastructure.Trie;

public class TestTrie {

	public static void main(String[] args) {
		String[] ss = {"lintcode", "lint", "code", "jiuzhang", "jiu", "zhan"};

		Trie trie = new Trie();
		for (String s : ss) {
			trie.insert(s);
		}
		
		System.out.println("Search 'lintcode': " + trie.search("lintcode"));
		System.out.println("Search 'code': " + trie.search("code"));
		System.out.println("Search 'jiuzhang': " + trie.search("jiuzhang"));
		System.out.println("Search 'zha': " + trie.search("zha"));
		System.out.println("Search 'jiu': " + trie.search("jiu"));
		System.out.println("Search startWith 'jiuzha': " + trie.startWith("jiuzha"));
		System.out.println("Search startWith 'jiuzhas': " + trie.startWith("jiuzhas"));
	}

}
