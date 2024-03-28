package lms.payload;

public class BatchPojo {

	String batchDescription;
	String batchName;
	int batchNoOfClasses;
	String batchStatus;
	int programId;

	public BatchPojo() {

	}

	public BatchPojo(String bDesc,String bName,int classes,String status,int id) {
		setBatchDescription(bDesc);
		setBatchName(bName);
		setBatchNoOfClasses(classes);
		setBatchStatus(status);
		setProgramId(id);
	}

	public String getBatchDescription() {
		return batchDescription;
	}

	public void setBatchDescription(String batchDescription) {
		this.batchDescription = batchDescription;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public int getBatchNoOfClasses() {
		return batchNoOfClasses;
	}

	public void setBatchNoOfClasses(int batchNoOfClasses) {
		this.batchNoOfClasses = batchNoOfClasses;
	}

	public String getBatchStatus() {
		return batchStatus;
	}

	public void setBatchStatus(String batchStatus) {
		this.batchStatus = batchStatus;
	}

	public int getProgramId() {
		return programId;
	}

	public void setProgramId(int programId) {
		this.programId = programId;
	}
	

}
