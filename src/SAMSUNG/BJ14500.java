package SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14500 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                dfs(j, i, 1, map[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);

    }

    static void dfs(int x, int y, int cnt, int sum){
        if(cnt==4){
            max = Math.max(max, sum);
            return;
        }

        if(cnt==2){
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                sum += map[ny][nx];
                for(int j=0; j<4; j++){
                    int nnx = x + dx[j];
                    int nny = y + dy[j];

                    if(nnx<0 || nnx>=M || nny<0 || nny>=N) continue;
                    if(visited[nny][nnx]) continue;

                    visited[nny][nnx] = true;
                    dfs(nnx, nny, cnt+2, sum + map[nny][nnx]);
                    visited[nny][nnx] = false;
                }
                sum -= map[ny][nx];
                visited[ny][nx] = false;
            }
        }

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
            if(visited[ny][nx]) continue;

            visited[ny][nx] = true;
            dfs(nx, ny, cnt+1, sum + map[ny][nx]);
            visited[ny][nx] = false;
        }
    }
}