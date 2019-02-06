package Graph;

import java.util.*;
import java.io.*;

public class BJ2206 {
    static int m, n, ans;
    static int[][] map, copy;
    static boolean[][] check, dcheck;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken()); // y
        n = Integer.parseInt(st.nextToken()); // x

        map = new int[m][n];
        check = new boolean[m][n];
        dcheck = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = (int) arr[j] - '0';
            }
        }
        ans = Integer.MAX_VALUE;
        bfs();
        System.out.println(ans);
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0, 0, 1, false));

        while (!q.isEmpty()) {
            Node point = q.poll();
            int px = point.x;
            int py = point.y;
            int len = point.len;
            boolean pd = point.destroy;

            if (px==n-1 && py==m-1) {
                ans = Math.min(ans, len);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(!pd){
                        if(!check[ny][nx] && map[ny][nx]==0){
                            q.offer(new Node(nx, ny, len+1, false));
                            check[ny][nx] = true;
                        }else if(map[ny][nx]==1 && !dcheck[ny][nx]){
                            q.offer(new Node(nx, ny, len+1, true));
                            dcheck[ny][nx] = true;
                        }
                    }else{
                        if(!dcheck[ny][nx] && map[ny][nx]==0){
                            q.offer(new Node(nx, ny, len+1, true));
                            dcheck[ny][nx] = true;
                        }
                    }
                }
            }
        }


        if(ans==Integer.MAX_VALUE) ans = -1;
    }
}

class Node{
    int x;
    int y;
    int len;
    boolean destroy;

    Node(int x, int y, int len, boolean destroy){
        this.x = x;
        this.y = y;
        this.len = len;
        this.destroy = destroy;
    }
}
