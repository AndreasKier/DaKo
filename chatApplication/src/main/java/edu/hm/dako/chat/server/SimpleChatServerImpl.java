package edu.hm.dako.chat.server;

import java.net.InetSocketAddress;
import java.net.InetSocketAddress;
import java.util.Vector; 
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.net.Socket;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import auditLog.AuditLogServer;
import edu.hm.dako.chat.common.ClientListEntry;
import edu.hm.dako.chat.common.ExceptionHandler;
import edu.hm.dako.chat.connection.Connection;
import edu.hm.dako.chat.connection.ServerSocketInterface;
import javafx.concurrent.Task;

/**
 * <p/>
 * Simple-Chat-Server-Implementierung
 *
 * @author Peter Mandl
 */
public class SimpleChatServerImpl extends AbstractChatServer {

	private static Log log = LogFactory.getLog(SimpleChatServerImpl.class);
	private static  InetSocketAddress adress; // TEST
	private static String schlieﬂen;
	
	// Threadpool fuer Worker-Threads
	private final ExecutorService executorService;

	// Socket fuer den Listener, der alle Verbindungsaufbauwuensche der Clients
	// entgegennimmt
	private ServerSocketInterface socket;

	/**
	 * Konstruktor
	 * 
	 * @param executorService
	 * @param socket
	 * @param serverGuiInterface
	 */
	public SimpleChatServerImpl(ExecutorService executorService,
			ServerSocketInterface socket, ChatServerGuiInterface serverGuiInterface) {
		log.debug("SimpleChatServerImpl konstruiert");
		this.executorService = executorService;
		this.socket = socket;
		this.serverGuiInterface = serverGuiInterface;
		counter = new SharedServerCounter();
		counter.logoutCounter = new AtomicInteger(0);
		counter.eventCounter = new AtomicInteger(0);
		counter.confirmCounter = new AtomicInteger(0);
	}
	// TEST
	public SimpleChatServerImpl(ExecutorService executorService, String hostname, int port) {
		this.executorService = executorService;
		adress = new InetSocketAddress(hostname, port);
	}
	

	@Override
	public void start() {
		Task<Void> task = new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				// Clientliste erzeugen
				clients = SharedChatClientList.getInstance();

				while (!Thread.currentThread().isInterrupted() && !socket.isClosed()) {
					try {
						// Auf ankommende Verbindungsaufbauwuensche warten
						System.out.println(
								"SimpleChatServer wartet auf Verbindungsanfragen von Clients...");

						Connection connection = socket.accept();
						
						socket.connect(adress, 50001); 		// TEST
						log.debug("Neuer Verbindungsaufbauwunsch empfangen");

						// Neuen Workerthread starten
						executorService.submit(new SimpleChatWorkerThreadImpl(connection, clients,
								counter, serverGuiInterface));
					} catch (Exception e) {
						if (socket.isClosed()) {
							log.debug("Socket wurde geschlossen");
						} else {
							log.error(
									"Exception beim Entgegennehmen von Verbindungsaufbauwuenschen: " + e);
							ExceptionHandler.logException(e);
						}
					}
				}
				return null;
			}
		};

		Thread th = new Thread(task);
		th.setDaemon(true);
		th.start();
	}
	
	

	@Override
	public void stop() throws Exception {

		// Alle Verbindungen zu aktiven Clients abbauen
		Vector<String> sendList = clients.getClientNameList();
		for (String s : new Vector<String>(sendList)) {
			ClientListEntry client = clients.getClient(s);
			try {
				if (client != null) {
					client.getConnection().close();
					log.error("Verbindung zu Client " + client.getUserName() + " geschlossen");
				}
			} catch (Exception e) {
				log.debug(
						"Fehler beim Schliessen der Verbindung zu Client " + client.getUserName());
				ExceptionHandler.logException(e);
			}
		}

		// Loeschen der Userliste
		clients.deleteAll();
		Thread.currentThread().interrupt();
		socket.close();
		log.debug("Listen-Socket geschlossen");
		executorService.shutdown();
		log.debug("Threadpool freigegeben");
		
		// test
		schlieﬂen = "SimpleChatServer beendet sich";
		System.out.println(schlieﬂen);
		
	}
	
	public static String getSchlieﬂen() {
		return schlieﬂen;
	}
	
	// Meine Tests ggf. Lˆschen!!!!!!!!!!!!
	
	
}