/***************************************************************
 * Developer:       Allison Crenshaw
 * Program #:       4
 * Chapter:         Chapter 16
 * Subject:         Letter Counter
 * File Name:       LetterCounter.java
 *                  LetterCounterDriver.java
 * Course:          ITSE 2317 - Intermediate Java
 * Due Date:        03/06/2020
 * Instructor:      Fred Kumi
 * Description:     Program accepts a string sentence,
 *                  counts the number of occurrences of
 *                  each letter in the sentence, ignores
 *                  spaces and punctuations, and then
 *                  outputs a table of each letter and the
 *                  count of occurrences for that letter.
 ****************************************************************/

// import statements
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class LetterCount {

    //***************************************************************
    //  Method:       developerInfo
    //  Description:  The developer information method of the program
    //  Parameters:   none
    //  Returns:      n/a
    //**************************************************************
    public static void developerInfo() {
        System.out.println("");
        System.out.println("*************************************************");
        System.out.println ("Name:    Allison Crenshaw");
        System.out.println ("Course:  ITSE 2317 Intermediate Java Programming");
        System.out.println ("Program: Four");
        System.out.println("*************************************************");
    } // End of developerInfo

    //***************************************************************
    //  Method:       mainMenu
    //  Description:  prompts user for input, removes spaces and
    //                  punctuation from the string, creates an
    //                  ArrayList of the characters, then calls
    //                  other methods to create and print the map
    //  Parameters:   none
    //  Returns:      n/a
    //***************************************************************
    public void mainMenu() {
        // method member variables
        String sentence; // will hold user input
        char[] charArray;
        ArrayList<Character> finalSentence = new ArrayList();
        Map<Character, Integer> letterMap; // HashMap of each letter in given sentence

        // welcome message
        System.out.println("Welcome! This program accepts a sentence as input and ");
        System.out.println("outputs a table of how many times each letter in the sentence occurs.");

        // create scanner object
        Scanner scanner = new Scanner(System.in);

        // prompt user for input
        System.out.print("Enter your sentence: ");
        sentence = scanner.nextLine();

        // change sentence to lowercase, remove punctuation & spaces
        sentence = sentence.toLowerCase();
        sentence = sentence.replaceAll("\\p{Punct}", "");
        charArray = sentence.toCharArray();
        for (char c : charArray) {
            if (c != ' ')
                finalSentence.add(c);
        } // end for loop

        // count letters in the array
        letterMap = createLetterCount(finalSentence);
        // print the results from the count
        printMap(letterMap);

    } // end method mainMenu()

    //***************************************************************
    //  Method:       createLetterCount()
    //  Description:  creates a HashMap from the passed array list,
    //                  key = character, value = # of occurrences
    //                  of that character
    //  Parameters:   ArrayList finalSentence
    //  Returns:      Map (HashMap) letterMap
    //***************************************************************
    public Map<Character, Integer> createLetterCount(ArrayList finalSentence) {
        // method member variables
        String letter;
        int count;
        Map<Character, Integer> letterMap = new HashMap<>();

        // create HashMap of letter counts
        for (Object c : finalSentence) {
            Character currentChar = (Character) c;
            letterMap.putIfAbsent(currentChar, 0);
            letterMap.replace(currentChar, letterMap.get(currentChar) + 1);
        } // end for loop

        return letterMap;

    } // end createLetterCount()

    //***************************************************************
    //  Method:       printMap()
    //  Description:  prints contents of the map in a table
    //  Parameters:   none
    //  Returns:      n/a
    //***************************************************************

    public void printMap(Map<Character, Integer> map) {
        System.out.println();
        System.out.println("Letter\tNumber");
        for (Character character : map.keySet()) {
            System.out.println(character + "\t\t" + map.get(character));
        } // end for loop

    } // end printMap

} // end class LetterCount
