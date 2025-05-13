package week7.backtracking;

import java.io.*;
import java.util.HashSet;

// 중복 조합 문제 - 현재 선택한 숫자부터 다시 뽑는다!
public class b16922_로마숫자만들기 {
    static int n;
    static HashSet<Integer> hs = new HashSet<>();
    static int[] numbers = {1,5,10,50};
    static void backtrack(int depth,int start, int sum){
        if(depth == n){
            hs.add(sum);
            return;
        }
        for(int i=start;i<4;i++){
            backtrack(depth+1, i, sum+numbers[i]);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        backtrack(0,0,0);
        System.out.print(hs.size());
    }
}
