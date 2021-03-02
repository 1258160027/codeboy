package com.yang.codeboy.thread.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-26
 */
public class QuickDemo {
    public static void quickSort(int[] arr, int low, int high) {
        if (arr.length <= 0) return;
        if (low >= high) return;
        int left = low;
        int right = high;
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        System.out.println("arr[left]:"+arr[left]);
        System.out.println("arr[right]:"+arr[right]);
        System.out.println("temp:"+temp);
        System.out.println("Sorting:" + Arrays.toString(arr));
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

    public static void main(String[] args) {
        int[] arr = {8, 31, 22, 4, 11, 66};
        System.out.println(arr.length);
        quickSort(arr, 0, arr.length - 1);
    }
}
