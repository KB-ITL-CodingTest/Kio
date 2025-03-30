package week1;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {
    static int[] map =  new int[100001];
    public static int bfs(int n, int k){
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        map[n] = 1;
        while(!q.isEmpty() && map[k] == 0){
            int cur = q.poll();
            int[] dx = {-1,1,cur};
            for(int i: dx){
                int next = cur + i;
                if(next >= 0 && next <= 100000 && map[next] == 0){
                    q.offer(next);
                    map[next] = map[cur]+1;
                }
            }
        }
        return map[k] - 1;
    }
    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(bfs(n,k)));
        bw.flush();
        bw.close();
        br.close();
    }
}
