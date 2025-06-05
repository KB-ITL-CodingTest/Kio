package week02.stack;

import java.io.*;
import java.util.Stack;

public class 문자열폭발 {
    static class Pair {
        char c;
        int i;

        public Pair(char c, int i) {
            this.c = c;
            this.i = i;
        }
    }
    static Stack<Pair> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int maxIdx = bomb.length();
        for(int i=0;i<str.length();i++){
            int idx = s.isEmpty() ? 0 : s.peek().i;
            char cur = str.charAt(i);
            if(bomb.charAt(idx) == cur){
                if(maxIdx == idx + 1){
                    for(int j=0;j<maxIdx-1;j++)
                        s.pop();
                }
                else {
                    idx++;
                    s.push(new Pair(cur,idx));
                }
            }
            else{
                if(bomb.charAt(0) == cur)
                    s.push(new Pair(cur,1));
                else
                    s.push(new Pair(cur,0));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop().c);
        }
        sb.reverse();
        System.out.print(sb.length() == 0  ? "FRULA" : sb.toString());
    }
}
