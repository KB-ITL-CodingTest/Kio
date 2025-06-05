package week09.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class b9095_123더하기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dp = new int[12];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<=11;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        int t = Integer.parseInt(br.readLine());
        for(int tc=0;tc<t;tc++){
            int n = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[n]) + '\n');
        }
        bw.flush();
    }
}
