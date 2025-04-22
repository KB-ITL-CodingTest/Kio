package week4_BFS_DFS.BFS;
import java.io.*;
import java.util.*;

/**
 * bfs에서 최적해 찾고 바로 종료하는 리팩토링 코드
 * 순서대로 탐색하여 거리가 늘어나는 순간 종료하여, x,y 가 작은 값은 pq를 통해 반환
 * 기존 코드에서 모든 bfs 구하고 나서 한번더 탐색하여 최적해를 찾는 비효율을 개선함
 */
public class b16236_babyShark_v2 {
    static int n, size = 2, eatCnt = 0;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1}; // 상좌우하 (우선순위 순서!)
    static int[] dy = {0, -1, 1, 0};

    static class Fish{
        int x, y, dist;
        public Fish(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static Fish bfs(int sx, int sy) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new ArrayDeque<>();
        PriorityQueue<Fish> pq = new PriorityQueue<>((a, b) -> {
            if (a.dist != b.dist) return a.dist - b.dist;
            if (a.x != b.x) return a.x - b.x;
            return a.y - b.y;
        });

        visited[sx][sy] = true;
        q.add(new int[]{sx, sy, 0});
        int minDist = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0], y = now[1], dist = now[2];

            if(dist > minDist) break;

            if(map[x][y] > 0 && map[x][y] < size){
                pq.add(new Fish(x, y, dist));
                minDist = dist;
                //이후로는 길이가 더 길어지므로 확인할 필요가 없다.
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (visited[nx][ny] || map[nx][ny] > size) continue;
                visited[nx][ny] = true;
                q.add(new int[]{nx, ny, dist + 1});
            }
        }

        return pq.isEmpty() ? null : pq.poll();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int sx = 0, sy = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;

        while (true) {
            Fish target = bfs(sx, sy);
            if (target == null) break; // 먹을 수 있는 물고기 없음

            time += target.dist;
            eatCnt++;
            if (eatCnt == size) {
                size++;
                eatCnt = 0;
            }

            map[target.x][target.y] = 0;
            sx = target.x;
            sy = target.y;
        }

        System.out.println(time);
    }
}
