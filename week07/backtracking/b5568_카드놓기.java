package week07.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class b5568_카드놓기 {
    static int n,k;
    static int[] cards;
    static HashSet<String> hs = new HashSet<>();
    static boolean[] visited;
    static void pickCard(int depth, StringBuilder sb) {
        if(depth == k){
            hs.add(sb.toString());
            return;
        }
        for(int i=0;i<n;i++){
            if(visited[i]) continue;
            visited[i] = true;
            String str = String.valueOf(cards[i]);
            sb.append(str);
            pickCard(depth+1, sb);
            sb.setLength(sb.length() - str.length());
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new int[n];
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            cards[i] = Integer.parseInt(br.readLine());
        }
        pickCard(0, new StringBuilder());
        System.out.print(hs.size());
    }
}
