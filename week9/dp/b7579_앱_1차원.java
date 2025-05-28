package week9.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b7579_앱_1차원 {
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
        // dp[b] -> b 비용을 써서 얻을 수 있는 최대 메모리
        int[] dp = new int[maxCost+1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            // 역순으로 업데이트하는 이유: 중복 계산을 피하기 위해. 이전 상태를 유지하고 있어야하므로
            // 앞부터 업데이트한다면 업데이트된 값이 또 들어가므로 (dp[j - cost[i]]) 잘못된 값이 나타남
            for (int j = maxCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memories[i]);
            }
        }
        for(int i=0;i<=maxCost;i++){
            if(dp[i] >= m){
                ans = i;
                break;
            }
        }
        System.out.print(ans);
    }
}
