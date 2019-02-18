package SAMSUNG;

import java.io.*;
import java.util.StringTokenizer;

public class BJ14889 {
    static int N, ans;
    static int[][] map;
    static boolean[] visited;

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;

        dfs(0,0);
        System.out.println(ans);
    }

    static void dfs(int idx, int cnt){
        if(cnt==N/2){
            int val = 0;
            int cval = 0;
            for (int i=0; i<N; i++) {
                if (visited[i]) {
                    for (int j=i; j<N; j++) {
                        if (visited[j]) {
                            val += map[i][j] + map[j][i];
                        }
                    }
                }
                else {
                    for (int j=i; j<N; j++) {
                        if (!visited[j]) {
                            cval += map[i][j] + map[j][i];
                        }
                    }
                }
            }

            ans = Math.min(ans, Math.abs(val - cval));
            return;
        }

        for (int i=idx; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i+1,cnt+1);
                visited[i] = false;
            }
        }
    }
}
