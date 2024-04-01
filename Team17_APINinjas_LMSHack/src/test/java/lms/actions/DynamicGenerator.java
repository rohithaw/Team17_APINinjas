package lms.actions;

public class DynamicGenerator {
	
private static int Positivecounter = 51;
private static int Negcounter = 6;
	
	public static String generateProgramName() {
        String baseProgName = "March24-APINinjas-QA-";
        String paddedCounter = String.format("%03d", Positivecounter);
        Positivecounter++; 
        return baseProgName + paddedCounter;
    }

	 public static String generateProgramName(String baseName) {
	        String paddedCounter = String.format("%03d", Negcounter); 
	        Negcounter++;
	        return baseName + paddedCounter;
	    }

	 public static void resetCounter() {
	    	Positivecounter = 1;
	    	Negcounter = 1; // Reset counters to 1 if and when needed
	    } 

}
