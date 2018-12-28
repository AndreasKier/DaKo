package edu.hm.dako.chat.tcp;

import auditLog.AuditLogPDU;

// Evtl noch umbennen
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
	
	// Für die PDU zum verschicken von Nachrichten.
	public void run() {
		System.out.println(this.getName() + "gestartet");
		while (connect == true) {
			try {
				echo();
				
			}catch(Exception e) {
				try {
					System.out.println(this.getName() + ": Exception beim Empfangen ");
					con.close();
					connect = false;
				}catch(Exception e2) {
					connect = false;
				}
			}
		}
	}
	
	// PDU wird noch benötigt.
	private void echo() throws Exception{
		try {
			AuditLogPDU receivedPDU = (AuditLogPDU) con.receive();
			String message = receivedPDU.getMessage();
			con.send(receivedPDU);
		}catch(Exception e) {
			System.out.println("Exception beim Empfangen der Nachricht");
			connect = false;
			
		}
	}

}
