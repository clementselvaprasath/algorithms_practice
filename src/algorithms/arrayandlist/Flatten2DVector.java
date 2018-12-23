package algorithms.arrayandlist;

import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.

Example:

Input: 2d vector =
[
  [1,2],
  [3],
  [4,5,6]
]
Output: [1,2,3,4,5,6]
Explanation: By calling next repeatedly until hasNext returns false, 
             the order of elements returned by next should be: [1,2,3,4,5,6].
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 * 
 * @author qz
 *
 */
public class Flatten2DVector {
	
	public class Vector2D implements Iterator<Integer> {

	    Iterator<Integer> it;
		Iterator<List<Integer>> lists;
	    public Vector2D(List<List<Integer>> vec2d) {
	        lists = vec2d.iterator();
	        it = null;
	    }

	    @Override
	    public Integer next() {
	        if (!hasNext()) return null;
	        return it.next();
	    }

	    @Override
	    public boolean hasNext() {
	        while ((it == null || !it.hasNext()) && lists.hasNext()) {
	            it = lists.next().iterator();
	        }
	        return it != null && it.hasNext();
	    }
	}
}
