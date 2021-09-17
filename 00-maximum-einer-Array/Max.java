public class test{


  public static void main(String[] args) {

    System.out.println(apply());
  }

  public static int apply()
  {
     int[] arr = new int[]{1,2,3};

     int max=2;

     int j = 0;

     for (j=2;j<arr.length ;j++ ) {

       if(arr[max] < arr[j]){

           max = j;
       }
     }

     return arr[max];
  }


}
