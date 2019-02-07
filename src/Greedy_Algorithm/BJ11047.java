package Greedy_Algorithm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ11047 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int caseN = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] money = new int[caseN];
        int idx = 0;
        for (int i = 0; i < caseN; i++) {
            int m = Integer.parseInt(br.readLine());
//            if(m<k) idx = i;
            money[i] = m;
        }

        int cnt = 0;
//        while(k>0){
//            if(k==0) break;
//            if(k>=money[idx]){
//                k -= money[idx];
//                cnt++;
//            }else if(k>0 && k<money[idx]){
//                idx--;
//            }
//        }

        for(int i=caseN-1; i>0; i--){
            if(money[i]>k) continue;
            cnt += k/money[i];
            k %= money[i];
            if(k==0) break;
        }
        System.out.println(cnt);
    }
}
