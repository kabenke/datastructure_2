
public class Main
{
    
    public static void main()
    {
       run();
    }
    public  static void run()
    {
    
    int[] arr = {-6,3,5,-7 , 5 , 6 , 9 , 4 } ;
    
    Data d = new Data(arr);
    
    // System.out.println(  id.action((p1,p2,p3)->{ 
      // {
        // if(p3 == 10)
        // {
           // return p1;
        // }
        // else { return p2;}
      // }}));
      // System.out.println(  id.action((p1,p2,p3)->{ 
      // {
        
         // if( p1 != null && p2 == null)
         // {
            // return p1;
         // }
         
         // else { return p2;}
      // }
      // }));
      // System.out.println(  id.action((p1,p2,p3)->{ 
      // {
        
         // if(p3 != null)
         // {
            // return ++p3;
         // }
         
         // else { return p2;}
      // }
      // }));
      
      
      // System.out.println("arr length is : "+arr.length);
   
    // }
    
    // System.out.println( d.action( (p1) -> p1 ,
                                  // (p2)->{if(p2 != 0 ){return 1;}
                                  // else{return 0;}}
                      // ));
    // System.out.println( d.action( (p1) -> {if(p1%2 != 0){return p1;}else{return -1;} },
                                  // (p2)->p2));
       // System.out.println( d.action( (p1) -> p1 ,
                                  // (p2)->{ int p3 , p4; p3 = p4 = 0 ;
                                       // if(p2 < 0 ){ p3++;} else { p4++; }
                                       
                                      // return p3 < p4 ? p4 : -1;
                                  
                                  // }));
        // System.out.println( d.action ( (p1)->p1 , (p2)->1));
                     
    Hello_world hello = new Hello_world();
    System.out.println(hello.action(()->"Bonjour"));
    dataClasse data = new dataClasse(arr);
    
    //Anzahl Elemente
    // System.out.println(data.compute(()->0 , (p1,p2,p3)->{return p1;}));
    // // Summe alle ungerade
    // System.out.println(data.compute(()->0 , (p1,p2,p3)->{if(p1%2!=0){return p3+=p2;}else{return p3;}}));
    // //Element an index 8 , oder -1 falls weniger als 8 Elemente
    //System.out.println(data.compute(()->0 , (p1,p2,p3)->{int p4 = -1; if(p1!=8){return p4;}else{return p2;}}));
    
   }
                 
    
}
