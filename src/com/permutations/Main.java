package com.permutations;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Any input can be entered and scanned as an input String
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a string below to calculate permutations; ");
        String input = in.nextLine();
        //Call calculatePermutations method of Permutations class with scanned input String
        Permutations permutation = new Permutations();
        permutation.calculatePermutations(input);
    }
}