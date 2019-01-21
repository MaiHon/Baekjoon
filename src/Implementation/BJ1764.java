package Implementation;

import java.util.*;
import java.io.*;

public class BJ1764 {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] nam = br.readLine().split(" ");
        HashMap<String, String> hmap = new HashMap<String, String>();

        int n = Integer.parseInt(nam[0]);
        int m = Integer.parseInt(nam[1]);

        for(int i=0; i<n; i++){
            hmap.put(br.readLine(), " ");
        }

        ArrayList<String> ans = new ArrayList<String>();

        for(int i=0; i<m; i++){
            String nobody = br.readLine();
            if(hmap.containsKey(nobody)) {
                ans.add(nobody);
            }
        }

        Collections.sort(ans);

        sb.append(ans.size() + "\n");
        for(String name : ans){
            sb.append(name + "\n");
        }

        System.out.println(sb);
    }
}
