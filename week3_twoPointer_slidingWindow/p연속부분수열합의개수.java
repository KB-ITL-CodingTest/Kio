package week3_twoPointer_slidingWindow;

import java.util.HashSet;

public class p연속부분수열합의개수 {
//    static public int solution(int[] elements) {
//        int answer = 0;
//        int n = elements.length;
//        int[] accSum = new int[n+1];
//        HashSet<Integer> hs = new HashSet<>();
//        for(int i=1;i<=n;i++){
//            accSum[i] = elements[i-1] + accSum[i-1];
//        }
//        for(int i=0;i<n;i++){
//            // i는 부분 수열의 길이를 의미함.
//            for(int j=1;j<=n;j++){
//                int start = (j+n) % (n+1);
//                int end = (j+i) % (n+1);
//                int sum;
//                if(start > end){
//                    sum = accSum[n] - accSum[start] + accSum[(end+1) % (n+1)];
//                }
//                else{
//                    sum = accSum[end] - accSum[start];
//                }
//                hs.add(sum);
//
//            }
//        }
//        return hs.size();
//    }
    static int solution(int[] elements) {
        int n = elements.length;
        int[] extended = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            extended[i] = elements[i % n];
        }

        // 누적합
        int[] acc = new int[n * 2 + 1];
        for (int i = 1; i <= n * 2; i++) {
            acc[i] = acc[i - 1] + extended[i - 1];
        }

        HashSet<Integer> set = new HashSet<>();

        // 길이 1부터 n까지의 부분합을 set에 추가
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start < n; start++) {
                int sum = acc[start + len] - acc[start];
                set.add(sum);
            }
        }

        return set.size();
    }
    public static void main(String[] args) {
        int ans = solution(new int[]{7,9,1,1,4});
        System.out.print(ans);
    }
}
