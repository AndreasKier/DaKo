//package auditLog;
//
//public class MeinProtokoll {
//	 private static final int COM_STATUS_WAITING    = 0; 
//	  private static final int COM_STATUS_READY_SENT = 1;
//	  private static final int COM_STATUS_DATA_SENT  = 2;
//	  private static final int COM_STATUS_WAITING_FOR_TERMINALID = 3;
//	  private int state = COM_STATUS_WAITING;
//	  private int iRet = 0;
//
//	
//	  public MeinProtokoll(){
//	     int    iRet = 0;
//	  
//	        
//	    }
//	  
//	  public MeinePDU processInput( MeinePDU theInput )
//	    {
//	    MeinePDU theOutput;
//	      
//	        theOutput = new MeinePDU();
//	      
//	        if ( theInput != null ) 
//	        {
//	            if ( theInput.comData.equals("!BYE.@") )
//	            {
//	        
//	                theOutput.comData = "BYE.";
//	        
//	                theOutput.bExit = true;
//	        
//	                state = COM_STATUS_WAITING;
//	        
//	                return theOutput;
//	            }
//	            if ( theInput.comData.equals("!SHUTDOWN.@") )
//	            {
//	        
//	                theOutput.comData = "BYE.";
//	        
//	                theOutput.bExit = true;
//	        
//	                MeinServer.GL_listening = false;
//	        
//	                state = COM_STATUS_WAITING;
//	        
//	                return theOutput;
//	            }
//	        }
//	        if ( state == COM_STATUS_WAITING )
//	        {
//	        
//	            theOutput.comData = "Ready:";
//	        
//	            state = COM_STATUS_WAITING_FOR_TERMINALID;
//	        }
//	        else if ( state == COM_STATUS_WAITING_FOR_TERMINALID )
//	        {
//	         int iRet;
//	           
////	            sTermId = theInput.comData; 
//	            
//	            theOutput.comData = "Ready;Server Version 1.0:";
//	            
//	            state = COM_STATUS_READY_SENT;
//	        }
//	        else if ( state == COM_STATUS_READY_SENT )
//	        {
//	         int iRet = 0;
//	            String sCommand = theInput.comData;
//	            
//	            if ( theInput.iRet == MeinePDU.NOWAIT_FOR_RESPONSE ) {
//	                
//	                theOutput.iRet = iRet;
//	                theOutput.comData = "";
//	            }
//	            else {
//	               
//	               
//	                theOutput.iRet       = iRet;
//	            }
//	        }
//	     return theOutput;
//	    }  
//}
//
