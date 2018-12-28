package auditLog;

import java.io.Serializable;

public class MeinePDU implements Serializable {
	
	
	private static final long serialVersionUID = 612779453919320994L;
	public String comData;
	public boolean bExit;
	public int iRet;
	
	static final int WAIT_FOR_RESPONSE    = 0;
    static final int NOWAIT_FOR_RESPONSE  = 1;
	
	public MeinePDU() {
		comData = "";
		bExit = false;
		iRet = 0;
	}
	// TEST
	public String getMessage() {
		return comData;
	}
	
	public void copy(MeinePDU tSrc) {
		
		this.comData = tSrc.comData;
		this.bExit = tSrc.bExit;
		this.iRet = tSrc.iRet;
	}

}
