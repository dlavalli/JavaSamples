package com.lavalliere.daniel.aps;

import java.util.*;

public class Anagram {

/*
Your previous Plain Text content is preserved below:

1. Given an array of strings, group anagrams together.

Example:

Input:["eat", "tea", "tan", "ate", "nat", "bat"], Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/
public void traverseAnagrams(String[] sampleData) {
    // Failed test from PaymntLabs Canada ... O n
    // About 25 - 30 minutes to write...
    Map<String, Vector<String>> match = new HashMap<>();
    for(String sample : sampleData) {
        char[] chArr = sample.toCharArray();
        Arrays.sort(chArr);
        String key = new String(chArr);
        Vector<String> matchVect = match.get(key);
        if (matchVect == null) {
            matchVect = new Vector<String>();
            match.put(key, matchVect);
        }
        matchVect.add(sample);
    }

    System.out.printf("[");
    for(String key : match.keySet()) {
        System.out.print("[");
        Vector<String> matchVal = match.get(key);
        for(String val : matchVal) {
            System.out.printf("%s ", val);
        }
        System.out.print("]");
    }
    System.out.printf("]\n");
}


/*
 Finding anagram from a file  ie:  permutations of the same letters (including itself)

 - Go word by word in paragraph,
 - first check if word has same length as given String and if successful then check if word is in hashset or not.
   If present then print it.

public String findAnagram(String string, String paragraph){
         ///////// invalid forms checking ie: null or string.length &gt; paragraph.legth //////////////

         HastMap stringCharCounter = counterCharacter(string);
         String[] array = paragraph.split(" "); // assuming that the paragraph consist of English characters only
                                                // also assuming that there is only one white space character in between two words.
                                                // otherwise cleaning up function may required

         for(String s : array){
                 HashMap tmpMap = countCharacter(s);
                 if(compareHashMap(stringCharCounter,tmpMap)){
                        return s;
                 }
         }
         return null;
}

private HashMap countCharacter(String s){
        ////// invalid forms checking /////

    HashMap map = new HashMap();
        for(char c : s.toCharArray()){
              Integer val;
              if((val = map.get(c)) != null){
                  map.put(c, val + 1);
              } else {
                  map.put(c, 0);
              }
        }

       return map;
}

private boolean compareHashMap(HashMap mapOne, HashMap mapTwo) {
   ////// invalid forms checking /////

   if(mapOne.size() != mapTwo.size()){
        return false;
   }

   // we only need to check one time b/c we know that the maps are in the same size
   // Therefore , if there is a key that is not in both map the comparison will return false;
   for( Entryc : mapOne.entrySet()){
         int valOne = c.getValue().intValue();
         int valTwo = mapTwo.get( c.charValue() ).intValue();

         if( valOne != valTwo ){
               return false;
         }
   }

  return true;
}
*/

}
