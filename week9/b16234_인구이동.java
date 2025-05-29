package week9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class b16234_인구이동 {
    static int n,l,r;
    static int[][] map;
    static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    static int[][] union;
    static int bfs(int x, int y, int idx){
        int cnt = 1;
        int sum = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        union[x][y] = idx;
        sum += map[x][y];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0]; int cy = cur[1];
            for(int d = 0; d<4; d++){
                int nx = cx + dx[d]; int ny = cy + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || union[nx][ny] != 0) continue;
                int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                if(diff < l || diff > r) continue;
                union[nx][ny] = idx;
                q.offer(new int[]{nx,ny});
                sum += map[nx][ny];
                cnt++;
            }
        }
        if(cnt == 1) return -1;
        return sum / cnt;
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while(true){
            boolean moved = false;
            union = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(union[i][j] == 0) {
                        // 경우의 수를 미리 줄여서 메모리, 속도 성능이 크게 오른다(특히 메모리). 깔끔한 코드를 위해서는 없애는게 낫다.
                        boolean isConnected = false;
                        for (int k = 0 ; k < 4 ; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if(nx < 0 || nx >= n || ny < 0 || ny >= n || union[nx][ny] != 0) continue;
                            int diff = Math.abs(map[i][j] - map[nx][ny]);
                            if(diff < l || diff > r) continue;
                            isConnected = true;
                            break;
                        }
                        if (!isConnected) continue;
                        int idx = n*i + j + 1;
                        int avg = bfs(i, j, idx);
                        moved = true;
                        map[i][j] = avg;
                    }
                    else{
                        int idx = union[i][j] - 1;
                        int x = idx/n; int y = idx%n;
                        map[i][j] = map[x][y];
                    }
                }
            }
            if(!moved) break;
            cnt++;
        }

        System.out.print(cnt);
    }
}
