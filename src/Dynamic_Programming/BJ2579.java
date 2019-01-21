package Dynamic_Programming;

import java.util.*;
import java.io.*;

public class BJ2579 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseN = Integer.parseInt(br.readLine());
        int[] stairs = new int[caseN];

        for(int i=0; i<caseN; i++){
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[][] ans = new int[caseN][caseN];
        ans[0][0] = stairs[0];

        if(1<caseN){
            ans[1][0] = ans[0][0] + stairs[1];
        }
        if(2<caseN){
            ans[2][0] = stairs[1] + stairs[2];
            ans[2][1] = ans[0][0] + stairs[2];
        }

        int a = 1;
        int b = 1;

        for(int i=3; i<caseN; i++){
            for(int j=0; j<a; j++){
                ans[i][j] = ans[i-3][j] + stairs[i] + stairs[i-1];
            }
            for(int j=a; j<a+b; j++){
                ans[i][j] = ans[i-2][j-a] + stairs[i];
            }
            if(i%2==0){
                a++;
            }else{
                b++;
            }
        }

        for(int i=0; i<ans.length; i++){
            System.out.println(Arrays.toString(ans[i]));
        }


        Arrays.sort(ans[ans.length-1]);
        System.out.println(ans[ans.length-1][ans.length-1]);
    }
}


// need to modify
