class Solution {
    private class pair{
        int id;
        int val;
        pair(int id, int val){
            // 记录元素在数组中的原始索引
            this.id = id;
            // 记录数组的元素值
            this.val = val;
        }
    }

    // 归并排序所用的辅助数组
    private pair[] tmp;
    // 记录每个元素后面比自己小的元素个数
    private int[] count;
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        count = new int[n];
        tmp = new pair[n];
        // 记录元素原始的索引位置，以便在 count 数组中更新结果
        // index -> value
        pair[] arr = new pair[n];
        for(int i = 0; i < n; i++){
            arr[i] = new pair(i, nums[i]);
        }

        // 执行归并排序，本题结果被记录在 count 数组中
        sort(arr, 0, n - 1);

        List<Integer> res = new LinkedList();
        for(int i : count){
            res.add(i);
        }
        return res;
    }

    public void sort(pair[] arr, int low, int high){
        if(low == high)
            return;

        int mid = low + (high - low) / 2;
        sort(arr, low, mid);
        sort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    public void merge(pair[] arr, int low, int mid, int high){
        for(int i = low; i <= high; i++){
            tmp[i] = arr[i];
        }

        int i = low, j = mid + 1;
        for(int p = low; p <= high; p++){
            //说明这时右边的j的num都大一些，那跟我们要的count无关，正常流程
            if(i == mid + 1){
                arr[p] = tmp[j++];
            //说明右边走完了，现在左边每一个都比右边所有的都要大
            }else if(j == high + 1){
                arr[p] = tmp[i++];
                count[arr[p].id] += j - mid - 1;// ！= high - (mid + 1) + 1
            }else if(tmp[i].val > tmp[j].val){
            /*
            为什么是i > j 呢，因为我们是要sort 小的值的
            下面到了i < j的时候，我们开始到了arr[p] = tmp[i++]
            这个时候我们知道右边已经sort了 j - (mid + 1)个，
            咱们肯定比他们大，所以咱们可以 j - mid - 1
             */ 
                arr[p] = tmp[j++];
            }else{
                arr[p] = tmp[i++];
                count[arr[p].id] += j - mid - 1;
            }
        }
    }
}