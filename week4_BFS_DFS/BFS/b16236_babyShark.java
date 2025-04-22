package week4_BFS_DFS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b16236_babyShark {
    static int n;
    // 물고기의 크기 저장
    static int[][] map;
    static int size = 2;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int[][] bfs(int[] cur){
        int[][] dist = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        Deque<int[]> queue = new ArrayDeque<>();
        visited[cur[0]][cur[1]] = true;
        queue.addLast(cur);
        while(!queue.isEmpty()){
            int[] now = queue.removeFirst();
            int x = now[0];
            int y = now[1];
            for(int k = 0; k < 4; k++){
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(map[nx][ny] <= size && !visited[nx][ny]){
                    dist[nx][ny] = dist[x][y] + 1;
                    visited[nx][ny] = true;
                    queue.addLast(new int[]{nx, ny});
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int[] cur = null;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9){
                    map[i][j] = 0;
                    cur = new int[]{i,j};
                }
            }
        }
        int eatCnt = 0;
        int time = 0;
        while(true){
            int[][] dist = bfs(cur);
            int minX = -1, minY = -1;
            int minDist = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(map[i][j] > 0 && map[i][j] < size && dist[i][j] < minDist && dist[i][j] > 0){
                        minDist = dist[i][j];
                        minX = i;
                        minY = j;
                    }
                }
            }
            if(minX == -1) break;

            cur = new int[]{minX, minY};
            eatCnt++;
            map[cur[0]][cur[1]] = 0;
            if(eatCnt == size){
                size++;
                eatCnt = 0;
            }
            time += dist[cur[0]][cur[1]];

        }
        System.out.print(time);
    }
}
