package lms.actions;

public class dynamicGenerator {
	
	private static int PositiveProgramcounter = 78;
	private static int PositiveBatchcounter = 37;
	private static int Negcounter = 8;
	
	public static String generateProgramName() {
        String baseProgName = "March24-ApINinjas-QA-";
        String paddedCounter = String.format("%03d", PositiveProgramcounter);
        PositiveProgramcounter++; 
        return baseProgName + paddedCounter;
    }

    public static String generateBatchName() {
    	String baseBatchName = "March24-ApINinjas-QA-QA1-";
        String paddedCounter = String.format("%03d", PositiveBatchcounter); // To ensure counter is 3 digits padded with zeros
        PositiveBatchcounter++; // To increment counter for the next call
        return baseBatchName + paddedCounter;
    }
    
    public static String generateBatchName(String baseName) {
        String paddedCounter = String.format("%03d", Negcounter); 
        Negcounter++;
        return baseName + paddedCounter;
    }

    public static void resetCounter() {
    	PositiveBatchcounter = 1;
    	PositiveProgramcounter = 1;
    	Negcounter = 1; // Reset counters to 1 if and when needed
    } 
}


