package Graph;

import java.util.*;

public class BJ1697 {
    static int a, b, len;
    static final int MAX = 100000;
    static final int MIN = 0;
    static boolean[] check = new boolean[200002];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        bfs();
        System.out.println(len);
    }

    static void bfs(){
        Queue<int []> q = new LinkedList<>();
        len = 0;
        q.offer(new int[]{a, len});
        check[a] = true;

        while(!q.isEmpty()){
            int[] pair = q.poll();
            int p = pair[0];
            len = pair[1];

            if(p==b) break;
            if(p+1<=MAX && !check[p+1]){
                q.offer(new int[]{p+1, len+1});
                check[p+1] = true;
            }
            if(p>0 && !check[p-1] && p-1>=MIN){
                q.offer(new int[]{p-1, len+1});
                check[p-1] = true;
            }
            if(p*2<=MAX && !check[p*2]) {
                q.offer(new int[]{p*2, len+1});
                check[p*2] = true;
            }
        }
    }
}
