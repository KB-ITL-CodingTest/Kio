package week05.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2146_bridge {
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static ArrayList<int[]> bfs(boolean[][] visited,int x, int y){
        ArrayList<int[]> res = new ArrayList<>();
        res.add(new int[]{x, y});
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x, y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int dir = 0; dir < 4; dir++){
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];
                if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if(map[nx][ny] != 1 || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                res.add(new int[]{nx, ny});
                q.offer(new int[]{nx, ny});
            }
        }
        return res;
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
        ArrayList<ArrayList<int[]>> islands = new ArrayList<ArrayList<int[]>>();
        boolean[][] visited = new boolean[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j] == 1 && !visited[i][j]){
                    visited[i][j] = true;
                    islands.add(bfs(visited,i,j));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(ArrayList<int[]> island: islands){
            int[][] dist = new int[n][n];
            boolean[][] visited2 = new boolean[n][n];
            Deque<int[]> q = new ArrayDeque<>();
            for(int[] row: island){
                visited2[row[0]][row[1]] = true;
                q.offer(new int[]{row[0], row[1]});
            }
            while(!q.isEmpty()){
                int[] cur = q.poll();
                for(int dir = 0; dir < 4; dir++){
                    int nx = cur[0] + dx[dir];
                    int ny = cur[1] + dy[dir];
                    if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                    if(visited2[nx][ny]) continue;
                    visited2[nx][ny] = true;
                    if(map[nx][ny] == 1){
                        min = Math.min(min, dist[cur[0]][cur[1]]);
                        continue;
                    }
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        System.out.print(min);
    }
}
