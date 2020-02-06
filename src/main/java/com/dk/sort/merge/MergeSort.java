package com.dk.sort.merge;

import com.dk.sort.SortTestHelper;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    private MergeSort() {}

    private static void merge(Comparable[] arr, int l, int mid, int r) {
        //这个方法好坑！copyOfRange 参数：前闭后开，from: inclusive, to: exclusive
        Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);

        int i = l, j = mid+1;
        for (int k = l; k <= r; k++) {
            if ( i > mid) { //如果左边已经处理完毕
                arr[k] = aux[j-l]; j++;
            }
            else if (j > r) { //如果右边处理完毕
                arr[k] = aux[i-l]; i++;
            }
            else if (aux[i-l].compareTo(aux[j-l]) < 0){
                arr[k] = aux[i-l]; i++;
            }
            else {
                arr[k] = aux[j-l]; j++;
            }
        }
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l >=r)
            return;
        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void sort(Comparable[] arr){

        int n = arr.length;
        sort(arr, 0, n-1);
    }

    public static void main(String[] args) {
        int N = 100;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100);
        SortTestHelper.testSort("com.dk.sort.merge.MergeSort", arr);
    }
}
