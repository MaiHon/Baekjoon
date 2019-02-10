package Dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1753_v1 {
    static final int INF = 1000000000;

    static int[][] map;
    static boolean[] v;
    static int[] d;
    static int V, E;


    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int startN = Integer.parseInt(br.readLine());

        // Initialize the graph
        map = new int[V][V];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            map[u-1][v-1] = w;
        }

        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(map[i][j]==0 && i!=j) map[i][j] = INF;
            }
        }

//        for(int[] arr: map){
//            System.out.println(Arrays.toString(arr));
//        }

        d = new int[V];
        v = new boolean[V];

        dijkstra(startN-1);
        for(Integer val: d){
            if(val==INF){
                sb.append("INF\n");
            }else{
                sb.append(val + "\n");
            }
        }
        System.out.println(sb);
    }

    static int getSmallIndex(){
        int min = INF;
        int index = 0;

        for(int i=0; i<V; i++){
            if(d[i] < min && !v[i]){
                min = d[i];
                index = i;
            }
        }
        return index;
    }

    static void dijkstra(int start){

        // Initialize dijkstra array
        for(int i=0; i<V; i++){
            d[i] = map[start][i];
        }

        v[start] = true;

        for(int i=0; i<V-2; i++){
            int current = getSmallIndex();
            v[current] = true;
            for(int j=0; j<V; j++){
                if(!v[j]){
                    if(d[current]+map[current][j]<d[j]){
                        d[j] = d[current]+map[current][j];
                    }
                }
            }
        }
    }
}
