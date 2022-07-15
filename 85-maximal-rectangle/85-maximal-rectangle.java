class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] left = new int[m][n];
        
         for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int max = 0;
        // monotonic stack
        for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];
            Deque<Integer> deq = new ArrayDeque();

            for(int i = 0; i < m; i++){
                while(!deq.isEmpty() && left[deq.peek()][j] >= left[i][j])
                    deq.pop();
                up[i] = deq.isEmpty() ? -1 : deq.peek();
                deq.push(i);
            }

            deq.clear();

            for(int i = m - 1; i >= 0; i--){
                while(!deq.isEmpty() && left[deq.peek()][j] >= left[i][j])
                    deq.pop();
                down[i] = deq.isEmpty() ? m : deq.peek();
                deq.push(i);
            }

            for(int i = 0; i < m; i++){
                max = Math.max(max, (down[i] - up[i] - 1) * left[i][j]);
            }
        }

        return max;
    }
}