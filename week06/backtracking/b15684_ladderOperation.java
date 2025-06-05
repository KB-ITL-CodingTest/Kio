package week06.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b15684_ladderOperation {
    static int N,M,H;
    static boolean[][] ladders;
    static int answer = -1;
    // 모든 사다리가 자신의 위치로 가는지 확인하는 시뮬레이션 코드
    static boolean simulate(){
        for(int i=0;i<N;i++){
            int cur = i;
            for(int h=0;h<H;h++){
                if(cur > 0 && ladders[h][cur-1]){
                    cur--;
                }
                else if(cur < N-1 && ladders[h][cur]){
                    cur++;
                }
            }
            if(cur != i) return false;
        }
        return true;
    }
    static void backtrack(int goal, int depth, int x, int y){
        //이미 최소값이 나타났다면
        if(answer != -1) return;
        if(depth == goal){
            if(simulate()) {
                answer = depth;
            }
            return;
        }
        // 사다리 추가 순서는 가로 -> 세로 순서로 하였다.
        // 위 x줄은 이미 검사했으므로 x부터 시작
        for(int h=x;h<H;h++){
            // 사다리를 가로로 확인해가며 다리 추가함.
            // h == x, 즉 첫 줄이라면 이전 왼쪽 y개는 이미 검사했으므로 패스, 다음 아래 줄로 넘어갔다면 다시 0부터 해봐야함.
            for(int i=(h==x ? y : 0);i<N-1;i++){
                // 추가할 위치와 왼쪽, 오른쪽에 사다리가 있다면 패스
                if(ladders[h][i]) continue;
                if(i>0 && ladders[h][i-1]) continue;
                if(i<N-2 && ladders[h][i+1]) continue;

                ladders[h][i] = true;
                // i+2를 하는 이유는 이번에 사다리를 추가했다면 오른쪽에는 사다리 추가가 불가하므로 중복 검사 줄이기 위함.
                backtrack(goal,depth+1,h,i+2);
                ladders[h][i] = false;
                if(answer != -1) return;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        ladders = new boolean[H][N-1];
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ladders[a-1][b-1] = true;
        }
        // 최적화를 위해 0개의 사다리부터 3개의 사다리를 쓰는 경우를 분리해서 확인
        for(int i=0;i<=3;i++){
            backtrack(i,0,0,0);
            // 답을 찾았다면 조기 종료
            if(answer != -1) break;
        }
        System.out.print(answer);
    }
}
