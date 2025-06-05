package week01.BFS;

import java.io.*;
import java.util.*;

public class 토마토 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); // 열 (가로)
        int n = Integer.parseInt(st.nextToken()); // 행 (세로)

        int[][] tomatoes = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        int total = n * m, done = 0, days = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomatoes[i][j] = Integer.parseInt(st.nextToken());
                if (tomatoes[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    done++;
                } else if (tomatoes[i][j] == -1) {
                    total--;
                }
            }
        }

        while (!q.isEmpty() && done < total) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int curX = cur[0], curY = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nextX = curX + dx[d];
                    int nextY = curY + dy[d];

                    if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && tomatoes[nextX][nextY] == 0) {
                        tomatoes[nextX][nextY] = 1;
                        q.offer(new int[]{nextX, nextY});
                        done++;
                    }
                }
            }
            days++;
        }

        bw.write((done == total) ? String.valueOf(days) : "-1");
        bw.flush();
        bw.close();
        br.close();
    }
}
