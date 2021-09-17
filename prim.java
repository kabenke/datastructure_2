import java.util.*;
public class prim {

 public static void main(String[] args) {
   int n  = 0 ;

   try{
      n = Integer.parseInt(args[0]);
    if (n < 0 ) {
      System.out.println("only positives arguments"); return ;
    }
   }
   catch(Exception e){
    System.out.println("Please give a Positive argument");
   }
   computePrime(n);
 }
  public static  void computePrime( int n )
  {
     boolean[] numbers = initializeNumbers(n);

     inspectsNumbers( numbers);

     show( numbers);
  }

  public static boolean[] initializeNumbers (int n)
  {
    boolean[] numbers = new boolean[n+1];

    for (int i = 2 ; i<numbers.length ; i++) {

          numbers[i] = true;
    }

    return numbers;
  }

  public static void inspectsNumbers ( boolean[] numbers)
  {
    double limits = Math.sqrt(numbers.length);
     for (int i = 2;i<limits; i++ ) {

       if (numbers[i]) {
         discardMultiple(numbers , i);
       }
     }
  }

  //Striecht vielfacher von primzahlen
  public static void discardMultiple( boolean[] numbers , int j )
  {


     for (int i =j*j; i< numbers.length ; i+=j ) {

       if (i % j ==0) {
         numbers[i] = false;
       }
     }
  }

  public static void show(boolean[] numbers)
  {
    for ( int i = 2; i<numbers.length ; i++ ) {
      if (numbers[i]) {

        System.out.println(i+"  ");
      }
    }
    //System.out.println();
  }
}
