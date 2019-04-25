package com.zhao.lex.javaBasic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.Executors;

/**
 * Created by qtfs on 2019/4/15.
 */
public class PostOrder {
    class TreeNode {
        int val;
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode left;
        TreeNode right;
    }
    public void postOrder(TreeNode node) {
        if(node == null) return;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = node;
        TreeNode lastNode = null;
        while(currentNode != null) {
            stack.add(currentNode);
            currentNode = currentNode.left;
        }
        while(!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            if(temp.right != null && temp.right != lastNode) {
                currentNode = temp.right;
                stack.add(temp);
                while(currentNode != null) {
                    stack.add(currentNode);
                    currentNode = currentNode.left;
                }
            }
            else {
                System.out.println(temp.val);
                lastNode = temp;
            }
        }
    }

    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(pRoot == null) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(pRoot);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
                if((count & 1) == 0)
                    list.add(node.val);
                else
                    list.add(0, node.val);
            }
            count++;
            result.add(list);
        }
        return result;
    }


    public TreeNode create(int[] arr) {
        return create(arr, 0, arr.length - 1);
    }

    public TreeNode create(int[] arr, int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        TreeNode left = create(arr, start, mid - 1);
        TreeNode right = create(arr, mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        PostOrder postOrder = new PostOrder();
        PostOrder.TreeNode root = postOrder.create(arr);
        postOrder.postOrder(root);
        System.out.println(postOrder.Print(root));
        int port = 4444;
        ServerSocket serverSocket = new ServerSocket(port);
        Socket s = serverSocket.accept();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }

    public int JumpFloor(int target) {
        if(target == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }


}
