package algorithms.other;

/**
 * There are n bulbs that are initially off. You first turn on all the bulbs.
 * Then, you turn off every second bulb. On the third round, you toggle every
 * third bulb (turning on if it's off or turning off if it's on). For the i-th
 * round, you toggle every i bulb. For the n-th round, you only toggle the last
 * bulb. Find how many bulbs are on after n rounds.
 * 
 * Example:
 * 
 * Input: 3 Output: 1 Explanation: At first, the three bulbs are [off, off,
 * off]. After first round, the three bulbs are [on, on, on]. After second
 * round, the three bulbs are [on, off, on]. After third round, the three bulbs
 * are [on, off, off].
 * 
 * So you should return 1, because there is only one bulb is on.
 * 
 * @author qz
 *
 */
public class BulbSwitcher {

	/**
	 * First, we focus on the switch times of every bulb, the odd times one will be
	 * on and the even times one will be off. Second, if i is the factor of n, the
	 * n-th bulb will be switched in i-th turn. We need to count the factor number
	 * of every bulb. Third, if i is the factor of n, then (n / i) is also the
	 * factor of n. So if the number is a perfect square, this number has odd number
	 * factors. Otherwise, this number has even number factors. Finally, this
	 * problem becomes counting the number of perfect square range [1,n]
	 * 
	 * @param n
	 * @return
	 */
	public int bulbSwitch(int n) {
		return (int) Math.sqrt(n);
	}
}
