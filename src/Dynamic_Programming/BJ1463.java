package Dynamic_Programming;

import java.io.*;

public class BJ1463 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int DP[] = new int[1000001];

        DP[1] = 0;
        DP[2] = 1;
        DP[3] = 1;

        for(int i=2; i<1000001; i++){
            DP[i] = DP[i-1] + 1;
            if(i%2==0 && (DP[i/2] + 1 < DP[i])) DP[i] = DP[i/2] + 1;
            if(i%3==0 && (DP[i/3] + 1 < DP[i])) DP[i] = DP[i/3] + 1;

        }

        bw.write(DP[num] + "\n");
        bw.flush();
    }
}

