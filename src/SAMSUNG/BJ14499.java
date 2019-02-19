package SAMSUNG;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14499 {
    static int N, M, r, c, K;
    static int[][] map;
    static int[] order;
    static StringBuilder sb;
    static BufferedReader br;
    static StringTokenizer st;

    // 1, 2, 3, 4, 5, 6
    static int[] dice = new int[7];
    // e, w, n, s -> 1, 2, 3, 4
    static int[] start;
    static int[][] move = new int[][]{{}, {1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String args[])throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());
        r = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        map = new int[N+2][M+2];
        start = new int[2];
        order = new int[K];

        Arrays.fill(map[0], -1);
        for(int i=1; i<=N; i++){
            map[i][0] = -1;
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
            map[i][M+1] = -1;
        }
        Arrays.fill(map[N+1], -1);

        for(int[] arr : map){
            System.out.println(Arrays.toString(arr));
        }

        rolling();
        System.out.println(sb);
    }

    static void rolling()throws IOException{
        r += 1;
        c += 1;
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<K; i++){
            int rollDir = Integer.valueOf(st.nextToken());
            int nextR = r + move[rollDir][0];
            int nextC = c + move[rollDir][1];

            if(map[nextC][nextR]==-1) continue;
            r = nextR;
            c = nextC;

            int tmp = dice[1];
            switch (rollDir){
                case 1:
                    dice[1]=dice[3];
                    dice[3]=dice[6];
                    dice[6]=dice[4];
                    dice[4]=tmp;
                    break;

                case 2:
                    dice[1]=dice[4];
                    dice[4]=dice[6];
                    dice[6]=dice[3];
                    dice[3]=tmp;

                    break;
                case 3:
                    dice[1]=dice[2];
                    dice[2]=dice[6];
                    dice[6]=dice[5];
                    dice[5]=tmp;
                    break;

                case 4:
                    dice[1]=dice[5];
                    dice[5]=dice[6];
                    dice[6]=dice[2];
                    dice[2]=tmp;
                    break;
            }

            if (map[c][r] == 0) {
                map[c][r] = dice[1];
            }
            else {
                dice[1] = map[c][r];
                map[c][r] = 0;
            }

            sb.append(dice[6] + "\n");
        }
    }
}
