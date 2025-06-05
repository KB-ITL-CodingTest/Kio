package week06.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9663_NQueen {
    static boolean[] leftDiagonal;
    static boolean[] rightDiagonal;
    static boolean[] colVisited;
    static int cnt = 0;
    static int N;
    static void backtrack(int row) {
        if(row == N){
            cnt++;
            return;
        }
        for(int col=0; col< N; col++){
            if(colVisited[col] || rightDiagonal[row+col] || leftDiagonal[N-1-col+row]) continue;
            colVisited[col] = true;
            rightDiagonal[row+col] = true;
            leftDiagonal[N-1-col+row] = true;
            backtrack(row+1);
            colVisited[col] = false;
            rightDiagonal[row+col] = false;
            leftDiagonal[N-1-col+row] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        leftDiagonal = new boolean[2*N-1];
        rightDiagonal = new boolean[2*N-1];
        colVisited = new boolean[N];
        backtrack(0);
        System.out.print(cnt);
    }
}
