package com.sep;

class Spreadsheet {
    private int[][] sheet;

    public Spreadsheet(int rows) {
        sheet = new int[rows][26]; // rows x 26 (A-Z)
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        sheet[row][col] = 0;
    }

    private int solve(String s) {
        if (Character.isDigit(s.charAt(0))) {
            return Integer.parseInt(s);
        }
        int col = s.charAt(0) - 'A';
        int row = Integer.parseInt(s.substring(1)) - 1;
        return sheet[row][col];
    }

    public int getValue(String formula) {
        // Example: "=A1+B2"
        String s = formula.substring(1); // remove '='
        int plusIdx = s.indexOf('+');

        String left = s.substring(0, plusIdx);
        String right = s.substring(plusIdx + 1);

        return solve(left) + solve(right);
    }
}
