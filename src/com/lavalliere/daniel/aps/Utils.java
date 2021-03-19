package com.lavalliere.daniel.aps;

import java.util.Arrays;
public class Utils {

    @FunctionalInterface
    interface Converter<F, T> {
        T convert(F from);
    }

    // Converter using a method reference
    // Could also be doen through a lambda function but this is just an example
    public int convert(String number) {
        Converter<String, Integer> converter = Integer::valueOf;
        return  converter.convert("123");
    }

    // Corresponds to n * n-1 * n-2 ... * 1 (ie: 0!)
    public int factorial(int x) {
        if (x == 0) return 1;
        return x * factorial(x - 1);
    }

    public boolean isPrime(int n) {
        if (n <= 1) return false;
        else if (n == 2) return true;
        else if (n % 2 == 0) return false;

        for(int i=3; i < Math.sqrt(n);i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
    // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ……..
    // In mathematical terms, the sequence Fn of Fibonacci numbers is defined by the recurrence relation
    // Fn = Fn-1 + Fn-2
    public int fibonacci_n2(int n) {    // O(N^2)
        if (n <= 1) return n;
        return fibonacci_n2(n-1) + fibonacci_n2(n-2);
    }

    public int fibonacci_n(int n) { // O(N)
        int a=0, b=1, c=0;
        if (n == 0) return n;
        for(int i=2;i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }


    /* low  --> Starting index,  high  --> Ending index */
        public void quickSort(int[] arr, int low, int high)
        {
            if (low < high)
            {
                /* pi is partitioning index, arr[pi] is now at right place */
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);  // Before pi
                quickSort(arr, pi + 1, high); // After pi
            }
        }

        public int partition (int[] arr, int low, int high)
        {
            // pivot (Element to be placed at right position)
            int pivot = arr[high];
            int i = (low - 1);  // Index of smaller element

            for (int j = low; j <= high- 1; j++)
            {
                // If current element is smaller than the pivot
                if (arr[j] < pivot)
                {
                    i++;    // increment index of smaller element
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
            int tmp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = tmp;
            return (i + 1);
        }


    public long exponentiation(long base, long exp)  {
        long commonPrimeModulo = 1000000007L;
        long t = 1L;
        while (exp > 0) {
            if (exp % 2 != 0) {
                t = (t * base) % commonPrimeModulo;
            }
            base = (base * base) % commonPrimeModulo;
            exp /= 2;
        }
        return (t % commonPrimeModulo);
    }

    public boolean areAnagram(String string1, String string2)
    {
        char[] str1 = string1.toCharArray();
        char[] str2 = string2.toCharArray();

        if (string1.length() != string2.length())  return false;

        Arrays.sort(str1);
        Arrays.sort(str2);
        for (int i = 0; i < string1.length(); i++)
            if (str1[i] != str2[i])
                return false;

        return true;
    }

}


