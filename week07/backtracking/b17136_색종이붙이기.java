package week07.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b17136_색종이붙이기 {
    static int[] used = new int[5];
    static ArrayList<int[]> target = new ArrayList<>();
    static int cnt;
    static int answer = Integer.MAX_VALUE;
    static int check(int maxSize, int x, int y, int[][] board){
        int minSize = 1;
        for(int size = 1; size < maxSize; size++){
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
    static int[][] copyArr(int[][] board){
        int[][] copy = new int[10][10];
        for(int j=0;j<10;j++){
            System.arraycopy(board[j],0,copy[j],0,10);
        }
        return copy;
    }
    static void backtrack(int depth, int remain, int useCnt, int[][] board){
        // 최소값이 아니므로 더 이상 진행할 필요가 없다.
        if(useCnt > answer) return;
        // 조건을 완성했고, 이전 조건에서 최소값인 것도 확인했으므로 바로 업데이트
        if(remain == 0){
            answer = useCnt;
            return;
        }
        // 끝까지 도달했다면 종료
        if(depth == target.size()) return;
        int[] cur = target.get(depth);
        int size = board[cur[0]][cur[1]];
        if(size == 0){
            backtrack(depth+1,remain,useCnt,board);
        }
        else {
            size = check(size, cur[0], cur[1], board);
            for (int i = size; i > 0; i--) {
                // 해당 크기의 종이를 모두 사용했다면 다음 크기로 넘어간다.
                if(used[i-1] >= 5) continue;
                //복사본을 사용, board에 1~5까지의 수가 저장되어있어 복구하기가 힘들어 복사본을 사용하였다. 좋은 방법은 x
                int[][] copy = copyArr(board);
                //색종이 붙이기
                for(int j=0;j<i;j++){
                    for(int k=0;k<i;k++){
                        copy[cur[0]+j][cur[1]+k] = 0;
                    }
                }
                // 색종이 사용 표시
                used[i-1]++;
                //remain: 남은 1 개수, usecnt: 사용한 종이 개수
                backtrack(depth+1, remain - i*i, useCnt + 1, copy);
                used[i-1]--;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        int[][] board = new int[10][10];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<10;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<10;j++){
                int num = Integer.parseInt(st.nextToken());
                board[i][j] = num;
                if(num == 1){
                    cnt++;
                    target.add(new int[]{i,j});
                }
            }
        }

        // 보드 업데이트
        for(int[] cur: target){
            board[cur[0]][cur[1]] = check(5,cur[0],cur[1],board);
        }

        backtrack(0,cnt,0,board);
        System.out.print((answer == Integer.MAX_VALUE) ? -1 : answer);
    }
}
