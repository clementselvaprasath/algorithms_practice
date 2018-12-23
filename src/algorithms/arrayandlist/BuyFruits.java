package algorithms.arrayandlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Xiao Ming is going to help companies buy fruit. Give a codeList, which is
 * loaded with the fruit he bought. Give a shoppingCart, which is loaded with
 * target fruit. We need to check if the order in the codeList matches the order
 * in the shoppingCart. Note that only the sum of the items in all linked lists
 * in the codeList add up to less than or equal to the sum of items in the
 * shoppingcart may return 1. In addition, the item in codeList may be
 * "anything", which can match with any fruit.
 * 
 * Notice The number of fruits in codeList and the number of fruits in
 * shppingCart are both less than 2000.
 * 
 * Example Given codeList = [["apple", "apple"],["orange", "banana",
 * "orange"]],, shoppingCart = ["orange", "apple", "apple", "orange", "banana",
 * "orange"], return 1.
 * 
 * Explanation: Because the order in the codeList matches the fruit in the
 * shoppingCart except for the first orange. Given codeList = [["orange",
 * "banana", "orange"],["apple", "apple"]], shoppingCart = ["orange", "apple",
 * "apple", "orange", "banana", "orange"], return 0.
 * 
 * Explanation: Because the order in the codeList doesn't match the
 * shoppingCart. Given codeList = [["apple", "apple"],["orange", "anything",
 * "orange"]], shoppingCart = ["orange", "apple", "apple", "orange", "mango",
 * "orange"], return 1.
 * 
 * Explanation: anything matches mango, so codeList can match the fruit of
 * shoppingCart.
 * 
 * @author qz
 *
 */
public class BuyFruits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// be careful the edge cases.
	// carefully consider the edge cases before writing code
	public int buyFruits(List<List<String>> codeList, List<String> shoppingCart) {
        List<String> codes = new ArrayList<>();
        for (List<String> list : codeList) {
            codes.addAll(list);
        }
        
        int i = 0, j = 0;
        while (i < codes.size() && j < shoppingCart.size()) {
            if (codes.get(i).equals("anything")) i++;
            else if (codes.get(i).equals(shoppingCart.get(j))) {
                break;
            }
            j++;
        }
        
        if (i == codes.size()) return 1;
        if (shoppingCart.size() - j < codes.size() - i) return 0;
        
        for (; i < codes.size(); i++) {
            if (shoppingCart.get(j).equals(codes.get(i)) || codes.get(i).equals("anything")) {
                j++;
            } else {
                return 0;
            }
        }
        
        return 1;
    }
}
