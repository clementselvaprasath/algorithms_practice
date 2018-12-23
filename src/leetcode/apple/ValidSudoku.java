package leetcode.apple;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/description/
 * Determine if a Sudoku is valid
 * @author qz
 *
 */
public class ValidSudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidSudoku(char[][] board) {
		int m = board.length, n = board[0].length;
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (board[i][j] != '.') {
        			String pos_row = "row-" + i + "-" + board[i][j];
        			String pos_col = "col-" + j + "-" + board[i][j];
        			String pos_block = "block-" + (i / 3 * 3 + j / 3) + "-" + board[i][j];
        			if (seen.contains(pos_row) || seen.contains(pos_col) || seen.contains(pos_block)) {
        				return false;
        			}
        			seen.add(pos_block);
        			seen.add(pos_col);
        			seen.add(pos_row);
        		}
        	}
        }

        return true;
    }
}
