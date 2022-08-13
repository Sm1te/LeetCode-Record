class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0; 

        while(i < n){
            int sumOfGas  = 0; // 总共加的油
            int SumOfCost = 0; // 总共消费的油
            int count = 0;     // 记录能走过几个站点
            while(count < n){  // 退出循环的条件是走过所有的站点
                int j = (i + count) % n; // 加油站是环形的
                sumOfGas += gas[j];
                SumOfCost += cost[j];
                // 油不够了
                if(SumOfCost > sumOfGas){ 
                    break;
                }
                count++; // 这个站点油箱足够
            }
            //成功找到
            if(count == n){
                return i;
            }else{ 
                // 不行的话 从下一个站点开始 检查
                i = i + count + 1;
            }
        }
        // 所有加油站作为起点都不满足
        return -1;
    }
}