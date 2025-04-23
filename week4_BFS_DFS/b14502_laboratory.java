package week4_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b14502_laboratory {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] viruses = new int[10][2];
        int[][] empty = new int[100][2];
        int numEmpty = 0;
        int numViruses = 0;
        map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    viruses[numViruses++] = new int[] {i,j};
                }
                else if(map[i][j] == 0){
                    empty[numEmpty++] = new int[] {i,j};
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<numEmpty;i++){
            for(int j=i+1;j<numEmpty;j++){
                for(int k=j+1;k<numEmpty;k++){
                    int x1 = empty[i][0], y1 = empty[i][1], x2 = empty[j][0], y2 = empty[j][1], x3 = empty[k][0], y3 = empty[k][1];

                    if(map[x1][y1] != 0 || map[x2][y2] != 0 || map[x3][y3] != 0 ) continue;
                    map[x1][y1] = 1;
                    map[x2][y2] = 1;
                    map[x3][y3] = 1;
                    // bfs
                    int spread = 0;
                    visited = new boolean[N][M];
                    Deque<int[]> queue = new ArrayDeque<>();
                    for(int v = 0; v < numViruses; v++){
                        int[] curr = viruses[v];
                        queue.addLast(curr);
                        visited[curr[0]][curr[1]] = true;
                    }
                    while(!queue.isEmpty()){
                        int[] curr = queue.pollFirst();
                        for(int d=0;d<4;d++){
                            int nx = curr[0] + dx[d];
                            int ny = curr[1] + dy[d];
                            if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                            if(!visited[nx][ny] && map[nx][ny] == 0){
                                visited[nx][ny] = true;
                                queue.addLast(new int[] {nx,ny});
                                spread++;
                            }
                        }
                    }

                    max = Math.max(max, (numEmpty-spread-3));
                    map[x1][y1] = 0;
                    map[x2][y2] = 0;
                    map[x3][y3] = 0;
                }
            }
        }
        System.out.print(max);
    }
}
