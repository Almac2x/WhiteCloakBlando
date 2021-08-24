import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class GE300EncryptExercise3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input Something to Encrypt: ");
        String toEncrypt = scanner.nextLine();  //"HellOg";// to encrypt

        String vowels = "a,e,i,o,u,a,e,i,o,u";// second set is for uppercase
        String alphabet = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z";

        var map = makeMapVowel(vowels);
        makeMapConsonant(getAlphabet(alphabet), map);

        toEncrypt = replace(toEncrypt, map);
        System.out.println(toEncrypt);

    }
    public static String[] getAlphabet(String string){

        return string.split("[,]");

    }
    public static void printMap(HashMap<String,String> map){

        for (String name: map.keySet()) {
            String key = name;
            String value = map.get(name).toString();
            System.out.println(key + " " + value);
        }
    }

    public static HashMap<String,String> makeMapVowel(String set){

        HashMap<String, String> map = new HashMap<>();
        String[] stringSetArray = set.split("[,]");

        int iterator = 0;

        for(String x : stringSetArray){

            if(iterator < 5){
                map.put(x.toUpperCase(),Integer.toString(iterator)); // for uppercase
            }else{
                map.put(x,Integer.toString(iterator));
            }
            iterator++;
        }
        return map;
    }
    public static void makeMapConsonant(String[] set,HashMap<String ,String> map){

        for(int i = set.length-1; i >= 0 ; i--){

            if(map.containsKey(set[i])){

            }else{
                if(i==1){
                    map.put(set[i], set[set.length-2]);
                }else if(i == 0){
                    map.put(set[i], set[set.length-3]);
                }else{
                    map.put(set[i], set[i-2]);
                    map.put(set[i].toUpperCase(), set[i-2].toUpperCase());
                }

            }
        }
    }

    public static String replace(String toEncrypt, HashMap<String,String> map){

        String toEncryptTemp = toEncrypt;

        for (String name: map.keySet()) {
            String key = name;
            String value = map.get(name);
            toEncryptTemp = toEncryptTemp.replaceAll("["+key+"]",value); // replaces all value within the map set
        }

       return toEncryptTemp;
    }
}
