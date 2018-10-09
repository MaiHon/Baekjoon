import java.io.*;

public class BJ1149 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int houses = Integer.parseInt(br.readLine());
        int House[][] = new int[houses+1][3];
        int Sum[][] = new int[houses+1][3];

        for(int i=1; i<=houses; i++) {
            String prices[] = br.readLine().split(" ");
            for (int j = 0; j<3; j++) {
                House[0][j] = Sum[0][j] = 0;
                House[i][j] = Integer.parseInt(prices[j]);
            }
        }

        // Key point to solve the problem.
        for(int i=1; i<=houses; i++){
            Sum[i][0] = Math.min(Sum[i-1][1], Sum[i-1][2]) + House[i][0];
            Sum[i][1] = Math.min(Sum[i-1][0], Sum[i-1][2]) + House[i][1];
            Sum[i][2] = Math.min(Sum[i-1][0], Sum[i-1][1]) + House[i][2];
        }

        int ans = Math.min(Sum[houses][2], Math.min(Sum[houses][0], Sum[houses][1]));
        bw.write(ans + "\n");
        bw.flush();
    }
}
