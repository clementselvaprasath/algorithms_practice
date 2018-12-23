package algorithms.trie;
import java.util.*;
public class PrefixTrieTest {
	public static prefixTrie root = new prefixTrie();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addWord(root, "dsc");
		addWord(root, "cauw");
		addWord(root, "caww");
		addWord(root, "caw");
		addWord(root, "daw");
		addWord(root, "cbqa");
       Set<String> set = findWord(root, "*");
       for(String s:set)
       {
    	   System.out.println(s);
       }
	}
	
	public static void addWord(prefixTrie root, String s)
	{
		if(root == null || s == null || s.length()<= 0) return;
	    char[] c = s.toCharArray();
	    for(int i = 0; i < c.length; i ++)
	    {
	        root.prefixes.add(s);
	        if(root.children[c[i]-'a'] == null)
	        {
	            root.children[c[i]-'a'] = new prefixTrie();
	        }
	        root = root.children[c[i]-'a'];
	    }
	    root.isEnd = true;
	}

	public static Set<String> findWord(prefixTrie root, String pattern)
	{
		if(root == null || pattern == null || pattern.length()<= 0) return null;
		Set<String> matchlist = new HashSet<String>();
		findWord(root, pattern, "", matchlist);
		return matchlist;
	}

	public static void findWord(prefixTrie root, String pattern, String cur, Set<String> matchlist)
	{
		if(root== null || pattern == null) return;
		if(pattern.length()<= 0 && root.isEnd)
		{
		    matchlist.add(cur);
		    return;
		}
		if(pattern.length()<= 0 && root.isEnd == false)return;
		char ch = pattern.charAt(0);
		{
		    if(ch!= '*')
		    {
		        findWord(root.children[ch-'a'], pattern.substring(1), cur+ch, matchlist);
		        return;
		    }
		    else
		    {
	            for(int i = 0; i < 26; i ++)
	            {
	                if(root.children[i] != null)
	                {
	                    findWord(root.children[i], pattern, cur+(char)('a'+i), matchlist);
	                    findWord(root.children[i], pattern.substring(1), cur+(char)('a'+i), matchlist);
	                }
	            }
		    }
		}
	}
}
 class prefixTrie
{
	prefixTrie[] children;
	boolean isEnd;
	ArrayList<String> prefixes;
	prefixTrie()
	{
	    children = new prefixTrie[26];
	    prefixes = new ArrayList<String>();
	}
}