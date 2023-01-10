package com.github.ikhideifidon;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public static void printLinkedList(ListNode head) {
        if (head == null) return;
        ListNode current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

    private static ListNode node;

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }

        int size = 0;
        ListNode runner = head;
        node = head;

        while(runner != null){
            runner = runner.next;
            size ++;
        }

        return inorderHelper(0, size - 1);
    }

    public static TreeNode inorderHelper(int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);

        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;

        treenode.right = inorderHelper(mid + 1, end);

        return treenode;
    }
}


