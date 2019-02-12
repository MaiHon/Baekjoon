package Mathmatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2751_QuickSort {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        quicksort(list, 0, list.length-1);
        for(Integer comp: list){
            sb.append(comp + "\n");
        }
        System.out.println(sb);
    }

    static void quicksort(int[] list, int start, int end){
        if(start>=end) return ;

        int pivot = start;
        int i = start + 1;
        int j = end;
        int tmp;

        while(i<=j){
            while(i<=j && list[i]<=list[pivot]){
                i++;
            }
            while(j>pivot && list[j]>=list[pivot]){
                j--;
            }
            if(i>j){
                tmp = list[j];
                list[j] = list[pivot];
                list[pivot] = tmp;
            }else{
                tmp = list[j];
                list[j] = list[i];
                list[i] = tmp;
            }
        }

        quicksort(list, pivot, j-1);
        quicksort(list, j+1, end);
    }
}
