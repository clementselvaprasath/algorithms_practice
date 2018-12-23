package leetcode.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a string s and a list of strings dict, you need to add a closed pair of
 * bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two
 * such substrings overlap, you need to wrap them together by only one pair of
 * closed bold tag. Also, if two substrings wrapped by bold tags are
 * consecutive, you need to combine them.
 * 
 * Example 1:
	Input: 
	s = "abcxyz123"
	dict = ["abc","123"]
	Output:
	"<b>abc</b>xyz<b>123</b>"
	Example 2:
	Input: 
	s = "aaabbcc"
	dict = ["aaa","aab","bc"]
	Output:
	"<b>aaabbc</b>c"
	Note:
	The given dict won't contain duplicates, and its length won't exceed 100.
	All the strings in input have length in range [1, 1000].
 * 
 * @author qz
 *
 */
public class AddBoldTagInString {

	public static void main(String[] args) {
		AddBoldTagInString obj = new AddBoldTagInString();
		String s = "aaabbcc";
		String[] dict = {"a","b", "c"};
		System.out.println(obj.addBoldTag(s, dict));
	}

	public String addBoldTag(String s, String[] dict) {
		if (s == null || s.length() == 0 || dict.length == 0) return s;
        int size = s.length();
        
        boolean[] bold = new boolean[size];
        StringBuilder sb = new StringBuilder();
        for (String word : dict) {
            int i = 0;
            while (i < size) {
                int index = s.indexOf(word, i);
                if (index >= 0) {
                    for (int j = index; j < index + word.length(); j++) {
                        bold[j] = true;
                    }
                    i = index + 1;
                } else {
                    break;
                }
            }
        }
        
        int i = 0;
        while (i < size) {
            if (!bold[i]) {
                sb.append(s.charAt(i));
                i++;
                continue;
            }
            int j = i + 1;
            while (j < size && bold[j]) {
                j++;
            }
            sb.append("<b>").append(s.substring(i, j)).append("</b>");
            i = j;
        }
     
        return sb.toString();
    }
	
	public String addBoldTag_interval(String s, String[] dict) {
		if (s == null || s.length() == 0) return s;
        List<Interval> intervals = new ArrayList<>();
        // create list of intervals
        for (String str : dict) {
            if (!s.contains(str)) continue;
            int len = str.length();
            int start = s.indexOf(str);
            int end = start + len;
            int i = 1;
            while (start + i < s.length()) {
                String newStr = s.substring(start + i);
                if (newStr.contains(str)) {
                    int nStart = newStr.indexOf(str) + start + i;
                    int nEnd = nStart + len;
                    if (nStart <= end) {
                        end = nEnd;
                    } else {
                        intervals.add(new Interval(start, end));
                        start = nStart;
                        end = nEnd;
                    }
                    i++;
                } else {
                    break;
                }
            }
            intervals.add(new Interval(start, end));
        }
        
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        // merge intervals
        List<Interval> nlist = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start > end) {
                nlist.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(end, interval.end);
            }
        }
        nlist.add(new Interval(start, end));
        
        // add bold tags
        StringBuilder sb = new StringBuilder();
        int lastPos = 0;
        for (Interval interval : nlist) {
        	start = interval.start;
            end = interval.end;
            sb.append(s.substring(lastPos, start)).append("<b>")
                .append(s.substring(start, end))
                .append("</b>");
            lastPos = end;
        }
        sb.append(s.substring(lastPos));
        return sb.toString();
    }
	class Interval {
	    int start;
	    int end;
	    public Interval (int start, int end) {
	        this.start = start;
	        this.end = end;
	    }
	}
}
