package Graph;

import java.io.*;
import java.util.*;

public class BJ2468 {
    static int n, g;
    static int[][] map, group;
    static boolean[][] check;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        int max = 0;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        check = new boolean[n][n];
        group = new int[n][n];

        // bfs
//        int ans = 0;
//        for(int i=0; i<=max; i++){
//            g=0;
//            for(int j=0; j<n; j++){
//                for(int k=0; k<n; k++){
//                    if(map[j][k]>i && !check[j][k]){
//                        bfs(k, j, i);
//                    }
//                }
//            }
//            ans = Math.max(ans, g);
//            group = new int[n][n];
//            check = new boolean[n][n];
//        }
//        System.out.println(ans);

        // dfs
        int ans = 0;
        for(int i=0; i<=max; i++) {
            g=0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (map[j][k] > i && !check[j][k]) {
                        g++;
                        dfs(k, j, i);
                    }
                }
            }
            ans = Math.max(ans, g);
            group = new int[n][n];
            check = new boolean[n][n];
        }
        System.out.println(ans);
    }

    static void dfs(int x, int y, int rain){
        if(check[y][x]){
            return;
        }
        group[y][x] = g;
        check[y][x] = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n){
                if(map[ny][nx]>rain && !check[ny][nx]){
                    dfs(nx, ny, rain);
                }
            }
        }
    }

    static void bfs(int x, int y, int rain){
        Queue<int []> q = new LinkedList<>();
        check[y][x] = true;
        group[y][x] = ++g;
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int point[] = q.poll();
            int x_ = point[0];
            int y_ = point[1];

            for(int i=0; i<4; i++){
                int nx = x_ + dx[i];
                int ny = y_ + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<n){
                    if(map[ny][nx]>rain && !check[ny][nx]){
                        check[ny][nx] = true;
                        group[ny][nx] = g;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
