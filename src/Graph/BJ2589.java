package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2589 {
    static int N, M, max;
    static char[][] map;
    static int[][] moves;
    static boolean[][] visited;

    static final int[] dx = new int[]{1, 0, -1, 0};
    static final int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.valueOf(st.nextToken());
        M = Integer.valueOf(st.nextToken());

        map = new char[N][M];
        moves = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                map[i][j] = chars[j];
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        max = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j]=='L' && !visited[i][j]){
                    bfs(j, i);
                    visited = new boolean[N][M];
                    moves = new int[N][M];
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int px = now[0];
            int py = now[1];

            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
                if(visited[ny][nx]) continue;
                if(map[ny][nx]=='W') continue;

                visited[ny][nx] = true;
                moves[ny][nx] = moves[py][px] + 1;
                max = Math.max(moves[ny][nx], max);
                q.offer(new int[]{nx, ny});
            }
        }
    }
}
