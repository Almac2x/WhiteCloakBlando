import java.io.PipedOutputStream;
import java.util.ArrayList;

public class    Partnerships {

    public static void main(String[] args) {

        String[] names = {"Anne","Jane", "Michael","Paul","Harold","Kate","Edric","Fred","Josh","Shane"};

        ArrayList<String> possiblePartnerships = new ArrayList<>();

        for(int i = 0; i < names.length-1; i++ ){

           for(int k = 0; k < names.length; k++){

               if(i == k ){

               }
               else {

                   if(isAlready(names[i], names[k], possiblePartnerships)){
                       possiblePartnerships.add(names[i] +", " + names[k]);
                   }

                   }
               }

           }

        for (String nani : possiblePartnerships){

            System.out.println(nani);
        }

        System.out.println(possiblePartnerships.size() + " partnetships");

    }

    public static boolean isAlready(String firstNanme, String secondName, ArrayList<String> list){

        for (String nani : list){

            String combine = firstNanme +", "+ secondName;
            String reverseCombine = secondName+", " +firstNanme;

            if(combine.equals(nani) || reverseCombine.equals(nani)){
                return false;
            }
        }

        return  true;
    }


}
