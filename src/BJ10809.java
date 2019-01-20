import java.io.*;
import java.util.*;

public class BJ10809 {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> dic = new HashMap<>();

        String[] str = br.readLine().split("");
//        System.out.println(Arrays.toString(str));

//        int a = (int)'a';
//        int z = (int)'z';
//        System.out.println(a);
//        System.out.println(z);

        for(int i=97; i<=122 ;i++){
            String ch = String.valueOf((char)i);
            dic.put(ch, -1);
        }
//        System.out.println(dic);

        for(int i=0; i<str.length; i++){
            String key = String.valueOf(str[i]);
            if(dic.get(key)==-1) dic.put(key, i);
        }
//        System.out.println(dic);

        for(String keys : dic.keySet()){
            bw.write(dic.get(keys) + " ");
        }
        bw.flush();
    }
}
