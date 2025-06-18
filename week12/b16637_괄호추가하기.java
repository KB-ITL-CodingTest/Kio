package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b16637_괄호추가하기 {
    static int max, n;
    static char[] expr;
    static void backtrack(int depth, int res){
        if(depth >= n-1){
            max = Math.max(max, res);
            return;
        }

        //괄호없이 계산
        char op = expr[depth+1];
        int num = expr[depth+2] - '0';
        int result = calculate(res, num, op);
        backtrack(depth+2, result);

        // 뒤에 괄호치기
        if(depth + 4 < n){
            int num2 = expr[depth+4] - '0';
            char op2 = expr[depth+3];
            int result2 = calculate(num, num2, op2);
            result = calculate(res, result2, op);
            backtrack(depth+4, result);
        }
    }
    static int calculate(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        return a * b;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        expr = br.readLine().toCharArray();
        max = Integer.MIN_VALUE;
        backtrack(0, expr[0] - '0');
        System.out.print(max);
    }
}
