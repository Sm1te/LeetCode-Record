class Solution {
    int MOD = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a, b, b.length - 1);
    }
    int dfs(int a, int[] b, int u) {
        if (u == -1) return 1;
        return qpow(dfs(a, b, u - 1), 10) * qpow(a, b[u]) % MOD;
    }
    int qpow(int a, int k) {
        if (k == 0) return 1;
        a %= MOD;

        if (k % 2 == 1) {
            // k 是奇数
            return (a * qpow(a, k - 1)) % MOD;
        } else {
            // k 是偶数
            int sub = qpow(a, k / 2);
            return (sub * sub) % MOD;
        }
    }
}
