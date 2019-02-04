package Graph;

import java.util.*;
import java.io.*;

public class BJ2146 {
    static int n, g;
    static int[][] map, group;
    static boolean[][] check;
    static Queue<Pos> qe;

    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        check = new boolean[n][n];
        group = new int[n][n];

        for(int i=0; i<n; i++){
            String[] arr = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        g = 0;
        qe = new LinkedList<>();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1 && !check[i][j]){
                    bfs(j, i);
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!qe.isEmpty()){
            Pos p = qe.poll();
            int p_x = p.x;
            int p_y = p.y;

            for(int i=0; i<4; i++){
                int n_x = p_x + dx[i];
                int n_y = p_y + dy[i];

                if(n_x>=0 && n_x<n && n_y>=0 && n_y<n){
                    if(!check[n_y][n_x] && map[n_y][n_x]==0){
                        qe.offer(new Pos(n_x, n_y));
                        check[n_y][n_x] = true;
                        map[n_y][n_x] = map[p_y][p_x] + 1;
                    }
                    if(check[n_y][n_x] && map[n_y][n_x]!=1 && group[n_y][n_x]!=0){

                    }
                }
            }
        }

        System.out.println(Arrays.toString(ans.toArray()));

        System.out.println();
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println();
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(check[i]));
        }

        System.out.println();
        for(int i=0; i<n; i++){
            System.out.println(Arrays.toString(group[i]));
        }

    }

    static void bfs(int x, int y){
        Queue<Pos> q = new LinkedList<>();
        group[y][x] = ++g;
        check[y][x] = true;
        q.offer(new Pos(x,y));
        qe.offer(new Pos(x, y));


        while(!q.isEmpty()){
            int x_ = q.peek().x;
            int y_ = q.poll().y;

            for(int i=0; i<4; i++){
                int p_x = x_ + dx[i];
                int p_y = y_ + dy[i];

                if(p_x>=0 && p_x<n && p_y>=0 && p_y<n && !check[p_y][p_x] && map[p_y][p_x]==1){
                    q.offer(new Pos(p_x, p_y));
                    qe.offer(new Pos(p_x, p_y));
                    group[p_y][p_x] = g;
                    check[p_y][p_x] = true;
                }
            }
        }
    }
}

class Pos{
    int x;
    int y;

    Pos(int x, int y){
        this.x = x;
        this.y = y;
    }
}
