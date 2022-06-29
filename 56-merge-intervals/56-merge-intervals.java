class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b)  -> a[0] - b[0]);
        LinkedList<int[]> res = new LinkedList();
        int start = intervals[0][0], end = intervals[0][1];
        
        for(int i = 0; i < n; i++){
            if(res.isEmpty() || intervals[i][0] > res.getLast()[1]){
                res.add(new int[]{intervals[i][0], intervals[i][1]});
            }
            res.getLast()[1] = Math.max(intervals[i][1], res.getLast()[1]);
        }
        
        return res.toArray(new int[res.size()][]);
    }
}