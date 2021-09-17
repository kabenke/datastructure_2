
public class Data
{
   
    private int[] values;
    
    public Data( int[] p)
    {
        values = p;
    }
       int result  = 0;
       
       public int action ( Intfunc f  , Intfunc g)
       {
       
       for(int i = 0 ; i< values.length; i++)
       {
          if(f.compute(i) > 0)
          {
            result = result+g.compute(values[i]);
            
          }
        
       }
        return result;
     }
     
}  
