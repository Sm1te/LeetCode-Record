class Solution {
    boolean ok = false;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        int index = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0))
                    dfs(index, word, board, i, j);
                
                if(ok)
                    return true;
            }
        }
        return false;
    }

    public void dfs(int index, String word, char[][] board, int i, int j){
        int m = board.length;
        int n = board[0].length;

        if(i >= m || j >= n || i < 0 || j < 0 || board[i][j] != word.charAt(index) || visited[i][j])
            return;

        visited[i][j] = true;

        if(word.length() == index + 1){
            ok = true;
            return;
        }
            

        dfs(index + 1, word, board, i + 1, j);
        dfs(index + 1, word, board, i, j + 1);
        dfs(index + 1, word, board, i - 1, j);
        dfs(index + 1, word, board, i, j - 1);

        visited[i][j] = false;
    }
}