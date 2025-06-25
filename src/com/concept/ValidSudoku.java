package com.concept;

public class ValidSudoku {
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
        boolean flag = isValidSudoku(board);
        System.out.println(flag);
    }

    private static boolean isValidSudoku(char[][] board) {
        //traverse all rows and check for any duplicate entries
        for(int i=0;i<9;i++){
            boolean [] visited = new boolean[10];
            for(int j=0;j<9;j++){
                char ch = board[i][j];
                if(ch=='.')continue;
                int num = ch-'0';
                if(visited[num]) return false;
                visited[num] = true;
            }
        }
        //traverse all columns and check for any duplicate entries
        for(int j=0;j<9;j++){
            boolean [] visited = new boolean[10];
            for(int i=0;i<9;i++){
                char ch = board[i][j];
                int num = ch-'0';
                if(ch=='.')continue;
                if(visited[num]) return false;
                visited[num] = true;
            }
        }
        //now traverse 3*3 grid
        for(int i=0;i<9;i+=3){
            for(int j=0;j<9;j+=3){
                boolean [] visited = new boolean[10];
                boolean flag = validateGrid(board, i,j, visited);
                if(!flag)return false;
                //else if(i <9 && j<9)continue;
            }
        }
        return true;
    }

    private static boolean validateGrid(char[][] board, int row, int col, boolean[] visited) {
        for(int i=row;i<row+3;i++) {
            for (int j = col; j < col+3; j++) {
                char ch = board[i][j];
                if(ch=='.')continue;
                int num = ch-'0';
                if(visited[num]) return false;
                visited[num] = true;
            }
        }
        return true;
    }
}
