package week10.dp;

import java.io.BufferedReader;

public class b11726_2xN타일링 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        // n-2 번째 타일들에 가로타일 2개 놓기 + n-1번째 타일들에 세로타일 1개 놓기
        dp[1] = 1;
        if(n >= 2) dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.print(dp[n]);

    }
}
