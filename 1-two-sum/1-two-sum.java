class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++){
            int tmp = nums[i];
            if(map.containsKey(target - tmp))
                return new int[]{i, map.get(target - tmp)};
            map.put(tmp, i);
        }
        return null;
    }
}