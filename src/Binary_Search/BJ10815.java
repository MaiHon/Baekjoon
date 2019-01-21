package Binary_Search;

import java.util.*;
import java.io.*;

public class BJ10815 {
    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hset = new HashSet<Integer>();

        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            hset.add(num);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if (hset.contains(num)){
                sb.append(1 + " ");
            }else{
                sb.append(0 + " ");
            }
        }

        System.out.println(sb);

    }
}
