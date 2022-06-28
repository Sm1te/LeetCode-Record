class Solution {
    List<List<Integer>> res = new ArrayList();
    List<Integer> output = new LinkedList();
    
    public List<List<Integer>> permute(int[] nums) {
        for(int num : nums)
            output.add(num);
        
        backTrack(output, nums, 0);
        return res;
    }
    
    public void backTrack(List<Integer> output, int[] nums, int start){
        if(start == nums.length){
            res.add(new LinkedList(output));
            return;
        }
        
        for(int i = start; i < nums.length; i++){
            Collections.swap(output, start, i);
            backTrack(output, nums, start + 1);
            Collections.swap(output, start, i);
        }
    }
}