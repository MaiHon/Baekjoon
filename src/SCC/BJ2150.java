package SCC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2150 {
    private static LinkedList[] list;
    private static Stack<Integer> stk;
    private static int[] parent;
    private static boolean[] visited;
    private static int a, b, cnt, V, E;
    private static ArrayList<Integer>[] scc;
    private static StringBuilder sb;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine().trim());
        sb = new StringBuilder();

        V = Integer.valueOf(st.nextToken());
        E = Integer.valueOf(st.nextToken());

        parent = new int[V+1];
        visited = new boolean[V+1];

        scc = new ArrayList[V+1];
        list = new LinkedList[V+1];
        stk = new Stack<>();

        for(int i=1; i<=V; i++){
            list[i] = new LinkedList();
            scc[i] = new ArrayList();
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine().trim());
            a = Integer.valueOf(st.nextToken());
            b = Integer.valueOf(st.nextToken());

            scc[a].add(b);
        }

        cnt = 0;
        for(int i=1; i<=V; i++){
            if(parent[i]==0) dfs(i);
        }

        cnt = 0;
        for(int i=1; i<=V; i++){
            if(!list[i].isEmpty()){
                cnt++;
                for(int j=0; j<list[i].size(); j++){
                    sb.append(list[i].get(j) + " ");
                }sb.append("\n");
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }

    // DFS는 총 정점의 갯수만큼 실행
    private static int dfs(int node) {
        parent[node] = ++cnt; // 노드마다 고유한 번호 할당
        stk.push(node); // 스택에 자기자신을 삽입

        int parentN = parent[node];
        for(int i=0; i<scc[node].size(); i++){
            int next = scc[node].get(i);

            // 방문하지 않은 이웃
            if(parent[next]==0) parentN = Math.min(parentN, dfs(next));
            // 현재 dfs수행하고 있는 노드(처리중인 노드)
            else if(!visited[next]) parentN = Math.min(parentN, parent[next]);
        }

        // 부모노드가 자기자신인 경우
        if(parent[node]==parentN){
            LinkedList<Integer> scc = new LinkedList<>();
            while(true){
                int t = stk.pop();
                scc.add(t);
                visited[t] = true;

                // 자기자신이 나오면 정지
                if(t==node) break;
            }
            Collections.sort(scc);
            scc.add(-1);
            list[scc.get(0)] = scc;
        }
        return parentN;
    }
}
