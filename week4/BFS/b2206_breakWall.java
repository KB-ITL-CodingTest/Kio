package week4.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2206_breakWall {
    static int N,M;
    static char[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        class Node{
            int x, y;
            int useBreak;
            Node(int x, int y, int useBreak) {
                this.x = x;
                this.y = y;
                this.useBreak = useBreak;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[N][M][2];
        for(int x = 0; x < N; x++){
            String line = br.readLine();
            for(int y = 0; y < M; y++){
                map[x][y] = line.charAt(y);
            }
        }
        //bfs
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(0,0,0));
        visited[0][0][0] = 1;
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visited[nx][ny][cur.useBreak] == 0 && map[nx][ny] == '0'){
                    visited[nx][ny][cur.useBreak] = visited[cur.x][cur.y][cur.useBreak] + 1;
                    q.offer(new Node(nx,ny,cur.useBreak));
                }
                else if(visited[nx][ny][1] == 0 && map[nx][ny] == '1' && cur.useBreak == 0){
                    visited[nx][ny][1] = visited[cur.x][cur.y][0] + 1;
                    q.offer(new Node(nx,ny,1));
                }
            }
        }
        int res = 0;
        if(visited[N-1][M-1][0] == 0 && visited[N-1][M-1][1] == 0){
            res = -1;
        } else if(visited[N-1][M-1][0] == 0){
            res = visited[N-1][M-1][1];
        } else if(visited[N-1][M-1][1] == 0){
            res = visited[N-1][M-1][0];
        } else {
            res = Math.min(visited[N-1][M-1][0], visited[N-1][M-1][1]);
        }
        System.out.print(res);
    }
}
