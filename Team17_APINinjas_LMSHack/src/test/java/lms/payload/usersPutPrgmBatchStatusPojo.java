package lms.payload;
import java.util.ArrayList;
import java.util.List;
import com.beust.ah.A;
public class usersPutPrgmBatchStatusPojo {
	
	Integer programId;
	String roleId;
	usersPutPrgmBatchStatusPojo batchStatus;
	List<userRoleProgramBatchesPojo> userRoleProgramBatches;	
	
	
	
	public List<userRoleProgramBatchesPojo> getUserRoleProgramBatches() {
		return userRoleProgramBatches;
	}
	public void setUserRoleProgramBatches(List<userRoleProgramBatchesPojo> userRoleProgramBatches) {
		this.userRoleProgramBatches = userRoleProgramBatches;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public Integer getProgramId() {
		return programId;
	}
	public void setProgramId(Integer programId) {
		this.programId = programId;
	}
	
	public usersPutPrgmBatchStatusPojo() {
		
	}
	
	public usersPutPrgmBatchStatusPojo( Integer programid, Integer batchid, String roleid,   String userRoleProgramBatchStatus) {
		
		setProgramId(programid);
		setRoleId(roleid);
		userRoleProgramBatchesPojo batchStatus= new userRoleProgramBatchesPojo(batchid, userRoleProgramBatchStatus );
		List<userRoleProgramBatchesPojo> allBatches =  new ArrayList<>();
		allBatches.add(batchStatus);
//		for (userRoleProgramBatchesPojo all: allBatches){
//			System.out.println(all.getBatchId());
//			System.out.println(all.getUserRoleProgramBatchStatus() );
//		}
		
		setUserRoleProgramBatches(allBatches);
	}
}
