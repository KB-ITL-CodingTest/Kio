package week9.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b7579_앱 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] memories = new int[n+1];
        int[] cost = new int[n+1];
        int maxCost = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            memories[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            cost[i] = Integer.parseInt(st.nextToken());
            maxCost += cost[i];
        }
        // dp[a][b] -> 1 ~ a 번까지 앱 안에서 b 비용을 써서 얻을 수 있는 최대 메모리
        int[][] dp = new int[n+1][maxCost+1];
        int ans = 0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=maxCost;j++){
                //i를 넣지않은, 1 ~ i-1까지의 app 비활성화 최대 메모리로 초기화
                dp[i][j] = dp[i-1][j];
                //i 번째가 들어간다면 업데이트
                if(j >= cost[i]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-cost[i]] + memories[i]);
                }
            }
        }
        for(int j = 0 ;j <= maxCost; j++){
            if(dp[n][j] >= m){
                ans = j;
                break;
            }
        }
        System.out.print(ans);
    }
}
