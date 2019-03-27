package KMP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BJ1786 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String pattern = br.readLine();

        KMP(str, pattern);
    }

    static int[] getPi(String pattern){
        char[] str = pattern.toCharArray();
        int len = str.length;
        int[] pi = new int[len];

        int j=0;
        for(int i=1; i<len; i++){
            while(j>0 && str[i]!=str[j]){
                j = pi[j-1];
            }
            if(str[i]==str[j]){
                pi[i] = ++j;
            }
        }
        return pi;
    }

    static void KMP(String string, String pattern){
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> cp = new ArrayList<>();
        char str[] = string.toCharArray();
        char ptn[] = pattern.toCharArray();

        int sSize = str.length;
        int pSize = ptn.length;
        int pi[] = getPi(pattern);

        int j=0;
        for(int i=0; i<sSize; i++){
            while(j>0 && str[i]!=ptn[j]){
                j = pi[j-1];
            }

            if(str[i]==ptn[j]){
                if(j == pSize-1){
                    cp.add(i-pSize+2);
                    j = pi[j];
                }else{
                    j++;
                }
            }
        }

        sb.append(cp.size() + "\n");
        for(Integer idx: cp){
            sb.append(idx + "\n");
        }
        System.out.println(sb);
    }
}
