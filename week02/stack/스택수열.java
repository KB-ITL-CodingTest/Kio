package week02.stack;

import java.io.*;

public class 스택수열 {
    static int n;
    static int[] arr;
    static int[] seq;
    static char[] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        seq = new int[n];
        answer = new char[2*n];
        int[] stack = new int[n];

        for (int i = 0; i < n; i++) arr[i] = i + 1;
        for (int i = 0; i < n; i++) seq[i] = Integer.parseInt(br.readLine());

        int top = -1; // ✅ top을 -1로 시작해서 비어있음을 표현
        int remain = 0;
        int answerIdx = 0;
        boolean isPossible = true;

        for (int i = 0; i < n; i++) {
            int target = seq[i];

            while (remain < n && (top == -1 || stack[top] < target)) {
                stack[++top] = arr[remain++];
                answer[answerIdx++] = '+';
            }

            // pop
            if (top >= 0 && stack[top] == target) {
                top--;
                answer[answerIdx++] = '-';
            } else {
                isPossible = false;
                break;
            }
        }

        if (!isPossible) {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write("NO\n");
        }
        else{
            for(int i=0;i<answerIdx;i++) bw.write(answer[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
