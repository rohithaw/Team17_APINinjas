package lms.payload;

public class ProgramPojo {	
	
	String programDescription;
	String programName;
	String programStatus;
	
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramStatus() {
		return programStatus;
	}
	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}
	
    public ProgramPojo() {
		
	}
	
	
	public ProgramPojo(String programDescription,String programName,String programStatus)
	{
		setProgramDescription(programDescription);
		setProgramName(programName);
		setProgramStatus(programStatus);
	}	

}
