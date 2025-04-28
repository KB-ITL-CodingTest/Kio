package week5.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b17086_babyShark2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        int cnt = 0;
        int[] dx = {-1, 0, 1, 0, -1, 1, -1, 1};
        int[] dy = {0, -1, 0, 1, -1, 1, 1, -1};
        int[][] visited = new int[N][M];
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    queue.add(new int[]{i,j});
                    visited[i][j] = 1;
                }
            }
        }
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i=0; i<8; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny] > 0) continue;
                queue.add(new int[]{nx, ny});
                visited[nx][ny] = visited[cur[0]][cur[1]] + 1;
            }
        }
        int ans = -1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                ans = Math.max(ans, visited[i][j]-1);
            }
        }
        System.out.print(ans);
    }
}
