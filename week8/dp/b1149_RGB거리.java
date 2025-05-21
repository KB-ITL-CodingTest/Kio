package week8.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1149_RGB거리 {
    static int n;
    static int[][] houseCost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        houseCost = new int[n+1][3];
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                houseCost[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<3;j++){
                houseCost[i][j] += Math.min((houseCost[i-1][(j+1)%3]), (houseCost[i-1][(j+2)%3]));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int cost : houseCost[n]){
            ans = Math.min(cost,ans);
        }
        System.out.print(ans);
    }
}
