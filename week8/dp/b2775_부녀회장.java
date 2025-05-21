package week8.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b2775_부녀회장 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        for(int tc=0;tc<T;tc++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[k+1][n+1];
            for(int i=1;i<=n;i++){
                arr[0][i] = i;
            }
            for(int i=1;i<=k;i++){
                for(int j=1;j<=n;j++){
                    arr[i][j] = arr[i-1][j] + arr[i][j-1];
                }
            }
            sb.append(arr[k][n]).append("\n");
        }
        System.out.print(sb);
    }
}
