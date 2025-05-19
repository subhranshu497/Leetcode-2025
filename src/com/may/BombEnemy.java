package com.may;

import java.util.Arrays;

public class BombEnemy {
    public static void main(String[] args) {
        char [][] grid = {{'W','w','W'},{'0','0','0'},{'E','E','E'}};
        int enemiesCount = maxKilledEnemies(grid);
        System.out.println(enemiesCount);
    }

    private static int maxKilledEnemies(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int maxEnemies = 0;

        int[][][] dp = new int[rows][cols][4];

        // Calculate enemies killed moving downwards
        for (int j = 0; j < cols; j++) {
            int count = 0;
            for (int i = 0; i < rows; i++) {
                if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                }
                dp[i][j][0] = count;
            }
        }

        // Calculate enemies killed moving upwards
        for (int j = 0; j < cols; j++) {
            int count = 0;
            for (int i = rows - 1; i >= 0; i--) {
                if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                }
                dp[i][j][1] = count;
            }
        }

        // Calculate enemies killed moving rightwards
        for (int i = 0; i < rows; i++) {
            int count = 0;
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                }
                dp[i][j][2] = count;
            }
        }

        // Calculate enemies killed moving leftwards
        for (int i = 0; i < rows; i++) {
            int count = 0;
            for (int j = cols - 1; j >= 0; j--) {
                if (grid[i][j] == 'W') {
                    count = 0;
                } else if (grid[i][j] == 'E') {
                    count++;
                }
                dp[i][j][3] = count;
            }
        }

        // Iterate through the grid to find the maximum kill count for empty cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    int currentEnemies = dp[i][j][0] + dp[i][j][1] + dp[i][j][2] + dp[i][j][3];
                    maxEnemies = Math.max(maxEnemies, currentEnemies);
                }
            }
        }

        return maxEnemies;
    }
}
