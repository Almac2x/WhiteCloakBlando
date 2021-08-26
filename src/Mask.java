import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Locale;
import java.util.Scanner;

public class Mask {

    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input C or V = ");

        String choice = scanner.nextLine().toLowerCase();

        File file = new File("src//paragraph.txt");

        BufferedReader buffReader= new BufferedReader( new FileReader(file));

        String paragraph = buffReader.readLine();

        switch (choice){

            case "c" :

                System.out.println(removeConsonants(paragraph));

                break;
            case "v" :
                System.out.println(removesVowels(paragraph));
        }
    }

    public static String removesVowels(String paragraph){
        return paragraph.replaceAll("[aeiou]\\GI","");
    }
    public static String removeConsonants(String paragraph){

        return paragraph.replaceAll("[^aeiouAEIOU\\d\\W]","");
    }

}
