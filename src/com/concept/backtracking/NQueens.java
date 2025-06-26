package com.concept.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        List<List<String>> solution = solveNQueens(n);
        // Loop through each complete solution board
        for (int solIndex = 0; solIndex < solution.size(); solIndex++) {
            List<String> currentBoard = solution.get(solIndex);
            System.out.println("Solution " + (solIndex + 1) + ":");
            for (int i = 0; i < n; i++) {
                String rowString = currentBoard.get(i);
                for (int j = 0; j < n; j++) {
                    System.out.print(rowString.charAt(j) + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> solution = new ArrayList<>();
        //at starting fill the board with .
        for(char [] charr:board){
            Arrays.fill(charr, '.');
        }
        //Start placing the queen
        solveNQueensRec(board, n,0,solution);
        return solution;
    }

    private static void solveNQueensRec(char[][] board, int n, int row, List<List<String>> solution) {

        //base condition
        if(row==n){
            List<String> rowSol = new ArrayList<>();
            for(char[] charArr:board){
                rowSol.add(new String(charArr));
            }
            solution.add(rowSol);
            return;
        }

        //try placing q
        for(int col=0;col<n;col++) {
           // if (board[row][col]=='.') {
                if (postionIsValid(board, row, col)) {
                    board[row][col]='Q';
                    solveNQueensRec(board, n, row + 1, solution);
                    board[row][col]='.';//backtrack
                }
            //}
        }
    }

    private static boolean postionIsValid(char[][] board, int row, int col) {

        //traverse in row and check if any q is in the same col
        for (int i = 0; i < board.length; i++) {
            if(i==row)continue;
            if(board[i][col]=='Q')return false;
        }
        //check upper left diagonal
        for(int i = row-1, j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q')return false;
        }

        //check upper right diagonal
        for(int i = row-1, j=col+1;i>=0 && j<board.length;i--,j++){
            if(board[i][j]=='Q')return false;
        }
        return true;
    }
}
