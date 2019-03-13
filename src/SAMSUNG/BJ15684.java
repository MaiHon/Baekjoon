package SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ15684 {
    private static int N, M, H, ans;
    private static boolean isTrue = false;
    private static int[][] map;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());
        H = Integer.valueOf(st.nextToken());


        map = new int[H+1][N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());

            map[a][b] = 1;
        }
        for(int i=0; i<=3; i++){
            dfs(i,0, 1);
            if(isTrue) break;
        }
        if(isTrue) System.out.println(ans);
        else System.out.println(-1);
    }

    private static void dfs(int ladder, int depth, int idx){
        if(isTrue) return;

        if(depth<=ladder){
            if (chk()) {
//                for(int[] arr: map){
//                    System.out.println(Arrays.toString(arr));
//                }System.out.println();

                ans = depth;
                isTrue = true;
                return;
            }
        }

        if(depth<ladder){
            for(int i=idx; i<H+1; i++){
                for(int j=1; j<N; j++){
                    if(map[i][j]==1 || map[i][j-1]==1 || map[i][j+1]==1) continue;

                    map[i][j]=1;
                    dfs(ladder,depth+1, i);
                    map[i][j]=0;
                }
            }
        }else{
            return;
        }
    }

    private static boolean chk(){
        for (int i=1; i<=N; i++) {
            int x = i;
            for (int y = 1; y<= H; y++) {
                if (map[y][x]==1) {
                    x += 1;
                } else if (map[y][x-1] == 1) {
                    x -= 1;
                }
            }
            if (i != x) {
                return false;
            }
        }
        return true;
    }
}
