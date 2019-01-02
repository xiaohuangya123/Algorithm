package com.xhj.algorithm;

import android.provider.Telephony;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Created by XHJ on 2019/1/2.
 * 种一棵树最好的时间是十年前，其次是现在。
 */
public class Algorithm {

    /**
     * 插入排序
     * 从第一个元素开始，该元素可以认为已经被排序；
     * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
     * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
     * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
     * 将新元素插入到该位置后；
     * 重复步骤2~5。
     * @param arr
     * @return
     */
    public static int[] insetSort(int[] arr){
        int len = arr.length;
        int preIndex,current;
        for(int i=1;i<len -1;i++){
            preIndex = i-1;
            current = arr[i];

            while (preIndex >=0 && arr[preIndex] > current){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }

            arr[preIndex+1] = current;
        }

        return arr;
    }

    /**
     * 选择排序
     *选择排序(Selection-sort)是一种简单直观的排序算法。
     * 它的工作原理：首先在未排序序列中找到最小（大）元素，
     * 存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr){
        int len = arr.length;
        int minIndex,temp;
        for(int i=0;i<len-1;i++){
            minIndex = i;
            for(int k=i+1;k<len;k++){
                if(arr[k]<arr[minIndex]){
                    minIndex = k;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }

        return arr;
    }

    /**
     * 冒泡排序
     * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
     * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
     * 针对所有的元素重复以上的步骤，除了最后一个；
     * 重复步骤1~3，直到排序完成。
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr){
        int len = arr.length;
        int temp;
        for(int i=0;i<len-1;i++){
            for(int k=0;k<len-1-i;k++){
                if(arr[k]>arr[k+1]){
                    temp = arr[k+1];
                    arr[k+1] = arr[k];
                    arr[k] = temp;
                }
            }
        }

        return arr;
    }


    /**
     * 斐波那契序列
     * 斐波那契序列优化后的递归实现。
     * @param n
     * @return
     */
    static Map<Integer, Long> mMap = new HashMap<>();
    public static Long fibonacciSequence(int n){
        if(n<=2){
            return 1L;
        }else {
            if(!mMap.containsKey(n)){
                mMap.put(n,fibonacciSequence(n-1) + fibonacciSequence(n-2));
            }
            return mMap.get(n);
        }
    }































}
