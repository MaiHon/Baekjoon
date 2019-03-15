package Topology_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1005 {
    private static int N, K;
    private static long ans, max;
    private static ArrayList[] list;
    private static int[] times;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader br = new BufferedReader(new FileReader("/Users/mah/Desktop/input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int testN  = Integer.valueOf(st.nextToken().trim());
        while(testN-->0){
            st = new StringTokenizer(br.readLine());
            N = Integer.valueOf(st.nextToken());
            K = Integer.valueOf(st.nextToken());

            times = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++){
                times[i] = Integer.valueOf(st.nextToken().trim());
            }

            list = new ArrayList[N+1];

            for(int i=1; i<list.length; i++){
                list[i] = new ArrayList<Integer>();
            }

            int[] nodeN = new int[N+1];
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int col = Integer.valueOf(st.nextToken().trim());
                int row = Integer.valueOf(st.nextToken().trim());

                list[col].add(row);
                nodeN[row]++;
            }


            int endN = Integer.valueOf(br.readLine().trim());
            Queue<Node> nodes = new PriorityQueue<>();

            ans = 0;
            max = 0;
            for(int i=1; i<=N; i++){
                if(nodeN[i]==0){
                    nodes.offer(new Node(i, times[i]));
                    break;
                }
            }

            while(!nodes.isEmpty()){
                Node now = nodes.poll();

                if(now.idx==endN){
                    ans = now.tot;
                    break;
                }

                for(int i=0; i<list[now.idx].size(); i++){
                    int next = Integer.valueOf(list[now.idx].get(i).toString());

                    if(--nodeN[next]==0){
                        nodes.offer(new Node(next, now.tot + times[next]));
                    }else {
                        nodes.offer(new Node(now.idx, now.tot));
                    }
                }
            }

//            Queue<Node> q = new PriorityQueue<>();
//
//            for(int i=1; i<=N; i++){
//                int num = Integer.valueOf(list[endN].get(i).toString());
//                q.offer(new Node(num, times[num]+times[endN]));
//            }
//
//            ans = 0;
//
//            boolean isFinshed = false;
//            Queue<Node> nodes = new LinkedList<>();
//
//            while(!isFinshed){
//                for(int i=0; i<q.size(); i++){
//                    Node now = q.poll();
//                    if(list[now.idx].size()==0){
//                        ans = Math.max(ans, now.tot);
//                        isFinshed = true;
//                        break;
//                    }
//
//                    for(int j=0; j<list[now.idx].size(); j++){
//                        int num = Integer.valueOf(list[now.idx].get(j).toString());
//                        nodes.offer(new Node(num, now.tot+times[num]));
//                    }
//                }
//
//                while(!nodes.isEmpty() && !isFinshed){
//                    q.offer(nodes.poll());
//                }
//            }
            sb.append(ans + "\n");
        }
        System.out.println(sb);
    }
}

class Node implements Comparable<Node>{
    int idx;
    long tot;

    Node(int idx, long val){
        this.idx = idx;
        this.tot = val;
    }

    public int compareTo(Node n){
       return this.tot < n.tot ? 1:-1;
    }
}