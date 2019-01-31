package Graph;

import java.io.*;
import java.util.*;

public class BJ11724 {
    static int v, e;
    static boolean[] check;
    static ArrayList<Integer>[] list;

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        list = new ArrayList[v+1];
        for(int i=1; i<=v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        int ans = 0;
        check = new boolean[v+1];

        for(int i=1; i<=v; i++){
            if(!check[i]){
                dfs(i);
                ans++;
            }
        }
        System.out.println(ans);
    }

    static void dfs(int n){
        check[n] = true;
        for(int m : list[n]) {
            if(!check[m]) {
                dfs(m);
            }
        }
    }

}
