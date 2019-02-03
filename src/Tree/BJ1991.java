package Tree;

import java.io.*;
import java.util.*;

public class BJ1991 {
    private static Node[] Btree;
    static StringBuilder sb;

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseN = Integer.parseInt(br.readLine());

        Btree = new Node[caseN];
        for(int i=0; i<caseN; i++){
            Btree[i] = new Node((char)('A' + i));
        }

        for(int i=0; i<caseN; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left!='.') Btree[root-'A'].left = Btree[left-'A'];
            if (right!='.') Btree[root-'A'].right = Btree[right-'A'];
        }

        sb = new StringBuilder();
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);

        System.out.println(sb);
    }

    static void preorder(int idx){
        sb.append(Btree[idx].data);
        if(Btree[idx].left!=null) preorder(Btree[idx].left.data-'A');
        if(Btree[idx].right!=null) preorder(Btree[idx].right.data-'A');
    }

    static void inorder(int idx){
        if(Btree[idx].left!=null) inorder(Btree[idx].left.data-'A');
        sb.append(Btree[idx].data);
        if(Btree[idx].right!=null) inorder(Btree[idx].right.data-'A');
    }

    static void postorder(int idx){
        if(Btree[idx].left!=null) postorder(Btree[idx].left.data-'A');
        if(Btree[idx].right!=null) postorder(Btree[idx].right.data-'A');
        sb.append(Btree[idx].data);
    }
}


class Node{
    char data;
    Node left;
    Node right;

    Node(char data){
        this.data = data;
    }
}