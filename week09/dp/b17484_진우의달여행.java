package week09.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b17484_진우의달여행 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] cost = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 3번째 = 방향. 1 - 왼쪽, 2 - 아래, 3 - 오른쪽
        int[] dir = {-1, 0, 1};
        int[][][] dp = new int[n+1][m+2][3];
        for(int[][] layer : dp)
            for(int[] row : layer)
                Arrays.fill(row, 123456789);
        // 초기화: 첫 줄은 이전 방향이 없으므로 모든 방향에서 시작 가능
        for(int j=1; j<=m; j++){
            for(int d=0; d<3; d++){
                dp[1][j][d] = cost[0][j-1];
            }
        }
        //2번줄부터 계산 시작. 3방향을 확인해가며 자기 방향이 아닌 곳을 확인하여 업데이트
        for(int i=2;i<=n;i++){
            for(int j=1;j<=m;j++){
                for(int d=0;d<3;d++){
                    int next = (j + dir[d]);
                    if(next < 1 || next > m) continue;
                    for(int k=0;k<3;k++){
                        if(k == d) continue;
                        dp[i][j][d] = Math.min(dp[i][j][d], dp[i-1][next][k] + cost[i-1][j-1]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=m;i++){
            for(int j=0;j<3;j++){
                ans = Math.min(ans, dp[n][i][j]);
            }
        }
        System.out.print(ans);
    }
}
