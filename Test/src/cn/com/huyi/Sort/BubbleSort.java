package cn.com.huyi.Sort;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @title: BbbleSort
 * @Author SXSQ
 * @Description //TODO 冒泡排序 时间复杂度：O(n^2)
 * @Date 2022/4/23 21:41
 **/

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, -2 };
        bubblesort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubblesort(int[] arr) {
        int temp = 0;
        boolean flag = false;
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 ; i++) {
                if (arr[i] > arr[i+1]){
                    flag = true;
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            if (false!=false){
                break;
            }else {
                flag = false;
            }
        }
    }
}
