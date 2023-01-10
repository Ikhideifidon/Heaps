package com.github.ikhideifidon;


import java.util.*;

public class Solution {

    public static void mergeSort(int[] A, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;       // Midpoint of A[low:high]
        mergeSort(A, low, mid);                 // Recursively sort A[low:mid]
        mergeSort(A, mid + 1, high);       // Recursively sort A[mid+1:high]
        // Merge A[low:high] and A[mid+1:high] into A[low:high]
        merge(A, low, mid, high);
    }

    private static void merge(int[] A, int low, int mid, int high) {
        int nL = mid - low + 1;             // Length of A[low:mid]
        int nR = high - mid;                // Length of A[mid+1:high]

        // Declaration of new arrays
        int[] left = new int[nL];
        int[] right = new int[nR];

        System.arraycopy(A, low, left, 0, nL);                    // Copy A[low:mid] into left[0:nL]
        System.arraycopy(A, mid + 1, right, 0, nR);        // Copy A[mid+1:high] into right[mid+1:nR]

        int i = 0;
        int j = 0;
        int k = low;

        while (i < nL && j < nR) {
            if (left[i] <= right[j])
                A[k++] = left[i++];
            else
                A[k++] = right[j++];
        }

        while (i < nL)
            A[k++] = left[i++];

        while (j < nR)
            A[k++] = right[j++];
    }

    // Recursive Insertion Sort
    public static void recursiveInsertionSort(int[] A, int n) {
        // A = [12, 3, 7, 9, 14, 6, 11, 2]
        if (n <= 1) return;
        recursiveInsertionSort(A, n - 1);
        // At this point, n = 1. Assume there is a pointer i at index 0.
        // Let j be the pointer referencing the index before the pointer i.
        // Since i = n - 1, j must be equal to n - 2
        int key = A[n - 1];
        int j = n - 2;
        while (j >= 0 && A[j] > key)
            A[j + 1] = A[j--];
        A[j + 1] = key;
    }

    public static int sumoOfElementsInArray(int[] A, int n) {
        if (n <= 1)
            return n == 1 ? A[0] : 0;

        return A[n - 1] + sumoOfElementsInArray(A, n - 1);
    }

    public static int recursiveBinarySearch(int[] A, int p, int r, int v) {
        if (p > r)
            return -1;

        int q = p + (r - p) / 2;

        if (A[q] == v)
            return q;
        else if (A[q] > v)
            return recursiveBinarySearch(A, p, q - 1, v);
        else
            return recursiveBinarySearch(A, q + 1, r, v);
    }

    public static void recursiveInsertionSortBinarySearch(int[] A, int n) {
        // A = [12, 3, 7, 9, 14, 6, 11, 2]
        if (n <= 1) return;
        for (int i = 1; i < n; i++) {
            int key = A[i];
            int j = i - 1;
            int index = binarySearch(A, 0, j, key);

            while (j >= index)
                A[j + 1] = A[j--];
            A[j + 1] = key;
        }
    }

    // Return the index of the right position to insert the key
    private static int binarySearch(int[] A, int left, int high, int key) {
       if (left >= high)
           return A[left] > key ? left : left + 1;

       int mid = left + (high - left) / 2;
       if (key == A[mid])
           return mid + 1;

       else if (key > A[mid])
           return binarySearch(A, mid + 1, high, key);
       else
           return binarySearch(A, left, mid - 1, key);
    }

    public static boolean sumOfTwoNumbers(int[] A, int x) {
        int n = A.length;
        if (n <= 1)
            return false;

        Arrays.sort(A);
        int high = n - 1;               // index of the last element
        for (int i = 0; i < n; i++) {
            int key = A[i];
            int difference = x - key;
            int low = i + 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (A[mid] == difference)
                    return true;
                else if (difference > A[mid])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return false;
    }

    public static void bubbleSort(int[] A) {
        int n = A.length;
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n - i; j++) {
                if (A[j] < A[j - 1]) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }
    }

    public static List<List<Integer>> inversions(int[] A) {
        int n = A.length;
        if (n <= 1) return new ArrayList<>();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j])
                    list.add(List.of(i, j));
            }
        }
        return list;
    }

    public static int inversionCounts(int[] A, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;                       // Midpoint of A[low:high]
        int left = inversionCounts(A, low, mid);                 // Recursively sort A[low:mid]
        int right = inversionCounts(A, mid + 1, high);       // Recursively sort A[mid+1:high]
        // Merge A[low:high] and A[mid+1:high] into A[low:high]
        return left + right + modifiedMerge(A, low, mid, high);
    }

    private static int modifiedMerge(int[] A, int low, int mid, int high) {
        // low <= mid < high
        int nL = mid - low + 1;             // Length of A[low:mid]
        int nR = high - mid;                // Length of A[mid+1:high]

        // Declaration of new arrays
        int[] left = new int[nL];
        int[] right = new int[nR];

        System.arraycopy(A, low, left, 0, nL);                    // Copy A[low:mid] into left[0:nL]
        System.arraycopy(A, mid + 1, right, 0, nR);        // Copy A[mid+1:high] into right[mid+1:nR]

        int i = 0;                      // Pointer on the left array
        int j = 0;                      // Pointer on the right array
        int k = low;
        int count = 0;

        while (i < nL && j < nR) {
            if (left[i] <= right[j])
                A[k++] = left[i++];
            else {
                count += nL - i;
                A[k++] = right[j++];
            }
        }

        while (i < nL)
            A[k++] = left[i++];

        while (j < nR)
            A[k++] = right[j++];
        return count;
    }

    /**
     * Definition for singly-linked list.
     */
     public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solutions {
        public ListNode removeNodes(ListNode head) {
            if (head == null || head.next == null) return head;

            Deque<ListNode> queue = new LinkedList<>();
            for (ListNode current = head; current != null; current = current.next) {
                while (!queue.isEmpty() && current.val > queue.peek().val)
                    queue.poll();

                queue.offer(current);
            }
            ListNode newHead = new ListNode(0);
            ListNode tail = newHead;
            for (ListNode node : queue) {
                tail.next = node;
                tail = tail.next;
            }
            return newHead.next;
        }
    }


    public static int canCompleteCircuit(int[] gas, int[] cost) {
         return helper(gas, cost, 0, 0, 0, 0);
    }

    private static int helper(int[] gas, int[] cost, int i, int balance, int deficit, int start) {
        int n = gas.length;
        if (i >= n) return (deficit < 0) ? -1 : start;
        int available = gas[i] - cost[i];
        deficit += available;
        balance += available;
        return helper(gas, cost, i + 1, Math.max(balance, 0), deficit, (balance < 0) ? i + 1 : start);
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int n = gas.length;
        int balance = 0;
        int deficit = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            balance += gas[i] - cost[i];
            deficit += gas[i] - cost[i];
            if(balance < 0){
                balance = 0;
                start = i + 1;
            }
        }
        return (deficit < 0) ? -1 : start;
    }

    public static int candy(int[] ratings) {
         int n = ratings.length;
         if (n == 1) return 1;
         int[] C = new int[n];
         C[0] = 1;

         for (int i = 1; i < n; i++) {
             if (ratings[i] > ratings[i - 1])
                 C[i] = C[i - 1] + 1;
             else
                 C[i] = 1;
         }
         int sum = C[n - 1];
         for (int i = n - 2; i >= 0; i--) {
             if (ratings[i] > ratings[i + 1])
                 C[i] = Math.max(C[i + 1] + 1, C[i]);
             sum += C[i];
         }
         return sum;
    }
}
