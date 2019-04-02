package Brute_Force;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14225 {
    private static int N, ans, max;
    private static int[] nums;
    private static boolean[] visited;
    private static boolean[] chk;


    public static void main(String args[]){
        getInput();

        dfs(0, 0);
        getAns();
        System.out.println(ans);
    }

    private static void getInput(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            N = Integer.valueOf(br.readLine());
            nums = new int[N];
            visited = new boolean[N];
            max = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                nums[i] = Integer.valueOf(st.nextToken());
                max += nums[i];
            }

            chk = new boolean[max+1];

        }catch (Exception e){
            System.out.println(e);
        }
    }

    private static void dfs(int depth, int val){
        if(depth==N){
            chk[val] = true;
            return;
        }

        dfs(depth+1, val);
        dfs(depth+1, val+nums[depth]);
    }

    private static void getAns(){
        boolean isFound = false;

        for(int i=1; i<=max; i++){
            if(chk[i]) continue;

            isFound = true;
            ans = i;
            break;
        }

        if(!isFound) ans = ++max;
    }
}
