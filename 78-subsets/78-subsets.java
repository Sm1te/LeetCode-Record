class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList();
        backTrack(0, nums, new LinkedList());
        return res;
    }
    
    public void backTrack(int start, int[] nums, LinkedList<Integer> tmp){
        if(tmp.size() > nums.length || start > nums.length)
            return;
        
        res.add(new ArrayList(tmp));
        
        for(int i = start; i < nums.length; i++){
            tmp.add(nums[i]);
            backTrack(i + 1, nums, tmp);
            tmp.removeLast();
        }
        
        
    }
}