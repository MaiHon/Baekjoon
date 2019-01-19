import java.io.*;

public class BJ2579_v2 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseN = Integer.parseInt(br.readLine());
        int[] stairs = new int[caseN+1];
        int[] ans = new int[caseN+1];

        for(int i=1; i<=caseN; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        ans[0] = 0;
        ans[1] = stairs[1];

        if(caseN>=1) ans[2] = ans[1] + stairs[2];

        for(int i=3; i<=caseN; i++){
            ans[i] = Math.max(ans[i-3] + stairs[i] + stairs[i-1], ans[i-2] + stairs[i]);
        }

        System.out.println(ans[caseN]);
    }
}
