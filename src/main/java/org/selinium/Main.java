package org.selinium;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Main {

    //Find the palandrom number and rever the string with no withespace
    public static void main(String[] args) {
        String name = "nitin";
        String replaceName = name.replaceAll("\\s","");
        System.out.println(replaceName);
        StringBuilder str = new StringBuilder(replaceName);
        String actualName = str.reverse().toString();
        if(name.equals(actualName)) {
            System.out.println("The actual name is palandrom: " + actualName);
        }else{
            System.out.println("The actual name is not palandrom");
        }
    }

    //Remove char from the string
    @Test
    public void removeTheCharFromString(){
        String name = "123trim123@#trimSame233122";
        String nameChar = name.replaceAll("\\d","");
        System.out.println("The String remove is: "+nameChar);
    }



   // Find dupliacte character from the array
   // @Test
    public void same() {
        int[] arr = new int[]{1,2,2,3,4,4,5,6,6,7,7,8,9};
        System.out.println("The array is: "+ Arrays.toString(arr));
        for(int i=0; i<arr.length; i++){
            for (int j = i+1;j<arr.length;j++){
                if (arr[i] == arr[j]) {
                    System.out.println("the duplicate array is of : "+arr[j]);
                }
            }
        }
    }



    @Test
    public void mostAndLeastFrequentCharacter() {
        String input = "aabcccde";
        Map<Character, Integer> map = new HashMap<>();

        for (char c : input.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char maxChar = ' ', minChar = ' ';
        int max = 0, min = Integer.MAX_VALUE;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxChar = entry.getKey();
            }
            if (entry.getValue() < min) {
                min = entry.getValue();
                minChar = entry.getKey();
            }
        }
        System.out.println("Most frequent: " + maxChar + ", Least frequent: " + minChar);

    }


}