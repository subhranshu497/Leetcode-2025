package com.concept.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        char [][] board ={
                {'.','.','.','.','5','.','.','1','.'},
                {'.','4','.','3','.','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'8','.','.','.','.','.','.','2','.'},
                {'.','.','2','.','7','.','.','.','.'},
                {'.','1','5','.','.','.','.','.','.'},
                {'.','.','.','.','.','2','.','.','.'},
                {'.','2','.','9','.','.','.','.','.'},
                {'.','.','4','.','.','.','.','.','.'}
        };
        solveSudoku(board);
    }

    private static void solveSudoku(char[][] board) {
        solveBoard(board);
    }

    private static boolean solveBoard(char[][] board) {
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(board[i][j]=='.'){
                        for(char ch= '1';ch<='9';ch++){
                            if(validatePlacementOfCh(board, i, j, ch)){
                                board[i][j] = ch;
                                if(solveBoard(board))return true;
                                board[i][j]='.'; // backtrack
                            }
                        }
                        return false;
                    }
                }
            }
            return true;
    }

    private static boolean validatePlacementOfCh(char[][] board, int i, int j, char ch) {
        //validate col
        for(int r=0;r<9;r++){
            if(board[r][j]==ch)return false;
        }
        //validate row
        for(int c=0;c<9;c++){
            if(board[i][c]==ch)return false;
        }
        // validate 3*3 grid
        int startRow = i -(i%3);
        int startCol = j -(j%3);

        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                if(board[startRow+r][startCol+c]==ch)return false;
            }
        }
        return true;
    }
}
