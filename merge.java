public class merge{

  public static void MergeSort(int[] A , int l , int r)
  {
    if(l<r)
    {
       int m = (l+r)/2;
       MergeSort(A,l,m);
       MergeSort(A,m+1,r);
       Merge(A,l,m,r);
    }

  }

  public static void Merge(int[] A , int l , int m , int r)
  {
    int[] temp = new int[A.length];

  }
}
