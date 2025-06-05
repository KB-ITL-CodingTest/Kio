package week07.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b16945_매직스퀘어 {
    static int min = Integer.MAX_VALUE;
    static boolean isValid(int[][] arr){
        if(arr[0][0] + arr[1][1]+ arr[2][2] != 15 || arr[0][2] + arr[1][1]+ arr[2][0] != 15) return false;
        for(int i=0;i<3;i++){
            int sum = arr[i][0] + arr[i][1] + arr[i][2];
            if(sum != 15) return false;
            sum = arr[0][i] + arr[1][i] + arr[2][i];
            if(sum != 15) return false;
        }
        return true;
    }
    static void backtrack(int depth, int sum, boolean[]used, int[][] arr){
        if(sum >= min) return;
        if(depth == 9){
            if(isValid(arr)){
                min = Math.min(min, sum);
            }
            return;
        }
        for(int i=1;i<=9;i++){
            if(used[i]) continue;
            used[i] = true;
            int origin = arr[depth/3][depth%3];
            arr[depth/3][depth%3] = i;
            backtrack(depth+1,sum+Math.abs(origin-i),used,arr);
            arr[depth/3][depth%3] = origin;
            used[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[3][3];
        for(int i=0;i<3;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backtrack(0,0,new boolean[10],arr);
        System.out.print(min);
    }
}
