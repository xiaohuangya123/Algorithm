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
     * @param arr 由小到到排序的数组无重复
     * @param key 需要查找的值
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

    /**
     * 二分查找 递归实现
     * @param arr 由小到到排序的数组无重复
     * @param key 需要查找的值
     * @param leftIndex 数组第一个元素下标
     * @param rightIndex 数组最后一个元素下标
     * @return 如果找到则返回对应的位置，未找到返回-1
     */
    public static int binarySearchByRecursion(int[] arr, int key, int leftIndex, int rightIndex){
        if(leftIndex>rightIndex || key>arr[rightIndex] || key<arr[leftIndex]){
            return -1;
        }
        int mid = (leftIndex + rightIndex)/2;
        if(key > arr[mid]){
            return binarySearchByRecursion(arr, key, mid+1, rightIndex);
        }else if(key < arr[mid]){
            return binarySearchByRecursion(arr, key, leftIndex, mid-1);
        }else {
            return mid;
        }
    }

    /**
     * 二分查找 查找第一次出现的位置
     * 被查找的数组需要是从小到大排好序,可以重复。
     * @param arr 由小到到排序的数组，可以重复
     * @param key 需要查找的值
     * @return 如果找到则返回对应的位置，未找到返回-1
     */
    public static int binarySearchFirstLocation(int[] arr, int key){
        int left = 0;
        int right = arr.length-1;

        if(key>arr[right] || key<arr[left]){
            return -1;
        }

        while(left<=right){
            int mid = (left+right)/2;
            if(key == arr[mid]){
                while (mid>=0){
                    if(key != arr[mid]){
                        break;
                    }
                    mid--;
                }
                return mid+1;
            }else if(key>arr[mid]){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return -1;
    }

    /**
     *插值查找
     * 可以理解为对二分查找的优化
     * 被查找的数组需要是从小到大排好序且没有重复。
     * @param arr 由小到到排序的数组无重复
     * @param key 需要查找的值
     * @return 如果找到则返回对应的位置，未找到返回-1
     */
    public static int insertValueSearch(int[] arr, int key){
        int left = 0;
        int right = arr.length-1;

        if(key<arr[0] || key>arr[arr.length-1]){
            return -1;
        }

        while (left<=right){
            int mid = left + (right-left) * ((key - arr[left]) / (arr[right] - arr[left]));
            if(key == arr[mid]){
                return mid;
            }else if(key>arr[mid]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;
    }

}
