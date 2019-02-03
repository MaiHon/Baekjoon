package Graph;

import java.io.*;
import java.util.*;

public class BJ4963 {
    static int[][] map;
    static boolean[][] check;
    static int x_, y_, count;
    static int[] dx = {1, -1, 1, -1, 1, 0, -1, 0};
    static int[] dy = {1, -1, -1, 1, 0, 1, 0, -1};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x_ = Integer.parseInt(st.nextToken());
            y_ = Integer.parseInt(st.nextToken());
            if(x_==0 && y_==0) break;


            check = new boolean[y_+1][x_+1];
            map = new int[y_+1][x_+1];
            for(int i=1; i<=y_; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=x_; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            System.out.println();
//            for(int i=1; i<=y_; i++){
//                System.out.println(Arrays.toString(map[i]));
//            }

            count=0;
            for(int i=1; i<=y_; i++){
                for(int j=1; j<=x_; j++){
                    if(map[i][j]==1 && !check[i][j]) {
                        bfs(j, i);
                        count++;
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }

    static void bfs(int x, int y){
        Queue<Pair> q = new LinkedList<>();
        check[y][x] = true;
        q.offer(new Pair(x, y));

        while(!q.isEmpty()){
            Pair p = q.poll();
            int px = p.x;
            int py = p.y;

            for(int i=0; i<8; i++){
                int nx = px+dx[i];
                int ny = py+dy[i];

                if(nx>0 && nx<=x_ && ny>0 && ny<=y_){
                    if(!check[ny][nx] && map[ny][nx]==1){
                        check[ny][nx] = true;
                        q.offer(new Pair(nx, ny));
                    }
                }
            }
        }
    }
}
