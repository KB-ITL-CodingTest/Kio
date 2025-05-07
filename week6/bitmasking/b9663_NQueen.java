package week6.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b9663_NQueen {
    static int N, count = 0;

    static void solve(int row, int col, int ld, int rd) {
        if (row == N) {
            count++;
            return;
        }
        // (1<<N)-1 -> 1로 n bit로 이루어진 수
        // 아직 사용 가능한 위치가 1로 나타난다.
        int available = ((1 << N) - 1) & ~(col | ld | rd); // 가능한 위치

        while (available != 0) {
            // ex) 010100 이라면 100이 추출된다. 즉 가장 오른쪽 0이 아닌 비트 추출
            int bit = available & -available;
            // ex) 010100 - 000100 = 010000 추출한 비트 제거
            available -= bit;
            // col: 현재 사용한 위치 방문처리
            // ld: 왼쪽 대각선은 row가 밑으로 내려갈 수록 한칸씩 왼쪽으로 밀린다. <<로 계산가능
            // rd: 오른쪽 대각선은 반대로 오른쪽으로 한칸씩 밀리므로 >>로 계산 가능
            solve(row + 1, col | bit, (ld | bit) << 1, (rd | bit) >> 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        solve(0, 0, 0, 0);
        System.out.println(count);
    }
}

