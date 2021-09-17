import java.util.*;


// Plannung
// 1:Methoden
// 2:Main Methode{ laufzeitMessungStart , Aufruf der Methode , Laufzeitmessungende , GesamtZeitAusgabe}



public class Quicksort {

	// Pruefen ob das array bis n-te Element sortiert ist. Fuer assertion
	public static boolean isSorted(int[] array, int n) {

		if(array == null) {return false;}
		for(int i=0; i<n; i++) {
			if(array[i]>array[i+1]) {
				System.out.println("Teilarray nicht sortiert");
				return false;
			}

		}
		return true;
	}

	// Pruefen ob das ganze Array sortiert ist
	public static boolean isSorted(int[] array) {

	     return isSorted(array,array.length-1); //Fuer eine TeilArray
	}

	// Implementierung von insertionsort aus Vorlseung
	public static void insertionSort(int[] array) {

		System.out.println("InsertionSort laeuft...");

		for( int j = 1; j< array.length; j++ ) {
				assert isSorted(array,j-1) : "Teilarray nicht sortiert!";
				int key = array[j];
				int i = j-1;
				while( (i>=0) && (array[i] > key) ) {
					array[i+1] = array[i];
					i = i-1;
			}
			array[i+1]=key;
			assert array[i+1] >= array[i] : "Assertion Fehler!";
		}

	}

	// Mergesort
	public static void mergeSort(int[] array) {
		System.out.println("MergeSort laeuft...");
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
	            assert isSorted(tmpArray) : "Teilarray nicht sortiert!";
	            mergeSort(array, tmpArray, m+1, right);
	            assert isSorted(tmpArray) : "Teilarray nicht sortiert!";

	            // Merge the sorted halves
	            mergeSortCombineV3(array, tmpArray, left, m, right); // Version3
	        }

		 }

	 // Fuegt die zerlegten Arrayteilen zusammen. Am Ende ist das resultierende Array sortiert
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


/////////////////////////////////////////////////////////////////////////////////////////////////

	 public static void QuickSort(int arr[], int left, int right)
	    {
	        if (left < right)
	        {
	           int i = left;
	           int j = right;

	           // pivot als das mittlere Element auswaehlen
	           int pivot = arr[(left+right)/2];
	           // Solange Elemente zwischen left und right bound gibt, true
	           while( i <= j ) {

	        	 //@loop_invariant lower <= left && left <= right+1 && right+1 < upper;
	        	 //@loop_invariant ge_seg(pivot, A, lower, left);
	        	 //@loop_invariant le_seg(pivot, A, right+1, upper-1);

	        	   // Suche nach Elementen, die nicht in richtiger Positionen stehen

	        	   // Beginnend am Anfang des Arrays, Suche nach dem ersten Element der groesser-gleich als pivot
	        	   while( arr[i] < pivot ) {
	        		   i = i+1;
	        	   }
	        	   // Beginnend am Ende des Arrays, Suche nach dem ersten Element der kleiner-gleich als pivot
	        	   while( arr[j] > pivot) {
	        		   j = j-1;
	        	   }
	        	   // Die 2 gefundenen Elemente, die in der falschen Positionen stehen, tauschen
	        	   if( i <= j ) {

	        		   int temp = arr[i];
	        		   arr[i] = arr[j];
	        		   arr[j] = temp;
	        		   i = i+1;
	        		   j = j-1;

	        	   }

	           }
	           // Fortfahren mit der linken und rechten Haelfte
	        	QuickSort(arr, left, j);
	            QuickSort(arr, i, right);
	        }
	    }

/////////////////////////////////////////////////////////////////////////////////////////

	// Das ganze Array wird mit zufaelligen werten gefuellt.
	public static void fillRandom(int[] array) {

			Random rand = new Random();

			for( int x = 0; x < array.length; x++) {
				 // To a number between [0 - 49]  : rand.nextInt(50);
				array[x] = rand.nextInt();
			}

	}



/////////////////////////////////////////////////////////////////////////////////////////


	public static void main(String[] args) {

		int eingabe = 0;  // Array length speichern
		// Timer variablen für die Laufzeitmessung
		long mStartTime=0;
		long mStopTime=0;

		// Eingabe ueberprüfen. Falls keine Eingabe, dann Abbruch.
		// Jetzt darf man 1 bis 3 Parameter eingeben
		if( !( args.length == 1 ) )
	    {

			System.out.println("Parameter Fehler! Bitte 1 Parameter eingeben. (" + args.length +")");
	        System.exit(0);

	    }
		else {

			try { // Ob die Eingabe in integer konvertierbar ist

				eingabe = Integer.parseInt(args[0]);  // String eingabe in integer umwandeln
		        // Array groesse kann nur positiv sein
		        if( eingabe <= 0 ) {
		        	System.out.println("Bitte positive Zahl eingeben!");
		        	System.exit(0);
		        }

			}
			catch (NumberFormatException e) {
		        System.out.println("Bitte positive Zahl als erste Parameter eingeben!");
				System.exit(0);
		    }

			int[] intArray = new int[eingabe];  // Array deklarieren mit der Laenge "eingabe"
			fillRandom(intArray);  // Array zufaellig fuellen

			// Da alle Sortierungsmethoden das Array in place sortiert, geht die zufaellige Sortierung verloren
			// Daher das ursprungliche Array in eine zweite Array kopieren
			int intArray2[]=new int[intArray.length];
			for(int i=0;i<intArray.length;++i){
				intArray2[i]=intArray[i];
			}

			System.out.println("QuickSort laeuft..");
			mStartTime = System.currentTimeMillis();
			QuickSort(intArray, 0, intArray.length-1);
			isSorted(intArray);
			mStopTime = System.currentTimeMillis();
			long mMeasuredTimeQ = (long)mStopTime- (long)mStartTime;

			//isSorted(intArray);

			for(int i=0;i<intArray2.length;++i){  // Array widerherstellen
				intArray[i]=intArray2[i];
			}

    	mStartTime = System.currentTimeMillis();
			mergeSort(intArray);
			isSorted(intArray);
			mStopTime = System.currentTimeMillis();
			long mMeasuredTimeM = (long)mStopTime- (long)mStartTime;

			//isSorted(intArray);

			for(int i=0;i<intArray2.length;++i){
				intArray[i]=intArray2[i];
			}

			mStartTime = System.currentTimeMillis();
			insertionSort(intArray);
			isSorted(intArray);
			mStopTime = System.currentTimeMillis();
			long mMeasuredTimeI = (long)mStopTime- (long)mStartTime;

			// isSorted(intArray);

			System.out.println("  ** Ergebnis **");
			System.out.print("Quick Sort Laufzeit    : " + mMeasuredTimeQ +"\n");
			System.out.print("Merge Sort Laufzeit    : " + mMeasuredTimeM +"\n");
			System.out.print("Insertion Sort Laufzeit: " + mMeasuredTimeI +"\n");


		}

	}

}
