import java.util.*;
import java.io.*;

public class BJ1764_new {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nam = br.readLine().split(" ");
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();

        int n = Integer.parseInt(nam[0]);
        int m = Integer.parseInt(nam[1]);

        for(int i=0; i<n; i++){
            hmap.put(br.readLine(), 1);
        }

        for(int i=0; i<m; i++){
            String nobody = br.readLine();
            Integer v = hmap.get(nobody);
            if(v==null){
                v = 0;
            }

            v += 2;
            hmap.put(nobody, v);
        }

        ArrayList<String> ans = new ArrayList<String>();
        for(Map.Entry<String, Integer> entry : hmap.entrySet()){
            String key = entry.getKey();
            Integer value = entry.getValue();

            if(value == 3) {
                ans.add(key);
            }
        }

        System.out.println(ans.size());
        Collections.sort(ans);
        for(String name : ans){
            System.out.println(name);
        }
    }
}
