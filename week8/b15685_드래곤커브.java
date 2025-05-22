package week8;

import java.io.BufferedReader;
import java.util.StringTokenizer;

public class b15685_드래곤커브 {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[101][101];
        for(int i=0;i<n;i++){
            StringTokenizer line = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(line.nextToken());
            int y = Integer.parseInt(line.nextToken());
            int d = Integer.parseInt(line.nextToken());
            int g = Integer.parseInt(line.nextToken());
            int[] stack = new int[(int) Math.pow(2,g)];
            map[x][y] = true;
            x += dx[d];
            y += dy[d];
            stack[0] = d;
            map[x][y] = true;
            int top = 0;
            while(g>0){
                for(int j=top;j>=0;j--){
                    d = (stack[j] + 1) % 4;
                    x += dx[d];
                    y += dy[d];
                    stack[++top] = d;
                    map[x][y] = true;
                }
                g--;
            }
        }
        int cnt = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]) cnt++;
            }
        }
        System.out.print(cnt);
    }
}
