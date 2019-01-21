package Mathmatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

public class BJ1076 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> hmap = new HashMap<String, Integer>();

        hmap.put("black",0);
        hmap.put("brown",1);
        hmap.put("red",2);
        hmap.put("orange",3);
        hmap.put("yellow",4);
        hmap.put("green",5);
        hmap.put("blue",6);
        hmap.put("violet",7);
        hmap.put("grey",8);
        hmap.put("white",9);

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();
        String c = sc.nextLine();

        long ans = hmap.get(a) * 10 + hmap.get(b);
        ans = ans * (long) Math.pow(10, hmap.get(c));

        System.out.println(ans);

    }
}
