import java.util.Arrays;

public class test {

  public static void main(String[] args) {

   apply();

  }

  public static void apply(){


  int[] array = {7,4,2,-3,6,8,-1,11,9};

  int[] helfer = new int[array.length];

  int sum = 0;

  for (int i = 0 ; i<array.length ; i++ )
  {
     for(int j = i ; j<array.length ; j++)
     {
        sum+=array[j];
        helfer[i]=sum;
     }

     sum = 0; // immer den summierer der vorherigen addition löschen bevor eine neue iteration
  }



  System.out.println(Arrays.toString(helfer));

}
}
