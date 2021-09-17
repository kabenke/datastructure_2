import java.util.*;

public class BubbleSort {

	static long time = 0;  // Comment out

	// Implementierung von BubbleSort
	public static void bubbleSort(int[] arr) {

		System.out.print("  BubbleSort Processing");    // Comment out

		int n = arr.length;
        for (int i = 0; i < n-1; i++){

        	// Anzeigen dass das Programm noch laeuft
    		long time2 = System.currentTimeMillis();   // Comment out
			long dif = time2 - time;                   // Comment out
			if(dif>=1000) {                            // Comment out

				time = System.currentTimeMillis();     // Comment out
				System.out.print(".");                 // Comment out

			}                                          // Comment out


        	for (int j = 0; j < n-i-1; j++){


        		if (arr[j] > arr[j+1])
                {
                    // swap arr[j+1] and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
        	}
        }

        System.out.println();                           // Comment out

	}

	// Das ganze Array wird erst mit zufaelligen werten gefüllt.
	// Dann werden diese Werte absteigend sortiert.
	public static void fillDescending(int[] array) { // absteigend

		Random rand = new Random();

		for( int x = 0; x < array.length; x++) {
			// To a number between [0 - 49]  : rand.nextInt(50);
			array[array.length-1-x] = rand.nextInt();
		}

		Arrays.sort(array);

		reverse(array);  // von aufsteigen zu absteigende Sortierung wechseln

	}

	// Hilfsmethode für absteigende Befüllung/Sortierung
	// Ausgeführt nachdem das Array aufsteigend sortiert ist
	public static void reverse(int[] input) {  // Array elemente umkehren

		int last = input.length - 1;
		int middle = input.length / 2;
		for (int i = 0; i <= middle; i++) {
				int temp = input[i];
					input[i] = input[last - i];
						input[last - i] = temp;
		}
	}

	public static void main(String[] args) {

		float eingabeSekunden = 0f; // Parameter speichern (Zeit in Sekunden)

		// Timer variablen für die Methode
		long mStartTime = 0;
		long mStopTime = 0;
		long Seconds = 0;

		int arrayLength = 50000;
		int[] lastTwoArrayLength = new int[2];  // Letzte 2 gefundene Array Größe speichern

		// Keine Eingabe (Erste Aufgabe)
		if( ( args.length == 0 ) )
	    {

			System.out.println("  (Kein Parameter erkannt)");

			int[] array = new int[arrayLength]; // = 50000
			System.out.println("Array length: " + arrayLength);
			System.out.println("***Absteigend Füllen***");
			fillDescending(array);
			time = System.currentTimeMillis();  // Comment out

			// Laufzeitmessung
			mStartTime = System.currentTimeMillis();

			bubbleSort(array);

			mStopTime = System.currentTimeMillis();

			long mMeasuredTime = (long)mStopTime- (long)mStartTime ;
			Seconds = mMeasuredTime/1000;  // Milisekunden nach Sekunden umwandeln

			// Zeitangaben
			System.out.println("Benötigte Zeit für die Methode(in Sekunden): " + (long)Seconds);
			System.out.println("Benötigte Zeit für die Methode(in Milisekunden): " + (long)mMeasuredTime);
			System.exit(0);
		}
		// Falls es Eingabe gibt
		else if( args.length == 1 ){

			System.out.println("Eingabe: " + args[0]);

			try { // Ob die erste Eingabe in float konvertierbar ist
				//  replaceAll methode sorgt dafür, dass alle Kommas zu Punkte wechseln.
				//  Da es keine Internationale Notation für Trennzeichen in gleitkommazahlen gibt (Decimal separator)
				//  Hinweis: 4f und 4F sind akzeptierte Eingaben
				eingabeSekunden = Float.parseFloat(args[0].replaceAll(",","."));
				// Zeiteingabe muss größer 0 sein
		        if( eingabeSekunden <= 0 ) {
		        	System.out.println("Bitte positive Zahl als Parameter eingeben!" + "("+args[0]+")");
		        	System.exit(0);
		        }
			}
			catch (NumberFormatException e) {
		        System.out.println("Eingabe ist nich in Float konvertierbar " + "("+args[0]+")");
				System.exit(0);
		    }

			// *********************************************

			arrayLength = 500; // Anfangswert(Array Laenge) aus dem Blatt

			int i = 0;  // index wert vom naechsten zu specihernden arrayLength [0-1]
			int k = 0;  // do-while Schleife Iteration

			do {

				k++;

				// Es könnte vorkommen, dass der Benutzer eine zu lange Zeitdauer eingegeben hat,
				// sodass arrayLength variable (endlos) bei jeder Iteration immer wieder dupliziert wird
				// dann wird irgendwann mal die Integer Grenze überschritten. Dafür Overflow check mit logischem Ausdruck
				int toCheck = arrayLength + arrayLength;

				if(	((arrayLength & arrayLength & ~toCheck) | (~arrayLength & ~arrayLength & toCheck)) < 0 ) {
					System.out.println("Integer Overflow");
					System.exit(0);
				}

				//arrayLength=toCheck;

				arrayLength*=2;  // Wird 1000 beim Eintreten

				i %=2;
				lastTwoArrayLength[i++] = arrayLength;  // letzte berechnete Array length

				System.out.println("---- Iteration: " + k +" ----");
				System.out.println("  Array Length: " + arrayLength);
				int[] array = new int[arrayLength];
				System.out.println("  (Absteigend Füllen) ");
				fillDescending(array);

				time = System.currentTimeMillis();       // Comment out
				mStartTime = System.currentTimeMillis();

				bubbleSort(array);  // Sortierungsmethode

				mStopTime = System.currentTimeMillis();

				long mMeasuredTime = (long)mStopTime- (long)mStartTime ;
				Seconds = mMeasuredTime/1000;

				// Zeitangaben
				System.out.println("    Benötigte Zeit für die Methode(in Sekunden): " + (long)Seconds);
				System.out.println("    Benötigte Zeit für die Methode(in Milisekunden): " + (long)mMeasuredTime);

				array = null; // Für garbage collector

				System.gc(); // garbage collector explizit rufen, damit die Sortierungsmethode am wenigsten davon verlangsamt wird


			}while( Seconds < eingabeSekunden );


			// Das Endergebnis/gefundene Array Größe zeigen
			System.out.println();
			System.out.println("    ***FINISH*** ");
			System.out.println();
			System.out.println("  Gefundene Array Größe: " + arrayLength);
			System.out.println("  Eingabe war: " + eingabeSekunden);
			System.out.println("  Letzte BubbleSort Dauer(in Sekunden): " + (long)Seconds);

		}
		else { // Parameter Anzahl stimmt nicht

			System.out.println("Parameter Fehler!");
			System.exit(0);

		}

	}

}
