package week5.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b2146_bridge_advanced {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static void bfs(int x, int y, int no){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        q.offer(new int[]{x, y});
        map[x][y] = no;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(map[nx][ny] != 1 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                map[nx][ny] = no;
                q.offer(new int[]{nx, ny});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int no = 2;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1){
                    bfs(i,j,no++);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        // 0:거리, 1:섬 번호
        int[][][] dist = new int[n][n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] > 1){
                    q.add(new int[]{i, j, map[i][j]});
                    visited[i][j] = true;
                    dist[i][j][1] = map[i][j];
                }
            }
        }
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(map[nx][ny] == 0 && !visited[nx][ny]) {
                    q.add(new int[]{nx, ny, cur[2]});
                    dist[nx][ny][0] = dist[cur[0]][cur[1]][0] + 1;
                    dist[nx][ny][1] = dist[cur[0]][cur[1]][1];
                    visited[nx][ny] = true;
                }
                else if(visited[nx][ny] && dist[nx][ny][1] != cur[2]){
                    min = Math.min(min, dist[cur[0]][cur[1]][0] + dist[nx][ny][0]);
                }

            }
        }
        System.out.print(min);
    }
}
