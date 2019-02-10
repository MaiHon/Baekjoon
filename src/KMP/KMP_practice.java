package KMP;

import java.util.ArrayList;
import java.util.Arrays;

public class KMP_practice {
    public static void main(String args[]){
        String string = "ABCDABCDEIDOVNCKSABCDABCDEDKAIABCDABCDE";
        String pattern = "ABCDABCDE";

        KMP(string, pattern);
    }

    static int[] getPi(String pattern){
        int len = pattern.length();
        int j = 0;
        char[] p;
        int[] pi = new int[len];

        p = pattern.toCharArray();

        for(int i=1; i<len; i++){
            while(j>0 && p[i]!=p[j]){
                j = pi[j-1];
            }
            if(p[i]==p[j]) pi[i] = ++j;
        }

        return pi;
    }

    static void KMP(String string, String pattern){
        ArrayList<Integer> list = new ArrayList<>();
         int[] pi = getPi(pattern);
         char[] str = string.toCharArray();
         char[] ptn = pattern.toCharArray();

         int strSize = string.length();
         int ptnSize = pattern.length();

         int j=0;

         for(int i=0; i<strSize; i++){
             while(j>0 && str[i]!=ptn[j]){
                 j = pi[j-1];
             }
             if(str[i]==ptn[j]){
                 // When the whole chars are matched
                 if(j == ptnSize-1){
                       list.add(i-ptnSize+2);
                       j = pi[j];
                 }else{
                     j++;
                 }
             }
         }
         for(Integer idx : list){
             System.out.println(idx);
         }
    }
}
