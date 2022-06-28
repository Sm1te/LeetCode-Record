class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList();
        
        backTrack(new LinkedList(), 0, candidates, target, 0);
        return res;
    }
    
    public void backTrack(LinkedList<Integer> list, int start, int[] candidates, int target, int sum){
        if(sum == target){
            res.add(new LinkedList(list));
            return;
        }
        
        if(sum > target)
            return;
        
        for(int i = start; i < candidates.length; i++){
            sum += candidates[i];
            list.add(candidates[i]);
            backTrack(list, i, candidates, target, sum);
            list.removeLast();
            sum -= candidates[i];
        }
    }
}