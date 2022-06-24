class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList();
        // 首先将所有的 0 都入队，并且将 1 的位置设置成 -1，表示该位置是 未被访问过的 1
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0)
                    queue.offer(new int[]{i, j});
                else
                    mat[i][j] = -1;
            }
        }

        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int x = tmp[0], y = tmp[1];

            for(int i = 0; i < 4; i++){
                int x1 = x + dirs[i][0];
                int y1 = y + dirs[i][1];
                // 如果四邻域的点是 -1，表示这个点是未被访问过的 1
                // 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
                if(x1 >= 0 && x1 < m && y1 >= 0 && y1 < n && mat[x1][y1] == -1){
                    mat[x1][y1] = mat[x][y] + 1;
                    queue.offer(new int[] {x1, y1});
                }
            }
        }
        return mat;
    }
}