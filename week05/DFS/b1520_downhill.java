package week05.DFS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1520_downhill {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] dp;
    static int dfs(int[][] map,int n, int m, int x, int y) {
        if(x== n-1 && y == m-1){
            return 1;
        }
        if(dp[x][y] != -1){
            return dp[x][y];
        }
        dp[x][y] = 0;
        for(int dir=0;dir<4;dir++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(map[nx][ny] < map[x][y]){
                dp[x][y] += dfs(map, n, m, nx, ny);
            }
        }
//        if(ret > 0) System.out.println(x+ " "+y );
        return dp[x][y];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = dfs(map, n, m, 0,0);

        System.out.print(answer);
    }
}
