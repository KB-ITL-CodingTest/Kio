package week3;

import java.io.*;
import java.util.StringTokenizer;

public class b14499_주사위굴리기 {

    public static void main(String[] args) throws IOException {
        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] commands = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            commands[i] = Integer.parseInt(st.nextToken());
        }
        //실행
        //이동 시 일어나는 일
        //위에 있던 수 -> 이동방향으로 ex) 동쪽으로 이동 시 다음 위치는 동쪽이 됨.
        //아래 있던 수 -> 이동방향 반대
        //이동 방향에 있던 수(동쪽으로 이동 시 동쪽) -> 아래로
        //이동 방향 반대에 있던 수(동쪽 이동시 서쪽) -> 위로
        //무관한 2개의 수(동서 이동 시 남북, 남북 이동시 동서) -> 그대로

        //1 동쪽 (0,1) 2 서 (0,-1) 3 북 (-1,0) 4 남(1,0)
        int[] dx = {0,0,0,-1,1};
        int[] dy = {0,1,-1,0,0};
        //위 동 서 북 남 아래
        int[] dice = {0,0,0,0,0,0};
        
        int curX = x;
        int curY = y;
        for(int i=0;i<k;i++){
            int command = commands[i];
            int nextX = curX + dx[command];
            int nextY = curY + dy[command];
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m){
                continue;
            }
            //이동
            curX = nextX;
            curY = nextY;
            //주사위 굴리기
            int tmp;
            switch(command){
                case 1:
                    tmp = dice[1];
                    dice[1] = dice[0];
                    dice[0] = dice[2];
                    dice[2] = dice[5];
                    dice[5] = tmp;
                    break;
                case 2:
                    tmp = dice[2];
                    dice[2] = dice[0];
                    dice[0] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = tmp;
                    break;
                case 3:
                    tmp = dice[3];
                    dice[3] = dice[0];
                    dice[0] = dice[4];
                    dice[4] = dice[5];
                    dice[5] = tmp;
                    break;
                case 4:
                    tmp = dice[4];
                    dice[4] = dice[0];
                    dice[0] = dice[3];
                    dice[3] = dice[5];
                    dice[5] = tmp;
                    break;
            }
            if(map[curX][curY] == 0){
                map[curX][curY] = dice[5];
            }
            else{
                dice[5] = map[curX][curY];
                map[curX][curY] = 0;
            }
            bw.write(String.valueOf(dice[0]) + "\n");
        }
        bw.flush();

    }
}
