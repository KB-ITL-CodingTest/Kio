package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14891_gear {
    static int[][] gears = new int[4][8];
    //각 톱니바퀴의 위 오른쪽 왼쪽 index 저장
    static int[] top = new int[4];
    static boolean[] visited;
    static void rotate(int target, int dir){
        visited[target] = true;
        // 톱니 위치 변하기전에 호출한다.
        // 왼쪽 기어 화전
        int left = (top[target] + 6) % 8;
        int right = (top[target] + 2) % 8;
        if(target > 0 && !visited[target-1] ){
            int lRight = (top[target-1]+2)%8;
            if(gears[target][left] != gears[target-1][lRight]) {
                rotate(target - 1, -dir);
            }
        }
        // 오른쪽 기어 회전
        if(target < 3 && !visited[target+1]){
            int rLeft = (top[target+1]+6) % 8;
            if(gears[target][right] != gears[target+1][rLeft]) {
                rotate(target + 1, -dir);
            }
        }
        if(dir == -1){
            top[target] = (top[target] + 1)%8;
        }
        else{
            top[target] = (top[target] + 7)%8;
        }

    }
    public static void main(String[] args) throws IOException {
        // 시계(1) -> -1 씩 이동, 반시계(-1) -> +1씩 이동
        // 톱니바퀴 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0;i < 4;i++){
            String line = br.readLine();
            for(int j = 0;j < 8;j++){
                gears[i][j] = line.charAt(j) - '0';
            }
        }
        int n = Integer.parseInt(br.readLine());
        for(int i = 0;i < n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            visited = new boolean[4];
            rotate(target -1,dir);
        }
        int score = 0;
        for(int i = 0;i < 4;i++){
            if(gears[i][top[i]] == 1){
                score += (int) Math.pow(2,i);
            }
        }
        System.out.print(score);
    }
}
