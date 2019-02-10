package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1753_v2 {
    static final int INF = Integer.MAX_VALUE;

    static int[] map;
    static boolean[] v;
    static int[] d;
    static int V, E;
    static ArrayList<Pair>[] a;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int startN = Integer.parseInt(br.readLine());

        d = new int[V+1];
        v = new boolean[V+1];

        a = new ArrayList[V+1];

        for(int i=1; i<=V; i++){
            a[i] = new ArrayList<>();
            d[i] = INF;
        }

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            a[u].add(new Pair(v, w));
        }

        dijkstra(startN);
    }

    static void dijkstra(int start){
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Pair> q = new PriorityQueue<>();
        d[start] = 0;
        q.offer(new Pair(start, 0));

        while(!q.isEmpty()){
            Pair p = q.poll();

            if(v[p.next]) continue;

            v[p.next] = true;
            for(int i=0; i<a[p.next].size();i++){
                Pair temp = a[p.next].get(i);
                if(d[temp.next] > d[p.next]+temp.weight){
                    d[temp.next] = d[p.next]+temp.weight;
                    // usually add i in front of d[temp.next] for making reverse order
                    // but in this case, i set the comeparTo reverse order, so don't need it
                    q.add(new Pair(temp.next, -d[temp.next]));
                }
            }
        }

        for(int i=1; i<=V; i++){
            if(d[i]>=INF) sb.append("INF\n");
            else sb.append(d[i]+"\n");
        }
        System.out.println(sb);
    }
}


class Pair implements Comparable<Pair>{
    int next;
    int weight;

    Pair(int next, int weight){
        this.next = next;
        this.weight = weight;
    }

    public int getNext(){
        return next;
    }

    public int getWeight(){
        return weight;
    }

    public int compareTo(Pair o){
        return weight <= o.weight ? 1:-1;
        // if it's true -> change order(1)
        // if it's false -> don't change order(-1 or 0 )
    }
}
