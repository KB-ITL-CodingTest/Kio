package week10.dp;

import java.io.BufferedReader;

public class b2193_이친수 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n+1];
        // i-2자리 이친수 뒤에 10 붙이기 + i-1자리 이친수 뒤에 0 붙이기
        dp[1] = 1;
        if(n >= 2) dp[2] = 1;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.print(dp[n]);
    }
}
