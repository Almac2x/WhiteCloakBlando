import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorseCode {
    public static void main(String[] args)  {

        String fileContent =  readFile("src//WorseCode.txt");

        String decipher = ".-..";
        //permutation(decipher);

        possibleCombinations(decipher);



    }

    public static String readFile (String filePath) {

        String data = "";
        try {
            data = "";
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data = data + scanner.nextLine();

            } scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

    public static void possibleCombinations(String toDecipher) {

        var possibleCombinationsMap = new HashMap<String, String>();

        String cutRightToLeft = toDecipher;
        String cutLeftToRight = toDecipher;

        if(cutLeftToRight.length()>4){

        }
        int i = 0;

        do {

            if(cutLeftToRight.length()== 0  || cutLeftToRight.length()== 0  ){
                break;

            }else{
                possibleCombinationsMap.put(cutRightToLeft,Integer.toString(++i));
                possibleCombinationsMap.put(cutLeftToRight,Integer.toString(++i));

                cutRightToLeft = cutRightToLeft.substring(0,cutRightToLeft.length()-1);
                cutLeftToRight = cutLeftToRight.substring(1);

            }


        } while(true);

        printMap(possibleCombinationsMap);

    }

    public static void breakDownToLeft(){

    }
    public static void breakDownToRight(){

    }

    public static void possibleCombinations (String toDecipher, HashMap<String,String> map){}

    public static HashMap<String, String>  createMorseCodeMap(String string){ // I can turn this to recursion

        var map = new HashMap<String,String>();
        string = string.replaceAll("[\\s]", ""); // removes unecessary Whitespace

        String rx = "[a-zA-Z]";
        Pattern p = Pattern.compile(rx);
        Matcher matcher;

        while(string.length() != 0){

             matcher = p.matcher(string);

            if (matcher.find()){

                String key= string.substring(0,matcher.start());
                map.put(key,matcher.group());
                string = string.replaceFirst(string.substring(0,matcher.start()+1),"");
            }
        }
        return map;
    }

    public static void printMap(HashMap<String,String> map){

        for (String name: map.keySet()) {
            String key = name;
            String value = map.get(name).toString();
            System.out.println(key + " " + value);
        }
    }
}
