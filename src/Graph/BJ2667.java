package Graph;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ2667 {
    static int[][] map;
    static boolean[][] check;
    static int n;
    static int count;
    static int ans;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        map = new int [n][n];
        check = new boolean[n][n];



        StringTokenizer st;
        for(int i=0; i<n; i++){
            char[] arr = br.readLine().toCharArray();
            for(int j=0; j<n; j++){
                map[i][j] = arr[j] - '0';
            }
        }

//        for(int i=0; i<n; i++){
//            System.out.println(Arrays.toString(map[i]));
//        }

        ArrayList<Integer> complexs = new ArrayList<>();

        ans = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==1 && !check[i][j]){
                    if(count!=0) count = 0;
                    ans = dfs(new P(j, i));
                    complexs.add(ans);
                }
            }
        }

        Collections.sort(complexs);
        sb.append(complexs.size() + "\n");
        for(Integer c : complexs){
            sb.append(c + "\n");
        }
        System.out.println(sb);
    }

    static int dfs(P p){
        count++;
        check[p.y][p.x] = true;

        int[] x = new int[]{0, 1, 0, -1};
        int[] y = new int[]{1, 0, -1, 0};

        for(int i=0; i<4; i++){
            int p_x = p.x + x[i];
            int p_y = p.y + y[i];

            if(p_x>=0 && p_x<n && p_y>=0 && p_y<n && !check[p_y][p_x] && map[p_y][p_x]==1){
                dfs(new P(p_x, p_y));
            }
        }
        return count;
    }
}

class P{
    int x;
    int y;

    P(int x, int y){
        this.x = x;
        this.y = y;
    }
}
