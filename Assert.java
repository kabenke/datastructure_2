public class Assert
{
    public static void main(String[] args) {


     System.out.println(compute(10));
     System.out.println(compute(30));
     System.out.println(compute(1));


    }

    public static int compute(int n )
    {
        int k = 0,
            x = 0,
            m = 2 * n;

        while( k < m)
        {
           assert_(k % 2 == 0 , "Nr. 1 felhgeschlagen");
           assert_(x == (k / 2)*(k / 2) ,"Nr. 2 fehlgechlagen");
            x = x+k+1;
            k=k+2;
        }

        return x;

    }

    public String assert_(boolean condition , String message)
    {

           return  (!condition) ?  message : "Behauptung fehlgeschlagen";

    }
}
 

