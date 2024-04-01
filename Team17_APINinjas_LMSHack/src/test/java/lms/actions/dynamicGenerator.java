package lms.actions;

public class dynamicGenerator {
	
	private static int counter = 102;
	
	public static String generateProgramName() {
        String baseProgName = "March24-ApINinjas-QA-";
        String paddedCounter = String.format("%03d", counter);
        counter++; 
        return baseProgName + paddedCounter;
    }

    public static String generatePhoneNumber(String baseNumber) {
        String paddedCounter = String.format("%03d", counter); // To ensure counter is 3 digits padded with zeros
        counter++; // To increment counter for the next call
        return baseNumber.replaceAll("xxx", paddedCounter);
    }
    
    public static String generateUserLoginEmail(String baseEmail) {
        String paddedCounter = String.format("%03d", counter); // To ensure counter is 3 digits padded with zeros
        counter++; // To increment counter for the next call
        return baseEmail.replaceAll("xxx", paddedCounter);
    }

    public static void resetCounter() {
        counter = 1; // Reset counter to 1 if and when needed
    } 
}