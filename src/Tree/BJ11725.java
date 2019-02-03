package Tree;


import java.util.*;
import java.io.*;

public class BJ11725 {
    static TreeNode[] tree;

    public static void main(String args[])throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int caseN = Integer.parseInt(br.readLine());
        tree = new TreeNode[caseN+1];

        for(int i=1; i<=caseN; i++){
            tree[i] = new TreeNode(i);
        }

        tree[1].parent = 1;
        Stack<int[]> first = new Stack<>();
        for(int i=1; i<caseN; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(tree[y].parent==-1 && tree[x].parent==-1) {
                first.push(new int[]{x, y});
            }else if(tree[y].parent==-1){
                tree[y].parent = x;
            }else if(tree[x].parent==-1){
                tree[x].parent = y;
            }
        }

        while(!first.isEmpty()){
            check(first);
        }


        for(int i=2; i<=caseN; i++){
            bw.write(tree[i].parent + "\n");
        }
        bw.flush();
    }

    private static void check(Stack<int[]> first) {
        Stack<int[]> second = new Stack<>();

        if(!first.isEmpty() || !second.isEmpty()){
            while(!first.isEmpty()){
                int[] arr = first.pop();
                int x_ = arr[0];
                int y_ = arr[1];

                if(tree[y_].parent==-1 && tree[x_].parent==-1){
                    second.push(arr);
                }else if(tree[y_].parent==-1){
                    tree[y_].parent = x_;
                }else{
                    tree[x_].parent = y_;
                }
            }

            while(!second.isEmpty()){
                int[] arr = second.pop();
                int x_ = arr[0];
                int y_ = arr[1];

                if(tree[y_].parent==-1 && tree[x_].parent==-1){
                    first.push(arr);
                }else if(tree[y_].parent==-1){
                    tree[y_].parent = x_;
                }else{
                    tree[x_].parent = y_;
                }
            }

        }
    }
}


class TreeNode{
    int data;
    int parent;

    TreeNode(int data){
        this.data = data;
        this.parent = -1;
    }
}