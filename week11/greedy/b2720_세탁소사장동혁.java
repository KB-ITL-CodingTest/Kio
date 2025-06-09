package week11.greedy;

import java.io.*;

// 25 10 5 1
public class b2720_세탁소사장동혁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for(int i =0;i<N;i++){
            int change = Integer.parseInt(br.readLine());
            bw.write((change/25) + " ");
            change = change % 25;
            bw.write((change/10) + " ");
            change = change % 10;
            bw.write((change/5) + " ");
            change = change % 5;
            bw.write((change) + " ");
            bw.newLine();
        }
        bw.flush();
    }
}
