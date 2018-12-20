package auditLog;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AuditLogServer {
	private int port;
	private ServerSocket serverSocket;
	
	public AuditLogServer(int port) {
		this.port = port;
	}
	//TEST134565
	//Dadfadf
	public void startListening() throws IOException {
		new Thread(new Runnable() {
			
			public void run() {
				
				
				// Ist ein Test
				// Abbruchbedingung "GUI ordnungsgemaess beendet"
				while(true) {
					
					try {
						System.out.println("[AUDIT] Server gestartet");
						ServerSocket serverSocket = new ServerSocket(50001);
						System.out.println("[AUDIT] Warten auf Verbindung...");
						Socket remoteClientSocket = serverSocket.accept();
						System.out.println("[AUDIT] Client verbunden");
						
							Scanner s = new Scanner (new BufferedReader(new InputStreamReader(remoteClientSocket.getInputStream())));
						if(s.hasNextLine()) {
							System.out.println("[AUDIT] Neue Nachricht von der GUI \n" + s.nextLine());
						}
						serverSocket.close();
						s.close();
						remoteClientSocket.close();
						
					}catch(Exception e) {
						e.printStackTrace();
						System.exit(1);
					}
				}
			}
		}).start();
	}
	
		
		public static void main (String[]args)throws IOException{
		AuditLogServer server = new AuditLogServer(50001);
		server.startListening();
		}
}
