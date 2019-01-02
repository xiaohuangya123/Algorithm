package com.xhj.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: Created by XHJ on 2019/1/2.
 * 种一棵树最好的时间是十年前，其次是现在。
 */
public class AlgorithmTest {

    private int[]arr;

    @Before
    public void setUp() throws Exception {
        arr = new int[]{2,1,4,6,3,2,9};
    }

    @After
    public void tearDown() throws Exception {
        printArray(arr);
    }

    @Test
    public void insetSort() {
        Algorithm.insetSort(arr);
    }

    @Test
    public void selectSort(){
        Algorithm.selectSort(arr);
    }

    @Test
    public void bubbleSort(){
        Algorithm.bubbleSort(arr);
    }

    @Test
    public void fibonacciSequence(){
        Long val = Algorithm.fibonacciSequence(50);
        System.out.println(val);
    }



    //打印数组
    private void printArray(int[] arr){
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i=0;i<arr.length;i++){
            sb.append(arr[i] + ",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");

        System.out.println(sb);
    }
}