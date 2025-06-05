package week07.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14888_연산자끼워넣기 {
    static int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
    static int[] arr;
    static int n;
    static int plus,minus,divide,multiply;
    static void backtrack(int depth, int sum, int[]use){
        if(depth == n){
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }
        if(use[0] < plus){
            use[0]++;
            backtrack(depth+1,sum+arr[depth],use);
            use[0]--;
        }
        if(use[1] < minus){
            use[1]++;
            backtrack(depth+1,sum-arr[depth],use);
            use[1]--;
        }
        if(use[2] < multiply){
            use[2]++;
            backtrack(depth+1,sum*arr[depth],use);
            use[2]--;
        }
        if(use[3] < divide){
            use[3]++;
            backtrack(depth+1,sum/arr[depth],use);
            use[3]--;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        plus = Integer.parseInt(st.nextToken());
        minus = Integer.parseInt(st.nextToken());
        multiply = Integer.parseInt(st.nextToken());
        divide = Integer.parseInt(st.nextToken());
        backtrack(1,arr[0],new int[4]);
        System.out.println(max);
        System.out.println(min);
    }
}
