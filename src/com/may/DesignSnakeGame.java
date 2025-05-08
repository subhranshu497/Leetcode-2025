package com.may;

import java.util.ArrayDeque;
import java.util.Deque;

public class DesignSnakeGame {
    private Deque<int[]> snake;
    private boolean [][] board;
    private int [][] food;
    private int width;
    private int height;
    private int currentFood;
    private int i, j;
    public DesignSnakeGame(){}


    public DesignSnakeGame(int width, int height, int[][] food) {
        snake = new ArrayDeque<>();
        snake.addLast(new int[]{0,0});
        this.height = height;
        this.width = width;
        this.board = new boolean[height][width];
        board[0][0] = true;
        this.food = food;
    }

    public boolean isFood(int i,int j,int index){
        return (index < food.length && i == food[index][0] && j == food[index][1]);
    }

    public int move(String direction) {
        int [] currentCell = new int[2];
        if(snake.size() != 0) currentCell = snake.getLast();
        int i_ = currentCell[0];
        int j_ = currentCell[1];
        if(direction.equals("R"))
            j_ = j+1;
        else if(direction.equals("L"))
            j_ = j-1;

        else if(direction.equals("U"))
            i_ =i-1;

        else if(direction.equals("D"))
            i_ =i+1;

        int [] removeCell = snake.removeFirst();
        board[removeCell[0]][removeCell[1]] = false;

        if(checkOutOfBound(i_,j_)) return -1;
            //check for food
        if (isFood(i_, j_, this.currentFood)){
                    currentFood += 1;
                    snake.addFirst(new int[]{removeCell[0], removeCell[1]});
                }
        snake.addLast(new int[]{i_, j_});
        board[i_][j_] = true;
        return this.currentFood;
    }

    //check for out of bound
    private boolean checkOutOfBound(int i, int j){
        if(i < 0 || i>=height || j < 0 || j >= width || board[i][j])
            return true;
        return false;
    }

    public static void main(String[] args) {
        DesignSnakeGame dsg1 = new DesignSnakeGame();
        dsg1.food = new int[][]{{1, 2}};
        DesignSnakeGame dsg = new DesignSnakeGame(3,2, dsg1.food);

        dsg.move("R");
//        dsg.move("D");
//        dsg.move("R");
//        dsg.move("U");
//        dsg.move("L");
//        dsg.move("U");
        System.out.println(dsg.currentFood);

    }
}
