package week11;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class b14890_경사로 {
    static int[][] map;
    static int n,l;
    static boolean checkPath(int startX,int startY,int dx,int dy){
        boolean[] used = new boolean[n];
        for(int i=0;i<n-1;i++){
            int x1= startX+i*dx;
            int y1= startY+i*dy;
            int x2= startX+(i+1)*dx;
            int y2= startY+(i+1)*dy;

            int curr = map[x1][y1];
            int next = map[x2][y2];

            if(curr == next) continue;

            // 올라가는 경사
            if(curr + 1 == next){
                if(i-l+1 < 0) return false;
                for(int j=0;j<l;j++){
                    int px = x1-j*dx;
                    int py = y1-j*dy;
                    int idx = i - j;
                    if(used[idx] || map[px][py] != curr) return false;
                    used[idx] = true;
                }
            }
            // 내려가는 경사
            else if(curr - 1 == next){
                if(i+l >= n) return false;
                for(int j=1;j<=l;j++){
                    int nx = x1+j*dx;
                    int ny = y1+j*dy;
                    int idx = i + j;
                    if(used[idx] || map[nx][ny] != next) return false;
                    used[idx] = true;
                }
            }
            // 1 이상 차이남 -> 경사로 설치 못함
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(checkPath(i,0,0,1)) ans++;
            if(checkPath(0,i,1,0)) ans++;
        }
        System.out.print(ans);
    }
}
