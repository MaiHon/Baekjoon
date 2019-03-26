package MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1197 {
    private static class Edge implements Comparable<Edge>{
        int a;
        int b;
        int distance;

        Edge(int a, int b, int distance){
            this.a = a;
            this.b = b;
            this.distance = distance;
        }

        public int compareTo(Edge e){
            return this.distance - e.distance;
        }
    }

    private static int a, b, c;
    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            int parentSize = Integer.valueOf(st.nextToken());
            int n = Integer.valueOf(st.nextToken());

            int[] parent = new int[parentSize+1];
            for(int i=1; i<=parentSize; i++){
                parent[i] = i;
            }


            PriorityQueue<Edge> q = new PriorityQueue<>();
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.valueOf(st.nextToken());
                b = Integer.valueOf(st.nextToken());
                c = Integer.valueOf(st.nextToken());

                q.offer(new Edge(a,b,c));
            }

            long sum = 0;
            while(!q.isEmpty()){
                Edge now = q.poll();
                if(!findParent(parent, now.a, now.b)){
                    sum += now.distance;
                    unionParent(parent, now.a, now.b);
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

        return a==b;
    }
}

