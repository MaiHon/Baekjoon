package Topology_Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2252 {
    static int N, M, A, B;

    public static void main(String args[]){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            N = Integer.valueOf(st.nextToken());
            M = Integer.valueOf(st.nextToken());


            int[] cntList = new int[N+1];


            ArrayList<Integer>[] list = new ArrayList[N+1];
            for(int i=0; i<=N; i++){
                list[i] = new ArrayList<>();
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());
                A = Integer.valueOf(st.nextToken());
                B = Integer.valueOf(st.nextToken());

                list[A].add(B);
                cntList[B]++;
            }

            topologicalSort(list, cntList, sb);
            sb.append("\n");
            System.out.println(sb);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    private static void topologicalSort(ArrayList<Integer>[] list, int[] cntList, StringBuilder sb){
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=N; i++){
            if(cntList[i]==0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now + " ");

            for(int next : list[now]){
                cntList[next]--;

                if(cntList[next]==0){
                    q.offer(next);
                }
            }
        }
    }
}
