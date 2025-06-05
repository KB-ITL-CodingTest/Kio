package week10.dp;

import java.io.IOException;
import java.util.*;

public class b2342_ddr {
    static int nextInt() throws IOException {
        int c;
        //숫자가 나올때까지 읽는다.
        while (!Character.isDigit(c = System.in.read()));
        //char -> int로 변환. 하위 4비트만 남기는데, 이 값이 0~9가 된다.
        int value = c & 15;
        // 두자리이 이상인 경우 누적해서 공백이 나타날때까지 계산
        while (Character.isDigit(c = System.in.read())) {
            value = value * 10 + (c & 15);
        }
        return value;
    }

    static int calcCost(int from, int to){
        if(from == 0) return 2;
        if(from == to) return 1;
        if(Math.abs(from-to) == 2) return 4;
        return 3;
    }
    public static void main(String[] args) throws IOException {
        List<Integer> steps = new ArrayList<>();
        int input;
        while ((input = nextInt()) != 0) {
            steps.add(input);
        }
        int n = steps.size();
        int[][][] dp = new int[n+1][5][5];
        for(int i=0;i<=n;i++){
            for(int j=0;j<5;j++){
                Arrays.fill(dp[i][j],Integer.MAX_VALUE);
            }
        }
        // 초기값 (0,0)에서의 드는 힘 0으로 초기화
        dp[0][0][0] = 0;
        for(int step = 1;step<=n;step++){
            int target = steps.get(step-1);
            // (0,0) 부터 (5,5)까지 모든 경우의 수 확인
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    // (l,r)에서 스텝까지 사용한 힘의 최소값
                    int curCost = dp[step - 1][l][r];
                    // 업데이트 되지 않았다면, 즉 도달할 수 없는 위치라면 무시
                    if (curCost == Integer.MAX_VALUE) continue;
                    // 왼발로 이동
                    int leftMoveCost = calcCost(l, target);
                    dp[step][target][r] = Math.min(dp[step][target][r], curCost + leftMoveCost);
                    // 오른발로 이동
                    int rightMoveCost = calcCost(r, target);
                    dp[step][l][target] = Math.min(dp[step][l][target], curCost + rightMoveCost);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                ans = Math.min(ans, dp[n][i][j]);
            }
        }
        System.out.print(ans);
    }
}
