package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2583 {
    static int[][] map;
    static int M, N, K, cnt;
    static boolean[][] visited;

    static final int[] dx = new int[]{1, 0, -1, 0};
    static final int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());
        K = Integer.valueOf(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.valueOf(st.nextToken());
            int y1 = Integer.valueOf(st.nextToken());
            int x2 = Integer.valueOf(st.nextToken());
            int y2 = Integer.valueOf(st.nextToken());

            for(int j=y1; j<y2; j++){
                for(int k=x1; k<x2; k++){
                    visited[j][k] = true;
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    bfs(j, i);
                    ans.add(cnt);
                }
            }
        }

        Collections.sort(ans);
        sb.append(ans.size()+"\n");
        for(Integer i : ans){
            sb.append(i + " ");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y){
        Queue<int []> q = new LinkedList<>();
        visited[y][x] = true;
        q.offer(new int[]{x, y});

        cnt = 0;

        while(!q.isEmpty()){
            cnt++;
            int[] pair = q.poll();
            int px = pair[0];
            int py = pair[1];

            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx<0 || nx>=N || ny<0 || ny>=M) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{nx, ny});
            }
        }

    }
}
