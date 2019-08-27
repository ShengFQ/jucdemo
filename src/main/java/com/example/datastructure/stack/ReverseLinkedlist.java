package com.example.datastructure.stack;

import java.util.Stack;

/**
 * @author guoqw
 * @since 2018-02-09 11:20
 */
public class ReverseLinkedlist {

    public static class Node {

        private Integer value;

        private Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void printRevertNode(Node node) {
        Stack<Integer> stack = new Stack<>();
        Node current = node;
        while (current != null) {
            stack.push(current.value);
            current = current.next;
        }
        System.out.println(stack);
    }

    public static void printRevertNode2(Node node) {
        Node current = node;
        if (current.next == null) {
            System.out.println(current.value);
        } else {
            printRevertNode2(current.next);
            System.out.println(current.value);
        }
    }

    public static void main(String[] args) {
        Node node3 = new Node(3, null);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        printRevertNode2(node1);
    }
}