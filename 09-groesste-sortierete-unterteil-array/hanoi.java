public class hanoi{

  public static void move(int quantity , char start , char help , char target)
  {

   if(quantity>0)
   {
     move(quantity-1,start,target,help);

     System.out.println("Verschiebe oberste scheibe von "+start+" nach "+target);

     move(quantity-1,help,start,target);

   }
 }



   public static void main (String[] args)
   {
    int [] a = {5,-6,2,2,-1,2,2,-6,3};

    System.out.println();

    long start  = System.currentTimeMillis();

    move(4,'A','B','C');

    long end = System.currentTimeMillis();System.out.println();


    System.out.println("Laufzeit : "+(long)(end-start) +"ms");System.out.println();

    }


}
