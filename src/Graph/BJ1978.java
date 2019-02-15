package Graph;

import java.io.*;
import java.util.*;

public class BJ1978 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseN = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = 0;

        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            boolean state = false;

            if(n==2 || n==3) cnt++;
            for(int i=2; i*i<=n; i++){
                if(n%i==0) {
                    state = false;
                    break;
                }else{
                    state = true;
                }
            }

            if(state) cnt++;
        }
        System.out.println(cnt);
    }
}
