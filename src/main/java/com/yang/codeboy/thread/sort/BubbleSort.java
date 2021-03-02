package com.yang.codeboy.thread.sort;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: zl
 * @date: 2021-02-26
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 31, 22, 4, 11, 66};
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    flag = true;
                }
            }
            if (flag == false) {
                return;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
