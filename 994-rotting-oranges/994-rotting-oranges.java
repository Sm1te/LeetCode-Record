class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair<Integer, Integer>> queue = new ArrayDeque();
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    queue.offer(new Pair(i, j));
                else if(grid[i][j] == 1)
                    count++;
            }
        }
        
        int res = 0;
        
        while(count > 0 && !queue.isEmpty()){
            res++;
            int size = queue.size();
            while(size-- > 0){
                Pair<Integer, Integer> tmp = queue.poll();
                int x = tmp.getKey();
                int y = tmp.getValue();
                
                if(x >= 1 && grid[x - 1][y] == 1){
                    grid[x - 1][y] = 2;
                    count--;
                    queue.offer(new Pair(x - 1, y));
                }
                
                if(x < m - 1 && grid[x + 1][y] == 1){
                    grid[x + 1][y] = 2;
                    count--;
                    queue.offer(new Pair(x + 1, y));
                }
                
                if(y < n - 1 && grid[x][y + 1] == 1){
                    grid[x][y + 1] = 2;
                    count--;
                    queue.offer(new Pair(x, y + 1));
                }
                
                if(y >= 1 && grid[x][y - 1] == 1){
                    grid[x][y - 1] = 2;
                    count--;
                    queue.offer(new Pair(x, y - 1));
                }
            }
        }
        
        return count == 0 ? res : -1;
    }
}