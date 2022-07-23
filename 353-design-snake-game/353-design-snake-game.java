class SnakeGame {
    LinkedList<int[]> bodyPlace = new LinkedList();
    LinkedList<int[]> foods = new LinkedList();
    int[][] grid;
    public SnakeGame(int width, int height, int[][] food) {
        grid = new int[height][width];
        for(int[] tmp : food){
            foods.add(tmp);
        }
        int[] fir = foods.pollFirst();
        grid[fir[0]][fir[1]] = 1;
        bodyPlace.add(new int[]{0, 0});
    }
    
    public int move(String direction) {
        int[] head = bodyPlace.peekFirst();
        
        if(direction.equals("R")){
            if(checkEdge(head[0], head[1] + 1))
                return -1;
            if(grid[head[0]][head[1] + 1] == 1){
                bodyPlace.addFirst(new int[]{head[0], head[1] + 1});
                grid[head[0]][head[1] + 1] = 0;
                if(foods.size() > 0){
                    int[] fir = foods.pollFirst();
                    grid[fir[0]][fir[1]] = 1;
                }
            }else{
                bodyPlace.pollLast();
                bodyPlace.addFirst(new int[]{head[0], head[1] + 1});
            }
        }
        
        if(direction.equals("L")){
            if(checkEdge(head[0], head[1] - 1))
                return -1;
            if(grid[head[0]][head[1] - 1] == 1){
                bodyPlace.addFirst(new int[]{head[0], head[1] - 1});
                grid[head[0]][head[1] - 1] = 0;
                if(foods.size() > 0){
                    int[] fir = foods.pollFirst();
                    grid[fir[0]][fir[1]] = 1;
                }
            }else{
                bodyPlace.pollLast();
                bodyPlace.addFirst(new int[]{head[0], head[1] - 1});
            }
        }
        
        if(direction.equals("U")){
            if(checkEdge(head[0] - 1, head[1]))
                return -1;
            if(grid[head[0] - 1][head[1]] == 1){
                bodyPlace.addFirst(new int[]{head[0] - 1, head[1]});
                grid[head[0] - 1][head[1]] = 0;
                if(foods.size() > 0){
                    int[] fir = foods.pollFirst();
                    grid[fir[0]][fir[1]] = 1;
                }
            }else{
                bodyPlace.pollLast();
                bodyPlace.addFirst(new int[]{head[0] - 1, head[1]});
            }
        }
        
        if(direction.equals("D")){
            if(checkEdge(head[0] + 1, head[1]))
                return -1;
            
            if(grid[head[0] + 1][head[1]] == 1){
                bodyPlace.addFirst(new int[]{head[0] + 1, head[1]});
                grid[head[0] + 1][head[1]] = 0;
                if(foods.size() > 0){
                    int[] fir = foods.pollFirst();
                    grid[fir[0]][fir[1]] = 1;
                }
            }else{
                bodyPlace.pollLast();
                bodyPlace.addFirst(new int[]{head[0] + 1, head[1]});
            }
        }
        
        return bodyPlace.size() - 1;
    }
    
    public boolean checkEdge(int x, int y){
        int m = grid.length, n = grid[0].length;
        if(x >= m || y >= n || x < 0 || y < 0)
            return true;
        
        int[] tmp = bodyPlace.pollLast();
        for(int[] t : bodyPlace){
            if(t[0] == x && t[1] == y)
                return true;
        }
        bodyPlace.addLast(tmp);
        return false;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */