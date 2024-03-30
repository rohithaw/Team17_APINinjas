package lms.actions;

public class dynamicGenerator {
	
	private static int Positivecounter = 31;
	private static int Negcounter = 6;
	
	public static String generateProgramName() {
        String baseProgName = "March24-ApINinjas-QA-";
        String paddedCounter = String.format("%03d", Positivecounter);
        Positivecounter++; 
        return baseProgName + paddedCounter;
    }

    public static String generateBatchName() {
    	String baseBatchName = "March24-ApINinjas-QA-QA1-";
        String paddedCounter = String.format("%03d", Positivecounter); // To ensure counter is 3 digits padded with zeros
        Positivecounter++; // To increment counter for the next call
        return baseBatchName + paddedCounter;
    }
    
    public static String generateBatchName(String baseName) {
        String paddedCounter = String.format("%03d", Negcounter); 
        Negcounter++;
        return baseName + paddedCounter;
    }

    public static void resetCounter() {
    	Positivecounter = 1;
    	Negcounter = 1; // Reset counters to 1 if and when needed
    } 
}


