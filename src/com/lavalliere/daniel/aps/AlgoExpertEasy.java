package com.lavalliere.daniel.aps;

import java.util.*;

public class AlgoExpertEasy {
    // ******************************************************************************************************
    //-----------------------------------------------------------------------------------
    // TWO NUMBER SUM:
    //-----------------------------------------------------------------------------------
    // Function that take non empty array and an integer representing the sum of 2 numbers.
    // If any 2 numbers in the array sum up to the specified value, return them in an array

    // My Solution 1
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // Write your code here.
        for(int i=0; i < array.length - 1; i++) {
            for(int j=i+1; j < array.length; j++) {
                if ((array[i] + array[j]) == targetSum) {
                    return new int[] {array[i], array[j] };
                }
            }
        }
        return new int[0];
    }

    // Original Solution 1:


    // ******************************************************************************************************
    //-----------------------------------------------------------------------------------
    // VALIDATE SUBSEQUENCE
    //-----------------------------------------------------------------------------------

    // Given 2 non-emty arrays (array and sequence), determine if the sequence elements appear
    // in the array in the same order but could have extra elements between them
    // ex: array: [ 5, 1, 22, 25, 6, -1, 8, 10]  sequence: [ 1, 6, -1, 10]    response: true

    // My Solution 1: (O N^2)
    public static boolean isValidSubsequenceMine(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        int lastPos = -1;
        int matchCount = 0;
        Integer[] searchArray = new Integer[array.size()];
        searchArray = array.toArray(searchArray);
        for(Integer seqVal : sequence) {
            for(int i = ++lastPos;i < searchArray.length; i++) {
                if (searchArray[i] == seqVal) {
                    matchCount++;
                    lastPos = i;
                    break;
                }
            }
        }
        return (matchCount == sequence.size());
    }

    // Original Soluton 1:  Better O(N)
    public static boolean isValidSubsequenceTheirs(List<Integer> array, List<Integer> sequence) {
        int arrIndex = 0;
        int seqIndex = 0;
        while(arrIndex < array.size() && seqIndex < sequence.size()) {
            if (array.get(arrIndex).equals(sequence.get(seqIndex))) {
                seqIndex++;
            }
            arrIndex++;
        }
        return seqIndex == sequence.size();
    }


    // ******************************************************************************************************
    //-----------------------------------------------------------------------------------
    // FIND CLOSEST VALUE IN BST
    //-----------------------------------------------------------------------------------

    // Given a Binary Search tree where all the nodes on the RHS are larger then the current node
    // and  all the nodes on the LHS are smaller and each node is assigned a number,
    // traverse the tree and return the closest match found, there will be at most 1 match

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    // My Solution 1:
    public static int findClosestValueInBst(BST tree, int target, int closest) {
        // Determine the closest between previous value and current node value
        if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
            closest = tree.value;
        }

        // If target value is larger that current node value
        // then any closest value has to be higher that current node value
        if ((target > tree.value) && (tree.right != null)) {
            return findClosestValueInBst(tree.right, target, closest);

            // If target value if smaller than current node value
            // then any closest hast to be lower than current node
        } else if ((target < tree.value) && (tree.left != null)) {
            return findClosestValueInBst(tree.left, target, closest);

            // Since nothing left to visit for current node, return last closet
        } else {
            return closest;
        }
    }

    // My Solution 2
    public static int findClosestValueInBst(BST tree, int target) {
        int closest = tree.value;
        while (tree != null) {
            if (Math.abs(tree.value - target) < Math.abs(closest - target)) {
                closest = tree.value;
            }
            tree = (target > tree.value ? tree.right : tree.left);
        }
        return closest;
    }
    // ******************************************************************************************************

    //-----------------------------------------------------------------------------------
    // BRANCH SUM
    //-----------------------------------------------------------------------------------

    // Take a binary tree and return a list of it branch sums
    // ordered from left breanch sum to right branch sum,

    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // My solution
    public static List<Integer> branchSums(BinaryTree root) {
        // Write your code here.
        List<Integer> sumList = new ArrayList<Integer>();
        branchSums(root, sumList, 0);
        return sumList;
    }

    private static void branchSums(BinaryTree root, List<Integer> sumList, int curSum) {
        if (root == null) {
            sumList.add(curSum);
        } else {
            curSum += root.value;

            // Have to check for null to make sure we do not add the same sum twice
            // since you have 2 leaf nodes to visit
            if ((root.left != null) && (root.right != null)) {
                branchSums(root.left, sumList, curSum);
                branchSums(root.right, sumList, curSum);
            } else if (root.left != null) {
                branchSums(root.left, sumList, curSum);
            } else {
                branchSums(root.right, sumList, curSum);
            }
        }
    }

    // Original Solution
    private static void branchSums2(BinaryTree node, List<Integer> sumList, int curSum) {
        if (node == null) return;

        int totSum = curSum + node.value;

        // Only sum when you reach the leaf node
        if ((node.left == null) && (node.right == null)) {
            sumList.add(totSum);
            return;
        }

        // Always visit both nodes since will check for null an return
        // and therefore prevent adding same value twice
        branchSums2(node.left, sumList, totSum);
        branchSums2(node.right, sumList, totSum);
    }



    // NODE DEPTH

    // The distance between a node in a binary and the Tree root is called the node depth
    // Take a binary tree and return the sum of its nodes depth where each node has a value
    // and possibly left/right child node

     // My Solution:

    public static int nodeDepths(BinaryTree root) {
        return nodeDepths(root, 0);
    }

    public static int nodeDepths(BinaryTree node, int depth) {
        if (node == null) return 0;
        int total = depth;
        total += nodeDepths(node.left, depth + 1);
        total += nodeDepths(node.right, depth + 1);
        return total;
    }

    // ******************************************************************************************************

    //---------------------------------------------------------------------------------------------
    // WARNING :    MAKE SURE TO READ THE ACTUAL QUESTION,
    //              IN THE CURRENT QUESTION, WHEN SAYING RETURN THE NTH NUMBER, IT IS ASSUMING STARTS AT 1
    //              IE: RETURN THE 1ST NUMBER, 2ND NUMBER ETC
    //              NOT THE USUAL F[0] = 0, F[1] = 1, F[2] = 1, F[3] = 2, F[4] = 3, F[5] = 5, F[6] = 8
    //              WHICH CORRESPONDS TO getFib(N)
    //---------------------------------------------------------------------------------------------------

    public static int getFib1(int n) {
        if (n < 0) return 0;
        if (n <= 1) return n;
        return getFib1(n-1) + getFib1(n-2);
    }

    public static int getFib2(int n) {
        int[] fibarr = new int[n + 1];
        fibarr[0] = 0;
        fibarr[1] = 1;
        for(int i = 2; i <= n; i++) {
            fibarr[i] = fibarr[i-1] + fibarr[i-2];
        }
        return fibarr[n];
    }

    public static int getNthFib1(int n) {
        return (n == 2 ? 1 : (n <= 1 ? 0 : (getNthFib1(n - 1) + getNthFib1(n - 2))));
    }

    public static int getNthFib2(int n) {
        int[] fibarr = new int[n + 1];
        fibarr[0] = 0;
        fibarr[1] = 1;
        for(int i = 2; i <= n; i++) {
            fibarr[i] = fibarr[i-1] + fibarr[i-2];
        }
        return fibarr[n - 1];
    }

    // ******************************************************************************************************
    //---------------------------------------------------------------------------------------------
    // implement the binary search algorithm
    //---------------------------------------------------------------------------------------------
    public static int binarySearch1(int[] array, int target) {
        if ((array.length == 0) ||
                (array[0] > target) ||
                (array[array.length - 1] < target)) {
            return -1;
        }
        int lhspos = 0;
        int rhspos = array.length;
        int midpos = (rhspos + lhspos) / 2;

        while (array[midpos] != target) {
            int lastmid = midpos;
            if (array[midpos] > target) {
                rhspos = midpos;
            } else {
                lhspos = midpos;
            }
            midpos = (rhspos + lhspos) / 2;
            if (midpos == lastmid) return -1;
        }
        return midpos;
    }



    public static int binarySearch2(int[] array, int target) {
        return binarySearch2(array, target, 0, array.length -1);
    }
    private static int binarySearch2(int[] array, int target, int left, int right) {
       if (left > right) return -1;
       int middle = (left + right) / 2;
       if (array[middle] == target) {
           return middle;
       } else if (target < array[middle]) {
            return binarySearch2(array, target, left, middle - 1);
       } else {
            return binarySearch2(array, target, middle + 1, right);
       }
    }


    // ******************************************************************************************************
    //---------------------------------------------------------------------------------------------
    // Write a function that takes in a special array and return its product sum
    // A special array is a non-empty array that contains either integers or other special arrays.
    // The product sum of a special array is the sum of its elements  where special arrays inside it are summed
    //  themselves then multiply by their level of depth. The depth of a special array is how far nested it is.
    // for instance the depth of [] is 1  the depth of the inner array in [[]] is 2, the depth of the innermost
    // array in [[[]]] is 3;  Therefore for [x, y] you have x+y, [x, [y, z]] x + 2 * (y + z), [x, [y, [z,]]]
    // you have x + 2 * (y + 3 * (z))
    //---------------------------------------------------------------------------------------------

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    @SuppressWarnings("unchecked")  // This is  to address the Object vs List<Object> cast warning
    private static int productSum(List<Object> array, int depthLevel) {
        int total = 0;
        depthLevel++;
        for(Object element : array) {
            if (element instanceof Integer) {
                total += ((Integer)element).intValue();
            }	else {
                total += depthLevel * productSum((List<Object>)element, depthLevel);
            }
        }
        return total;
    }

    // ******************************************************************************************************
    //---------------------------------------------------------------------------------------------
    // Write a function that takes and array of at leat 3 integers and, without sorting,
    // returns a sorted array of the three largest integers in the input array. The function should
    // return duplicates integers if necessary.
    // Ex: [141, 1, 17, -7, -17, -27, 18, 541, 8, 7 , 7]   returns [18, 141, 541]
    //---------------------------------------------------------------------------------------------

    // Not as good solution since restricted to 3 value
    public static int[] findThreeLargestNumbers(int[] array) {
        int smallLargestPos = -1;
        int midLargestPos = -1;
        int bigLargestPos = -1;
        for(int i=0; i <  array.length; i++) {
            if (bigLargestPos == -1) {
                bigLargestPos = i;
            } else if (array[i] >= array[bigLargestPos]) {
                smallLargestPos  = midLargestPos;
                midLargestPos = bigLargestPos;
                bigLargestPos = i;
            } else if (midLargestPos == -1) {
                midLargestPos = i;
            } else if (array[i] >= array[midLargestPos]) {
                smallLargestPos = midLargestPos;
                midLargestPos = i;
            } else if (smallLargestPos == -1) {
                smallLargestPos = i;
            } else if (array[i] >= array[smallLargestPos]) {
                smallLargestPos = i;
            }
        }
        return new int[]{array[smallLargestPos], array[midLargestPos], array[bigLargestPos]};
    }

    //---------------------------------------------------------------------------------------------

    // Best Original solution to adapt to increasing number of values to return
    public static int[] findThreeLargestNumbersOriginal(int[] array) {
        int[] threeLargest = { Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE };
        for(int num : array) {
            updateLargest(threeLargest, num);
        }
        return threeLargest;
    }
    private static void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2]) {
            shiftAndUpdate(threeLargest, num, 2);
        } else if (num > threeLargest[1]) {
            shiftAndUpdate(threeLargest, num, 1);
        } else if (num > threeLargest[0]) {
            shiftAndUpdate(threeLargest, num, 0);
        }
    }
    private static void shiftAndUpdate(int[] threeLargest, int num, int idx) {
        for (int i=0; i < idx; i++) {
            if (i == idx) {
                threeLargest[i] = num;
            } else {
                threeLargest[i] = threeLargest[i+1];
            }
        }
    }
    // ******************************************************************************************************



    /*
    The task that I was given was to write a method or function using my choice
    hat will take in a single string input that should output the same string, but all scrambled up.
    I was told not to worry about input data types since we can assume that a string will always be provided,
    and also to not worry about any special characters or spaces. The only rule I had to keep in mind was
    that I couldn’t use the shuffle method which is only available in the Ruby language. Shuffle is an array class
    method that takes an array and randomly moves the items around.
     */
}
