package week04.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b16173_jumpKing {
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    static boolean bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for(int i=0;i<2;i++){
                int nextX = x + dx[i]*map[x][y];
                int nextY = y + dy[i]*map[x][y];
                if(nextX >= n || nextY >= n || visited[nextX][nextY]) continue;
                visited[nextX][nextY] = true;
                q.offer(new int[]{nextX, nextY});
            }

        }
        return visited[n - 1][n - 1];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(bfs()){
            System.out.println("HaruHaru");
        }
        else{
            System.out.println("Hing");
        }
    }
}
