package week12.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class b1300_K번째수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int left = 1;
        int right = (int)Math.min(1_000_000_000,(long)n*n);
        int mid;
        int cnt;
        //시간 복잡도 = O(NlogN) log(N^2)이지만 상수는 무시하므로
        while(left <= right){
            mid = (left+right)/2;
            cnt = 0;
            // 각 row는 이미 정렬되어 있는 상태
            // 각 값은 i*j 이므로 mid/i 는 [1,mid/i]*i의 개수, 한 줄은 최대 n 개이므로 제한하기
            for(int i=1;i<=n;i++){
                cnt += Math.min(mid/i,n);
            }
            if(cnt < k){
                left = mid+1;
            }
            //최소값을 찾아야 하므로 같을 때에도 줄이면서 계속 진행
            else{
                right = mid-1;
            }
        }
        System.out.print(left);
    }
}
