package com.xhj.algorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author: Created by XHJ on 2019/1/5.
 * 种一棵树最好的时间是十年前，其次是现在。
 */
public class BinaryTree {

    //构造二叉树所需要的数组
//    String[] vals = {"A","B","C","D","E","F","G","H","I","J","K",
//        "L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] vals = {"A","B","C","D","E","F","G"};
    //存储二叉树的所有节点的LinkedList
    LinkedList<Node> nodeList = new LinkedList<>();

    //定义节点结构
    class Node{
        private String data;
        private Node leftNode;
        private Node rightNode;

        public Node(String data){
            this.data = data;
            leftNode = null;
            rightNode = null;
        }

    }

    /**
     * 创建一颗完全二叉树
     * @return 二叉树的跟节点
     */
    public Node createBinaryTree(){
        //根据数组内容生成所有节点并存储到nodelist
        for(int i=0;i<vals.length;i++){
            nodeList.add(new Node(vals[i]));
        }
        //完全二叉树中父节点的个数为[n/2],节点个数为基数时，最后一个父节点
        //有右子树，为偶数是无右子树。
        for(int parentIndex=0;parentIndex<nodeList.size()/2-1;parentIndex++){
            //左子树的节点编号为 parentIndex*2,因为数组下标从0开始所以+1，右子树+2
            nodeList.get(parentIndex).leftNode = nodeList.get(parentIndex*2+1);
            nodeList.get(parentIndex).rightNode = nodeList.get(parentIndex*2+2);
        }
        //最后一个父节点编号，因为数组从0开始，所以-1，二叉树的编号从1开始
        int lastNodeNum = nodeList.size()/2-1;
        nodeList.get(lastNodeNum).leftNode = nodeList.get(lastNodeNum*2+1);
        if(nodeList.size()%2==1){
            nodeList.get(lastNodeNum).rightNode = nodeList.get(lastNodeNum*2+2);
        }
        //完全二叉树生成后，返回数的跟节点
        return nodeList.get(0);
    }

    /**
     * 递归实现
     * 先序遍历二叉树
     * @param rootNode
     */
    public void preOrderTraversal(Node rootNode){
        if(rootNode == null){
            return;
        }
        System.out.print(rootNode.data+" ");
        preOrderTraversal(rootNode.leftNode);
        preOrderTraversal(rootNode.rightNode);

    }

    /**
     * 递归实现
     * 中序遍历二叉树
     * @param rootNode
     */
    public void inOrderTraversal(Node rootNode){
        if(rootNode == null){
            return;
        }
        inOrderTraversal(rootNode.leftNode);
        System.out.print(rootNode.data+" ");
        inOrderTraversal(rootNode.rightNode);

    }

    /**
     * 递归实现
     * 后序遍历二叉树
     * @param rootNode
     */
    public void postOrderTraversal(Node rootNode){
        if(rootNode == null){
            return;
        }
        postOrderTraversal(rootNode.leftNode);
        postOrderTraversal(rootNode.rightNode);
        System.out.print(rootNode.data+" ");

    }

    /**
     * 栈实现
     * 先序遍历
     * 遇到一个节点，访问它；
     * 然后就把它压栈，并去遍历它的左子树；
     * 当左子树遍历结束后，按其右子树指针再去中序遍历该结点的右子树。
     * @param node
     */
    public void preOrderTraversalByStack(Node node){
        Stack<Node> nodeStack = new Stack<>();
        while (node != null || !nodeStack.isEmpty()){

            while(node != null){
                System.out.print(node.data+" ");
                nodeStack.push(node);
                node = node.leftNode;
            }

            if (!nodeStack.isEmpty()){
                node = nodeStack.pop();
                node = node.rightNode;
            }
        }
    }

    /**
     * 栈实现
     * 中序遍历
     * 遇到一个节点，就把它压栈，并去遍历它的左子树；
     * 当左子树遍历结束后，从栈顶弹出这个节点并访问它；
     * 然后按其右子树指针再去中序遍历该结点的右子树。
     * @param node
     */
    public void inOrderTraversalByStack(Node node){
        Stack<Node> nodeStack = new Stack<>();
        while (node != null || !nodeStack.isEmpty()){

            while(node != null){
                nodeStack.push(node);
                node = node.leftNode;
            }

            if (!nodeStack.isEmpty()){
                node = nodeStack.pop();
                System.out.print(node.data+" ");
                node = node.rightNode;
            }
        }
    }

    /**
     * 栈实现
     * 后序遍历
     * 对于一个节点而言，要实现访问顺序为左子树->右子树->根节点，可以利用先进后出栈，
     * 在节点部位空的前提下，依次将根节点，右子树，左子树压栈。
     * 故我们需要按照根节点->右子树->左子树的顺序遍历树，
     * 而我们紫荆知道先序遍历是根节点->左子树->右子树，
     * 故只需将先序遍历的左右调换并把访问方式打印改为压入另一个栈即可，
     * 最后一起打印栈中的元素。
     * @param node
     */
    public void postOrderTraversalByStack(Node node){
        Stack<Node> nodeStack1 = new Stack<>();
        Stack<Node> nodeStack2 = new Stack<>();

        while (node != null || !nodeStack1.isEmpty()){

            while (node != null){
                nodeStack1.push(node);
                nodeStack2.push(node);
                node = node.rightNode;
            }

            if(!nodeStack1.isEmpty()) {
                node = nodeStack1.pop();
                node = node.leftNode;
            }
        }

        while (!nodeStack2.isEmpty()){
            node = nodeStack2.pop();
            System.out.print(node.data + " ");
        }
    }

    /**
     * 栈实现
     * 后序遍历
     *
     * @param node
     */
    public void postOrderTraversalByStack2(Node node){

        if(node == null){
            return;
        }
        Node preNode = null, currNode = null;
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);

        while (!nodeStack.isEmpty()){
            currNode = nodeStack.peek();
            if(preNode == null || preNode.leftNode == currNode || preNode.rightNode == currNode){
                if(currNode.leftNode != null){
                    nodeStack.push(currNode.leftNode);
                }else if(currNode.rightNode !=null){
                    nodeStack.push(currNode.rightNode);
                }
            }else if(currNode.leftNode == preNode){
                if(currNode.rightNode != null){
                    nodeStack.push(currNode.rightNode);
                }
            }else {
                System.out.print(currNode.data + " ");
                nodeStack.pop();
            }
            preNode = currNode;
        }
    }

    /**
     * 队列实现
     * 层序遍历
     * 遍历从根节点开始，首先将根节点入队，然后执行循环，
     * 节点出队，访问该节点，将左子树入队，将右子树入队，
     * 一直到队列为空为止，循环结束，程序结束。
     * @param node
     */
    public void levelOrderTraversal(Node node){
        if(node == null){
            return;
        }
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(node);
        while (!nodeQueue.isEmpty()){
            node = nodeQueue.poll();
            System.out.print(node.data + " ");
            if(node.leftNode != null){
                nodeQueue.offer(node.leftNode);
            }
            if(node.rightNode != null){
                nodeQueue.offer(node.rightNode);
            }
        }
    }


}
























