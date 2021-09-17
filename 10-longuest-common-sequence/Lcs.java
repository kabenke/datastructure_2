import java.util.*;

public class Lcs {
	
	static String teilfolge = "";
	
	// Zufaellige Teilfolge konstruieren mit n Buchtaben
	public static String randStr(int n, Random r) {
		String alphabet =
		"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder res = new StringBuilder(n);
		while (--n>=0) {
		res.append(alphabet.charAt(r.nextInt(alphabet.length())));
		}
		return res.toString();
	}
	
	// Berechnung der Werte von den rekursiven Aufrufen
	// O(n+m) Tabellen Eintraege mit Dynamischer Programmierung fuellen
	public static void LCSBerechnung(String X, String Y, int[][] C, int i, int j){
		
		if( X.charAt(i-1) == Y.charAt(j-1) ) {  // @@ charAt(j-1) lere -1 
			C[i][j] = (C[i-1][j-1] + 1); 
		} 
		else {
			
			if( C[i-1][j] >= C[i][j-1] ) { C[i][j]=C[i-1][j]; }
			else { C[i][j] = C[i][j-1]; }
		}
	}
	
	// Longest Common Sequience Laufzeit O(nm)
	// BUG FIXED: Erstes Zeichen wird nicht betrachtet in nested for
	public static int[][] LCS(String folge1, String folge2){
		
		int m = folge1.length();
		int n = folge2.length();
		
		int[][] C = new int[m+1][n+1];   // @@ +1 leri sil?
		for(int i = 0; i<=m; i++) { C[i][0] = 0; }
		for(int j = 0; j<=n; j++) { C[0][j] = 0; }
		
		for(int i=1; i<=m; i++) {
			for(int j=1; j<=n; j++) {
				LCSBerechnung(folge1,folge2,C,i,j);
			}
		}
		
		// Eine leangste gemeinsame Teilfolge aus der Tabelle bestimmen und ausgeben
		// Laufzeit: O(n+m) , n und m sind Laengen der generierten Folgen
		int index = C[m][n]; 
        int temp = index; 
        char[] lcs = new char[index+1]; 
		lcs[index] = ' '; // Should be an empty char, am ende length()-1 berechenn
		int i = m, j = n; 
        while (i > 0 && j > 0) 
        { 
            // If current character in X[] and Y are same, then 
            // current character is part of LCS 
            if (folge1.charAt(i-1) == folge2.charAt(j-1)) 
            { 
                // Put current character in result 
                lcs[index-1] = folge1.charAt(i-1);  
                  
                // reduce values of i, j and index 
                i--;  
                j--;  
                index--;      
            } 
   
            // If not same, then find the larger of two and 
            // go in the direction of larger value 
            else if (C[i-1][j] > C[i][j-1]) 
                i--; 
            else
                j--; 
        } 
   
        // Bilden der teilfolge
        for(int k=0;k<=temp;k++) { teilfolge += lcs[k]; }
				
		return C;
			
	}
	
	// Den groessten Eintrag in Tabelle (C) finden
	public static int findMax(int[][] result) {
		
		int max=0;
		
		 for(int i=0; i < result.length; i++) {
		        for(int j=0; j < result[i].length; j++) {
		        	if(result[i][j] > max) {
		        		max = result[i][j];
		        	}
		        }
		 }
		
		 return max;
		 
	}
	
	public static void main(String[] args) {
		
		int n;  // Speichern den Parameter
		long mStartTime = 0; // um die Laufzeit von der Methde zu messen, Timer deklarieren
		long mStopTime = 0;
		
		if( args.length == 1 ) {  // Parameter ueberpruefen
			
			 try{
					
					n = Integer.parseInt(args[0]);  // Ob Parameter in Interger konverntierbar
					if(n <= 0) { System.out.println("Parameter Fehler"); return;}  // Ob der groesser gleich 0 ist
					
				}
				catch( NumberFormatException e ){
					System.out.println("Bitte positive Zahl eingeben. (NumberFormatException)");
					return;
				}
			 
			 // 2 Zufaellige Folgen erstellen
			 Random generator = new java.util.Random();
			 String folge1 = randStr(n, generator);
			 String folge2 = randStr(n, generator);
			 		 			 
			 int[][] result;  // Tabelle erstellen
			 			 
			 // Laufzeit messen
			 mStartTime = System.currentTimeMillis();
			 result = LCS(folge1, folge2);	
			 mStopTime = System.currentTimeMillis();
	     
			 // Den maximalen Eintrag in der Tabelle finden
			 // Laenge einer laengsten Teilfolge
			 int max = findMax(result);					
	    	 
			 // Method Measured Time
			 long mMeasuredTime = (long)mStopTime- (long)mStartTime;
			 			
			 // Tabelle zeigen (OPTIONAL) , wird schnell sehr gross @@
			 System.out.println("***************** ");
			 for (int[] arr : result) {
		            System.out.println(Arrays.toString(arr));
		     }
			 System.out.println("***************** ");
			 
			 // Ergebnisse zeigen
			 System.out.println("Parameter/Laenge der gesamten Folge: " + n);	
			 System.out.println("1. Generierte Folge: " + folge1);	
			 System.out.println("2. Generierte Folge: " + folge2);
			 System.out.println();
			 System.out.println("Die Laenge der Laengsten Teilfolge: " + max);	
			 System.out.println("Eine gefundene laengste Teilfolge: " + teilfolge);
			 System.out.println("Laenge der Teilfolge: " + (teilfolge.length()-1)); // TEST
			 System.out.println("Benötigte Zeit für die Methode: " + (long)mMeasuredTime + " ms");	 
			 			 
			 // TEST
			 /*
			 System.out.println("***************** ");
			 int[][] result2;
			 String t1 = "yabcdf";
			 String t2 = "y1234f";
			 mStartTime = System.currentTimeMillis();
			 result2 = LCS(t1, t2);
			 mStopTime = System.currentTimeMillis();
			 int max2 = findMax(result2);	
			 long mMeasuredTime3 = (long)mStopTime- (long)mStartTime;
			 for (int[] arr : result2) {
		            System.out.println(Arrays.toString(arr));
		        }
			 System.out.println("Benötigte Zeit für die Methode: " + (long)mMeasuredTime3);	 
			 System.out.println("Die Laenge einer Laengsten Teilfolge: " + max2);	
			 System.out.println("Folge Laenge: " + t1.length() );
			 System.out.println("***************** ");
			 */
		}
		else { 
			
			System.out.println("Parameteranzahl Fehler");
			
		}

	}

}
