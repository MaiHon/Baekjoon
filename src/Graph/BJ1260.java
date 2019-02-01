package Graph;

import java.io.*;
import java.util.*;

public class BJ1260 {
    static int e, v, start;
    static boolean[] check;
    static StringBuilder sb;
    static ArrayList<Integer>[] elist;

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        v=Integer.parseInt(st.nextToken());
        e=Integer.parseInt(st.nextToken());
        start=Integer.parseInt(st.nextToken());

        elist = new ArrayList[v+1];

        for(int i=1; i<=v; i++) {
            elist[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            elist[a].add(b);
            elist[b].add(a);
        }

        for(int i=1; i<=v; i++) {
            Collections.sort(elist[i]);
        }

        check = new boolean[v+1];
        sb = new StringBuilder();
        dfs(start);
        System.out.println(sb);

        check = new boolean[v+1];
        sb = new StringBuilder();
        bfs(start);
        System.out.println(sb);

    }

    static void dfs(int n){
        if(check[n]) {
            return;
        }
        check[n] = true;
        sb.append(n + " ");
        for(int m : elist[n]) {
            if(!check[m]) {
                dfs(m);
            }
        }
    }

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        check[n] = true;
        q.offer(n);

        while (!q.isEmpty()) {
            int o = q.poll();
            sb.append(o + " ");
            for (int m : elist[o]) {
                if (!check[m]) {
                    check[m] = true;
                    q.offer(m);
                }
            }
        }
    }
}