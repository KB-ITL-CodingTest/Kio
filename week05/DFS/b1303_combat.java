package week05.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1303_combat {
    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int dfs(int x, int y){
        visited[x][y] = true;
        int ret = 1;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
            if(!visited[nx][ny] && map[nx][ny] == map[x][y]){
                ret += dfs(nx, ny);
            }
        }
        return ret;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = line.charAt(j);
            }
        }
        int W = 0;
        int B = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j]){
                    int ret = dfs(i, j);
                    if(map[i][j] == 'W'){
                        W += ret*ret;
                    }
                    else{
                        B += ret*ret;
                    }
                }
            }
        }
        System.out.print(W + " " + B);
    }
}
