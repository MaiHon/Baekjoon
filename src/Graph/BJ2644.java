package Graph;

import java.util.*;

public class BJ2644 {
    static int ppl, a, b, cnt;
    static int[][] map;
    static boolean[] visited;
    static ArrayList<Integer>[] q;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        ppl = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        int relationN = sc.nextInt();

        map = new int[ppl+1][ppl+1];
        visited = new boolean[ppl+1];

        for(int i=0; i<relationN; i++){
            int p = sc.nextInt();
            int c = sc.nextInt();

            map[p][c] = 1;
            map[c][p] = 1;
        }

        int ans = bfs();
        System.out.println(ans);
    }

    static int bfs(){
        cnt = 0;

        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{a, cnt});
        visited[a] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int p = now[0];
            int len = now[1];

            if(p==b) return len;

            for(int i=1; i<=ppl; i++){
                if(map[p][i]==1 && !visited[i]){
                    visited[i] = true;
                    q.offer(new int[]{i, len+1});
                }
            }
        }

        return -1;
    }
}
