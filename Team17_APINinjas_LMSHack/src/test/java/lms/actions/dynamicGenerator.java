package lms.actions;

public class dynamicGenerator {
	
	private static int PositiveProgramcounter =15;
	private static int PositiveBatchcounter = 15;
	private static int UserPhonecounter = 5;
	private static int UserEmailcounter = 100;
	private static int Negcounter = 18;
	
	
	public static String generateProgramName() {
        String baseProgName = "March24-ApiNinjas-QA1-";
        String paddedCounter = String.format("%03d", PositiveProgramcounter);
        PositiveProgramcounter++; 
        return baseProgName + paddedCounter;
    }

    public static String generateBatchName() {
    	String baseBatchName = "March24-ApiNinjas-QA1-QA01-";
        String paddedCounter = String.format("%03d", PositiveBatchcounter); // To ensure counter is 3 digits padded with zeros
        PositiveBatchcounter++; // To increment counter for the next call
        return baseBatchName + paddedCounter;
    }
    
    public static String generateBatchName(String baseName) {
        String paddedCounter = String.format("%03d", Negcounter); 
        Negcounter++;
        return baseName + paddedCounter;
    }
    
    public static String generatePhoneNumber(String baseNumber) {
        String paddedCounter = String.format("%03d", UserPhonecounter); // To ensure counter is 3 digits padded with zeros
        UserPhonecounter++; // To increment counter for the next call
        return baseNumber.replaceAll("xxx", paddedCounter);
    }
    public static String generateUserLoginEmail(String baseEmail) {
        String paddedCounter = String.format("%03d", UserEmailcounter); // To ensure counter is 3 digits padded with zeros
        UserEmailcounter++; // To increment counter for the next call
        return baseEmail.replaceAll("xxx", paddedCounter);
    }

    public static void resetCounter() {
    	PositiveBatchcounter = 1;
    	PositiveProgramcounter = 1;
    	UserEmailcounter = 1;
    	UserPhonecounter = 1;
    	Negcounter = 1; // Reset counters to 1 if and when needed
    } 
}


