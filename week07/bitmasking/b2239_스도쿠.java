package week07.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class b2239_스도쿠 {
    static int[][] sudoku = new int[9][9];
    static boolean find = false;
    static ArrayList<int[]> blanks = new ArrayList<>();
    // 비트 연산을 통해 숫자 사용 여부를 판단한다. i,j에 K를 사용했는가? -> row[i], col[j], row[getBoxIndex(i,j)] 검사
    static int[] row = new int[9], col = new int[9], box = new int[9];

    static int getBoxIndex(int x, int y) {
        return (x / 3) * 3 + (y / 3);
    }

    static void simulate(int depth){
        if(find) return;
        if(depth == blanks.size()){
            find = true;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    sb.append(sudoku[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            return;
        }
        int[] pos = blanks.get(depth);
        int x = pos[0];
        int y = pos[1];
        int boxIndex = getBoxIndex(x,y);
        for(int i=1;i<=9;i++){
            int bit = 1 << i;
            if((row[x] & bit) != 0 || (col[y] & bit) != 0 || (box[boxIndex] & bit) != 0) continue;
            sudoku[x][y] = i;
            row[x] |= bit;
            col[y] |= bit;
            box[boxIndex] |= bit;
            simulate(depth+1);
            sudoku[x][y] = 0;
            row[x] &= ~bit;
            col[y] &= ~bit;
            box[boxIndex] &= ~bit;
            if(find) return;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0;i<9;i++){
            String line = br.readLine();
            for(int j=0;j<9;j++){
                int num = line.charAt(j) - '0';
                sudoku[i][j] = num;
                if(num == 0){
                    blanks.add(new int[]{i,j});
                }
                else{
                    int bit = 1 << num;
                    row[i] |= bit;
                    col[j] |= bit;
                    box[getBoxIndex(i,j)] |= bit;
                }
            }
        }
        simulate(0);
    }
}
