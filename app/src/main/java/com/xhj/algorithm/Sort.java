package com.xhj.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: Created by XHJ on 2019/1/2.
 * 种一棵树最好的时间是十年前，其次是现在。
 */
public class Sort {

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
     * 快速排序
     * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
     * 从数列中挑出一个元素，称为 “基准”（pivot）；
     * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
     * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     * @param arr
     * @param leftIndex
     * @param rightIndex
     * @return
     */
    public static int[] quickSort(int[] arr, int leftIndex, int rightIndex){
        if(leftIndex>rightIndex){
            return null;
        }
        int key = arr[leftIndex];//默认基准是数组左边第一个元素
        int i = leftIndex, j = rightIndex;
        while (i<j){
            while (i<j && arr[j]>key){//从右边开始找到第一个小于key（基准）的元素的位置
                j--;
            }
            while (i<j && arr[i]<=key){//从左边开始找到第一个大于key（基准）的元素的位置
                i++;
            }
            if(i<j){//交换左边大于key的元素与右边小于key的元素位置
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        //交换基准key与arr[i]的值，此时key左边的元素均小于等于key，右边的军大于key
        //第一次排序完成，然后采用递归的方式分别排序左侧序列和右侧序列
        int point = arr[leftIndex];
        arr[leftIndex] = arr[i];
        arr[i] = point;

        quickSort(arr, leftIndex, i-1);
        quickSort(arr, i+1, rightIndex);
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
