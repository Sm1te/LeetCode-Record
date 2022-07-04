class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        int[][] arr=new int[n][3];
        
        for(int i=0; i<n; i++){
            arr[i]=new int[]{startTime[i],endTime[i],profit[i]};
        }
        
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            int prev = binarySearch(arr, i);
            dp[i] = Math.max(i > 0 ? dp[i - 1] : 0, (prev >= 0 ? dp[prev] : 0) + arr[i][2]);
        }
        
        return dp[n - 1];
    }
    
    public int binarySearch(int[][] arr, int i){
        int l = -1, r = arr.length;
        while(l + 1 != r){
            int mid = l + (r - l) / 2;
            if(arr[mid][1] <= arr[i][0])l=mid;
            else r=mid;
        }
        return l;
    }
}