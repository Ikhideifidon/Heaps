package com.github.ikhideifidon;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] keys = {5, 1, 7};
        ArrayBasedHeap<Integer> heap = new ArrayBasedHeap<>(keys);
        System.out.println(heap.remove());
        System.out.println(heap.remove());

        int n = 2;
        while (Math.pow(2, n / 8.0) < n)
            n++;
        System.out.println("Maximum value of n for which insertion sort beats merge sort is " + (n - 1));

        n = 2;
        while (100 * Math.pow(n, 2.0) >= Math.pow(2, n))
            n++;
        System.out.println("\nThe smallest value of n is: " + n);

        int[] A = {5, 2, 4, 6, 1, 3};
        int[] B = {6, 1, -1, 8, 2, 3, 5};
        selectionSort(A, 0);
        System.out.println("Selection Sort: " + Arrays.toString(A));
        Solution.mergeSort(B, 0, B.length - 1);
        System.out.println(Arrays.toString(B));
        int[] C = {2, 1, 5, -2, 8, 3};
        Solution.recursiveInsertionSort(C, C.length);
        System.out.println(Arrays.toString(C));
        System.out.println(Solution.sumoOfElementsInArray(C, C.length));
        System.out.println(Solution.recursiveBinarySearch(B, 0, B.length - 1, 8));
        int[] sample = {12, 5, -1, 3, 7, 9, 14, 6, 11, 2};
        Solution.recursiveInsertionSortBinarySearch(sample, sample.length);
        System.out.println(Arrays.toString(sample));
        System.out.println(Solution.sumOfTwoNumbers(sample, 90));
        Random rand = new Random(0);
        int[] sample2 = new int[100];
        for (int i = 0; i < 100; i++)
            sample2[i] = rand.nextInt(-5, 111);
        Solution.bubbleSort(sample2);
        int[] sample3 = {2, 1};
        Solution.bubbleSort(sample3);
        System.out.println(Arrays.toString(sample2));
        System.out.println(Arrays.toString(sample3));
        int[] array = {8, 1, 6, 2};
        System.out.println(Solution.inversions(array));

        System.out.println("Inversion Counts");
        int[] inversion = {1, 20, 6, 7, 5, 8, 11, 3};
        System.out.println(Solution.inversionCounts(inversion, 0, inversion.length - 1));
        int[] gas = {3, 1, 1};
        int[] cost = {1, 2, 2};
        System.out.println(Solution.canCompleteCircuit(gas, cost));

        int[] candy = {2, 4, 5, 3, 2, 1};
        System.out.println(Solution.candy(candy));

        System.out.println();
        System.out.println("ListNode");
        ListNode LL = new ListNode(3);
        LL.next = new ListNode(4);
        LL.next.next = new ListNode(5);
        LL.next.next.next = new ListNode(7);
        LL.next.next.next.next = new ListNode(8);
        LL.next.next.next.next.next = new ListNode(10);
        LL.next.next.next.next.next.next = new ListNode(12);
        ListNode.printLinkedList(LL);

        System.out.println();
        System.out.println("TreeNode");
        TreeNode tree = TreeNode.sortedListToBST(LL);
        TreeNode.printTree(tree);








    }

    public static void selectionSort(int[] A, int i) {
        int n = A.length;
        if (n <= 1) return;
        if (i >= n - 1) return;

        int index = findMinIndex(A, i);
        if (i != index) swap(A, i, index);
        selectionSort(A, i + 1);
    }

    private static int findMinIndex(int[] A, int i) {
        int minIndex = i;
        for (int j = i + 1; j < A.length; j++) {
            if (A[minIndex] > A[j])
                minIndex = j;
        }
        return minIndex;
    }

    private static void swap(int[] A, int i, int index) {
        int temp = A[i];
        A[i] = A[index];
        A[index] = temp;
    }



}