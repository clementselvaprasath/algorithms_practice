package algorithms;

public class CheckPossibility {

	public static void main(String[] args) {
		int[] a = {3,4,2,3};
		System.out.println(checkPossibility(a));
	}
	
	public static boolean checkPossibility(int[] nums) {
		if(nums.length < 2) return true;
        
        int k = 0;
        int count = 0;
        for(int i=1; i<nums.length; i++) {
            if(count > 1) return false;
            if(nums[i] < nums[k]) {
                count++;
                if(k == 0) {
                    k = i;
                } else {
                    k--;
                    i--;
                }
            } else {
                k = i;	
            }
        }
        if(count > 1) return false;
        else return true;
    }

}
