package ACM_ICPC.North_America;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2675 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();


        int n = Integer.valueOf(st.nextToken());
        while(n-->0){
            String ans = "";
            st = new StringTokenizer(br.readLine());

            int m = Integer.valueOf(st.nextToken());
            String chars = st.nextToken();

            for(int i=0; i<chars.length(); i++){
                for(int j=0; j<m; j++){
                    ans = ans.concat(chars.substring(i, i+1));
                }
            }

            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }
}
