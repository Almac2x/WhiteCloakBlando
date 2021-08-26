import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class pleaseWork {


    public static void main(String[] args) {

        String nani = ".-.--.";

        var woreseCodeMap = createMorseCodeMap(nani);
        printMap(createMorseCodeMap("src//WorseCode.txt"));
        System.out.println("Starting");
        //Break(nani,woreseCodeMap);
    }

    public static void Break(String breakdown, HashMap<String,String> map){

        System.out.println("nani");

        String cutRightToLeft = breakdown;
        String cutLeftToRight = breakdown;
        int i = 0;

        if(breakdown.length() > 4){
            String toRecur = breakdown.substring(4);
            System.out.println("nani");
            Break(toRecur,map);
        }else if(breakdown.length()<=0){
            System.out.println("stop");
        }

        do {

            if(cutLeftToRight.length() == 0  || cutLeftToRight.length()== 0  ){

                break;

            }else{
                System.out.println(map.get(cutLeftToRight));
                System.out.println(map.get(cutRightToLeft));

                //  possibleCombinationsMap.put(cutRightToLeft,Integer.toString(++i));
                //possibleCombinationsMap.put(cutLeftToRight,Integer.toString(++i));

                cutRightToLeft = cutRightToLeft.substring(0,cutRightToLeft.length()-1);
                cutLeftToRight = cutLeftToRight.substring(1);

            }


        } while(true);
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

    public static void printMap(HashMap<String,String> map){

        for (String name: map.keySet()) {
            String key = name;
            String value = map.get(name).toString();
            System.out.println(key + " " + value);
        }
    }
}
