package com.permutations;

import java.util.HashSet;
import java.util.Set;

public class Permutations {
    //Defined  a set to store distinct permutations and a getter to access it
    private Set<String> permutations = new HashSet<>();
    private Set<String> getPermutations() {
        return this.permutations;
    }


    //calculatePermutations method accepts a String input and returns all distinct permutations as Set
    public  Set<String> calculatePermutations(String input){
        //if the input string is an empty character or a null data, an error message is displayed as below
        if (input==null || input.equals("")){
            throw new IllegalArgumentException("Input cannot be null or empty. Please try again with a valid String");
        }
        //send input string and length to permute method which will be processed recursively
        permute(input,0,input.length()-1);
        printPermutations(getPermutations());
        return getPermutations();
    }
    //prints all distinct permutations of input string
    private void printPermutations(Set<String> permutationSet){
        int i =1;
        for (String p:permutationSet) {
            System.out.println("Permutation number " + i + " is "+p);
            i++;
        }
    }
    //swapping characters
    private String swap(String input, int i, int j){
        char[]temp = input.toCharArray();
        char tempChar = temp[i];
        temp[i] = temp[j];
        temp[j] = tempChar;
        return String.valueOf(temp);
    }

    /* @param input string to derive permutations
     * @param left starting index
     * @param right end index
     * This method finds all permutations of the string recursively*/
    private void permute(String input, int left, int right) {
        if (left == right) {
            //If the pointers match, we record the input within set
            getPermutations().add(input);
        } else {
            //Definition
            for (int i = left; i<=right; i++ ) {
                input = swap(input, left, i); //swap characters of left index and i index in input string
                permute(input, left + 1, right);//recursively call the method till left and right index are same
                input = swap(input, left, i);// revert back to input's original state
            }
        }
    }
}
