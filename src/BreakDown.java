import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BreakDown {


    public static void main(String[] args) {

        String decipher = ".-.--";

        String fileContent =  readFile("src//WorseCode.txt");
        var woreseCodeMap = createMorseCodeMap(fileContent);

        Break(decipher,woreseCodeMap);
    }

    public static String Break(String breakdown, HashMap<String,String> map){

        String cutRightToLeft = breakdown;
        String cutLeftToRight = breakdown;
        int i = 0;

        if(breakdown.length() > 4){
            String toRecur = breakdown.substring(4);
            String toRecur2 = breakdown.substring(0,4);
            Break(toRecur2,map);
            Break(toRecur,map);
        }else if(breakdown.length()<=0){
            System.out.println("stop");
        }

       /* do {

            if(cutLeftToRight.length() == 0  || cutLeftToRight.length()== 0  ){

                break;

            }else{
                System.out.println(map.get(cutLeftToRight));
                System.out.println(map.get(cutRightToLeft));

                //  possibleCombinationsMap.put(cutRightToLeft,Integer.toString(++i));
                //possibleCombinationsMap.put(cutLeftToRight,Integer.toString(++i));

                cutRightToLeft = cutRightToLeft.substring(0,cutRightToLeft.length()-1);
                cutLeftToRight = cutLeftToRight.substring(1);

                System.out.println(cutLeftToRight + cutRightToLeft);

            }


        } while(true);*/

        return "nani";
    }

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

    public static void printMap(HashMap<String,String> map){

        for (String name: map.keySet()) {
            String key = name;
            String value = map.get(name).toString();
            System.out.println(key + " " + value);
        }
    }
}
