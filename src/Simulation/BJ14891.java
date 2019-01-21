package Simulation;

import java.io.*;

public class BJ14891 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // making the gear array 5=> for starting number from 1
        char[][] DP = new char[5][8];

        DP[1] = br.readLine().toCharArray();
        DP[2] = br.readLine().toCharArray();
        DP[3] = br.readLine().toCharArray();
        DP[4] = br.readLine().toCharArray();

        int n = Integer.parseInt(br.readLine());

        for(int tN=0; tN<n; tN++) {
            String[] points = br.readLine().split(" ");

            int i, j;
            i = Integer.parseInt(points[0]);
            j = Integer.parseInt(points[1]);


            // selecting gear num
            if(i==1){
                if(DP[1][2]!=DP[2][6]){
                    if(DP[2][2]!=DP[3][6]){
                        if(DP[3][2]!=DP[4][6]){
                            rotate(DP, 4, 2, -j);
                        }
                        rotate(DP, 3, 2, j);
                    }
                    rotate(DP, 2, 2, -j);
                }
                rotate(DP, 1, 2, j);
            }

            else if(i==4){
                if(DP[4][6]!=DP[3][2]){
                    if(DP[3][6]!=DP[2][2]){
                        if(DP[2][6]!=DP[1][2]){
                            rotate(DP, 1, 2, -j);
                        }
                        rotate(DP, 2, 2, j);
                    }
                    rotate(DP, 3, 2, -j);
                }
                rotate(DP, 4, 2, j);
            }

            else if(i==2){
               if(DP[2][6]!=DP[1][2]){
                   rotate(DP, 1, 2, -j);
               }
               if(DP[2][2]!=DP[3][6]){
                   if(DP[3][2]!=DP[4][6]){
                        rotate(DP, 4, 2, j);
                   }
                   rotate(DP, 3, 2, -j);
               }
               rotate(DP, 2, 2, j);
            }

            else if(i==3){
                if(DP[3][2]!=DP[4][6]){
                    rotate(DP, 4, 2, -j);
                }
                if(DP[2][2]!=DP[3][6]){
                    if(DP[2][6]!=DP[1][2]){
                        rotate(DP, 1, 2, j);
                    }
                    rotate(DP, 2, 2, -j);
                }
                rotate(DP, 3, 2, j);
            }
        }

        int ans =0;
        for(int i=0; i<4; i++){
            ans += (DP[i+1][0]-'0') * Math.pow(2, i);
        }
        System.out.println(ans);
    }

    // rotating gear 1 for clock wise, -1 for anti-clock wise
    static void rotate(char[][]DP, int row, int start, int direction){
        switch (direction){
            case 1:
                char temp1 = DP[row][7];
                for(int i=7; i>0; i--){
                    DP[row][i] = DP[row][i-1];
                }
                DP[row][0] = temp1;
                break;

            case -1:
                char temp2 = DP[row][0];
                for(int i=0; i<7; i++){
                    DP[row][i] = DP[row][i+1];
                }
                DP[row][7] = temp2;
                break;
        }
    }
}