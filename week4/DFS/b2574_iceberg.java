package week4.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b2574_iceberg {
    static Queue<int[]> candidate = new LinkedList<>();
    static int[][] map;
    static boolean[][] visited;
    static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean dfs(int x, int y){
        if(visited[x][y]) return false;
        visited[x][y] = true;
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if(map[nx][ny] > 0 && !visited[nx][ny]){
                dfs(nx, ny);
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > 0){
                    candidate.add(new int[]{i, j});
                }
            }
        }
        int iceberg = 1;
        int time = 0;
        while(iceberg == 1){
            Queue<int[]> meltingQ = new LinkedList<>();
            int n = candidate.size();
            for(int i=0;i<n;i++){
                int[] cur = candidate.poll();
                int x = cur[0];
                int y = cur[1];
                int melt = 0;
                for(int k = 0; k < 4; k++){
                    int nx = cur[0] + dx[k];
                    int ny = cur[1] + dy[k];
                    if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
                    if(map[nx][ny] <= 0){
                        melt++;
                    }
                }
                if(map[x][y] > melt){
                    candidate.add(new int[]{x, y});
                }
                meltingQ.add(new int[] {x,y,map[x][y] - melt});
            }
            if(candidate.isEmpty()){
                System.out.println(0);
                return;
            }
            for(int[] cur : meltingQ){
                int x = cur[0];
                int y = cur[1];
                int melt = cur[2];
                map[x][y] = melt;
            }
            visited = new boolean[N][M];
            iceberg = 0;
            for(int[] cur : candidate){
                if(dfs(cur[0], cur[1])){
                    iceberg++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
