package week4_BFS_DFS.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b31575_bitcoin {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static int N,M;
    static void dfs(int i, int j){
        visited[i][j] = true;
        for(int k = 0; k < 2; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M){
                continue;
            }
            if(map[nx][ny] == 1 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(map[0][0] == 1){
            dfs(0, 0);
        }
        System.out.println(visited[N-1][M-1] ? "Yes" : "No");
    }
}
