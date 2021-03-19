package com.lavalliere.daniel.aps;
import java.util.*;
public class App {

    public static void testArraOps(int[] baseTestNumbers) {
        ArrayOps arrayOps = new ArrayOps(baseTestNumbers);
        arrayOps.mergeSortArray();
        
        /*
        arrayOps.insertionSortArray(false);
        arrayOps.insertionSortArray(true);
        arrayOps.selectionSortArray(false);
        arrayOps.selectionSortArray(true);
        arrayOps.insertionSortList(false);
        arrayOps.insertionSortList(true);
        arrayOps.selectionSortList(false);
        arrayOps.selectionSortList(true);
        arrayOps.quicksortArray();
        */

    }

    public static void testLinkedListOps(int[] baseTestNumbers) {
        LinkedListOps linkedListOps = new LinkedListOps(baseTestNumbers);
        linkedListOps.selectionSortList(false);
        linkedListOps.selectionSortList(true);
        linkedListOps.insertionSortList(false);
        linkedListOps.insertionSortList(true);
    }

    public static void testTreeOps(int[] baseTestNumbers) {
       TreeOps tree = new TreeOps();
       for(int i =0; i < baseTestNumbers.length; i++) {
           tree.insert(baseTestNumbers[i]);
       }
       tree.inOrderTraversal();
       System.out.printf("-------------------------------------------");
       tree.preOrderTraversal();
       System.out.printf("-------------------------------------------");
       tree.postOrderTraversal();
       System.out.printf("-------------------------------------------");

       System.out.printf("Looking for %d, found: %s\n", 24, (tree.search(24) ? "true" : "false"));
       System.out.printf("Looking for %d, found: %s\n", 32, (tree.search(32) ? "true" : "false"));
       System.out.printf("Looking for %d, found: %s\n", 6, (tree.search(6) ? "true" : "false"));
       System.out.printf("Looking for %d, found: %s\n", 1, (tree.search(1) ? "true" : "false"));
    }


    public static void main (String[] args) {

        //int[] baseTestNumbers = { 3, 5, 10, 1, 4, 9, 2, 8, 7, 6 };
        //int[] baseTestNumbers2 = { 31, 5, 10, 11, 24, 9, 2, 38, 17, 6 };
        //int[] sortedData = { 3, 5, 9, 13, 18, 25, 28, 32, 36, 44 };
        // List<Integer> baseTestNumbersList = Arrays.asList(3, 5, 10, 1, 4, 9, 2, 8, 7, 6);  // For JAVA 7 and less

        //testArraOps(baseTestNumbers2);
        // testLinkedListOps(baseTestNumbers);

        // testTreeOps(baseTestNumbers2);

        /*
        Utils utils = new Utils();
        //System.out.printf("Factorial of: %d is %d\n", 3, utils.factorial(4));
        //System.out.printf("A converted value: 123 to: %d", utils.convert("123") );
        for(int i=0; i < 10; i++) {
            System.out.printf("Fibonacci for %d is %d\n",i, utils.fibonacci_n2(i));
        }

        System.out.println("---------------------------------------------------------");
        for(int i=0; i < 10; i++) {
            System.out.printf("Fibonacci for %d is %d\n",i, utils.fibonacci_n(i));
        }

         */

        //MultitreadingOps tops = new MultitreadingOps(5000);

/*

        String[] sampleAnagrams1 = { "eat", "tea", "tan", "ate", "nat", "bat"};
        Anagram anagram = new Anagram();
        anagram.traverseAnagrams(sampleAnagrams1);
*/

        /*
        String[] sampleMatchStrings1 = {"())", "(((", "()", "()))((", ")))", "(", ")"};
        PatternMatch patternMatch = new PatternMatch();
        for(int i=0;i < sampleMatchStrings1.length; i++) {
            System.out.printf("Total missing for %s : %d\n",sampleMatchStrings1[i], patternMatch.getMissingParenCount(sampleMatchStrings1[i]));
        }
        */

        /*
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10));
        List<Integer> sequence = new ArrayList<Integer>(Arrays.asList(1, 6, -1, 10));
        boolean match = AlgoExpertEasy.isValidSubsequenceMine(array, sequence);
        System.out.printf("Is a match: %s\n", (match ? "true" : "false"));
         */

        // System.out.printf("Fibinacci of %d is %d , %d\n", 6, AlgoExpertEasy.getFib1(6), AlgoExpertEasy.getFib2(6));
    }




}