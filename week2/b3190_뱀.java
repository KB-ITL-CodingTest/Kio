import java.io.*;
import java.util.*;

public class b3190_뱀 {
    static int[][] map;
    static int n;
    static int[] dx = {0, 1, 0, -1}; // 오른쪽, 아래, 왼쪽, 위
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x - 1][y - 1] = 2; // 사과
        }

        int l = Integer.parseInt(br.readLine());
        int[][] commands = new int[l][2];

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            commands[i][0] = time;
            commands[i][1] = dir.equals("D") ? 1 : 0; // D: 오른쪽, L: 왼쪽
        }

        Deque<int[]> snake = new LinkedList<>();
        snake.add(new int[]{0, 0});
        map[0][0] = 1; // 뱀의 머리

        int dir = 0; // 시작 방향: 오른쪽
        int time = 0;
        int commandIndex = 0;

        while (true) {
            time++;

            // 현재 머리 위치
            int[] head = snake.peekLast();
            int nx = head[0] + dx[dir];
            int ny = head[1] + dy[dir];

            // 벽에 부딪히거나, 자기 자신에게 부딪히면 게임 종료
            if (nx < 0 || ny < 0 || nx >= n || ny >= n || map[nx][ny] == 1) {
                break;
            }

            // 이동
            if (map[nx][ny] == 2) {
                // 사과가 있으면 머리만 이동 (꼬리 안 움직임)
                map[nx][ny] = 1;
                snake.addLast(new int[]{nx, ny});
            } else {
                // 사과 없으면 꼬리 이동
                int[] tail = snake.pollFirst();
                map[tail[0]][tail[1]] = 0;
                map[nx][ny] = 1;
                snake.addLast(new int[]{nx, ny});
            }

            // 방향 전환
            if (commandIndex < l && time == commands[commandIndex][0]) {
                if (commands[commandIndex][1] == 1) {
                    dir = (dir + 1) % 4; // 오른쪽 회전
                } else {
                    dir = (dir + 3) % 4; // 왼쪽 회전
                }
                commandIndex++;
            }
        }

        System.out.print(time);
    }
}
