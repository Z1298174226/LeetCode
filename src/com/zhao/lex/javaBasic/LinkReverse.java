package com.zhao.lex.javaBasic;

import com.sun.org.apache.regexp.internal.RE;
import com.zhao.lex.meituan.ListNode;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by qtfs on 2019/3/12.
 */
public class LinkReverse {
    class Node {
        int val;

        Node(int val) {
            this.val = val;
        }

        Node next;
    }

    public Node initLink(int[] arr) {
        int length = arr.length;
        if (length == 0) return null;
        Node root = new Node(arr[0]);
        Node temp = root;
        for (int i = 1; i < length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return root;
    }

    public void printLink(Node root) {
        while (root != null) {
            System.out.print(root.val + (root.next != null ? " -> " : ""));
            root = root.next;
        }
    }

    public Node linkReverse(Node root) {
        if (root == null) return null;
        if (root.next == null) return root;
        Node p = root;
        Node q = root.next;
        Node r;
        p.next = null;
        while (q != null) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        root = p;
        return root;
    }

    public Node Root = null;

    public Node recurrentReverse(Node root) {
        if(root == null) return null;
        else if(root.next == null) {
            Root = root;
            return root;
        }
        else {
            Node subHesd = recurrentReverse(root.next);
            subHesd.next = root;
            root.next = null;
            return root;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < 100; i++)
            arr[i] = i;
        LinkReverse.Node root = new LinkReverse().initLink(arr);
        new LinkReverse().printLink(root);
        System.out.println();
        Node reRoot = new LinkReverse().linkReverse(root);
        new LinkReverse().printLink(reRoot);
        System.out.println();
        LinkReverse reverse = new LinkReverse();
        reverse.recurrentReverse(reRoot);
        reverse.printLink(reverse.Root);
        List<Integer> list1 = new ArrayList<Integer>();
        list1.add(7);list1.add(6);list1.add(5);list1.add(4);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(6);list2.add(4);
        System.out.println(list1.containsAll(list2));
        String s = null;
    }


}
