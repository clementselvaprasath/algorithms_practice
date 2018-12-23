package algorithms.bitmanipulation;

/**
 * Given 3*n + 1 numbers, every numbers occurs triple times except one, find it.
 * 
 * Example Given [1,1,2,3,3,3,2,2,4,1] return 4
 * 
 * Challenge One-pass, constant extra space.
 * 
 * @author qz
 *
 */
public class SingleNumber_II {

	/*
	 * This is a case of a finite state machine. States of machine- Total three
	 * (number appeared once, number appeared twice, number appeared thrice) Action
	 * - Incoming bit of one We will need two bits to keep track of the state. So
	 * lets take those states as 00, 01 and 10. The states will transition like 00
	 * -> 01 -> 10 with every incoming bit. Now lets look at the individual bits.
	 * First bit - 0 -> 0 -> 1 -> back to 0 Second bit - 0 -> 1 -> 0 -> back to 0
	 * Note that these bits are transitioning with every state change. Now we need
	 * to find a pattern of this change.
	 * 
	 * For first bit it is sufficient to say that with every incoming 1 bit, its
	 * next state is its XOR with it with an exception- If second bit is set, the
	 * first bit becomes zero. So we come up with => ones = ones ^ A[i]; if (twos ==
	 * 1) then ones = 0 It condenses to (ones ^ A[i]) & ~twos;
	 * 
	 * For second bit, it is sufficient to say that with every incoming 1 bit, its
	 * next state is its XOR with it with an exception- If the one's bit after the
	 * change above is set, then it will become zero too. So we come up with => twos
	 * = twos ^ A[i]; if (ones* == 1) then twos = 0 It condenses to (twos ^ A[i]) &
	 * ~ones;
	 */

	public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int i : nums) {
            ones = ones ^ i & ~twos;
            twos = twos ^ i & ~ones;
        }
        
        return ones;
    }

}
