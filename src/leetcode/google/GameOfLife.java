package leetcode.google;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as
 * Life, is a cellular automaton devised by the British mathematician John
 * Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or
 * dead (0). Each cell interacts with its eight neighbors (horizontal, vertical,
 * diagonal) using the following four rules (taken from the above Wikipedia
 * article):
 * 
 * Any live cell with fewer than two live neighbors dies, as if caused by
 * under-population. Any live cell with two or three live neighbors lives on to
 * the next generation. Any live cell with more than three live neighbors dies,
 * as if by over-population.. Any dead cell with exactly three live neighbors
 * becomes a live cell, as if by reproduction. Write a function to compute the
 * next state (after one update) of the board given its current state.
 * 
 * Follow up: Could you solve it in-place? Remember that the board needs to be
 * updated at the same time: You cannot update some cells first and then use
 * their updated values to update other cells. In this question, we represent
 * the board using a 2D array. In principle, the board is infinite, which would
 * cause problems when the active area encroaches the border of the array. How
 * would you address these problems?
 * 
 * @author qz
 *
 */
public class GameOfLife {

	public static void main(String[] args) throws Exception {
		int[][] board = {
				{0,0,0,0,0,0},
				{0,0,0,1,0,0},
				{0,1,0,0,1,0},
				{0,1,0,0,1,0},
				{0,0,1,0,0,0},
				{0,0,0,0,0,0}
		};
		
		int[][] board_moving = {
				{0,0,0,0,0,0},
				{0,0,1,0,0,0},
				{0,0,0,1,0,0},
				{0,1,1,1,0,0},
				{0,0,0,0,0,0},
				{0,0,0,0,0,0}
		};
		
		int[][] board2 = {
				{0,1,0},
				{1,1,0},
				{0,1,0}
		};
		
		GameOfLife gof = new GameOfLife();
		while(true) {
			printMatrix(board_moving);
			Thread.sleep(1000);
			clearConsole();
			gof.gameOfLife_Oscillators(board_moving);
		}
	}

	int[] idx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] idy = {0, 1, 1, 1, 0, -1, -1, -1};
    int deadToLive = -1;
    int liveToDead = 2;
    
    public void gameOfLife_Oscillators(int[][] board) {
        if (board == null || board.length == 0) return;
        // update temp value
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int lives = countLiveNeighhors_moving(board, i, j);
                if (lives >= 2 && lives <= 3) {
                    if (board[i][j] == 0 && lives == 3) {
                        board[i][j] = deadToLive;
                    }
                } else {
                    if (board[i][j] == 1) {
                        board[i][j] = liveToDead;
                    }
                }
            }
        }
        
        // restore value
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == deadToLive) {
                    board[i][j] = 1;
                } else if (board[i][j] == liveToDead) {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        // update temp value
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int lives = countLiveNeighhors(board, i, j);
                if (lives >= 2 && lives <= 3) {
                    if (board[i][j] == 0 && lives == 3) {
                        board[i][j] = deadToLive;
                    }
                } else {
                    if (board[i][j] == 1) {
                        board[i][j] = liveToDead;
                    }
                }
            }
        }
        
        // restore value
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == deadToLive) {
                    board[i][j] = 1;
                } else if (board[i][j] == liveToDead) {
                    board[i][j] = 0;
                }
            }
        }
    }
    
    private int countLiveNeighhors(int[][] board, int r, int c) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x = r + idx[i];
            int y = c + idy[i];
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
            if (board[x][y] == 1 || board[x][y] == liveToDead) count++;
        }

        return count;
    }
    
    private int countLiveNeighhors_moving(int[][] board, int r, int c) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x = r + idx[i];
            int y = c + idy[i];
            //if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) continue;
            if (x < 0) {
            	x = board.length - 1;
            } else if (x >= board.length) {
            	x = 0;
            }
            if (y < 0) {
            	y = board[0].length - 1;
            } else if (y >= board[0].length) {
            	y = 0;
            }
            if (board[x][y] == 1 || board[x][y] == liveToDead) count++;
        }

        return count;
    }
    private static void printMatrix(int[][] m) {
    	for (int i = 0; i < m.length; i++) {
    		for (int j = 0; j < m[i].length; j++) {
    			System.out.print(m[i][j] + " ");
    		}
    		System.out.println();
    	}
    }
    
    private static void clearConsole() {
    	for (int i = 0; i < 30; i++) {
    		System.out.println();
    	}
    }
}
