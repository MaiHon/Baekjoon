package SAMSUNG;

import java.io.*;
import java.util.*;

public class BJ15685 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseN = Integer.parseInt(br.readLine());
        String[] nums;
        int[][] map = new int[101][101];

        for(int i=0; i<caseN; i++){
            int x, y, d, g;
            nums = br.readLine().split(" ");
            x = Integer.parseInt(nums[0]);
            y = Integer.parseInt(nums[1]);
            d = Integer.parseInt(nums[2]);
            g = Integer.parseInt(nums[3]);
            int gs = (int)Math.pow(2, g);

            int[] dr = new int[gs];
            dr[0] = d;

            for(int j=1; j<=g; j++){
                gs = (int)Math.pow(2, j-1)-1;
                int s = 1;
                for(int k=gs; k>=0; k--){
                    if(dr[k]==0){
                        dr[gs+s] = 1;
                    }else if(dr[k]==1){
                        dr[gs+s] = 2;
                    }else if(dr[k]==2){
                        dr[gs+s] = 3;
                    }else{
                        dr[gs+s] = 0;
                    }
                    s++;
                }
            }

            map[y][x] = 1;
            for(Integer j : dr){
                if(j==0) {
                    x++;
                }else if(j==1){
                    y--;
                }else if(j==2){
                    x--;
                }else{
                    y++;
                }
                if(x<0 || y<0 || x>100 || y>100) break;
                map[y][x] = 1;
            }

            System.out.println();
            if(i==caseN-1){
                for(int j=0; j<101; j++){
                    System.out.println(Arrays.toString(map[j]));
                }
            }

        }
        int cnt=0;
        for(int j=1; j<101; j++){
            for(int k=0; k<100; k++){
                if(map[j][k]==1 && map[j][k+1]==1 && map[j-1][k]==1 && map[j-1][k+1]==1) cnt++;
            }
        }
        System.out.println(cnt);
    }
}