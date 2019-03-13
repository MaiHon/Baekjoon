package String_Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BJ1157 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toUpperCase().toCharArray();

        Map<Character, Integer> cnt = new HashMap();
        for(int i=0; i<str.length; i++){
            char key = str[i];
            if(cnt.containsKey(key)) cnt.put(key, cnt.get(key)+1);
            else cnt.put(str[i], 1);
        }

        int max = 0;
        char ans = 'A';
        for(char key : cnt.keySet()){
            if(max<cnt.get(key)){
                max = cnt.get(key);
                ans = key;
            }else if(max==cnt.get(key)) {
                ans = '?';
            }
        }

        System.out.println(ans);
    }
}
