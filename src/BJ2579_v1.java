import java.io.*;

public class BJ2579_v1 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseN = Integer.parseInt(br.readLine());
        int[] stairs = new int[caseN];

        for(int i=0; i<caseN; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] ans = new int[caseN];
        ans[0] = stairs[0];

        if(1<caseN){
            ans[1] = ans[0] + stairs[1];
        }
        if(2<caseN){
            ans[2] = Math.max(stairs[1] + stairs[2], ans[0] + stairs[2]);
        }

        for(int i=3; i<caseN; i++){
            ans[i] = Math.max(ans[i-3] + stairs[i] + stairs[i-1], ans[i-2] + stairs[i]);

        }

        System.out.println(ans[caseN-1]);
    }
}
