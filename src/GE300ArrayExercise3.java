import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class GE300ArrayExercise3 {


    public static void main(String[] args) {

        boolean retake = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Array: ");

        //0,1,2;3,4,5

        //String arrayInput = "0,1,2;"+ "3,4,5";

        String arrayInput = scanner.nextLine(); // Gets the array from user
        /*String arrayInput =     "0,1,2,3;" +
                                "4,5,6,7;" +
                                "8,9,0,0";*/
        var numberArray = getNumberArray(arrayInput);

        System.out.println();
        printArray(numberArray);

        do {
            System.out.print("\nR - ROTATE" +
                             " F - FLIP" +
                             " T - REVERSE: ")   ;
            String choice = scanner.nextLine();
            switch (choice.toUpperCase()) {// to lowercase

                case "R":
                     numberArray = rotateArray(numberArray);
                    printArray(numberArray);
                    break;

                case "F":
                    numberArray = flipArray(numberArray);
                    printArray(numberArray);
                    break;

                case "T":
                    numberArray = reverseArray(numberArray);
                    printArray(numberArray);
                    break;

                default:{
                    scanner.close();
                    System.out.println("Wrong input sir!");
                    retake=false;
                }
            }


        }while(retake == true);
    }
    public static void printArray(int[][] arrayNumbers){
        System.out.println("Your Array: ");
       for(int x[] : arrayNumbers){

           for(int y: x){
               System.out.print(y+ " ");
           }
           System.out.println("");
       }
    }
    public static int[][] flipArray(int[][] arrayNumbers){

        int row = arrayNumbers.length;
        int column = arrayNumbers[0].length;
        int[][] newArrayNumbers = new int[row][column];

        for(int i = 0 ; i < row; i++){
            newArrayNumbers[i] = arrayNumbers[row-i-1];
        }

        return newArrayNumbers;
    }
    public static int[][] reverseArray(int[][] arrayNumbers){

        int row = arrayNumbers.length;
        int column = arrayNumbers[0].length;
        int[][] newArrayNumbers = new int[row][column];

        for(int i = 0 ; i < row; i++){
            for (int j = 0; j < column; j++){
                newArrayNumbers [i][j] = arrayNumbers[i][column - j -1 ];
            }
        }
        return newArrayNumbers ;
    }

    public static int[][] rotateArray(int[][] arrayNumbers){

        int row = arrayNumbers.length;
        int column = arrayNumbers[0].length;
        int[][] newArrayNumbers = new int[column][row];
        for(int i = 0 ; i < column; i++){

            for(int j = 0; j< row; j ++){
              newArrayNumbers[i][j] = arrayNumbers[j][i];

            }
        }
        return reverseArray(newArrayNumbers);
    }// need to flip pa

    public static int[][] getNumberArray(String arrayInput) {

        String[] row = arrayInput.split("[;]");
        int[][] numberArray = new int[row.length][];

        // arrayInput.spl

        for (int i = 0; i < row.length; i++) {

            String[] column = row[i].split("[,]");
            int[] tempColumn = new int[column.length];

            for (int j = 0; j < column.length; j++) {
                tempColumn[j] = Integer.parseInt(column[j]);
            }
            numberArray[i] = tempColumn;
        }
        return numberArray;
    }


}
