package Mathmatics;

import java.util.*;

public class BJ2606_v1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int Node = sc.nextInt();
        int Edge = sc.nextInt();

        boolean[] visited = new boolean[Node+1];
        int[][] map = new int[Node+1][Node+1];

        for(int i=0; i<Edge; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            map[from][to] = map[to][from] = 1;
        }

        int len = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=1; i<=Node; i++){
                int next = map[now][i];
                if(next==0) continue;
                if(visited[i]) continue;

                q.offer(i);
                ++len;
                visited[i] = true;
            }
        }

        System.out.println(len);
    }
}