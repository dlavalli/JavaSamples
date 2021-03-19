package com.lavalliere.daniel.aps;

import java.util.Collection;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class ArrayOps {
    private int[] numbersToSortArray;
    private int[] sortedNumbersArray;
    private List<Integer> numbersToSortVector;

    public ArrayOps(int[] numbersToSortArray) {
        this.numbersToSortArray = numbersToSortArray;
        this.numbersToSortVector = Arrays.stream(numbersToSortArray)      // Returns IntStream,  Java 8 +
                .boxed()                         // Returns Stream<Integer>
                .collect(Collectors.toList());   // Returns List<Integer>
    }

    /*****************************************************************************************
     *
     * Complexity O(N ^ 2)
     *****************************************************************************************/

    public void insertionSortList(boolean reverse) {   // O(N^2)
        System.out.printf("Using %s ordering for list bubble sort: ", (reverse ? "decreasing" : "increasing"));
        // To get an array instead of processing a List
        int[] arr = numbersToSortVector.stream()            // Stream<Integer>,  Java 8 +
                .mapToInt(x -> x)    // IntStream
                .toArray();          // Returns int[]

        insertionSortArray(arr, reverse);
    }

    public void insertionSortArray(boolean reverse) {   // O(N^2)
        System.out.printf("Using %s ordering for array bubble sort: ", (reverse ? "decreasing" : "increasing"));
        insertionSortArray(numbersToSortArray, reverse);
    }

    private void insertionSortArray(int[] numbersArr, boolean reverse) {   // O(N^2)
        printArray(numbersArr);
        int[] sortedCopy = Arrays.copyOf(numbersArr, numbersArr.length);
        for(int k=0; k < sortedCopy.length; k++) {              // Run as many times as size of array
            for(int i=0,j=1; j < sortedCopy.length;i++,j++) {   // Compare from start to end
                if (reverse) {
                    if (sortedCopy[i] < sortedCopy[j]) {
                        int tmp = sortedCopy[j];
                        sortedCopy[j] = sortedCopy[i];
                        sortedCopy[i] = tmp;
                    }

                } else {
                    if (sortedCopy[i] > sortedCopy[j]) {
                        int tmp = sortedCopy[j];
                        sortedCopy[j] = sortedCopy[i];
                        sortedCopy[i] = tmp;
                    }
                }
            }
        }
        printArray(sortedCopy);
        sortedNumbersArray = sortedCopy;
    }


    /*****************************************************************************************
     *
     * Complexity O(N ^ 2)
     *****************************************************************************************/
    public void selectionSortList(boolean reverse) {   // Complexity O(N^2)
        System.out.printf("Using %s ordering for list selection sort: ", (reverse ? "decreasing" : "increasing"));
        // To get an array instead of processing a List
        int[] arr = numbersToSortVector.stream()            // Stream<Integer>,  Java 8 +
                .mapToInt(x -> x)    // IntStream
                .toArray();          // Returns int[]

        selectionSortArray(arr, reverse);
    }

    public void selectionSortArray(boolean reverse) {   // Complexity O(N^2)
        System.out.printf("Using %s ordering for array selection sort: ", (reverse ? "decreasing" : "increasing"));
        selectionSortArray(numbersToSortArray, reverse);
    }

    private void selectionSortArray(int[] numbersArr, boolean reverse) {   // Complexity O(N^2)
        printArray(numbersArr);
        int[] sortedCopy = Arrays.copyOf(numbersArr, numbersArr.length);
        for(int i=0;i < sortedCopy.length;i++) {
            for(int j=i+1; j < sortedCopy.length;j++) {
                int tmp = 0;
                if (reverse) {
                    if (sortedCopy[i] < sortedCopy[j]) {
                        tmp = sortedCopy[j];
                        sortedCopy[j] = sortedCopy[i];
                        sortedCopy[i] = tmp;
                    }

                } else {
                    if (sortedCopy[i] > sortedCopy[j]) {
                        tmp = sortedCopy[j];
                        sortedCopy[j] = sortedCopy[i];
                        sortedCopy[i] = tmp;
                    }
                }
            }
        }
        printArray(sortedCopy);
        sortedNumbersArray = sortedCopy;
    }

    private void printArray(int[] arrToPrint) {
        for(int i=0; i < arrToPrint.length;i++) {
            if (i > 0) System.out.printf(",");
            System.out.printf("%d", arrToPrint[i]);
        }
        System.out.printf("\n");
    }


    /*****************************************************************************************
     *
     * Complexity O(Log N)
     *****************************************************************************************/
    public int binarySearch(int value) {
        // return binarySearch(sortedNumbersArray, value);
        return binarySearch(sortedNumbersArray, value, 0, sortedNumbersArray.length - 1);
    }

    private int binarySearch(int[] values, int value) {
        int resultPos = -1;
        int leftPos = 0;
        int rightPos = values.length - 1;

        // Sample array creation and initialization
        int[] ts = new int[]{1,2,3,4,5};

        while(leftPos <= rightPos) {
            int midPos = leftPos + ((rightPos - leftPos) / 2);
            if (values[midPos] == value) {
                resultPos = midPos;
                break;
            } else if (values[midPos] < value) {
                leftPos = midPos + 1;
            } else {
                rightPos = midPos -1;
            }
        }
        return resultPos;
    }

    private int binarySearch(int[] values, int value, int leftPos, int rightPos) {
        if (leftPos < rightPos) {
            int midPos = leftPos + ((rightPos - leftPos) / 2);
            if (values[midPos] == value) {
                return midPos;
            } else if (values[midPos] < value) {
                return binarySearch(values, value, midPos + 1, rightPos);
            } else {
                return binarySearch(values, value, leftPos, midPos -1);
            }
        }
        return -1;
    }


    /*********************************************************************************************
     Basically the algorithm follows a divide and conquer philosophy where you take the array and recursively
     divide it in 2 until you reach an array of size 1. Then for each return you consider 2 arrays you have
     using an index on each, inside a new array (the size of both current array) compare the values at current pos
     of each array, append the loweest value to the new array and move its current pointer. When reahed then end of
     one of the array simplyappend the remainder of the other array (in order and return). Continue until you reach
     the top level and the array is sorted.
     Complexity: O(N Log N)

     Worst than quick sort when considering memory requirements
     Unless using someething like linked list and do not need to create so many arrays
    *********************************************************************************************/

    public void mergeSortArray() {
        printArray(numbersToSortArray);
        int[] tempArray = new int[numbersToSortArray.length];

        // NOTE: this version of the algorithm modifies in place the elements of the array
        //       so make a copy of the array to work with wo wont affect existing
        sortedNumbersArray = Arrays.copyOf(numbersToSortArray, numbersToSortArray.length);

        mergeSortArray(tempArray, 0, numbersToSortArray.length - 1);
        printArray(sortedNumbersArray);
    }

    private void mergeSortArray(int[] arrayToFix, int lowerIndex, int upperIndex) {
        // Stop when have an array with a single element in the current array
        if (lowerIndex == upperIndex) {
            return ;
        }

        // Locate the middle of the current array
        int middleIndex = (lowerIndex + upperIndex) / 2;

        // Split into smaller arrays arount the middle element
        mergeSortArray(arrayToFix, lowerIndex, middleIndex);                 // Split LHS
        mergeSortArray(arrayToFix, middleIndex + 1,  upperIndex);   // Split RHS

        // Now sort and merge the LHS and RHS
        mergeArray(arrayToFix, lowerIndex,                        // LHS array
                     middleIndex + 1,  upperIndex);     // RHS of array
    }

    private void mergeArray(int[] arrayToFix, int lowerIndexCursor,                 // LHS array
                                              int higherIndex, int upperIndex) {    // RHS of array
        int tempIndex = 0;
        int lowerIndex = lowerIndexCursor;              // Keep track of LHS array cur pos
        int midIndex = higherIndex - 1;                 // Keep track of RHS array pos
        int totalItems = upperIndex - lowerIndex + 1;   // Number of elemnts to process in current array section

        // Traversing both LHS and RHS arrays as long as both still have element to process
        while ((lowerIndex <= midIndex) && (higherIndex <= upperIndex)) {

            // If the next LHS array element is smaller the RHS array element
            // Copy it to its final location and advance the pointer
            if (sortedNumbersArray[lowerIndex] < sortedNumbersArray[higherIndex]) {
                arrayToFix[tempIndex++] = sortedNumbersArray[lowerIndex++];

            // If the next RHS array element is smaller the LHS array element
            // Copy it to its final location and advance the pointer
            } else {
                arrayToFix[tempIndex++] = sortedNumbersArray[higherIndex++];
            }
        }

        // Copy remaining element from LHS array if not all processed
        while (lowerIndex <=  midIndex) {
            arrayToFix[tempIndex++] = sortedNumbersArray[lowerIndex++];
        }

        // Copy remaining element from LHS array if not all processed
        while (higherIndex <= upperIndex) {
            arrayToFix[tempIndex++] = sortedNumbersArray[higherIndex++];
        }

        // Now update the original array with the sorted element from current subarray
        for(int i =0; i < totalItems; i++) {
            sortedNumbersArray[lowerIndexCursor+i] =  arrayToFix[i];
        }
    }

    /*********************************************************************************************
     *
     * Complexity: O(N Log N),  Worst case O(N ^ 2)
     * Better than merge sort when considering memory requirements
     *********************************************************************************************/
    public void quicksortArray() {
        printArray(numbersToSortArray);
        int[] sortedCopy = Arrays.copyOf(numbersToSortArray, numbersToSortArray.length);
        quicksortArray(sortedCopy, 0, sortedCopy.length - 1);
        printArray(sortedCopy);
        sortedNumbersArray = sortedCopy;
    }

    /* Function that implements QuickSort()
       arr[] --> Array to be sorted,
       low  --> Starting index,
       high  --> Ending index */
    private void quicksortArray(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
               now at right place */
            int pi = quicksortArrayPartition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quicksortArray(arr, low, pi-1);
            quicksortArray(arr, pi+1, high);
        }
    }

    /* This function takes last element as pivot,
       places the pivot element at its correct
       position in sorted array, and places all
       smaller (smaller than pivot) to left of
       pivot and all greater elements to right
       of pivot */
    private int quicksortArrayPartition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element (ie: so fall on 0 on first i++)
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    /*********************************************************************************************/


}
