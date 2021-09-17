import java.util.*;

public class Sortierung {

    // Implementierung von Insertion Sort aus Vorlesung
	public static void insertionSort(int[] array) {
		
		assert array.length <= 0 : array.length + " ist nicht groesser 0.";
		
		System.out.println("** INSERTION SORT BEGIN **");
		
		for( int j = 1; j< array.length; j++ ) {
			int key = array[j];
			int i = j-1;
			while( (i>=0) && (array[i] > key) ) {
				array[i+1] = array[i];
				i = i-1;
			}
			array[i+1]=key;
			
		}
		
		System.out.println("** INSERTION SORT ENDE **");
		
	}	
	
	// Alle Elemente vom Array anzeigen, falls Array Laenge kleiner gleich 100 ist
	public static void printArray(int[] array) {
		
		assert array.length <= 0 : array.length + " ist nicht groesser 0.";
		
		if( array.length<=100 ) {
			System.out.println("-- Print array --");	
			System.out.println(Arrays.toString(array));
			
		}
		else {
			System.out.println("Array too long to print! ("+array.length+")" );	
		}
		
	}
	
	// Merhode zum Überprüfen ob das Array aufsteigend sortiert ist.
	public static boolean isSorted(int[] array) { 
		
		assert array.length <= 0 : array.length + " ist nicht groesser 0.";
		
		 for (int i = 0; i < array.length - 1; i++) {
		     if (array[i] > array[i + 1]) {
		     System.out.println("Feld NICHT sortiert!");
		     return false; 
		     }
		 }
		 System.out.println("Feld sortiert!");
    	 return true;
	}
	
	// Hilfsmethode für absteigende Sortierung. 
	// Array elemente umkehren
	// Wird ausgeführt, nachdem das Array erst aufsteigend sortiert ist.
	public static void reverse(int[] input) {  
	    int last = input.length - 1;
	    int middle = input.length / 2;
	    for (int i = 0; i <= middle; i++) {
	        int temp = input[i];
	        input[i] = input[last - i];
	        input[last - i] = temp;
	    }
	}
	
	// Array zufällig mit zufälligen Zahlen füllen
	public static void fillRandom(int[] array) {  
		
		Random rand = new Random();
		
		for( int x = 0; x < array.length; x++) {
			 // To a number between [0 - 49]  : rand.nextInt(50);	
			array[x] = rand.nextInt();				
		}
		
	}
	
	// Array absteigend mit zufälligen Zahlen füllen
    public static void fillDescending(int[] array) { 
		
        Random rand = new Random();
		
		for( int x = 0; x < array.length; x++) {
			 // To a number between [0 - 49]  : rand.nextInt(50);	
			array[x] = rand.nextInt();				
		}
		
		Arrays.sort(array);
		
		reverse(array);  // von aufsteigen zu absteigende Sortierung wechseln
		
	}
    
	// Array aufsteigend mit zufälligen Zahlen füllen
    public static void fillAscending(int[] array) {  
		
        Random rand = new Random();
		
		for( int x = 0; x < array.length; x++) {
			 // To a number between [0 - 49]  : rand.nextInt(50);	
			array[x] = rand.nextInt();				
		}
		
		Arrays.sort(array);  // aufsteigend sortieren
		
	}
  
	public static void main(String[] args) {
		
		// Program Timer start
		// Timer variable, um die Laufzeit von dem ganzen Programm zu sehen.
		long pStartTime = System.currentTimeMillis();
		
		int eingabe = 0; // (vom Benuzter gelesene) Array Laenge
		
		// Bei diesem Programm darf der Benutzer nur 1 oder 2 Parameter eingeben.
		// Hier wird die Parameteranzahl geprüft
		// Eingabe Anzahl überprüfen. Falls keine Eingabe, dann Abbruch. Erlaubte Eingabe Anzahl: 1 oder 2 .
		if( (args.length > 0) && (args.length < 3) )
	    {	
			try {
				// Die erste Eingabe muss eine ganze Zahl sein
				eingabe = Integer.parseInt(args[0]);  // String eingabe in integer umwandeln	
				
			}catch (NumberFormatException e) { // Fehlermeldung anzeigen
		        System.out.println("Eingabe nicht in integer konvertierbar! (" + args[0] + ")");
				System.exit(0);
		    }
	         
	        // Array Größe kann nur positiv sein
	        if( eingabe <= 0 ) {
	        	System.out.println("Bitte positive Zahl eingeben!");
	        	System.exit(0);
	        }
	    }
		else {
			System.out.println("Parameter Fehler! Bitte Maximal 2 Parameter eingeben. (" + args.length +")");
	        System.exit(0);
		}
		
		 // Array deklarieren mit "eingabe" Zahlen. 
		 // Wird nachher gefüllt, je nachdem was der Benutzer als zweiter Parameter eingegeben hat
		 int[] intArray = new int[eingabe]; 
					
		if(args.length == 1) { // Falls kein zweiter parameter übergeben, dann wird das Array zufällig gefüllt (default)
			
			System.out.println("(Zweiter Parameter nicht eingegeben)"); 
			System.out.println("Default: ***Zufällig Füllen***");
 			fillRandom(intArray);
		}
		
		// Die zweite Eingabe beschreibt die Befüllungsart des Arrays
		// Falls 2. Eingabe vorhanden, entscheiden, auf welche Art das Array gefüllt wird
		if(args.length == 2) {
			
			switch(args[1]) 
	        { 
	            case "auf": 
	                System.out.println("***Aufsteigend Füllen***"); 
	                fillAscending(intArray);
	                break; 
	            case "ab": 
	                System.out.println("***Absteigend Füllen***"); 
	                fillDescending(intArray);
	                break; 
	            case "rand": 
	                System.out.println("***Zufällig Füllen***"); 
	                fillRandom(intArray);
	                break; 
	            default: // Eingabe nicht erkannt
	                System.out.println("Zweiter Parameter nicht definiert: " + args[1]); 
	                System.exit(0);
	              
	        } 
		} 
				
		// An dieser Stelle haben wir festgestellt, wie groß das Array ist,
		// und wie wir es füllen sollen. Jetzt können wir die insertionSort Methode ausführen.
		
		// Um die Laufzeit zu messen, umgeben wir die auszuführenden Methode mit 2 System.currentTimeMillis() Methoden.
		// Die Differenz gibt uns die Laufzeit von der Methode 
				
		// Method Start Time
		long mStartTime = System.currentTimeMillis();
		insertionSort(intArray); 
		long mStopTime = System.currentTimeMillis();
		// Method Measured Time
		long mMeasuredTime = (long)mStopTime- (long)mStartTime ;
		
		isSorted(intArray);  // Ob die Sortierung funktioniert hat
		
		printArray(intArray); // Falls Array nicht zu groß, alle Elemente anzeigen 
             
        // Program Timer Stop
		long pStopTime = System.currentTimeMillis();
		// Program Measured Time
		long pMeasuredTime = (long)pStopTime - (long)pStartTime;
		
		// Anzeigen, wie lange die Methode und das ganze Program dauert hat.
		System.out.println();	
		System.out.println("Benötigte Zeit für insertionSort() die Methode: " + (long)mMeasuredTime); 
		System.out.println("Benötigte Zeit für das Programm: " + (long)pMeasuredTime); 
		
	}

}
