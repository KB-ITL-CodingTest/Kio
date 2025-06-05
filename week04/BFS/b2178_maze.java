package week04.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2178_maze {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] maze = new char[n][m];
        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                maze[i][j] = line.charAt(j);
            }
        }
        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = 1;
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if(maze[nx][ny] == '1' && visited[nx][ny] == 0){
                    visited[nx][ny] = visited[x][y] + 1;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        System.out.println(visited[n-1][m-1]);
    }
}
