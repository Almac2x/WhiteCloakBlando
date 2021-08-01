public class Loop {

    public static void main(String[] args) {

        String template = "%d ";

        String amPmMidnight = "Midnight";

        int time = 12;

        int iterator = 0;

        do {
            System.out.println(time + " " + amPmMidnight);

            if (time == 12 ) {
                time = 0;
                amPmMidnight = checkAMPM(time, iterator, amPmMidnight);
            }

            amPmMidnight = checkAMPM(time, iterator, amPmMidnight);

                time++;
                iterator++;

        } while (iterator != 24) ;

    }

    public static String checkAMPM(int time ,int iterator , String amPmMidnight){

        if( iterator == 11){
            amPmMidnight  = "noon";
            return amPmMidnight ;

        }else if(iterator < 12){

            amPmMidnight = "am";
            return amPmMidnight;
        }
        else{
            amPmMidnight = "pm";
            return amPmMidnight;
        }

    }
}





