package org.example.backtracking;

/*
The N Queen is the problem of placing
 N chess queens on an N×N chessboard so that no two queens attack each other.
Time Complexity: O(N!)
Space Complexity: O(N^2)
 */
class NQueens {
    public boolean solveNQueens(int[][] board, int col) {
        if (col >= board.length) {
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQueens(board, col + 1)) {
                    return true;
                }

                board[i][col] = 0;  // BACKTRACK
            }
        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public void printSolution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];

        NQueens queens = new NQueens();
        if (queens.solveNQueens(board, 0)) {
            queens.printSolution(board);
        } else {
            System.out.println("No solution exists");
        }
    }
}
