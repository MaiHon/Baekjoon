package String_Search;

import java.util.*;

public class BJ11656 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        int len = input.length();
        String[] arr = new String[len];


        for(int i=0; i<len; i++){
            arr[i] = input.substring(i);
        }

        Arrays.sort(arr);
        for(String str : arr){
            System.out.println(str);
        }
    }
}
