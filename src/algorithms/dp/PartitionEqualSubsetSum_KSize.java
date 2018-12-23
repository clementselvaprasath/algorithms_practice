package algorithms.dp;

/**
 * Given an array of integers nums and a positive integer k, 
 * find whether it's possible to divide this array into k non-empty 
 * subsets whose sums are all equal.

Example 1:
Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
Output: True
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Note:

1 <= k <= len(nums) <= 16.
0 < nums[i] < 10000.
 * @author qz
 *
 */
public class PartitionEqualSubsetSum_KSize {

	public static void main(String[] args) {
		int[] nums = {2,2,10,5,2,7,2,2,13};
		int k = 3;
		PartitionEqualSubsetSum_KSize p = new PartitionEqualSubsetSum_KSize();
		System.out.println(p.canPartitionKSubsets(nums, k));
	}

	/**
	 * 解题思路分析

这个题即使k = 2，仍然没有什么除搜索外好的解法，所有的解法时间复杂度都在多项式时间以上，
所以事实上它是一个NP问题 (https://baike.baidu.com/item/NP%E9%97%AE%E9%A2%98/2860567?fr=aladdin)，
更不用说当k > 2时。这里能采用的方法仅仅是不断搜索。但是即使是搜索，也有许多的优化和方式可做，这里给出一种直观的搜索方法，和另一种较快的DP方法。
方法一（常规深度优先搜索）：
很容易想到每一个子集和必须为target = sum(nums) / k，如果除不尽，那么一定会返回False。
先模拟出k个子集，对于nums中最后一个数n，将其弹出。遍历k个子集，只要加入n后，这个子集和不超过target，就把它加入这个子集当中，然后带着当前的选择，继续递归搜索nums（此时nums已不包括n）。
重复上述过程，如果nums最后为空，那么说明搜索成功了。
这种方法十分直观，但是速度很慢，不过有一些加速方法可以采用，这里列举其中一些：
k个子集从前到后递归，如果当前的子集和与前一个子集和相同，那么这个子集就不用试了，因为把n放到这个子集和放到前一个子集没有差别。我们只关心能否搜索到，并不关心具体的分配方案。
先把nums排序，并优先先放入最大的元素，这样能减少许多搜索路径。
一旦找到nums[i] > target，那么就直接返回False。因为如果某一个元素，都超过了target，那么就一定不合题。
复杂度分析：
时间复杂度：O(k ^ N)，其中N时nums的长度，k是子集数。如果采用了优化方案a，则复杂度至少降到O(k ^ (N - k) * k!)，因为一开始会跳过很多和为0的子集，至少前k个元素的搜索次数不超过O(k!)。
空间复杂度：O(N)， 用于函数调用栈。
方法二：（构造一种序列化的搜索，相较方法一，减少冗余；不过该方法难度较大，且不好想）
方法一尽管经过优化，但是理论的时间复杂度仍然很大，其中的重要原因是*存在部分重复的搜索，*当nums和当前所有子集和相同时，之后的搜索运行了不止一次，而且如果只是分组排列不同，其实结果无差别，但在方法一中有可能会继续搜索。
方法一并不能解决这些问题。要解决重复搜索的问题，一种有效的方法是*构造一种序列化的搜索，并对于已搜索过的序列不重复搜索。*由此引出方法二。
同方法一，首先target = sum(nums) / k。接着用变量used表示nums[i]的使用情况，当且仅当nums[i]已经用过时，used的第i位为1。
仍然是搜索，只不过这次的搜索方法是是*寻找一个nums的序列，使得按照这个序列使用nums的元素时，能够正好构造出一个接一个的子集。*接着我们的任务就变成了构造出这样一个序列。
构造过程中，在确定序列中下一个元素时，需要遍历nums中的元素，*只有当used的对应位为0时，才表示这个元素还没有在序列中，*也即还没有用过，可以去考虑这个元素。那么这个没有用过的元素，能否作为序列中的下一个元素呢？
这就需要一个变量todo，表示当前所有未用元素的和，此时序列下一个元素的大小不能超过remain = (todo - 1) % target + 1。这个式子的含义就是todo % target，只不过如果todo % target == 0 时，会得到target。remain也就是序列到目前为止，正在构造的这个子集和，还需要的值。
当nums中的一个元素被认为能作为序列的下一个元素时，就把其对应的used中的位置为1，并让todo减去这个元素值，进行下一次递归搜索。
注意当used给定时，todo是固定的！为了加速搜索过程，可*用一个数组visit记录当前used是否访问过，如果访问过，不用再往下搜索了，直接返回False。*因为如果访问过当前的used并且能搜索成功的话，整个递归栈早就停止搜索返回True了。
当used的所有位全为1时，todo应该是0，此时搜索结束，返回True。
复杂度分析：
时间复杂度：O(N * 2 ^ N)，N是nums的长度，因为只有2 ^ N个used情况，每种情况其自身只需要O(N)的时间去遍历nums。
空间复杂度O(2 ^ N)，主要用于visit数组。

	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return true;
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0 || n < k) return false;
        int target = sum / k;
        
        boolean[] visited = new boolean[1 << n];
        return search(nums, visited, 0, sum, target);
    }

    private boolean search(int[] nums, boolean[] visited, int used, int todo, int target) {
    	if (todo == 0) {
			return true;
    	}

    	if (!visited[used]) {
            visited[used] = true;
            int remain = (todo - 1) % target + 1;
            for (int i = 0; i < nums.length; i++) {
                if (((used >> i) & 1) == 0 && remain >= nums[i]) {
                    if (search(nums, visited, used | 1 << i, todo - nums[i], target)) {
                        return true;
                    }
                }
            }
        }

    	return false;
    }
}
