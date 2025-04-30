package week1.BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 적록색약 {
    static int n;
    static char[][] map;
    static char[][] map2;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static void bfs(int x, int y, boolean normal){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visited[x][y] = true;
        if(normal){
            while(!q.isEmpty()){
                int[] cur = q.poll();
                for(int i=0;i<4;i++){
                    int nextX = cur[0]+dx[i];
                    int nextY = cur[1]+dy[i];
                    if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n){
                        if(map[nextX][nextY] == map[x][y] && !visited[nextX][nextY]){
                            q.offer(new int[]{nextX,nextY});
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }
        else{
            while(!q.isEmpty()){
                int[] cur = q.poll();
                for(int i=0;i<4;i++){
                    int nextX = cur[0]+dx[i];
                    int nextY = cur[1]+dy[i];
                    if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < n){
                        if(map2[nextX][nextY] == map2[x][y] && !visited[nextX][nextY]){
                            q.offer(new int[]{nextX,nextY});
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
        }
    }
    static int solution(boolean normal){
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(i, j, normal);
                    ans++;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new char[n][n];
        map2 = new char[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++) {
                char cur = line.charAt(j);
                map[i][j] = cur;
                if(cur == 'R' || cur == 'G')
                    map2[i][j] = 'R';
            }
        }
        bw.write(String.valueOf(solution(true))+ " ");
        visited = new boolean[n][n];
        bw.write(String.valueOf(solution(false)));
        bw.flush();
        bw.close();
        br.close();
    }
}
