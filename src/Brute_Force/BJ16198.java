package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16198 {
    private static int N, ans;
    private static int[] weights;
    private static boolean[] chk;

    public static void main(String args[]){
        input();

        ans = 0;
        dfs(0, 0, weights, chk);
        System.out.println(ans);
    }

    private static void input(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine().trim());

            N = Integer.valueOf(st.nextToken());
            weights = new int[N];
            chk = new boolean[N];
            st = new StringTokenizer(br.readLine().trim());
            for(int i=0; i<N; i++){
                weights[i] = Integer.valueOf(st.nextToken());
            }


        }catch (Exception e){
            System.out.println(e);
        }
    }

    // dfs 진행시 구슬배열과 체크배열 달라짐 -> 파라미터로 넣음
    private static void dfs(int depth, int val, int[] list, boolean[] chk){
        // 양끝 구슬을 제외하고 모두 방문했을시 -> 최대값 비교후 할당
        if(depth==N-2) {
            ans = Math.max(ans, val);
            return;
        }

        for(int i=1; i<list.length-1; i++){
            if(chk[i]) continue;

            // 방문한적 없으면 진행
            chk[i] = true;

            // 선택한 에너지구슬 제외한 나머지 구슬배열 및 체크배열 생성
            int[] copy = new int[list.length-1];
            copyArr(list, copy, chk);
            boolean[] copyBool = new boolean[list.length-1];

            // dfs진행
            dfs(depth+1, val+list[i-1]*list[i+1], copy, copyBool);

            // 빠져 나왔으면 체크풀어주기
            chk[i] = false;
        }
    }

    // 선택한 에너지 구슬 제외한 나머지 구슬배열을 복사
    private static void copyArr(int[] from, int[] to, boolean[] fromC){
        int j=0;
        for(int i=0; i<from.length; i++){
            if(fromC[i]) continue;
            else{
                to[j++] = from[i];
            }
        }
    }
}
