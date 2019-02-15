package Dynamic_Programming;

import java.util.*;

public class BJ10164 {
    static int x, y;
    static final int[] dx = new int[]{-1, 0};
    static final int[] dy = new int[]{0, -1};

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] pos = new int[2];

        int[][] map = new int[N][M];
        int cnt = 1;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                map[i][j] = cnt;
                cnt++;

                if(map[i][j]==K) {
                    pos[0] = j+1;
                    pos[1] = i+1;
                }
            }
        }

        if(K==0){
            pos[0] = M;
            pos[1] = N;
        }

        for(int[] arr : map){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();

        int[][] fdp = new int[pos[1]][pos[0]];
        int[][] sdp = new int[N-pos[1]+1][M-pos[0]+1];

        fdp[0][0] = 1;
        sdp[0][0] = 1;

        for(int i=0; i<pos[1]; i++){
            for(int j=0; j<pos[0]; j++){
                if(i>0 && j>0) fdp[i][j] = fdp[i-1][j] + fdp[i][j-1];
                else if(i==0 && j>0) fdp[i][j] = fdp[i][j-1];
                else if(j==0 && i>0) fdp[i][j] = fdp[i-1][j];
            }
        }


        for(int i=0; i<N-pos[1]+1; i++){
            for(int j=0; j<M-pos[0]+1; j++){
                if(i>0 && j>0) sdp[i][j] = sdp[i-1][j] + sdp[i][j-1];
                else if(i==0 && j>0) sdp[i][j] = sdp[i][j-1];
                else if(j==0 && i>0) sdp[i][j] = sdp[i-1][j];
            }
        }

        for(int[] arr : fdp){
            System.out.println(Arrays.toString(arr));
        }
        System.out.println();

        for(int[] arr : sdp){
            System.out.println(Arrays.toString(arr));
        }

        int a = fdp[pos[1]-1][pos[0]-1];
        int b = sdp[N-pos[1]][M-pos[0]];

        System.out.println(a*b);
    }
}
