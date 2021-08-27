import java.util.Locale;
import java.util.Scanner;

public class PalindromeRecursion {

    public static void main(String[] args) {

        String string = "dad";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a String to check if its Palindrome: ");
        string = scanner.next().toLowerCase();

        boolean isPalindrome = drome(string, string.length());

        if(isPalindrome == true){
            System.out.println(string + " is a Palindrome");
        }
        else
            System.out.println(string + " is not a Palindrome");

    }
    public static boolean drome(String word,int len){

        if(len <= 1){
            return true;
        }
        else if (word.charAt(0) == word.charAt(word.length()-1)){
                                       //sends the substring of the string and then returns the lenght of the new substring
            return drome(word.substring(1,word.length()-1),len-2);
        }
        return false;

    }
}
