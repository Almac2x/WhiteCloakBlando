import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {


      Scanner scanner = new Scanner(System.in);

      double cigarette = scanner.nextInt();
      double cigarretteButt = scanner.nextInt();
      double totalCigarretes = cigarette;

       double cigarretesFromButts = 0;
      int i = 0;

      do{
          if(i == 0 ){
              cigarretesFromButts  = cigarette / cigarretteButt;

          }else

          cigarretesFromButts = (cigarretesFromButts / cigarretteButt);
          totalCigarretes += cigarretesFromButts;
         i++;

      }while(cigarretesFromButts >= cigarretteButt);

        System.out.println((int)Math.ceil(totalCigarretes));

    }
}
