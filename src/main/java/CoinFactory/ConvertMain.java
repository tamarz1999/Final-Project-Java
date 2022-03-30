package CoinFactory;

import CoinTypes.Coins;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConvertMain {
    public static void main(String[] args) throws IOException {

        boolean isBodyCorrect = true;
        boolean isUserChoice = true;
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> resultsHistory = new ArrayList<Double>();

        //Welcome Screen
        System.out.println("Welcome to currency converter");
        while (isBodyCorrect) {
            System.out.println("Please choose an option (1/2):");
            System.out.println("1. Dollars to Shekels");
            System.out.println("2. Shekels to Dollars");

            try {
               int choice = scanner.nextInt();

                //Convert Dollars to Shekels
                if (choice == 1) {
                    //Input amount screen
                    System.out.println("Please enter an amount to convert");
                    double input = scanner.nextDouble();
                    Coin usdValue = CoinFactory.getCoinInstance(Coins.ILS);
                    double value = usdValue.calculate(input);
                    //Result screen
                    System.out.println("The converted amount is: " + value + " Shekels");
                    resultsHistory.add(value);

                 //Convert Shekels to Dollars
                } else if (choice == 2) {
                    //Input amount screen
                    System.out.println("Please enter an amount to convert");
                    double input = scanner.nextDouble();
                    Coin ilsValue = CoinFactory.getCoinInstance(Coins.USD);
                    double value = ilsValue.calculate(input);
                    //Result screen
                    System.out.println("The converted amount is: " + value + " Dollars");
                    resultsHistory.add(value);
                }
                //Handling invalid int input
                else {
                    System.out.println("Invalid choice - please enter 1/2 only");
                }

            //Handling invalid input
            } catch (InputMismatchException e) {
                e.printStackTrace();
                System.out.println("Invalid input - please enter int value only");
            }

            while (isUserChoice) {
                //Start over or exit the program
                System.out.println("Would you like to start over? Y/N");
                Scanner scanner1 = new Scanner(System.in);
                String userChoice = scanner1.nextLine();

                //Handling invalid string input
                if (!userChoice.equalsIgnoreCase("Y") && !userChoice.equalsIgnoreCase("N")) {
                    System.out.println("Invalid choice - please enter Y/N only");
                }

                if (userChoice.equalsIgnoreCase("Y")) {
                    isBodyCorrect = true;
                    break;
                } else if (userChoice.equalsIgnoreCase("N")) {
                    isBodyCorrect = false;
                    isUserChoice = false;
                    System.out.println("Thanks for using our currency converter");
                    System.out.println("Your history is: " + resultsHistory);
                    //Exporting results to txt file
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    FileWriter historyFile = new FileWriter(dateFormat.format(date) + " historyFile.txt");
                    for (double arrayList : resultsHistory) {
                        historyFile.write(arrayList + System.lineSeparator());
                    }
                    historyFile.close();
                    break;
                }
            }

        }

    }
}