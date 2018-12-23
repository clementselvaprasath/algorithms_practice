package leetcode.google;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * A Range Module is a module that tracks ranges of numbers. Your task is to
 * design and implement the following interfaces in an efficient manner.
 * 
 * addRange(int left, int right) Adds the half-open interval [left, right),
 * tracking every real number in that interval. Adding an interval that
 * partially overlaps with currently tracked numbers should add any numbers in
 * the interval [left, right) that are not already tracked. queryRange(int left,
 * int right) Returns true if and only if every real number in the interval
 * [left, right) is currently being tracked. removeRange(int left, int right)
 * Stops tracking every real number currently being tracked in the interval
 * [left, right).
 * 
 * Example 1: addRange(10, 20): null removeRange(14, 16): null queryRange(10,
 * 14): true (Every number in [10, 14) is being tracked) queryRange(13, 15):
 * false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
 * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked,
 * despite the remove operation) Note:
 * 
 * A half open interval [left, right) denotes all real numbers left <= x <
 * right. 0 < left < right < 10^9 in all calls to addRange, queryRange,
 * removeRange. The total number of calls to addRange in a single test case is
 * at most 1000. The total number of calls to queryRange in a single test case
 * is at most 5000. The total number of calls to removeRange in a single test
 * case is at most 1000.
 * 
 * @author qz
 *
 */
public class RangeModule {

	TreeSet<Interval> set;
    
    public RangeModule() {
        set = new TreeSet<>((a, b) -> a.right - b.right);
    }
    
    public void addRange(int left, int right) {
        Set<Interval> tail = set.tailSet(new Interval(0, left));
        if (tail == null || tail.isEmpty()) set.add(new Interval(left, right));
        else {
            Set<Interval> removeSet = new HashSet<>();
            for (Interval interval : tail) {
                if (left <= interval.right && right >= interval.left) {
                    left = Math.min(interval.left, left);
                    right = Math.max(interval.right, right);
                    removeSet.add(interval);
                } else {
                    break;
                }
            }
            set.removeAll(removeSet);
            set.add(new Interval(left, right));
        }
    }
    
    public boolean queryRange(int left, int right) {
        for (Interval interval : set) {
            if (interval.left > right) break;
            if (interval.left <= left && interval.right >= right) return true;
        }
        return false;
    }
    
    public void removeRange(int left, int right) {
        Set<Interval> subSet = set.tailSet(new Interval(0, left));
        if (subSet == null || subSet.isEmpty()) return;
        else {
            Set<Interval> addSet = new HashSet<Interval>();
            Set<Interval> removeSet = new HashSet<Interval>();
            for (Interval interval : subSet) {
                if (left <= interval.right && right >= interval.left) {
                    if (left > interval.left) {
                        addSet.add(new Interval(interval.left, left));
                    }
                    if (right < interval.right) {
                        addSet.add(new Interval(right, interval.right));
                    }
                    removeSet.add(interval);
                } else {
                    break;
                }
            }
            set.removeAll(removeSet);
            set.addAll(addSet);
        }
    }
    class Interval {
        int left, right;
        public Interval (int start, int end) {
            this.left = start;
            this.right = end;
        }
    }
}
