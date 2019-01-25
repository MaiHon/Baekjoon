package Dynamic_Programming;

import java.io.*;


public class BJ10844 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[][] stair = new long[101][10];
        long result = 0;

        stair[1][0] = 0;
        for(int i=1; i<=9; i++) {
            stair[1][i] = 1;

        }

        for(int i=2; i<=n; i++) {
            stair[i][0] = 1;
            for(int j=0; j<=9; j++){
                if(j==0) stair[i][j] = stair[i-1][1]%1000000000;
                if(j!=0 && j!=9) stair[i][j] = (stair[i-1][j-1] + stair[i-1][j+1])%1000000000;
                if(j==9) stair[i][j] = stair[i-1][8]%1000000000;
            }
        }

//        for(int i=0; i<=n; i++){
//            System.out.println(Arrays.toString(stair[i]));
//        }

        for(int i=0; i<=9; i++) {
            result += stair[n][i];
        }
        bw.write(String.valueOf(result%1000000000));
        bw.flush();
    }
}
