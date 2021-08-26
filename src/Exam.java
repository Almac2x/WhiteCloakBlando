import java.util.Scanner;

public class Exam {
    public static void main(String[] args) {

        String specializationTrack = "Android";
        int examTaken = 0,score = 0;
        Scanner scanner = new Scanner(System.in);

        while (examTaken < 2){
            switch (specializationTrack){
                case "Android": score = takeAnyExam(specializationTrack); break;
                case "Front-end":score = takeAnyExam(specializationTrack);break;
                case "Back-end":score = takeAnyExam(specializationTrack);break;
                case "IOS":score = takeAnyExam(specializationTrack);break;
            }

            if(score >= 50){
                System.out.println("Score: " + score + "\nStatus: Pass");
                examTaken = 3;
            } else if(examTaken == 1){
                System.out.println("Score: " + score + "\nStatus: Pass \nAt least you tried twice");
                examTaken = 3;
            }

            else if(examTaken < 1){
                System.out.println("Do you want to take exam again (Y/N)");
                String yesOrNo = scanner.next().toLowerCase();

                switch (yesOrNo){
                    case"y":examTaken ++; break;
                    case"n":examTaken = 3;break; //Ends if does not want to retake

                }
            }

        }
    }

    public static int takeAnyExam(String track){

        switch (track){
            case "Android": return new Scanner(System.in).nextInt();
            case "Front-end":return 70;
            case "Back-end":return 65;
            case "IOS":return 90;
            default: return 50;
         }
    }
}
