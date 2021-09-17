import java.util.*;
import java.nio.charset.StandardCharsets;

public class Sortierung2 {

	// Implementierung von insertionsort aus Vorlseung
	public static void insertionSort(int[] array) {


		for( int j = 1; j< array.length; j++ ) {
			int key = array[j];
			int i = j-1;
			while( (i>=0) && (array[i] > key) ) {
				array[i+1] = array[i];
				i = i-1;
			}
			array[i+1]=key;

                        assert : array[i+1] + array[i];

		}

	}

	// Jedes element vom Array auf dem Bildschirm angezeigen, falls die laenge der array kleiner gleich 100
	// Wenn wir ein Array der Laenge <= 100 haben, dann werden alle elemente auf dem Bildschirm angezeigt
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

    // Hilfsmethode für absteigende Sortierung.
	// Ausgeführt, nachdem das Array erst absteigend sortiert ist.
    public static void reverse(int[] input) {  // Array elemente umkehren

    	assert input.length <= 0 : input.length + " ist nicht groesser 0.";
    	//assert (isSorted(input)) : " Array ist nicht sortiert.";

	    int last = input.length - 1;
	    int middle = input.length / 2;
	    for (int i = 0; i <= middle; i++) {
	        int temp = input[i];
	        input[i] = input[last - i];
	        input[last - i] = temp;
	    }
	  }

    // Überprüfen, ob das array aufsteigend sortiert ist.
	public static boolean isSorted(int[] array) {

		assert array.length <= 0 : array.length + " ist nicht groesser 0.";

		if( array == null ) { System.out.println("Fehler: Array == null!"); return false; }

		 for (int i = 0; i < array.length - 1; i++) {
		     if (array[i] > array[i + 1]) {
		     System.out.println("Feld NICHT sortiert!");
		     return false;
		     }
		 }
		 System.out.println("Feld sortiert!");
    	 return true;
	}

	// Das ganze Array wird mit zufaelligen werten gefüllt.
	public static void fillRandom(int[] array) {  // @@@@@ ??????

		Random rand = new Random();

		for( int x = 0; x < array.length; x++) {
			 // To a number between [0 - 49]  : rand.nextInt(50);
			array[x] = rand.nextInt();
		}

	}

	// Das ganze Array wird erst mit zufaelligen werten gefüllt.
	// Werden diese Werte absteigend sortiert.
	public static void fillDescending(int[] array) { // absteigend

        Random rand = new Random();

		for( int x = 0; x < array.length; x++) {
			 // To a number between [0 - 49]  : rand.nextInt(50);
			array[array.length-1-x] = rand.nextInt();
		}

		Arrays.sort(array);

		reverse(array);  // von aufsteigen zu absteigende Sortierung wechseln

	}

	// Das ganze Array wird erst mit zufaelligen werten gefüllt.
	// Werden diese Werte aufsteigend sortiert.
    public static void fillAscending(int[] array) {  // aufsteigend

        Random rand = new Random();

		for( int x = 0; x < array.length; x++) {
			 // To a number between [0 - 49]  : rand.nextInt(50);
			array[x] = rand.nextInt();
		}

		Arrays.sort(array);  // aufsteigend sortieren

	}

    // Gegebene mergesort methode aus dem Blatt
	// Erstellt eim temporaeres Array, das nachher zu einem Ganzen zusammengefügt wird
    public static void mergeSort(int[] array) {
    	// System.out.println("Auswahl: ** Merge Sort **");
    	int[] tmpArray = new int[array.length];
    	mergeSort(array, tmpArray, 0, array.length-1);
    	assert isSorted(array);
    	}

    // Implementierung der Mergesort aus der Vorlesung
	// Zerlegt das gegebene Array auf Teile und sortiert sie
    public static void mergeSort(int[] array, int[] tmpArray, int left, int right) {

	    	if (left < right)
	        {
	            // Find the middle point
	           int m = left + (right-left)/2;

	            // Sort first and second halves
	            mergeSort(array, tmpArray, left, m);
	            mergeSort(array, tmpArray, m+1, right);

	            // Merge the sorted halves
	            mergeSortCombineV3(array, tmpArray, left, m, right); // Version3
	        }

		 }

	 // Fügt die zerlegten Arrayteilen zusammen. Am Ende ist das resultierende Array sortiert
	 public static void mergeSortCombineV3(int[] arr, int tempArray[], int st, int mid, int en) {

		    int i,j,l,m;
		    i = st;
		    l = st;
		    m = mid + 1;
		    while((l<=mid) && (m <= en))
		    {
		        if(arr[l] <= arr[m])
		        {
		            tempArray[i] = arr[l];
		            l++;
		            i++;
		        }
		        else
		        {
		            tempArray[i] = arr[m];
		            m++;
		            i++;
		        }
		    }
		    if(l <= mid)
		    {
		        for(j=l;j<=mid;j++)
		        {
		            tempArray[i] = arr[j];
		            i++;
		        }
		    }
		    else
		    {
		        for(j=m;j<=en;j++)
		        {
		            tempArray[i] = arr[j];
		            i++;
		        }
		    }
		    for(j=st;j<=en;j++)
		        arr[j] = tempArray[j];

	 }

	public static void main(String[] args) {
        StandardCharsets.UTF_8.name();

		// Program Timer start
		long pStartTime = System.currentTimeMillis();

		int eingabe = 0;  // Array length

		// Eingabe überprüfen. Falls keine Eingabe, dann Abbruch. Erlaubte Eingabe Anzahl: 1 bis 3 .
		// Jetzt darf man 1 bis 3 Parameter eingeben
		if( (args.length > 0) && (args.length < 4) )
	    {
			try { // Ob die erste Eingabe in integer konvertierbar ist

				eingabe = Integer.parseInt(args[0]);  // String eingabe in integer umwandeln
		        // Array größe kann nur positiv sein
		        if( eingabe <= 0 ) {
		        	System.out.println("Bitte positive Zahl eingeben!");
		        	System.exit(0);
		        }

			}
			catch (NumberFormatException e) {
		        System.out.println("Bitte positive Zahl als erste Parameter eingeben!");
				System.exit(0);
		    }

	    }
		else {
			System.out.println("Parameter Fehler! Bitte 2 Parameter eingeben. (" + args.length +")");
	        System.exit(0);
		}

		int[] intArray = new int[eingabe];  // Array deklarieren mit der Laenge "eingabe"
		long mStartTime=0; // um die Laufzeit von der Sortierungsmethde zu messen, Timer deklarieren
		long mStopTime=0;

		// Falls 2. oder 3. Parametern existieren, überprüfen
		if(args.length >= 2) {

			if( args.length == 3 ){ // Erst die dritte Parameter überprüfen, wie das array gefüllt werden soll
				// Dritter Parameter bestimmt die Befüllungsart von dem Array
				switch(args[2])
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
		            default:
		                System.out.println("Dritter Parameter nicht definiert: " + args[2]);
		                System.exit(0);
		        }

			}
			else { // Falls kein dritter Parameter eingegeben, wird das Array zufaellig gefüllt

				System.out.println("(Kein Dritter Parameter) Default: ***Zufällig Füllen*** ");
                fillRandom(intArray);

			}

			// Auswahl, welche Sortierungsmethode auf das Array ausgeführt wird
			switch(args[1])
	        {
	            case "insert":
	                System.out.println("Auswahl: **Insertion Sort**");
	                // Timer vor Methodenaufruf, um die Laufzeit der Sortierungsmethode zu messen.
	                mStartTime = System.currentTimeMillis();
	        		insertionSort(intArray);
	        		mStopTime = System.currentTimeMillis();

	                break;
	            case "merge":
	            	System.out.println("Auswahl: ** Merge Sort **");
					// Timer vor Methodenaufruf
	            	mStartTime = System.currentTimeMillis();
	        		mergeSort(intArray);
	        		mStopTime = System.currentTimeMillis();

	                break;
	            default:
	                System.out.println("Zweiter Parameter nicht definiert: " + args[1]);
	                System.exit(0);
	        }



		}
		else if(args.length == 1) { // Dieser Zweig wird ausgeführt, wenn nur die Laenge des Arrays eingegeben ist.
		    // Kein zweiter Parameter
			// Default: MergeSort auf einem mit Zufallszahlen befüllten Feld erfolgen

			System.out.println("Default: Auswahl: ** Merge Sort **");
			System.out.println("Default: ***Zufällig Füllen***");
            fillRandom(intArray);

            // Method Start Time
            mStartTime = System.currentTimeMillis();
    		mergeSort(intArray);
    		mStopTime = System.currentTimeMillis();

		}

		// Method Measured Time
		long mMeasuredTime = (long)mStopTime- (long)mStartTime ;

		isSorted(intArray);  // Ob die Sortierungsmethde richtig funktioniert hat.

		printArray(intArray); // Falls Arraylaenge klein genug, alle Elemente anzeigen.

		// Program Timer Stop
		long pStopTime = System.currentTimeMillis();
		// Program Measured Time
		long pMeasuredTime = (long)pStopTime - (long)pStartTime;

		// Laufzeitanzeigen auf dem Bildschirm
		System.out.println("Benötigte Zeit für die Methode: " + (long)mMeasuredTime);
		System.out.println("Benötigte Zeit für das Programm: " + (long)pMeasuredTime);


	}

}
