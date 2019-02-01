package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io. InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x;
    int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class BJ1012 {
    static int n, m;
    static int[][] map;
    static boolean[][] check;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int caseN = Integer.parseInt(br.readLine());

        while(caseN-- >0){
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            map= new int[n][m];
            check = new boolean[n][m];

            int cC = Integer.parseInt(st.nextToken());
            for(int i=0; i<cC; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                map[y][x] = 1;
            }

            int cont=0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(map[i][j]==1 && !check[i][j]) {
                        bfs(new Point(j,i));
                        cont++;
                    }
                }

            }
            System.out.println(cont);


            int ans=0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(map[i][j]==1 && !check[i][j]){
                        ans++;
                        dfs(new Point(j, i));
                    }
                }
            }
            System.out.println(ans);


            System.out.println();
            for(int i=0; i<n; i++){
                System.out.println(Arrays.toString(map[i]));
            }


        }
    }

    static void bfs(Point p) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(p);

        while(!queue.isEmpty()){
            Point p_ = queue.poll();

            int[] x = new int[]{1, 0, -1, 0};
            int[] y = new int[]{0, -1, 0, 1};

            for(int i=0; i<4; i++){
                int p_x = p_.x + x[i];
                int p_y = p_.y + y[i];

                if(p_x>=0 && p_x<m && p_y>=0 && p_y<n && !check[p_y][p_x] && map[p_y][p_x]==1) {
                    queue.offer(new Point(p_x, p_y));
                    check[p_y][p_x]=true;
                }
            }
        }
    }

    static void dfs(Point p){
        check[p.y][p.x] = true;

        int[] x = new int[]{1, 0, -1, 0};
        int[] y = new int[]{0, -1, 0, 1};

        for(int i=0; i<4; i++){
            int p_x = p.x + x[i];
            int p_y = p.y + y[i];

            if(p_x>=0 && p_x<m && p_y>=0 && p_y<n && !check[p_y][p_x] && map[p_y][p_x]==1) {
                dfs(new Point(p_x, p_y));
            }
        }
    }
}
