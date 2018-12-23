package leetcode.google;

public class GuessNumberGame {

	static int num = 10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * We are playing the Guess Game. The game is as follows:
	 * 
	 * I pick a number from 1 to n. You have to guess which number I picked.
	 * 
	 * Every time you guess wrong, I'll tell you whether the number is higher or
	 * lower.
	 * 
	 * You call a pre-defined API guess(int num) which returns 3 possible
	 * results (-1, 1, or 0):
	 * 
	 * Example n = 10, 
	 * I pick 4 (but you don't know)
	 * Return 4. Correct !
	 */
	
	// Binary search
	public static int guessNumber(int n) {
		long start = 1, end = n, mid = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            long g = guess((int) mid);
            if (g == 0) {
                return (int) mid;
            } else if (g == 1) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
	
	public static int guess (int n) {
		
		return 0;
	}
}
