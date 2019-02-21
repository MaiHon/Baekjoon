package Dijkstra;

import java.util.*;
import java.io.*;

public class BJ1261 {
    static int N, M, ans;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.valueOf(st.nextToken());
        N = Integer.valueOf(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            char[] w = br.readLine().toCharArray();
            for (int j=0; j<M; j++){
                map[i][j] = w[j]- '0';
            }
        }

        Queue<Algospot> q = new PriorityQueue<>();
        q.offer(new Algospot(0, 0, 0));
        while(!q.isEmpty()){
            Algospot now = q.poll();
            int px = now.x;
            int py = now.y;
            int destroy = now.destroy;

            if(px == M-1 && py == N-1){
                ans = destroy;
                break;
            }

            for(int i=0; i<4; i++){
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(ny<0 || nx<0 || ny>=N || nx>=M) continue;
                if(visited[ny][nx]) continue;

                visited[ny][nx] = true;
                if(map[ny][nx]==1){
                    q.offer(new Algospot(nx, ny, destroy+1));
                }else{
                    q.offer(new Algospot(nx, ny, destroy));
                }
            }
        }

        System.out.println(ans);
    }
}


class Algospot implements Comparable<Algospot>{
    int x;
    int y;
    int destroy;

    Algospot(int x, int y, int destroy){
        this.x = x;
        this.y = y;
        this.destroy = destroy;
    }

    @Override
    public int compareTo(Algospot o) {
       return this.destroy>=o.destroy? 1:-1;
       // 1-> change -1 & 0 -> not change
    }
}