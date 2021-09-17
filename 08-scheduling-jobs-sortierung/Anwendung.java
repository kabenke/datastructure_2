import java.util.*;
import java.io.*;
import java.nio.file.*;


public class Anwendung {

	static int maxLateness = 0;  // Maximale Verspaetung bei Aufgabe 2

	// Erste Aufgabe Implementierung aus Vorlesung
	// Voraussetzung: Intervalls sind aufsteigend sortiert nach ihren Endpunkten
	public static ArrayList<Intervall> intervalScheduling(ArrayList<Intervall> intervals){

		// System.out.println("intervalScheduling Computing...");

		int n = intervals.size();
		ArrayList<Intervall> result = new ArrayList<Intervall>();

		result.add(intervals.get(0));

		int j = 0;

		for(int i = 1; i < n; i++) {

			if( intervals.get(i).start >= intervals.get(j).end ) {

				result.add( intervals.get(i) );
				j = i;

			}

		}

		return result;

	}


	// Zweite Aufgabe Implementierung
	// Voraussetzung: Jobs aufsteigend sortiert nach deadlines
	// Ausgabe: startzeitpunkte
	public static int[] latenessScheduling(ArrayList<Job> jobs) {

		int check = 0;
		int n = jobs.size();

		int[] result = new int[n];

		int z = 0;

		for( int i = 0; i<n; i++ ) {

			result[i] = z;
			z = z + jobs.get(i).dauer;

		}

		// Maximale Verspaetung berechnen
		for(int j = 0; j<n; j++) {

			check = (result[j] + jobs.get(j).dauer) - jobs.get(j).deadline;
			if( check >= maxLateness ) {  // Groesseren Wert gefunden
				maxLateness = check;
			}

		}

		return result;

	}


//////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) {

		// Eingabe "C:\\Users\\DoMeRaS\\Desktop\\Dap2 Praktikum\\vorlagenblatt06";
		// "C:/Users/DoMeRaS/Desktop/Dap2 Praktikum/vorlagenblatt06/datenBsp1.zahlen"
		String PATH = "";
		FileReader fr = null;


		// Erste Aufgabe, IntervalScheduling
		if( args.length == 1 ) {

		ArrayList<Intervall> array = new ArrayList<Intervall>();

			PATH = args[0];  // Erste Parameter ist der Datenpfad
			PATH = PATH.replace("\\", "/"); // Windows konvention / verwenden


			// Ueberpruefen ob die Datei ueberhaupt existiert
			try {
				fr = new FileReader(PATH);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        BufferedReader br  = new BufferedReader(fr);

			String line = "";
			String zeile = "";

			// Zeilen fuer Zeite die Datei lesen, solange es noch was zu lesen gibt
			try {
				zeile = br.readLine();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

      // Als token Komma ',' verwenden und in einer Zeile die 2 Werten aus der Datei holen
			// und ein Intervall mit diesen Werten bilden
			StringTokenizer st = new StringTokenizer(zeile,",");
			int start = Integer.parseInt(st.nextToken());
			int ende = Integer.parseInt(st.nextToken());
			Intervall ivall = new Intervall(start, ende);
			array.add(ivall);

//System.out.println("    Interval added: [" + start + ", " + ende + "]" );

	        try {
	        	while ((line = br.readLine())!= null){

//System.out.println("  Found Line in File: "+line);

	                StringTokenizer stToken = new StringTokenizer(line, ",");
	                while(stToken.hasMoreTokens()){
	                	// DELETE X
	                	start = Integer.parseInt(stToken.nextToken());
	                   	ende = Integer.parseInt(stToken.nextToken());
//System.out.println("  Start end End found as: " + start +", " + ende);
	                	Intervall ivall2 = new Intervall(start, ende);
	        			array.add(ivall2);
//System.out.println("    Interval added: [" + start + ", " + ende + "]" );

	                }
	        	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        Collections.sort(array);  // Nach Intervalendpunkten sortieren, damit der Algoritmus oben korrekt arbeitet

	        ArrayList<Intervall> result = intervalScheduling(array);
	        System.out.println("-------------------------");


          System.out.println("Es wurde "+array.size()+" Zeilen mit folgendem Inhalt gelesen");
          System.out.println((array));
	        // Sortiertes Array zeigen

	        System.out.println(" Sortiert : \n");
	        System.out.println(array);

	        // Ergebnis zeigen
			    System.out.println("Berechnetes Intervallscheduling : \n");
			    System.out.println(result);

		}

		/* Aufgabe 2, 2 Parameter:
		Erster Parameter soll ”Interval” oder ”Lateness” sein
		Zweiter soll der Dateipfad sein.
		 */
		else if( args.length == 2 ) {

			ArrayList<Job> array = new ArrayList<Job>();
			ArrayList<Intervall> interval = new ArrayList<Intervall>();

			String auswahl = "";

			 switch( args[0] ) {

			     case "Interval":
			    	 auswahl = "Interval";
			    	 break;
			     case "Lateness":
			    	 auswahl = "Lateness";
			    	 break;
			     default:
			    	 System.out.println("Undefinierter erster Parameter");
			    	 System.exit(0);


			 }

			 System.out.println("Auswahl: " + auswahl );

			 PATH = args[1];
			 PATH = PATH.replace("\\", "/");
       int count = 0;


       try {
         fr = new FileReader(PATH);
       } catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
         e.printStackTrace();
       }

       BufferedReader br  = new BufferedReader(fr);

				String line = "";

				int start=0;
				int ende =0;


//System.out.println("    Job added: [" + start + ", " + ende + "]" );  // Delete

		        try {
		        	while ((line = br.readLine())!= null){

//System.out.println("  Found Line in File: "+line);

		                StringTokenizer stToken = new StringTokenizer(line, ",");
		                while(stToken.hasMoreTokens()){
		                	// DELETE X
		                	start = Integer.parseInt(stToken.nextToken());
		                   	ende = Integer.parseInt(stToken.nextToken());

                        count ++;
//System.out.println("  Start end End found as: " + start +", " + ende);

		                   	if( auswahl.equalsIgnoreCase("Lateness") ) {

		    					Job ivall2 = new Job(start, ende);
		    					array.add(ivall2);
		    				}
		    				else {  // "Intervall"

		    					Intervall ivall2 = new Intervall(start, ende);
		    					interval.add(ivall2);

		    				}

//System.out.println("    Job added: [" + start + ", " + ende + "]" );

		                }
		        	}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

        ////////////////BEVOR JEDES AUSFÜHRUNG//////////////

         {

           System.out.println("-------------------------------------------------");

           System.out.print("Bearbeite Datei "+PATH);
           System.out.println("\n");

           System.out.println("Es wurden " +count +" Zeilen mit folgendem Inhalt gelesen\n");

           System.out.println(interval);

           }






       /////////////////////////AUSFÜHRUNG //////////////////////


       if( auswahl.equalsIgnoreCase("Lateness") ) {

		        	 Collections.sort(array);

    		       System.out.println("Sortiert : \n");
    					 System.out.println(array);

    					 int[] result = latenessScheduling(array);

    					 System.out.println("Berechnetes Intervallscheduling : \n");
    					 System.out.println(Arrays.toString(result));

    					 System.out.println("  Maximale Verspaetung: " + maxLateness);
    				}

				else {  // "Intervall"

					   Collections.sort(interval);
					   ArrayList<Intervall> result = intervalScheduling(interval);

				     // Sortiertes Array zeigen
				     System.out.println("Sortiert : ");
				     System.out.println(interval);

				     // Ergebnis zeigen
					 System.out.println("Berechnetes Intervallscheduling");
					 System.out.println(result);

				}


      System.out.println("-------------------------------------------------");


    }

		else {

			System.out.println("Parameteranzahl stimmt nicht: " + args.length);

		}
}

 }
