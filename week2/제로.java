package week2;

import java.io.*;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] stack = new int[n];
        int top = -1;
        for(int i=0;i<n;i++){
            int cur = Integer.parseInt(br.readLine());
            if(cur == 0){
                sum -= stack[top--];
                continue;
            }
            sum += cur;
            stack[++top] = cur;
        }
        bw.write(String.valueOf(sum));
        bw.close();
        br.close();
    }
}
