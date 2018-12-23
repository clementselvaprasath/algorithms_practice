package leetcode.amazon;

/**
 * Let's play the minesweeper game (Wikipedia, online game)!
 * 
 * You are given a 2D char matrix representing the game board. 'M' represents an
 * unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a
 * revealed blank square that has no adjacent (above, below, left, right, and
 * all 4 diagonals) mines, digit ('1' to '8') represents how many mines are
 * adjacent to this revealed square, and finally 'X' represents a revealed mine.
 * 
 * Now given the next click position (row and column indices) among all the
 * unrevealed squares ('M' or 'E'), return the board after revealing this
 * position according to the following rules:
 * 
 * If a mine ('M') is revealed, then the game is over - change it to 'X'. If an
 * empty square ('E') with no adjacent mines is revealed, then change it to
 * revealed blank ('B') and all of its adjacent unrevealed squares should be
 * revealed recursively. If an empty square ('E') with at least one adjacent
 * mine is revealed, then change it to a digit ('1' to '8') representing the
 * number of adjacent mines. Return the board when no more squares will be
 * revealed.
 * 
 * @author qz
 *
 */
public class MineSweeper {

	public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        update (board, x, y, visited);
        return board;
    }
    
    int[] idx = {-1, -1, -1, 0, 1, 1, 1, 0};
    int[] idy = {-1, 0, 1, 1, 1, 0, -1, -1};
    private void update(char[][] board, int r, int c, boolean[][] visited) {
        if (board[r][c] == 'M') return;
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int x = r + idx[i];
            int y = c + idy[i];
            if (x < 0 || x >= board.length || y < 0 || y >= board[x].length) continue;
            if (board[x][y] == 'M') {
                count++;
            }
        }
        if (count > 0) {
            board[r][c] = Character.forDigit(count, 10);            
        } else {
            board[r][c] = 'B';
            for (int i = 0; i < 8; i++) {
                int x = r + idx[i];
                int y = c + idy[i];
                if (x < 0 || x >= board.length || y < 0 || y >= board[x].length || visited[x][y]) continue;
                visited[x][y] = true;
                update(board, x, y, visited);
            }
        }
    }

}
