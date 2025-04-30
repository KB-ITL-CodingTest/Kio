package week3.slidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b12891_DNA비밀번호 {
    static int s,p;
    static int[] charMap = new int[128];
    static {
        charMap['A'] = 0;
        charMap['C'] = 1;
        charMap['G'] = 2;
        charMap['T'] = 3;
    }
    static boolean IsPassword(int[] acgt, int[] cur){
        for(int i=0;i<4;i++){
            if(acgt[i] > cur[i]) return false;
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] acgt = new int[4];
        int[] cur = new int[4];
        int cnt = 0;
        for(int i=0;i<4;i++){
            acgt[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0;i<p;i++){
            cur[charMap[dna.charAt(i)]]++;
        }
        if(IsPassword(acgt,cur)) cnt++;

        for(int i=0;i<s-p;i++){
            cur[charMap[dna.charAt(i)]]--;
            cur[charMap[dna.charAt(i+p)]]++;
            if(IsPassword(acgt,cur)){
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
