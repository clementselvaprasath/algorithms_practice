package algorithms.bitmanipulation;

/**
 * http://www.lintcode.com/en/problem/count-1-in-binary/
 * @author qz
 *
 */
public class Count1InBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            count++;
            num &= num - 1;
        }
        
        return count;
    }
}
