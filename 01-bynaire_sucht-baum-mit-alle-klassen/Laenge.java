public class Laenge
{





  public static void main(String[] args) {
     char c = '';
  }
  public static boolean sindVielfaches(long[] a)
  {
    boolean sindVielfaches = false;
     int i = 0 ;

     while(i < a.length && a[i]%a[i+1] != 0)
     {
       sindVielfaches = true;

       i++;
     }
  }
}
