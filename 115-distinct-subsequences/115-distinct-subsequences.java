class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for(int[] tmp : memo)
            Arrays.fill(tmp, -1);

        return dp(s, 0, t, 0);
    }

    public int dp(String s, int i, String t, int j){
        if(j == t.length())
            return 1;
        
        if(s.length() - i < t.length() - j)
            return 0;

        if(memo[i][j] != -1)
            return memo[i][j];

        int res = 0;
        if (s.charAt(i) == t.charAt(j)) {
            // 匹配，两种情况，累加关系
            // 选择这一轮j+1或者跳过
            res += dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
        } else {
            // 不匹配，在 s[i+1..] 的子序列中计算 t[j..] 的出现次数
            res += dp(s, i + 1, t, j);
        }
        // 结果存入备忘录
        memo[i][j] = res;
        return res;
    }
}