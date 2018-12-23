package leetcode.google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a nested list of integers, implement an iterator to flatten it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Notice You don't need to implement the remove method.
 * 
 * Example Given the list
 * [[1,1],2,[1,1]], By calling next repeatedly until hasNext returns false, the
 * order of elements returned by next should be: [1,1,2,1,1].
 * 
 * Given the list [1,[4,[6]]], By calling next repeatedly until hasNext returns
 * false, the order of elements returned by next should be: [1,4,6].
 * 
 * @author qz
 *
 */
public class NestedIterator implements Iterator<Integer> {
	private List<Integer> list;
	private int index;
	
    public NestedIterator(List<NestedInteger> nestedList) {
    	list = new ArrayList<Integer>();
    	initialize(nestedList, list);
    	index = 0;
    }

    private void initialize(List<NestedInteger> nlist, List<Integer> l) {
    	if (nlist.isEmpty()) return;
    	for (NestedInteger ni : nlist) {
    		if (ni.isInteger()) {
    			l.add(ni.getInteger());
    		} else {
    			initialize(ni.getList(), l);
    		}
    	}
    }

    // @return {int} the next element in the iteration
    @Override
    public Integer next() {
    	// Write your code here
    	return list.get(index++);
    }

    // @return {boolean} true if the iteration has more element or false
    @Override
    public boolean hasNext() {
        // Write your code here
    	return index < list.size();
    }

    @Override
    public void remove() {}
}

interface NestedInteger {
	// @return true if this NestedInteger holds a single integer,
	// rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds,
	// if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds,
	// if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList); while (i.hasNext())
 * v.add(i.next());
 */