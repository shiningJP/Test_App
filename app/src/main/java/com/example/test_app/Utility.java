package com.example.test_app;

public class Utility {
    /**
     * 2つの文字列をレーベンシュタイン距離を用いて比較する
     *
     * @param src1 比較する文字列
     * @param src2 比較する文字列
     * @return 文字列の類似度<br>
     *         0.0が完全不一致 1.0が完全一致
     */
    public static float matchRate(String src1, String src2) {
        int len1 = src1.length(), len2 = src2.length();
        if (len1 == 0 || len2 == 0)
            return 1f;

        char[] a = src1.toCharArray(), b = src2.toCharArray();
        var dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i < len1 + 1; i++)
            dp[i][0] = i;
        for (int i = 0; i < len2 + 1; i++)
            dp[0][i] = i;

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                int add = dp[i - 1][j] + 1;
                int del = dp[i][j - 1] + 1;
                int rep = dp[i - 1][j - 1];

                if (a[i - 1] != b[j - 1])
                    rep++;

                var tmp = Math.min(add, del);
                dp[i][j] = Math.min(rep, tmp);
            }
        }
        float distance = dp[len1][len2];
        float length = Math.max(len1, len2);
        return 1 - distance / length;
    }

}
