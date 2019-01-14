import java.io.*;

public class BJ2747 {
    public static void main(String arg[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());
        int DP[] = new int[n+1];

        DP[0] = 0;
        DP[1] = 1;

        for(int i=2; i<=n; i++){
            DP[i] = DP[i-1] + DP[i-2];
        }

        int ans = DP[DP.length -1];
        bw.write(ans+"");
        bw.flush();


    }
}
