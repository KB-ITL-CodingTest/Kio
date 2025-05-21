package week8.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15486_퇴사 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cost = new int[N+1];
        int[] reward = new int[N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            reward[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N+2];
        for(int i=1;i<=N;i++){
            dp[i] = Math.max(dp[i], dp[i-1]);
            int end = i+cost[i];
            if(end > N+1) continue;
            dp[end] = Math.max(dp[end], dp[i] + reward[i]);
        }
        int ans = Math.max(dp[N], dp[N+1]);
        System.out.print(ans);
    }
}
