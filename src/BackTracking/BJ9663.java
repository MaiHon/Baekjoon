package BackTracking;

import java.util.*;

public class BJ9663 {
    static int N, ans;
    static int[] d1;
    static int[] d2;
    static int[] row;
    static int[] col;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        d1 = new int[2*N-1];
        d2 = new int[2*N-1];
        row = new int[N];
        col = new int[N];

        chess(0);
        System.out.println(ans);
    }

    static void chess(int depth){
        if(depth==N){
            ans++;
            return;
        }

        for(int i=0; i<N; i++){
            if(row[i]==1 || col[i]==1 || d1[i+depth]==1 || d2[N+depth-i-1]==1) continue;

            row[i] = col[i] = d1[i+depth] = d2[N+depth-i-1] = 1;
            chess(depth+1);
            row[i] = col[i] = d1[i+depth] = d2[N+depth-i-1] = 0;
        }
    }
}
