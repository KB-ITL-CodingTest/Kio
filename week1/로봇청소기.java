package week1;

import java.io.*;
import java.util.*;

public class 로봇청소기 {
    //0 -> up, 1->right, 2-> down, 3-> left
    static int n,m,r,c,dir;
    static int[][] map;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int done = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        while(true){
            if(map[r][c] == 0){
                map[r][c] = -1;
                done++;
            }
            boolean found = false;
            for(int i=0;i<4;i++){
                dir = (dir+3)%4;
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0){
                    c = nc;
                    r = nr;
                    found = true;
                    break;
                }

            }
            if(!found){
                int rDir = (dir+2)%4;
                int nr = r + dr[rDir];
                int nc = c + dc[rDir];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] < 1) {
                    c = nc;
                    r = nr;
                }
                else{
                    break;
                }
            }
        }
        System.out.print(done);
        br.close();
    }
}
