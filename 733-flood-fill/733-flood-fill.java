class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    
    public void dfs(int[][] image, int x, int y, int color, int oldC){
        if(x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != oldC || image[x][y] == color){
            return;
        }
        
        image[x][y] = color;
        
        dfs(image, x + 1, y, color, oldC);
        dfs(image, x - 1, y, color, oldC);
        dfs(image, x, y + 1, color, oldC);
        dfs(image, x, y - 1, color, oldC);
    }
}