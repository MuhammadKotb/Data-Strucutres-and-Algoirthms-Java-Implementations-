


import java.util.Arrays;

import java.util.Scanner;

public class Main {

    public static String getUserRequest(Scanner input){
        String[] validInput = {"1","2","3","4","5","6","7"};

        System.out.print("Which operation you want to perform from the following operation:\n" +
                "                           (1) Load Dictionary.\n" +
                "                           (2) Print Dictionary Size.\n" +
                "                           (3) Insert Word.\n" +
                "                           (4) Look-up a Word.\n" +
                "                           (5) Remove Word.\n" +
                "                           (6) Clear Dictionary.\n"+
                "                           (7) Dictionary Is Empty?\n"+
                "                           (8) Batch Look-ups.\n" +
                "                           (9) Batch Deletions.\n" +
                "Enter the number of the operation(ex: 3): ");
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
                    case "1":
                        System.out.print("Enter the path of the dictionary: ");
                        dictionary.load(input.nextLine().strip());
                        break;
                    case "2":
                        dictionary.printSize();
                        break;
                    case "3":
                        System.out.print("Enter the word: ");
                        dictionary.insert(input.nextLine().toLowerCase());
                        break;
                    case "4":
                        System.out.print("Enter the word: ");
                        dictionary.lookUp(input.nextLine().toLowerCase());
                        break;
                    case "5":
                        System.out.print("Enter the word: ");
                        dictionary.delete(input.nextLine().toLowerCase());
                        break;
                    case "6":
                        dictionary.clear();
                        break;
                    case "7":
                        dictionary.isEmpty();
                        break;
                    case "8":
                        System.out.print("Enter the path of the queries: ");
                        dictionary.batchLookUp(input.nextLine().strip());
                        break;
                    case "9":
                        System.out.print("Enter the path of the deletions: ");
                        dictionary.batchDeletions(input.nextLine().strip());
                        break;
                    default:
                        System.out.println("Invalid Input");
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