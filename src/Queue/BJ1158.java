package Queue;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;

public class BJ1158 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Queue<Integer> que = new LinkedList<Integer>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        sb.append('<');

        for(int i=1; i<=n; i++){
            que.offer(i);
        }

        for(int i=0; i<n-1; i++){
            for(int j=0; j<m-1; j++){
                que.offer(que.poll());
            }
            sb.append(que.poll() + ", ");
        }
        sb.append(que.poll() + ">");

        System.out.println(sb);
    }
}
