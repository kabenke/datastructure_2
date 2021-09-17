public class Intervall implements Comparable<Intervall>{

	int start;
	int end;
	
	// Konstruktor
	public Intervall(int start, int end) {
		
		this.start = start;
		this.end = end;
		
	}
	
	// Getter Methods
	public int getStart() {	return this.start; }
	
	public int getEnd() { return this.end;	}
	
	// die eine geeignete String-Repräsentation des	Intervals
	public String toString() {
				
		return ("[" + start +", " + end + "]");
		
	}
		
	@Override
	public int compareTo(Intervall other) {  // Nach endpunkten sortieren
		
		return (this.end - other.end);
	}
	
}
