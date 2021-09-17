
public class Job implements Comparable<Job>{

	int dauer;
	int deadline;
	
	public Job(int dauer, int deadline) {
		
		this.dauer = dauer;
		this.deadline = deadline;
		
	}
	
	public int getDauer() {	return this.dauer; }
	
	public int getDeadline() { return this.deadline;	}
	
	public String toString() {
		
		return ("[" + dauer +", " + deadline + "]");
		
	}
	
	@Override
	public int compareTo(Job other) {
		
		return (this.deadline - other.deadline);
		
	}
			
}
