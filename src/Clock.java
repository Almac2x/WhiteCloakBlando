public class Clock {

    public static void main(String[] args) {
        int degreePerMinute = 360 / 60, degreePerHour = 360 / 12;
        boolean retake = false;

        do {

            System.out.println("Display AM or PM Only!");

            String stringTime = "7:15";

            int[] timeInt = seperateHourandMinute(stringTime);

            int hour = timeInt[0];
            int minute = timeInt[1];

            if(hour > 12 || hour < 1 || minute < 0 || minute > 59  ){
                System.out.println("Wrong Input Time");
                retake = true;
            }else if(hour == 12 && minute == 0){
                System.out.println("Degree in between is " + 0);
                retake = false;
            }
            else {

                int hourInDegrees = calculateInDegrees(degreePerHour,hour);
                int minuteInDegrees = calculateInDegrees(degreePerMinute,minute);

                System.out.println("Degree in between is " + Math.abs(hourInDegrees-minuteInDegrees));

                retake = false;
            }

            for (int x : timeInt) {
                System.out.println(x);
            }
        }while(retake == true);

    }

    public  static int calculateInDegrees(int perSomething, int time){
        return perSomething*time;
    }

    public static int[] seperateHourandMinute(String time) {

       String[] tempTime = time.split("[:]",3);

       int[] timeInt = {Integer.parseInt(tempTime[0]),Integer.parseInt(tempTime[1])};

       return timeInt;

    }
}
