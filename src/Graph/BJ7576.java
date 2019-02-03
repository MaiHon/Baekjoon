package Graph;

import java.util.*;
import java.io.*;

public class BJ7576 {
    static int n, m;
    static int[][] map, check;
    static int count;

    static final int[] dx = new int[]{0, 1, 0, -1};
    static final int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        check = new int[m][n];

        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<m; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j=0; j<n; j++) {
                check[i][j] = -1;
                map[i][j] = Integer.parseInt(arr[j]);
                if(Integer.parseInt(arr[j])==1){
                    q.offer(new Pair(j, i));
                    check[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int p_x = q.peek().x;
            int p_y = q.poll().y;

            for(int i=0; i<4; i++){
                int n_x = p_x + dx[i];
                int n_y = p_y + dy[i];

                if(n_x>=0 && n_x<n && n_y>=0 && n_y<m){
                    if(check[n_y][n_x]==-1 && map[n_y][n_x]==0){
                        q.offer(new Pair(n_x, n_y));
                        check[n_y][n_x] = check[p_y][p_x] + 1;
                    }
                }
            }
        }

        int ans =0;
        Outter : for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==0 && check[i][j]==-1){
                    ans = -1;
                    break Outter;
                } else if(ans<check[i][j]){
                    ans = check[i][j];
                }

            }
        }

        System.out.println(ans);

        System.out.println();
        for(int i=0; i<m; i++){
            System.out.println(Arrays.toString(map[i]));
        }

        System.out.println();
        for(int i=0; i<m; i++){
            System.out.println(Arrays.toString(check[i]));
        }
    }
}

class Pair{
    int x;
    int y;

    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

