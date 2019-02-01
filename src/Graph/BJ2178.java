package Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ2178 {
    static int m, n;
    static int[][] map, dis;
    static boolean[][] check;
    static int count;

    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        check = new boolean[n][m];
        dis = new int[n][m];

        for(int i=0; i<n; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<m; j++){
                map[i][j] = arr[j] - '0';
            }
        }

        bfs();

//        System.out.println();
//        for(int i=0; i<n; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }
//
//        System.out.println();
//        for(int i=0; i<n; i++){
//            System.out.println(Arrays.toString(dis[i]));
//        }
        System.out.println(dis[n-1][m-1]);
    }

    static void bfs(){
        Queue<Po> q = new LinkedList<>();
        q.offer(new Po(0,0));
        check[0][0] = true;
        dis[0][0] = 1;

        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.poll().y;

            for(int i=0; i<4; i++){
                int p_x = x + dx[i];
                int p_y = y + dy[i];

                if(p_x>=0 && p_x<m && p_y>=0 && p_y<n && !check[p_y][p_x] && map[p_y][p_x]==1){
                    q.offer(new Po(p_x, p_y));
                    dis[p_y][p_x] = dis[y][x] + 1;
                    check[p_y][p_x] = true;
                }
            }
        }
    }
}

class Po{
    int x;
    int y;

    Po(int x, int y){
        this.x = x;
        this.y = y;
    }
}
