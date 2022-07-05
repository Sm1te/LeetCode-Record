class Solution {
    int m, n;
    boolean res = false;
    int[][] seen;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        seen =  new int[m][n];
        int index = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                backTrack(0, i, j, word, board);
                if(res)
                    return true;
            }
        }
        
        return false;
    }
    
    public void backTrack(int index, int x, int y, String word,char[][] board){
        if(x == m || y == n || x < 0 || y < 0 || seen[x][y] == 1 || index >= word.length())
            return;
        
        if(word.charAt(index) == board[x][y]){
            seen[x][y] = 1;
            if(index == word.length() - 1){
                res = true;
                return; 
            }else{
                backTrack(index + 1, x + 1, y, word, board);
                backTrack(index + 1, x - 1, y, word, board);
                backTrack(index + 1, x, y + 1, word, board);
                backTrack(index + 1, x, y - 1, word, board);
            }
            seen[x][y] = 0; 
        }
        return;

    }
}