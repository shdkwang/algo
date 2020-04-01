package com.dk.leetcode.backtrack.WorkSearch;

//79. Word Search
// 回溯法
// 时间复杂度： O(m*n*m*n)
// 空间复杂度： O(m*n)
public class Solution {

    private int d[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    private int m,n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null)
            throw new IllegalArgumentException("Word or board can not be null!");
        m = board.length;
        if (m==0) {
            throw new IllegalArgumentException("board can't be empty!");
        }
        n = board[0].length;
        if (n==0) {
            throw new IllegalArgumentException("board can't be empty!");
        }

        visited = new boolean[m][n];
        for (int i = 0; i<m; i++) {
            for (int j = 0; j< n; j++) {
                if (searchWord(board, word, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    private boolean searchWord(char[][] board, String word, int index, int startx, int starty) {
        if (index == word.length() -1) {
            return board[startx][starty] == word.charAt(index);
        }
        if (board[startx][starty] == word.charAt(index)) {
            visited[startx][starty] = true;
            for (int i = 0; i < 4; i++) {
                int newx = startx + d[i][0];
                int newy = starty + d[i][1];
                if (inArea(newx, newy) && !visited[newx][newy] ) {
                    if (searchWord(board, word, index+1, newx, newy)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >=0 && y < n;
    }

    public static void main(String[] args) {
        char[][] b1 = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String words[] = {"ABCCED", "SEE", "ABCB"};
        for (int i = 0; i < words.length; i++) {
            if ((new Solution()).exist(b1, words[i]))
                System.out.println("found " + words[i]);
            else
                System.out.println("can not found " + words[i]);
        }
    }
}
