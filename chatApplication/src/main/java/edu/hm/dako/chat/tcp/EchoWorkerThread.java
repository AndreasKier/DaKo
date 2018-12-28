package edu.hm.dako.chat.tcp;

import auditLog.MeinePDU;

public class EchoWorkerThread extends Thread {
	
	private static int nrWorkerThread = 0;
	private TcpConnectionAudit con;
	private boolean connect;
	
	public EchoWorkerThread(TcpConnectionAudit con) {
		this.con = con;
		connect = true;
		nrWorkerThread++;
		this.setName("WorkerThread-" + nrWorkerThread);
	}
	
//	public void run() {
//		System.out.println(this.getName() + "gestartet");
//		while (connect == true) {
//			try {
////				echo();
//				
//			}catch(Exception e) {
//				try {
//					System.out.println(this.getName() + ": Exception beim Empfangen ");
//					con.close();
//					connect = false;
//				}catch(Exception e2) {
//					connect = false;
//				}
//			}
//		}
//	}
	
//	private void echo() throws Exception{
//		try {
//			MeinePDU receivedPDU =(MeinePDU) con.receive();
//			String message = receivedPDU.getMessage();
//			con.send(receivedPDU);
//		}catch(Exception e) {
//			System.out.println("Exception beim Empfangen der Nachricht");
//			
//		}
//	}

}
