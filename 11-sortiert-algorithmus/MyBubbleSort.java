
import java.util.*;


public class BubbleSort{


	public static void bubbleSort(int[] array)
	{
		int temp = 0 ; 
		int n = array.length;

		for(int i = 0 ; i<n ; i++)
		{
			for(int j = n ; j<i+1 ; j--)
			{
				if(array[j-1]>array[j])         
				{
					temp = array[j]; 
					array[j] = array[j-1];
					array[j-1] = temp;
				}	
			}
		}
	}
	public static void fillRandom(int[] array)
	{  
		Random rand = new Random();

		for( int x = 0; x < array.length; x++) 
		{
			 // To a number between [0 - 49]  : rand.nextInt(50);	
			array[x] = rand.nextInt();				
		}

	}


	public static void main (String[] args)
	{ 
		

		if(args.length == 1)
		{


			try { 


            // 
            // 
				float str = Float.parseFloat(args[0]); 

				if(str < 0.0){System.out.println("Enter a positv Number");System.exit(0);}


			} 

			catch (NumberFormatException  e) { 

				System.out.println("Bitte geben Sie ein Float ein "); 
			} 

			
		}
		else {
			System.out.println("Parameter Fehler ! muss höchsten ein Parameter gegeben und höchsten eins\n");System.exit(0);
		}

        float str = Float.parseFloat(args[0]); 

        
		int n = 1000 ;

		int[] array = new int[n];
		fillRandom(array);
		long mStart = 0; //Mess die Zeit am Start
		long mEnde = 0;   // Mess die Zeit am Ende 
		long mDelta = mEnde - mStart ;  

		float mMerker = str ; 

		while (mDelta < 0.1)
		{

			mStart = System.currentTimeMillis();
			bubbleSort(array);
			mEnde = System.currentTimeMillis();

			if((float)(mDelta/1000) < str)
			{
				n = 2*n;
			}
		}
		System.out.println (n + ": Zeit am Ende");



	} 

} 


