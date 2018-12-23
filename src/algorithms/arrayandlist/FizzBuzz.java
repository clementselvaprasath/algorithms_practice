package algorithms.arrayandlist;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

	public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        for (int i = 1; i <= n; i++) {
            String s = "";
            if (i % 3 == 0) {
                s += "Fizz";
            }
            if (i % 5 == 0) {
                s += "Buzz";
            }
            if (s.isEmpty()) {
                s += i;
            }
            res.add(s);
        }
        return res;
    }
}
