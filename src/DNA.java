import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class DNA {
    public static void main(String[] args) {

        Scanner scanner = new Scanner((System.in));

        StringBuilder stringBuilder = new StringBuilder();

        HashMap<String, String> conversionMaps = new HashMap<String, String>();

         stringBuilder.append("'TTT': 'F', 'TTC': 'F', 'TTA': 'L', 'TTG': 'L', 'TCT': 'S', 'TCC': 'S', 'TCA': 'S', 'TCG': 'S'") ;
         stringBuilder.append("'TAT': 'Y', 'TAC': 'Y', 'TGT': 'C', 'TGC': 'C', 'TGG': 'W', 'CTT': 'L', 'CTC': 'L', 'CTA': 'L'") ;
         stringBuilder.append("'CAG': 'Q', 'CGT': 'R', 'CGC': 'R', 'CGA': 'R', 'CGG': 'R', 'ATT': 'I', 'ATC': 'I', 'ATA': 'I'") ;
         stringBuilder.append("'CTG': 'L', 'CCT': 'P', 'CCC': 'P', 'CCA': 'P', 'CCG': 'P', 'CAT': 'H', 'CAC': 'H', 'CAA': 'Q'") ;
         stringBuilder.append("'ATG': 'M', 'ACT': 'T', 'ACC': 'T', 'ACA': 'T', 'ACG': 'T', 'AAT': 'N', 'AAC': 'N', 'AAA': 'K'") ;
         stringBuilder.append("'AAG': 'K', 'AGT': 'S', 'AGC': 'S', 'AGA': 'R', 'AGG': 'R', 'GTT': 'V', 'GTC': 'V', 'GTA': 'V'") ;
         stringBuilder.append("'GTG': 'V', 'GCT': 'A', 'GCC': 'A', 'GCA': 'A', 'GCG': 'A', 'GAT': 'D', 'GAC': 'D'") ;
         stringBuilder.append("'GAA': 'E', 'GAG': 'E', 'GGT': 'G', 'GGC': 'G', 'GGA': 'G', 'GGG': 'G'");

         readMapping(stringBuilder,conversionMaps);
         //printMap(conversionMaps);

        System.out.print("Input Condon: ");
        String codons = scanner.nextLine().toUpperCase().replaceAll("\s","");

        System.out.println(getProtein(codons,conversionMaps));

        ///System.out.println(stringBuilder.toString());

    }

    public static void readMapping(StringBuilder list, HashMap<String,String> map){

        StringBuilder stringBuilder = new StringBuilder(list.toString().replaceAll("[^a-zA-Z]",""));

        for(int i = 0; stringBuilder.length()!=0 ;i++){
            String key = stringBuilder.substring(0,3);
            String value =stringBuilder.substring(3,4);
            map.put(key,value);

            //deletes after input
             String deleteSubstring = stringBuilder.delete(0,4).toString();

            // System.out.println();
        }
    }

    public static void printMap(HashMap<String,String> map){

        for (String nani: map.keySet()){
            String key = nani.toString();
            String value = map.get(key).toString();
            System.out.println(key + " " + value);

        }
    }

    public static String getProtein(String codons,HashMap<String,String> map){
        String protein ="";

        StringBuilder stringBuilder = new StringBuilder(codons);

        while(stringBuilder.length()!=0){
            if(stringBuilder.length() <= 2){
                protein += "*";
                break;
            }
            String key = stringBuilder.substring(0,3);
            stringBuilder.delete(0,3);

            if(key.length() == 3)
            protein += map.get(key);
        }

        return protein;
    }
}
