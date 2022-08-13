class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList();
        for (int n = arr.length; n > 1; n--) {
            int index = 0;
            // find max
            for (int i = 1; i < n; i++) {
                if (arr[i] >= arr[index]) {
                    index = i;
                }
            }
            if(index == n - 1)
                continue;
            
            // filp twice
            reverse(arr, index);
            reverse(arr, n - 1);
            res.add(index + 1);
            res.add(n);
        }
        return res;
    }
    
    public void reverse(int[] arr, int index){
        int left = 0, right = index;
        while(left <= right){
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            right--;
            left++;
        }
    }
}