package week02.queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 식당입구대기줄 {
    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int maxNum = 0, maxIdx = 123456789;
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int mode = Integer.parseInt(st.nextToken());
            if(mode == 1){
                int cur = Integer.parseInt(st.nextToken());
                q.offer(cur);
                if(maxNum < q.size()){
                    maxNum = q.size();
                    maxIdx = cur;
                }
                else if(maxNum == q.size() && maxIdx > cur){
                    maxIdx = cur;
                }
            }
            else{
                q.poll();
            }
        }
        bw.write(String.valueOf(maxNum));
        bw.write(" ");
        bw.write(String.valueOf(maxIdx));
        bw.flush();
        bw.close();
        br.close();
    }
}
