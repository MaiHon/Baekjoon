package Mathmatics;

import java.util.*;

public class BJ2960 {

    static boolean is_prime(int n){
        if(n<2) {
            return false;
        }
        else{
            for(int i=2; i*i<n; i++){
                if(n%i==0) return false;
            }
            return true;
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] map = new int[k+1];
        for(int i=0; i<=k; i++){
            map[i] = i;
        }
        Queue<Integer> ans = new ArrayDeque<>();

        boolean t = false;
        for(int i=2; i<=k; i++){
            t = is_prime(i);
            if(t){
                for(int j=1; j<=k/i; j++){
                    if(map[i*j]!=0) {
                        ans.add(map[i*j]);
                        map[i*j] = 0;
                    }
                }
            }
        }
        for(int i=0; i<n-1; i++){
            ans.poll();
        }
        System.out.println(ans.peek());

    }
}
