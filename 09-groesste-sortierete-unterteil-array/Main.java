import java.util.*;

public class Main
{

   public static void main (String[] args)
    {
        int [] a = {5,-6,2,2,-1,2,2,-6,3};

        System.out.println("Aufgabe 1");System.out.println();


        System.out.println("Leagnste gemeinsam teilfolge : "+LCS(a));System.out.println();


        System.out.println("Augabe 2");

        System.out.println();

        move(4,'A','B','C');

    }

    /*
     *Folgt aus Kadane Algotihme
     */

    static int LCS(int arr[])
    {
        int size = arr.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + arr[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }



    }

}
