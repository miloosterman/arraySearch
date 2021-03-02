/*******************************************************************************************************************
 * CIS129_MiloOsterman_Ch9.java
 * Author: Milo Osterman
 * CIS 129 - Programming and Problem Solving I
 * Pima Community College
 ******************************************************************************************************************
 * This program has user populate an array with names.
 * The user can then search the array for a name and receive feedback if the name is in the array.
 ******************************************************************************************************************/

import java.util.*;

public class CIS129_MiloOsterman_Ch9 {

    //Constants for how many names you want user to input and sentinel value
    static int NAMES_ENTERED = 20;
    static String SENTINEL_VALUE = "quit";

    //Main
    public static void main(String[] args) {

        String[] namesArray = new String[NAMES_ENTERED];

        do {
            //Welcome message
            displayWelcome();
            //Populate the array
            getArrayValues(namesArray);
            //Sort the array
            listBubbleSort(namesArray);
            //Search the array
            nameSearch("Please enter the name you would like to search for. Enter 'quit' to exit.", namesArray);
            //Goodbye message
            displayGoodbye();
            //Do again loop
        } while (IR.getYorN("Would you like to use the program again? y/n"));

    }
    //Welcome
    public static void displayWelcome() {

        System.out.println("Greetings and welcome to the name program.");
        System.out.println("You will be entering " + NAMES_ENTERED + " names.");
        System.out.println("The program will display them in alphabetical order.");
        System.out.println("You will then be able to search the entered names.");

    }
    //Sort
    public static void listBubbleSort(String[] namesArray) {

        int arraySize = namesArray.length;

        for (int i = arraySize - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                String temp;

                if (namesArray[j].compareToIgnoreCase(namesArray[j + 1]) > 0) {

                    temp = namesArray[j];

                    namesArray[j] = namesArray[j + 1];

                    namesArray[j + 1] = temp;
                }
            }
        }

        for (int k = 0; k < namesArray.length; k++) {

            System.out.print(namesArray[k] + " ");

        }

        System.out.println(" ");
    }
    //Populate array
    public static void getArrayValues(String[] namesArray) {

        int arraySize = namesArray.length;

        for (int i = 0; i < arraySize; i++) {

            namesArray[i] = IR.getString("Enter name #" + (i + 1)).trim();

        }
    }
    //Search array
    public static void nameSearch(String msg, String[] namesArray) {

        String userInput;
        Boolean nameMatch;

        userInput = IR.getString(msg);

        while (!userInput.equalsIgnoreCase(SENTINEL_VALUE)) {

            nameMatch = findValue(userInput, namesArray);

            if (nameMatch) {

                System.out.println("That name was a match to the array.");

            } else {

                System.out.println("That name was not in the array.");
            }

            userInput = IR.getString(msg);

        }
    }
    //Test user's input to array contents
    public static boolean findValue(String input, String[] array) {

        int arraySize = array.length;

        for (int i = 0; i < arraySize; i++) {

            if (input.equalsIgnoreCase(array[i])) {

                return true;

            }
        }

        return false;

    }
    //Goodbye message
    public static void displayGoodbye() {

        System.out.println("Thanks for using the name search program!");

    }
}