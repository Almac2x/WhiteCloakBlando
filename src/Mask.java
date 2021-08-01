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

        File file = new File("D:\\Documents\\WhiteCloakBlando\\src\\paragraph.txt");

        BufferedReader buffReader= new BufferedReader( new FileReader(file));

        String paragraph = buffReader.readLine();

        switch (choice){

            case "c" :

                removeConsonants(paragraph.toLowerCase());

                break;
            case "v" :
                removesVowels(paragraph.toLowerCase());
        }

    }

    public static void removesVowels(String paragraph){

        paragraph = paragraph.replace("a","");
        paragraph = paragraph.replace("e","");
        paragraph = paragraph.replace("i","");
        paragraph = paragraph.replace("o","");
        paragraph = paragraph.replace("u","");

        System.out.println(paragraph);
    }
    public static void removeConsonants(String paragraph){

        paragraph = paragraph.replace("b","");
        paragraph = paragraph.replace("c","");
        paragraph = paragraph.replace("d","");
        paragraph = paragraph.replace("f","");
        paragraph = paragraph.replace("g","");
        paragraph = paragraph.replace("j","");
        paragraph = paragraph.replace("k","");
        paragraph = paragraph.replace("l","");
        paragraph = paragraph.replace("m","");
        paragraph = paragraph.replace("n","");
        paragraph = paragraph.replace("p","");
        paragraph = paragraph.replace("q","");
        paragraph = paragraph.replace("s","");
        paragraph = paragraph.replace("t","");
        paragraph = paragraph.replace("v","");
        paragraph = paragraph.replace("x","");
        paragraph = paragraph.replace("z","");
        paragraph = paragraph.replace("h","");
        paragraph = paragraph.replace("r","");
        paragraph = paragraph.replace("w","");
        paragraph = paragraph.replace("y","");

        System.out.println(paragraph);


    }

}
