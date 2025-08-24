package com.august;

public class FindtheMinimumAreatoCoverAllOnesII {
    public static void main(String[] args) {
        int [][] grid = {{1,0,1},{1,1,1}};
        int areaSum = minimumSum(grid);
        System.out.println(areaSum);
    }

    public static int minimumSum(int[][] grid) {
        int result = utility(grid);
        int[][] rotatedGrid = rotateClockWise(grid);
        result = Math.min(result, utility(rotatedGrid));
        return result;
    }
    private static int[][] rotateClockWise(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] rotatedGrid = new int[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedGrid[j][m - i - 1] = grid[i][j];
            }
        }
        return rotatedGrid;
    }
    public static int utility(int[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        //to create 3 non overlapping triangle, we have to draw 2 lines
        //one horizontal one vertical
        int totalArea = Integer.MAX_VALUE;
        for(int rowSplit =1;rowSplit<m;rowSplit++){
            for (int colSplit=1;colSplit<n;colSplit++){
                //case 1 - one rectangle at top , 2 rectangle at bottom
                int topArea = findMinAreaToCoverAllOnes(0,rowSplit,0,n, grid);
                int bottomLeftArea = findMinAreaToCoverAllOnes(rowSplit,m,0,colSplit, grid);
                int bottomRightArea = findMinAreaToCoverAllOnes(rowSplit,m,colSplit,n, grid);
                totalArea = Math.min(topArea+bottomRightArea+bottomLeftArea, totalArea);
            }
        }
        // Case 2: topLeft + topRight + bottom
        for (int rowSplit = 1; rowSplit < m; rowSplit++) {
            for (int colSplit = 1; colSplit < n; colSplit++) {
                int topLeft = findMinAreaToCoverAllOnes(0, rowSplit, 0, colSplit, grid);
                int topRight = findMinAreaToCoverAllOnes(0, rowSplit, colSplit, n, grid);
                int bottom = findMinAreaToCoverAllOnes(rowSplit, m, 0, n, grid);

                totalArea = Math.min(totalArea, topLeft + topRight + bottom);
            }
        }

        // Case 3: top + middle + bottom
        for (int split1 = 1; split1 < m; split1++) {
            for (int split2 = split1 + 1; split2 < m; split2++) {
                int top = findMinAreaToCoverAllOnes(0, split1, 0, n, grid);
                int middle = findMinAreaToCoverAllOnes(split1, split2, 0, n, grid);
                int bottom = findMinAreaToCoverAllOnes(split2, m, 0, n, grid);

                totalArea = Math.min(totalArea, top + middle + bottom);
            }
        }
        return totalArea;
    }
    private static int findMinAreaToCoverAllOnes(int stRow, int endRow, int stCol, int endCol, int[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        int minHeight = m;
        int maxHeight = -1;
        int minWidth = n;
        int maxWidth = -1;
        for(int i=stRow;i<endRow;i++){
            for(int j=stCol;j<endCol;j++){
                if(grid[i][j]==1){
                    minHeight = Math.min(minHeight,i);
                    maxHeight = Math.max(maxHeight,i);
                    minWidth = Math.min(minWidth,j);
                    maxWidth = Math.max(maxWidth,j);
                }
            }
        }
        int height = maxHeight-minHeight+1;
        int width = maxWidth - minWidth+1;

        return height*width;
    }
}
