class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalLen = Arrays.stream(nums).sum();
        if (totalLen % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        //从大到小拿
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        
        int[] edges = new int[k];
        return dfs(0, nums, edges, totalLen / k);
    }
    
    public boolean dfs(int index, int[] nums, int[] edges, int len){
        if (index == nums.length) {
            return true;
        }
        
        for (int i = 0; i < edges.length; i++) {
            edges[i] += nums[index];
            // 第一次剪枝
            if (edges[i] <= len && dfs(index + 1, nums , edges, len)) {
                return true;
            }
            edges[i] -= nums[index];
            // 第二次剪枝
            if(edges[i] == 0)
                break;
        }
        return false;
    }
}