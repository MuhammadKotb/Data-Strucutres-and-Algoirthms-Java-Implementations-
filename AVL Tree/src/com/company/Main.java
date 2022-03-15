package com.company;



import java.util.Arrays;

import java.util.Scanner;

public class Main {

    public static String getUserRequest(Scanner input){
        String[] validInput = {"1","2","3","4","5","6","7"};

        System.out.print("""
                Which operation you want to perform from the following operation:
                                           (1) Load Dictionary.
                                           (2) Print Dictionary Size.
                                           (3) Insert Word.
                                           (4) Look-up a Word.
                                           (5) Remove Word.
                                           (6) Batch Look-ups.
                                           (7) Batch Deletions.
                Enter the number of the operation(ex: 3):\s""");
        String userRequest = input.nextLine().strip();
        if(!Arrays.stream(validInput).anyMatch(userRequest::equals)){
            System.out.println("Invalid Input");
            return getUserRequest(input);
        }else {
            return userRequest;
        }
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Dictionary dictionary = new Dictionary();

        while (true){
            String userRequest = getUserRequest(input);
            try {
                switch (userRequest) {
                    case "1" -> {
                        System.out.print("Enter the path of the dictionary: ");
                        dictionary.load(input.nextLine().strip());
                    }
                    case "2" -> dictionary.printSize();
                    case "3" -> {
                        System.out.print("Enter the word: ");
                        dictionary.insert(input.nextLine().toLowerCase());
                    }
                    case "4" -> {
                        System.out.print("Enter the word: ");
                        dictionary.lookUp(input.nextLine().toLowerCase());
                    }
                    case "5" -> {
                        System.out.print("Enter the word: ");
                        dictionary.delete(input.nextLine().toLowerCase());
                    }
                    case "6" -> {
                        System.out.print("Enter the path of the queries: ");
                        dictionary.batchLookUp(input.nextLine().strip());
                    }
                    case "7" -> {
                        System.out.print("Enter the path of the deletions: ");
                        dictionary.batchDeletions(input.nextLine().strip());
                    }
                    default -> System.out.println("Invalid Input");
                }
            }catch( Exception e ){
                System.out.println("Invalid Input");
            }
            System.out.print("Do you want to exit?(y/n): ");
            if(input.nextLine().strip().equalsIgnoreCase("y")){
                break;

            }

        }
    }
}
