
public class IData
{
   private Integer[] iValues;
   
   public IData(Integer[] p)
   {
       iValues = p;
   }
   
   public Integer action(IntegerTriFunction itf)
   {
       Integer lastResult = null;
       
       for(int i = 0 ; i<iValues.length ; i++)
       {
          if(iValues[i] != null)
          {lastResult = itf.apply(iValues[i] , lastResult , i);}
       }
       return lastResult;
   }
}
