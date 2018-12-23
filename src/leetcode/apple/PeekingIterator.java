package leetcode.apple;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer peekVal;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        peekVal = null;
        this.iterator = iterator;
        if (this.iterator.hasNext()) {
            peekVal = this.iterator.next();
        }
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peekVal;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer val = peekVal;
        if (iterator.hasNext()) {
            peekVal = iterator.next();
        } else {
            peekVal = null;
        }
        return val;
	}

	@Override
	public boolean hasNext() {
	    return peekVal != null;
	}
}
