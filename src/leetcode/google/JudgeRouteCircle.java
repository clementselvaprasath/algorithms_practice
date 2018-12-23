package leetcode.google;

import java.util.HashMap;
import java.util.Map;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its
 * moves, judge if this robot makes a circle, which means it moves back to the
 * original place.
 * 
 * The move sequence is represented by a string. And each move is represent by a
 * character. The valid robot moves are R (Right), L (Left), U (Up) and D
 * (down). The output should be true or false representing whether the robot
 * makes a circle.
 * 
 * Example 1: Input: "UD" Output: true Example 2: Input: "LL" Output: false
 * 
 * @author qz
 *
 */
public class JudgeRouteCircle {

	static Map<Character, int[]> map;
    static {
        map = new HashMap<>();
        map.put('L', new int[]{0, -1});
        map.put('R', new int[]{0, 1});
        map.put('U', new int[]{-1, 0});
        map.put('D', new int[]{1, 0});
    }
    public boolean judgeCircle(String moves) {
        int[] pos = new int[]{0, 0};
        for (char c : moves.toCharArray()) {
            int[] m = map.get(c);
            pos[0] += m[0];
            pos[1] += m[1];
        }
        
        return pos[0] == 0 && pos[1] == 0;
    }
}
