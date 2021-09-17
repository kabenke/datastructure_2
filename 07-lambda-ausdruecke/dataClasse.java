public class dataClasse

{  private int[] values;
    
    public dataClasse(int[] v)
    {
        values = v;
    }
    
    public int compute( simplex f , TriFunc g)
    {
        
        int result =  f.apply();
        
        for(int i = 0 ; i<values.length ; i++)
        {
            result = g.action( i , values[i] , result);
        }
        
        return result;
    }
    
    
}
