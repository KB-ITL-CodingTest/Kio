package week2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Stack<int[]> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int cur = Integer.parseInt(st.nextToken());
            while(!s.isEmpty() && s.peek()[0] < cur) {
                s.pop();
            }
            if(s.isEmpty()){
                bw.write("0 ");
            }
            else{
                bw.write(String.valueOf(s.peek()[1]));
                bw.write(" ");
            }
            s.push(new int[] {cur ,i+1});
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
