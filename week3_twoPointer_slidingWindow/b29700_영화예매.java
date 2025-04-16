package week3_twoPointer_slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b29700_영화예매 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] seats = new int[n][m];
        int[][] acc = new int[n][m+1];
        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                seats[i][j] = (line.charAt(j) - '0');
            }
            for(int j=1;j<=m;j++){
                acc[i][j] = acc[i][j-1] + seats[i][j-1];
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<=m-k;j++){
                if(acc[i][j+k] - acc[i][j] == 0){
                    cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}
