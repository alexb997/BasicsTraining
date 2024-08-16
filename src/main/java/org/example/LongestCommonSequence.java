package org.example;

/*
Time Complexity: O(m * n)
Space Complexity: O(m * n)
 */
class LongestCommonSubsequence {
    public int lcs(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("Length of LCS: " + lcs.lcs(X, Y, X.length(), Y.length()));
    }
}
