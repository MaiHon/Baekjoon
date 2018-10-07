import java.io.*;

public class BJ1003_DP {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int DP[][] = new int[41][2];

        DP[0][0] = 1;
        DP[1][1] = 1;

        for(int i=2; i<41; i++){
            DP[i][0] = DP[i-1][0] + DP[i-2][0];
            DP[i][1] = DP[i-1][1] + DP[i-2][1];
        }

        for(int tN=0; tN<num; tN++){
            int fibo = Integer.parseInt(br.readLine());
            bw.write(DP[fibo][0] + " " + DP[fibo][1]);
            bw.newLine();
        }
        bw.flush();

    }
}
