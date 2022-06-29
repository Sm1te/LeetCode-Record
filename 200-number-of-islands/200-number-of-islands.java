class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(count, i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int count, int i, int j, char[][] grid){
        if(i < 0 || j < 0 || j >= grid[0].length || i >= grid.length || grid[i][j] == '0')
            return;
        
        grid[i][j] = '0';
        
        dfs(count, i + 1, j, grid);
        dfs(count, i - 1, j, grid);
        dfs(count, i, j + 1, grid);
        dfs(count, i, j - 1, grid);
    }
}
