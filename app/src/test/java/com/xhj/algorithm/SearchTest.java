package com.xhj.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: Created by XHJ on 2019/1/14.
 * 种一棵树最好的时间是十年前，其次是现在。
 */
public class SearchTest {
    private int[]arr;
    @Before
    public void setUp() throws Exception {
        arr = new int[]{1,2,3,4,5,6,7,8,9,10,11};
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void binarySearch() {
        int res = Search.binarySearch(arr,6);
        System.out.println(res + "");
    }

    @Test
    public void binarySearchByRecursion() {
        int res = Search.binarySearchByRecursion(arr,4, 0, arr.length-1);
        System.out.println(res + "");
    }
}