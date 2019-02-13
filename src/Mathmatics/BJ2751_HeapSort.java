package Mathmatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BJ2751_HeapSort{
    static int N;

    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        for(int i=0; i<N; i++){
            list[i] = Integer.valueOf(br.readLine());
        }

        maxHeap(list, list.length);
//        System.out.println(Arrays.toString(list));
        heapSort(list);
//        System.out.println(Arrays.toString(list));
        for(Integer i : list){
            sb.append(i + "\n");
        }
        System.out.println(sb);
    }

    static void maxHeap(int[] list, int size){
            for(int i=1; i<size; i++){
                int child = i;

                do{
                    int parent= (child-1)/2;
                    if(list[parent]<list[child]){
                        int tmp = list[parent];
                        list[parent] = list[child];
                        list[child] = tmp;
                    }
                    child = parent;
                }while(child!=0);
            }
    }

    static void heapSort(int[] list){
        for(int i=list.length-1; i>=0; i--){
            int tmp = list[0];
            list[0] = list[i];
            list[i] = tmp;

            int root = 0;
            int child = 1;
            do{
                child = 2 * root + 1;
                // get the bigger value from child values
                if(child < i-1 && list[child]<list[child+1]){
                    child++;
                }
                if(child < i && list[root]<=list[child]){
                    int temp = list[root];
                    list[root] = list[child];
                    list[child] = temp;
                }
                root = child;
            }while(child < i);
        }
    }
}
