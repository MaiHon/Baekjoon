package Mathmatics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ2751_MergeSort {
    static int N;
    static int[] sorted;


    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        for(int i=0; i<N; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        sorted = new int[N];
        mergeSort(list, 0, list.length-1);


        for(Integer comp: list){
            sb.append(comp + "\n");
        }
        System.out.println(sb);
    }

    static void merge(int[] arr, int m, int middle, int n){
        int i = m;
        int j = middle + 1;
        int k = m;

        while(i<=middle && j<=n) {
            if(arr[i]<=arr[j]){
                sorted[k] = arr[i];
                i++;
            }else{
                sorted[k] = arr[j];
                j++;
            }
            k++;
        }


        // for the leftover
        if(i>middle){
            for(int t=j; t<=n; t++){
                sorted[k] = arr[t];
                k++;
            }
        }else{
            for(int t=i; t<=middle; t++){
                sorted[k] = arr[t];
                k++;
            }
        }

        // to move from sorted array to real array
        for(int t=m; t<=n; t++){
            arr[t] = sorted[t];
        }
    }

    static void mergeSort(int[] arr, int m, int n){
        // to ensure the length of array is over 1
        if(m<n){
            int middle = (m+n)/2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle+1, n);
            merge(arr, m, middle, n);
        }
    }
}
