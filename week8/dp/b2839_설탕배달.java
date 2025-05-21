package week8.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b2839_설탕배달 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        final int INF = 5001;
        int[] dp = new int[N + 1];
        Arrays.fill(dp, INF);
        if(N >= 3) dp[3] = 1;
        if(N >= 5) dp[5] = 1;
        for (int i = 6; i <= N; i++) {
            if (dp[i - 3] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 3] + 1);
            }
            if (dp[i - 5] != INF) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        System.out.println(dp[N] == INF ? -1 : dp[N]);
    }
}
