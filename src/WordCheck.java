/**
 * Java program to count the number of valid words in a given string, using local dictionary.
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class WordCheck {

    public static boolean real_word(String word) throws FileNotFoundException {
        try {
            BufferedReader dictionary = new BufferedReader(new FileReader(
                    "/usr/share/dict/web2")); //For Mac OS
            String dictionaryString;
            while ((dictionaryString = dictionary.readLine()) != null) {
                if (dictionaryString.contains(word)) {
                    return true;
                }
            }
            dictionary.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main (String [] args) throws FileNotFoundException {

        Scanner userInput = new Scanner(System.in);
        String inputString;
        int count = 0;

        System.out.println("Enter the string you would like to examine:");
        inputString = userInput.nextLine();

        //Split input on spaces and special characters.
        String [] stringArray = inputString.split("[\\s@&.?$+-]+");

        for (String a: stringArray) {
            if (real_word(a)) {
                count ++;
                System.out.println(a);
            }
        }

        System.out.printf("There are %d valid words in the input string.", count);
    }
}
