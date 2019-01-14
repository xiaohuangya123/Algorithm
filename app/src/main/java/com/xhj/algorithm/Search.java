package com.xhj.algorithm;

/**
 * Author: Created by XHJ on 2019/1/14.
 * 种一棵树最好的时间是十年前，其次是现在。
 *
 * 常用查找算法
 */
public class Search {

    /**
     * 二分查找
     * 被查找的数组需要是从小到大排好序且没有重复。
     * @param arr
     * @param key
     * @return 如果找到则返回对应的位置，未找到返回-1
     */
    public static int binarySearch(int[] arr, int key){
        int left = 0;
        int right = arr.length-1;

        if(key>arr[right] || key<arr[0]){
            return -1;
        }

        while(left<=right){
            int mid = (left+right)/2;
            if(key == arr[mid]){
                return mid;
            }else if(key>arr[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }


}
