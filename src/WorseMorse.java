import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WorseMorse {

    public static void main(String[] args)

    {
        String fileContent =  readFile("src//WorseCode.txt");
        var woreseCodeMap = createMorseCodeMap(fileContent);

        var possible = new HashMap<String,String>();
        // input string
        final String decipher = "----";

        int starting_index = 0;
         possible = breadDown(decipher, starting_index, "",woreseCodeMap,possible);

        System.out.println();
         printMap(possible);
         writeFile(possible);

    }

     public static HashMap breadDown(String toDecipher, int starting_index, String previousString, HashMap<String,String> map, HashMap<String,String> possible)
        {

            if(toDecipher.length() > 4){ // if String index is greater than 4

                if (starting_index == toDecipher.length()) {
                    System.out.println(previousString + "yes");
                    possible.put(previousString, Integer.toString(starting_index));
                }

                for (int j = toDecipher.length() - 1; j >= starting_index; j--)

                {
                    String subString =  map.get(toDecipher.substring(starting_index, j + 1));

                    breadDown(toDecipher.substring(0,4), j + 1, (previousString + subString),map,possible);
                }

            }

                if (starting_index == toDecipher.length()) {
                    System.out.println(previousString);
                    possible.put(previousString, Integer.toString(starting_index)); // Index is just a placeholder for value map
                }


                for (int j = toDecipher.length() - 1; j >= starting_index; j--)
                {
                   String subString =  map.get(toDecipher.substring(starting_index, j + 1));

                    breadDown(toDecipher, j + 1, (previousString + subString),map,possible);
                }

            return possible;
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

    public static void writeFile (HashMap<String,String> map){

        int i =0;
        try {
            FileWriter myWriter = new FileWriter("Possible.txt");

            for (String name: map.keySet()) {
                String key = name;
                if(i>4){
                    myWriter.write("\n");
                    i = 0;
                }
                myWriter.write(key + ", ");
                i++;
            }

            myWriter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public static HashMap<String, String> createMorseCodeMap(String string){ // I can turn this to recursion

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
            String value = map.get(name);
            System.out.println(key + " " + value);
        }
    }
}
