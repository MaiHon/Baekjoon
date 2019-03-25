package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1922 {
    private static class Edge implements Comparable<Edge>{
        int[] node = new int[2];
        int distance;

        Edge(int a, int b, int distance){
            this.node[0] = a;
            this.node[1] = b;
            this.distance = distance;
        }

        public int compareTo(Edge e){
            return this.distance < e.distance ? -1:1;
        }
    }

    private static int a, b, c;
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;

            int parentSize = Integer.valueOf(br.readLine().trim());
            int[] parent = new int[parentSize+1];

            for(int i=1; i<=parentSize; i++){
                parent[i] = i;
            }

            int n = Integer.valueOf(br.readLine().trim());
            PriorityQueue<Edge> q = new PriorityQueue<>();
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.valueOf(st.nextToken());
                b = Integer.valueOf(st.nextToken());
                c = Integer.valueOf(st.nextToken());

                q.offer(new Edge(a,b,c));
            }

            int sum = 0;
            while(!q.isEmpty()){
                Edge now = q.poll();
                if(!findParent(parent, now.node[0], now.node[1])){
                    sum += now.distance;
                    unionParent(parent, now.node[0], now.node[1]);
                }
            }

            System.out.println(sum);

        }catch (Exception e){
            System.out.println(e);
        }

    }

    private static int getParent(int[] parent, int a){
        if(parent[a] == a ) return a;
        else return getParent(parent, parent[a]);
    }

    private static void unionParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    private static boolean findParent(int[] parent, int a, int b){
        a = getParent(parent, a);
        b = getParent(parent, b);

        if(a==b) return true;
        else return false;
    }
}
