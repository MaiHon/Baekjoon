package BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BJ2661 {
    static int n;
    static boolean isFinished;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());
        String str = "1";


        isFinished = false;
        dfs(1, str);
    }

    static void dfs(int depth, String str){
        if(depth==n){
            System.out.println(str);
            isFinished = true;
            return;
        }

        for(int i=1; i<=3; i++){
            str = str.concat(String.valueOf(i));
            if(chk(str)){
                dfs(depth+1, str);
            }
            if(isFinished) return;
            str = str.substring(0, str.length()-1);
        }
    }

    static boolean chk(String str){
        for(int i=1; i<=str.length()/2; i++){
            for(int j=0; j+2*i<=str.length(); j++){
                if(str.substring(j, i+j).equals(str.substring(i+j, j+2*i))){
                    return false;
                }
            }
        }
        return true;
    }
}
