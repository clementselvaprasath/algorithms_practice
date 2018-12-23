package algorithms.arrayandlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a width maxWidth, format the text such that each
 * line has exactly maxWidth characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly maxWidth characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. If
 * the number of spaces on a line do not divide evenly between words, the empty
 * slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is
 * inserted between words.
 * 
 * Note:
 * 
 * A word is defined as a character sequence consisting of non-space characters
 * only. Each word's length is guaranteed to be greater than 0 and not exceed
 * maxWidth. The input array words contains at least one word.
 * 
 * Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Example 2:

Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
Example 3:

Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
 * 
 * @author qz
 *
 */
public class TextJustification {

	public static void main(String[] args) {
		TextJustification tj = new TextJustification();
		String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
		List<String> res = tj.fullJustify(words, 20);
		for (String str : res) {
			System.out.println("'" + str + "'");
		}
	}

	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        if (words.length == 0) return res;
        String w = words[0];
        List<String> line = new ArrayList<>();
        line.add(w);
        int len = w.length();
        for (int i = 1; i < words.length; i++) {
        	String s = words[i];
        	if (len + s.length() + 1 <= maxWidth) {
        		len += s.length() + 1;
        		line.add(s);
        	} else {
				res.add(generateLine(line, len, maxWidth));
				w = s;
				len = w.length();
				line.clear();
				line.add(w);
        	}
        }
        StringBuilder sb = new StringBuilder();
        sb.append(line.get(0));
        for (int i = 1; i < line.size(); i++) {
        	sb.append(" ").append(line.get(i));
        }
        sb.append(generateSpaces(maxWidth - len));
        res.add(sb.toString());
        
        return res;
    }
	
	private String generateLine(List<String> line, int len, int maxWidth) {		
		StringBuilder sb = new StringBuilder();
		int totalSpace = maxWidth - (len - line.size() + 1);
		if (line.size() == 1) {
			sb.append(line.get(0)).append(generateSpaces(totalSpace));
			return sb.toString();
		}
		int spaces_size = totalSpace / (line.size() - 1);
		sb.append(line.get(0));
		String spaces = generateSpaces(spaces_size);
		int remain = totalSpace % (line.size() - 1);
		for (int j = 1; j < line.size(); j++) {
			if (remain-- > 0) sb.append(" ");
			sb.append(spaces).append(line.get(j));
		}
		return sb.toString();
	}

    private String generateSpaces(int n) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < n; i++) {
    		sb.append(" ");
    	}
    	return sb.toString();
    }
}
