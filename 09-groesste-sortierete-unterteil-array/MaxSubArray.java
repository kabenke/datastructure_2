import java.util.*;

public class MaxSubArray {
	
		// Naive Loesung die alle Teilarrays betrachtet: O(n^2)
		public static int[] naviveLoesung1( int[] arr ) {
			
			System.out.println("   ** Naive Loesung ** "); 
			
			int n = arr.length;
			int max = 0;
			int best_start = 0;
			int current_start = 0;
			int end = 0;
			int sum = 0;	
			
			for(int i = 0; i < n; i++) {  // Startindex: i, summe 0-en bei jeder iteration
				sum = 0;
				current_start = i;
				for (int j = i; j < n; j++) {  // Von i bis Ende des Arrays durchlaufen
				        sum += arr[j];         // Aktuelles Element addieren
				        if (sum > max) {       // Falls summe groesser als die bisher gemerkten besten Summe, dann wird die variable max ueberschrieben
				        	max = sum; 		   // Die Summe des Teilarrays merken
				        	best_start = current_start;  // Bestmoegliche startindex aktualisieren
				        	end = j+1;                   // Endindex des Arrays aktualisieren
				        }
				}
			}
			
		    int[] result = new int[(end-1)-best_start+1];  // Neues Array inizialisieren [startindex, endindex]
				
			for( int j = best_start, k = 0; j<end; j++,k++ ) {
		        		        	
		    	result[k] = arr[j];
		        	
		    }
		       
			// Ergebnisse zeigen
			System.out.println("Startindex: " + best_start); 
		    System.out.println("Endindex: " + (end-1)); 
		    System.out.println("Gefundene Summe: " + max ); 
		    System.out.println("Teilarray: " + Arrays.toString(result));
			    
		    return result;
				
		}
	
	// Dynamische Programmierung: O(n)
	public static int[] dynamischeProgLoesung( int[] arr ) {
		
		System.out.println("   ** Dynamische Programmierung ** "); 
		
	    int max = 0;	  // Maximale Summe
	    int best_start = 0;  // Bestmoegliche startindex
	    int this_start = 0;  // Aktuelles startindex
	    int end = 0;         // Endindex des gefundenen Teilarrays
	    int best_so_far = 0; 

	    for ( int i = 0; i < arr.length; i++ ) {
	    	
	    	max += arr[i];
	    	best_so_far = Math.max( best_so_far, max );
	    	
	        if ( max <= 0 ) {
	        	
	        	this_start = i + 1;
	    	    max = 0;
	        	
	        }
         
	        else if ( max == best_so_far ) {
	        	
	        	best_start = this_start;
	            end = i + 1; // +1 weil endindex muss inklusiv sein
	        	
	        }

	    }
	    
	    int[] result = new int[(end-1)-best_start+1];  // Neues Array inizialisieren [startindex, endindex]
			
	    for( int j = best_start, k = 0; j<end; j++,k++ ) {
        	        	
        	result[k] = arr[j];
        	
        }
	    
	    //Ergebnisse zeigen
        System.out.println("Startindex: " + best_start); 
        System.out.println("Endindex: " + (end-1)); 
        System.out.println("Gefundene Summe: " + best_so_far); 
        System.out.println("Teilarray: " + Arrays.toString(result));
	    
		return result;
		
	}
				
	public static void main(String[] args) {
	
		int[] eingabe = { 5, -6, 2, 2, -1, 2, 2, -6, 3 };  // Eingabe hier, unterschiedliche Ergebnisse bei 1,1,1,-1,1
		
		long mStartTime = 0;  // Varibalen fuer Laufzeitmessung
		long mStopTime = 0;
		
		System.out.print("Eingabe Array: ");
		System.out.println(Arrays.toString(eingabe));
		
		// Naive Loesung aufrufen, Laufzeit messen
		mStartTime = System.currentTimeMillis();
		naviveLoesung1( eingabe );  // keine return verwendet
		mStopTime = System.currentTimeMillis();
		long MeasuredTime1 = (long)mStopTime - (long)mStartTime;
		
		// Dynamische Prog. version aufrufen, Laufzeit messen
		mStartTime = System.currentTimeMillis();
		dynamischeProgLoesung( eingabe ); // keine return verwendet
		mStopTime = System.currentTimeMillis();
		long MeasuredTime2 = (long)mStopTime - (long)mStartTime;
		
		// Ergebnisse
		System.out.println();
		System.out.println("  Naive Loesung Laufzeit             : " + MeasuredTime1 + " ms");	
		System.out.println("  Dynamische Programmierung Laufzeit : " + MeasuredTime2 + " ms");	

	}
	
	/*  // Test
	public static int[] naviveLoesung(int a[])  // DELETE
    { 		
		System.out.println(" ** Naive Loesung ** "); 
        int max_so_far = Integer.MIN_VALUE, 
        max_ending_here = 0,start = 0, 
        end = 0, s = 0; 
  
        for (int i = 0; i < a.length; i++)  
        { 
            max_ending_here += a[i]; 
  
            if (max_so_far < max_ending_here)  
            { 
                max_so_far = max_ending_here; 
                start = s; 
                end = i; 
            } 
  
            if (max_ending_here < 0)  
            { 
                max_ending_here = 0; 
                s = i + 1; 
            } 
        } 
        
        System.out.println("Startindex: " + start); 
        System.out.println("Endindex: " + (end)); 
        System.out.println("Gefundene Summe: " + max_so_far); 
        
        System.out.print("Teilarray: "); 
        int[] result = new int[(end)-start+1];
        
        for( int j = start, k = 0; j<=end; j++,k++ ) {
        	        	
        	result[k] = a[j];
        	
        }
        
        System.out.println(Arrays.toString(result));
        
        return result;
        
    } 
	*/

}
