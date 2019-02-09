package Graph;

import java.io.*;
import java.util.*;

public class BJ10026_BFS {
    static int N, cnt;
    static int[][] map, RGmap;
    static boolean[][] check;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        RGmap = new int[N][N];
        check = new boolean[N][N];

        for(int i=0; i<N; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<N; j++){
                map[i][j] = arr[j];
                RGmap[i][j] = arr[j];
                if(arr[j]=='G') RGmap[i][j] = 'R';
            }
        }

        cnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!check[i][j]){
                    if(map[i][j]=='R') {
                        bfs(j, i, 'R', map);
                        cnt++;
                        continue;
                    }else if(map[i][j]=='G'){
                        bfs(j, i, 'G', map);
                        cnt++;
                        continue;
                    }else{
                        bfs(j, i, 'B', map);
                        cnt++;
                        continue;
                    }
                }
            }
        }
        sb.append(cnt + " ");

        check = new boolean[N][N];
        cnt =0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (!check[i][j]) {
                    if (RGmap[i][j] == 'R') {
                        bfs(j, i, 'R', RGmap);
                        cnt++;
                        continue;
                    } else {
                        bfs(j, i, 'B', RGmap);
                        cnt++;
                        continue;
                    }
                }
            }
        }
        sb.append(cnt);
        System.out.println(sb);
    }

    static void bfs(int x, int y, char ch, int[][] map){
        Queue<int[]> q = new LinkedList<>();
        check[y][x] = true;
        q.offer(new int[]{x, y});

        while(!q.isEmpty()){
            int[] x_y = q.poll();
            int px = x_y[0];
            int py = x_y[1];

            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
                if(check[ny][nx]) continue;
                if(map[ny][nx]==ch){
                    check[ny][nx] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
