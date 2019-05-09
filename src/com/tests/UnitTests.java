package com.tests;

import com.permutations.Permutations;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Set;

public class UnitTests {
    private static final String nullTestData = null;
    private static final String emptyChar = "";
    private static final String upper = "AABCD";
    private static final String upperAndLower = "AabbC";
    private static final String lower = "aabcd";
    private static final String duplicate = "AAAAbb";
    private static final String specialChars = "%$ /*&@?";
    private static final String singleChar = "z";
    private static final String longString = "AABBCCDDEE";
    private Permutations permutations;

    /*Assumptions
    - There is no partial permutation requirement
    - User can call main method to enter desired string through screen scanner
     or call Permutations.calculatePermutations() method directly to send the input
    - Long strings can be entered but due to system memory constraint, it creates heavy load so not suggested
    - Special characters, space, empty string and null can be passed as input
    - Inputs are case-sensitive
    * */
    @Before
    public void preparePermutationInstance(){
         permutations = new Permutations();
    }


    //Verify that if input string is null, IllegalArgumentException is thrown.
    @Test(expected = IllegalArgumentException.class)
    public void verifyExceptionForNullData(){
        Assert.assertNotNull("Result is null",permutations.calculatePermutations(nullTestData));
    }

    //Verify that if input string is empty, IllegalArgumentException is thrown.
    @Test(expected = IllegalArgumentException.class)
    public void verifyExceptionForEmptyData(){
        Assert.assertNotNull("Result is empty",permutations.calculatePermutations(emptyChar));
    }

    //Verify that when input has uppercase characters, actual number of permutations are successfully calculated
    //and matched with expected number of permutations
    @Test
    public void verifyUpperChars(){
        Set<String> resultSet = permutations.calculatePermutations(upper);
        Assert.assertEquals("Total number of permutations is incorrect",resultSet.size(),calculateNoOfPermutations(upper));
    }

    //Verify that when input has uppercase and lowercase characters, actual number of permutations are successfully calculated
    //and matched with expected number of permutations
    @Test
    public void verifyUpperAndLowerChars(){
        Set<String> resultSet = permutations.calculatePermutations(upperAndLower);
        Assert.assertEquals("Total number of permutations is incorrect",resultSet.size(),calculateNoOfPermutations(upperAndLower));
    }

    //Verify that when input has lowercase characters, actual number of permutations are successfully calculated
    //and matched with expected number of permutations
    @Test
    public void verifyLowerChars(){
        Set<String> resultSet = permutations.calculatePermutations(lower);
        Assert.assertEquals("Total number of permutations is incorrect",resultSet.size(),calculateNoOfPermutations(lower));
    }

    //Verify that when input has duplicate characters, actual number of distinct permutations are successfully calculated
    //and matched with expected number of distinct permutations
    @Test
    public void verifyDuplicateChars(){
        Set<String> resultSet = permutations.calculatePermutations(duplicate);
        Assert.assertEquals("Total number of permutations is incorrect",resultSet.size(),calculateNoOfPermutations(duplicate));
    }

    //Verify that when input has special characters, actual number of permutations are successfully calculated
    //and matched with expected number of permutations
    @Test
    public void verifySpecialChars(){
        Set<String> resultSet = permutations.calculatePermutations(specialChars);
        Assert.assertEquals("Total number of permutations is incorrect",resultSet.size(),calculateNoOfPermutations(specialChars));
    }

    //Verify that if input has single character, actual one permutation should be calculated successfully
    // and matched with expected count
    @Test
    public void verifySingleChar(){
        Set<String> resultSet = permutations.calculatePermutations(singleChar);
        Assert.assertEquals("Total number of permutations is incorrect",resultSet.size(),calculateNoOfPermutations(singleChar));
    }

    //Verify that if input has long String value actual permutations should be calculated successfully
    //and matched with expected permutations
    @Test
    public void verifyLongString(){
        Set<String> resultSet = permutations.calculatePermutations(longString);
        Assert.assertEquals("Total number of permutations is incorrect",resultSet.size(),calculateNoOfPermutations(longString));
    }

    //Method to calculate expected number of permutations
    private long calculateNoOfPermutations(String input){
        char[] strArray = input.toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (char c : strArray) {
            if(charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c)+1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        //Calculating permutations of each characters and multiplying them
        long x=1;
        for (int value:charCountMap.values())
        {
            x=factorial(value)*x;
        }
        long numberOfPermutations = factorial(strArray.length)/x;
        return numberOfPermutations;
    }

    //Method to calculate factorial
    private long factorial (int input) {
        long fact = 1;
        for (int i = 1; i <= input; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
