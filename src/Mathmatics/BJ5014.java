package Mathmatics;

import java.util.*;

public class BJ5014 {
    static int F, S, G, U, D, len;
    static int[] map;
    static boolean[] visited;

    static int[] dx;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        map = new int[2000002];
        visited = new boolean[2000002];

        dx = new int[]{U, -D};

        if(S>G && D<=0) System.out.println("use the stairs");
        else if(S<G && U<=0) System.out.println("use the stairs");
        else{
            len = Integer.MIN_VALUE;
            bfs();
            if(len!=Integer.MIN_VALUE){
                System.out.println(len);
            }else{
                System.out.println("use the stairs");
            }
        }
    }

    static void bfs(){
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{S, 0});
        visited[S] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            int pos = now[0];
            int cnt = now[1];

            if(pos==G){
                len = cnt;
                break;
            }

            for(int i=0; i<dx.length; i++){
                int nepos = pos + dx[i];
                int necnt = cnt+1;

                if(nepos<1 || nepos>=2000001) continue;
                if(visited[nepos]) continue;

                visited[nepos] = true;
                q.offer(new int[]{nepos, necnt});
            }
        }
    }
}
