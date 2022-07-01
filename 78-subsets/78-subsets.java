class Solution {
    List<List<Integer>> res = new ArrayList();
    LinkedList<Integer> list = new LinkedList();
    
    public List<List<Integer>> subsets(int[] nums) {
        backTrack(nums, 0);
        return res;
    }
    
    public void backTrack(int[] nums, int startIndex){
        if(list.size() <= nums.length){
            res.add(new LinkedList(list));   
        }
        
        for(int i = startIndex; i < nums.length; i++){
            list.add(nums[i]);
            backTrack(nums, i + 1);
            list.removeLast();
        }  
    }
}