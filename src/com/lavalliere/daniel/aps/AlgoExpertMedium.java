package com.lavalliere.daniel.aps;

import java.util.*;
public class AlgoExpertMedium {


    // ******************************************************************************************************
    //-----------------------------------------------------------------------------------
    // ARRAY OF PRODUCTS
    //-----------------------------------------------------------------------------------

    // Take an array of number and return an array of the same size where the value of each element
    // corresponds to the product of all other elements of the array (not including itself)

    public int[] arrayOfProducts(int[] array) {
        int[] result = new int[array.length];
        for(int i=0;i < array.length;i++) {
            int prod = 1;
            for(int j=0;j < array.length; j++) {
                if (i == j) continue;
                prod *= array[j];
            }
            result[i] = prod;
        }
        return result;
    }

    // ******************************************************************************************************
    //-----------------------------------------------------------------------------------
    // FIRST DUPLICATE VALUE
    //-----------------------------------------------------------------------------------

    // Take an array, traversing from left to right, print the first value that occurs more that once

    public int firstDuplicateValue(int[] array) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int i=0; i < array.length; i++) {
            if (counts.get(array[i]) != null) return array[i];
            counts.put(array[i], 1);
        }
        return -1;
    }

    // ******************************************************************************************************
}
