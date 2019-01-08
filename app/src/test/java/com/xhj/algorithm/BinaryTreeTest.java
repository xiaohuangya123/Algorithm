package com.xhj.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Author: Created by XHJ on 2019/1/6.
 * 种一棵树最好的时间是十年前，其次是现在。
 */
public class BinaryTreeTest {

    BinaryTree mTree = null;
    BinaryTree.Node rootNode = null;

    @Before
    public void setUp() throws Exception {
        mTree = new BinaryTree();
        rootNode = mTree.createBinaryTree();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createBinaryTree() {
        mTree.createBinaryTree();
    }

    @Test
    public void preOrderTravsersal() {
        mTree.preOrderTraversal(rootNode);
    }

    @Test
    public void inOrderTravsersal() {
        mTree.inOrderTraversal(rootNode);
    }

    @Test
    public void postOrderTravsersal() {
        mTree.postOrderTraversal(rootNode);
    }

    @Test
    public void preOrderTravsersalByStack() {
        mTree.preOrderTraversalByStack(rootNode);
    }

    @Test
    public void inOrderTravsersalByStack() {
        mTree.inOrderTraversalByStack(rootNode);
    }

    @Test
    public void postOrderTraversalByStack(){
        mTree.postOrderTraversalByStack(rootNode);
    }
}
