package com.zhao.lex.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qtfs on 2018/11/30.
 */
public class CreateBinaryTree {


    private static class Node {
        Node leftChild;
        Node rightChidl;
        int data;
        int count;
        int lessThan;

        Node(int data) {
            this.data = data;
        }
    }

    public void createBintree(List<Node> nodeLIst, int[] array) {
        for (int i = 0; i < array.length; i++) {
            nodeLIst.add(new Node(array[i]));
        }

        if (nodeLIst.size() > 0) {
            for (int y = 0; y < array.length / 2 - 1; y++) {
                //leftChild
                if (null != nodeLIst.get(2 * y + 1)) {
                    nodeLIst.get(y).leftChild = nodeLIst.get(2 * y + 1);
                }
                //rightChild
                if (null != nodeLIst.get(2 * y + 2)) {
                    nodeLIst.get(y).rightChidl = nodeLIst.get(2 * y + 2);
                }
            }
            //最后一个父节点不一定有孩子
            int lastParentIndex = array.length / 2 - 1;
            // 左孩子
            nodeLIst.get(lastParentIndex).leftChild = nodeLIst
                    .get(lastParentIndex * 2 + 1);
            //奇数时候有右孩子
            if (array.length % 2 == 1) {
                nodeLIst.get(lastParentIndex).rightChidl = nodeLIst
                        .get(lastParentIndex * 2 + 2);
            }
        }
    }

    /**
     * 先序遍历
     *
     * @param node
     */
    public static void preOrderTraver(Node node) {
        if(node == null) return;
        System.out.println("node:" + node.data);
        preOrderTraver(node.leftChild);
        preOrderTraver(node.rightChidl);
    }

    public int getSmallest(Node root, int val) {
        if(root == null) return 0;
        else if(root.data == val) {
            root.count++;
            return root.lessThan;
        }else if(root.data > val) {
            root.lessThan++;
            return getSmallest(root.leftChild, val);
        }else {
            return root.count + root.lessThan + getSmallest(root.rightChidl, val);
        }
    }

    public List<Integer> getSmallest(Node root, int[] array) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < array.length; i++)
            list.add(getSmallest(root, array[i]));
        return list;
    }

    public static void main(String[] args) {
        int array[] = {1, 3, 5, 6, 7, 9};
        CreateBinaryTree tree = new CreateBinaryTree();
        List<Node> nodeList = new ArrayList<Node>();
        tree.createBintree(nodeList, array);
        preOrderTraver(nodeList.get(0));
        System.out.println(tree.getSmallest(nodeList.get(0), array));
    }
}
