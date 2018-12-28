package auditLog;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import edu.hm.dako.chat.tcp.EchoWorkerThread;
import edu.hm.dako.chat.tcp.TcpConnection;
import edu.hm.dako.chat.tcp.TcpConnectionAudit;
import edu.hm.dako.chat.tcp.TcpServerSocket;
import edu.hm.dako.chat.tcp.TcpServerSocketAudit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuditLogServer {
	TcpServerSocketAudit serverSocket = null;
	TcpConnectionAudit con = null;
	
	public static void main (String [] args) {
		System.out.println("Server gestartet");
		AuditLogServer server = new AuditLogServer();
		try {
			server.createSocket();
		}catch(Exception e) {
			System.out.println("Fehler beim erzeugen des Sockets");
			System.exit(1);
		}
	

	// AuditLog ist solange geöffnet wie die Bedingung true ist.
	boolean listening = true;
	while (listening) {
		try {
			System.out.println("Server wartet auf Verbindung...");
			TcpConnectionAudit con = server.waitForConnection();
			EchoWorkerThread ewt = new EchoWorkerThread(con);
			ewt.start();
		}catch(Exception e) {
			System.out.println("Exception beim WorkerThread");
			listening = false;
			server.close();
			}
		}
	
	}
	
	// Erstellt ein neues Socket.
	private void createSocket(){
		try {
			serverSocket = new TcpServerSocketAudit(50001);
		}catch(Exception e) {
			System.out.println("Fehler bei einem neuem Socket");
		}
	}
	
	// Wartet daruaf das eine Verbindung akzeptiert wird.
	private TcpConnectionAudit waitForConnection() throws Exception {
		try {
			TcpConnectionAudit con = (TcpConnectionAudit) serverSocket.accept();
			System.out.println("Verbindung ok");
			return (con);
		}catch(Exception e) {
			// brauchen anderen return type hab aber keine ahnung....
			throw new Exception();
		}
	}
	
	// Schließt die Verbindung.
	private void close() {
		try {
			con.close();
			System.out.println("Verbindung geschlossen");
		}catch (Exception e) {
			System.out.println("Fehler beim schließen der Verbindung");
		}
	}
	
}
//	private int port;
//	private ServerSocket serverSocket;
//	
//	public AuditLogServer(int port) {
//		this.port = port;
//	}
//	//TEST134565
//	//Dadfadf
//	public void startListening() throws IOException {
//		new Thread(new Runnable() {
//			
//			public void run() {
//				
//				
//				// Ist ein Test
//				// Abbruchbedingung "GUI ordnungsgemaess beendet"
//				while(true) {
//					
//					try {
//						System.out.println("[AUDIT] Server gestartet");
//						ServerSocket serverSocket = new ServerSocket(50001);
//						System.out.println("[AUDIT] Warten auf Verbindung...");
//						Socket remoteClientSocket = serverSocket.accept();
//						System.out.println("[AUDIT] Client verbunden");
//						
//							Scanner s = new Scanner (new BufferedReader(new InputStreamReader(remoteClientSocket.getInputStream())));
//						if(s.hasNextLine()) {
//							System.out.println("[AUDIT] Neue Nachricht von der GUI \n" + s.nextLine());
//						}
//						serverSocket.close();
//						s.close();
//						remoteClientSocket.close();
//						
//					}catch(Exception e) {
//						e.printStackTrace();
//						System.exit(1);
//					}
//				}
//			}
//		}).start();
//	}
//	
//		
//		public static void main (String[]args)throws IOException{
//		AuditLogServer server = new AuditLogServer(50001);
//		server.startListening();
//		}

