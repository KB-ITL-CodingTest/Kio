package week11.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b19941_햄버거분배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] input = br.readLine().toCharArray();
        boolean[] eat = new boolean[N];
        int ans = 0;
        for(int i = 0; i < N; i++){
            if(input[i] == 'P'){
                for(int j = -K; j <= K; j++){
                    if(i+j < 0 || i+j >= N) continue;
                    if(input[i+j] == 'H' && !eat[i+j]){
                        eat[i+j] = true;
                        ans++;
                        break;
                    }
                }
            }
        }
        System.out.print(ans);
    }
}
