package week5.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class b13459_beadEscape {
    static int N, M;
    // rx,ry,bx,by -> 두 구슬의 위치를 동시에 확인함
    static boolean[][][][] visited;
    static char[][] map;
    // up right down left
    static int[][] directions = {{-1,0},{0,1},{1,0},{0,-1}};

    // 해당 방향으로 구슬을 굴린다. 구멍에 도달하면 바로 리턴
    static int[] move(int x, int y, int dir) {
        int dx = directions[dir][0];
        int dy = directions[dir][1];
        // cnt = 이동한 거리, 만약 두 구슬이 같은 축에서 이동한다면 겹치는 현상 발생. 하나를 뒤로 빼야하므로 누가 늦게 도착했는지 판별하기 위해 계산한다.
        int cnt = 0;
        while(true){
            int nx = x + dx, ny = y + dy;
            if(map[nx][ny] == '#') break;
            x = nx;
            y = ny;
            cnt++;
            if(map[x][y] == 'O') break;
        }
        return new int[]{x, y, cnt};
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        int[] red = null, blue = null, goal = null;
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                char ch = row.charAt(j);
                if(ch == 'R'){
                    red = new int[]{i,j};
                    map[i][j] = '.';
                }
                else if(ch == 'B'){
                    blue = new int[]{i,j};
                    map[i][j] = '.';
                }
                else{
                    map[i][j] = row.charAt(j);
                }

            }
        }
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{red[0], red[1], blue[0], blue[1], 0});
        visited[red[0]][red[1]][blue[0]][blue[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            // 10회 이상 지났다면 진행 중단
            if(cur[4] == 10) continue;
            for(int dir = 0; dir < 4; dir++){
                int[] nRed = move(cur[0], cur[1], dir);
                int[] nBlue = move(cur[2], cur[3], dir);
                // 파란 구슬이 구멍에 들어갔다면 중단
                if(goal[0] == nBlue[0] && goal[1] == nBlue[1]) continue;
                // 파란 구슬이 들어가지 않고, 빨간 구슬이 들어갔다면 성공
                if(goal[0] == nRed[0] && goal[1] == nRed[1]){
                    System.out.println(1);
                    return;
                }
                // 만약 둘이 같은 위치에 있다면 하나를 뒤로 빼야한다.
                if(nRed[0] == nBlue[0] && nRed[1] == nBlue[1]){
                    if(nRed[2] > nBlue[2]){
                        nRed[0] -= directions[dir][0];
                        nRed[1] -= directions[dir][1];
                    }
                    else{
                        nBlue[0] -= directions[dir][0];
                        nBlue[1] -= directions[dir][1];
                    }
                }
                //이미 나타났던 상태라면 중단
                if(visited[nRed[0]][nRed[1]][nBlue[0]][nBlue[1]]) continue;
                visited[nRed[0]][nRed[1]][nBlue[0]][nBlue[1]] = true;
                q.offer(new int[]{nRed[0], nRed[1], nBlue[0], nBlue[1], cur[4] + 1});

            }
        }
        System.out.println(0);
    }
}
