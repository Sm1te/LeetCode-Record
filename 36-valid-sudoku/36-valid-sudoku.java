class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] jiugongge = new int[3][3][9];
        
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c == '.')
                    continue;
                int index = c - '1';
                rows[i][index]++;
                if(rows[i][index] > 1)
                    return false;
                cols[j][index]++;
                if(cols[j][index] > 1)
                    return false;
                jiugongge[i / 3][j / 3][index]++;
                if(jiugongge[i / 3][j / 3][index] > 1)
                    return false;
            }
        }
        return true;
    }
}