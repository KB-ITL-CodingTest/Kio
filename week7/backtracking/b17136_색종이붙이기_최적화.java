package week7.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b17136_색종이붙이기_최적화 {
    static int[] used = new int[] {0,5,5,5,5,5};
    static int[][] board = new int[10][10];
    static int cnt;
    static int answer = Integer.MAX_VALUE;

    // 색종이를 붙이고 떼는 함수. state = 0 : 붙인다, 1: 뗀다
    static void attach(int x, int y, int size, int state){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                board[x+i][y+j] = state;
            }
        }
    }
    static int check(int x, int y){
        int minSize = 1;
        for(int size = 1; size < 5; size++){
            // 범위 체크
            boolean flag = true;
            if(x+size >= 10 || y+size >= 10) break;
            if(board[x+size][y+size] == 0) break;
            for(int i=0;i<size;i++){
                if(board[x+i][y+size] == 0) {
                    flag = false;
                    break;
                }
                if(board[x+size][y+i] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                minSize++;
            }
            else{
                break;
            }
        }
        return minSize;
    }
    static void backtrack(int x, int y, int useCnt, int remain){
        if(useCnt >= answer) return;
        // 앞에서 useCnt는 현재 최소값보다 작다고 확인했으므로 바로 업데이트한다.
        if(remain == 0){
            answer = useCnt;
            return;
        }
        int nx = -1;
        int ny = -1;
        boolean find = false;
        for(int i=x;i<10;i++){
            for(int j=( x == i ? y : 0); j<10; j++){
                if(board[i][j] == 0 ) continue;
                nx = i;
                ny = j;
                find = true;
                break;
            }
            if(find) break;
        }
        if(!find) return;
        // 타겟 위치를 찾았다면 백트래킹 진행
        int maxSize = check(nx,ny);
        // 가능한 최대 크기부터 진행해야 가지치기를 효과적으로 할 수 있다.
        for(int size = maxSize; size > 0; size--){
            // 해당 크기의 종이가 없다면 다음 크기로
            if(used[size] == 0) continue;
            // 색종이 붙이기
            attach(nx,ny,size,0);
            used[size]--;
            if(ny == 9){
                backtrack(nx+1, 0,useCnt+1,remain-size*size);
            }
            else{
                backtrack(nx, ny+1,useCnt+1,remain-size*size);
            }
            used[size]++;
            attach(nx,ny,size,1);
        }

    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<10;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<10;j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if(num == 1){
                    cnt++;
                }
            }
        }
        backtrack(0,0,0,cnt);
        System.out.print((answer == Integer.MAX_VALUE) ? -1 : answer);
    }
}
