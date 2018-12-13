package edu.hm.dako.chat.server;

import java.io.IOException;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.Executors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hm.dako.chat.common.ImplementationType;
import edu.hm.dako.chat.connection.Connection;
import edu.hm.dako.chat.connection.LoggingConnectionDecorator;
import edu.hm.dako.chat.connection.ServerSocketInterface;
import edu.hm.dako.chat.tcp.TcpServerSocket;

/**
 * Uebernimmt die Konfiguration und Erzeugung bestimmter Server-Typen. 
 * @author Peter Mandl
 */
public final class ServerFactory {
	private static Log log = LogFactory.getLog(ServerFactory.class);
	
//	private static  InetSocketAddress adress; // TEST
	private Socket socket;	//TEST
	
	private ServerFactory() {
	}

	/**
	 * Erzeugt einen Chat-Server
	 * 
	 * @param implType
	 *          Implementierungytyp des Servers
	 * @param serverPort
	 *          Listenport
	 * @param sendBufferSize
	 *          Groesse des Sendepuffers in Byte
	 * @param receiveBufferSize
	 *          Groesse des Empfangspuffers in Byte
	 * @param serverGuiInterface
	 *          Referenz auf GUI fuer Callback
	 * @return
	 * @throws Exception
	 */
	//TEST
	
//	public ServerFactory(String hostname, int port) {
//		adress = new InetSocketAddress(hostname, port);
//	}
	// TEST
//	public void main(String[]args) throws Exception {
//		ServerFactory a = new ServerFactory("localhost", 50001);
//		a.sendMessage("HALLO");
//	}
	
	public static ChatServerInterface getServer(ImplementationType implType, int serverPort,
			int sendBufferSize, int receiveBufferSize,
			ChatServerGuiInterface serverGuiInterface) throws Exception {
		log.debug("ChatServer (" + implType.toString() + ") wird gestartet, Serverport: "
				+ serverPort + ", Sendepuffer: " + sendBufferSize + ", Empfangspuffer: "
				+ receiveBufferSize);
		System.out.println("ChatServer (" + implType.toString()
				+ ") wird gestartet, Listen-Port: " + serverPort + ", Sendepuffer: "
				+ sendBufferSize + ", Empfangspuffer: " + receiveBufferSize);

		switch (implType) {

		case TCPSimpleImplementation:

			try {
				TcpServerSocket tcpServerSocket = new TcpServerSocket(serverPort, sendBufferSize,
						receiveBufferSize);
				System.out.println("[Client] Verbindet zu Server"); // TEST
//				Socket socket = new Socket();
				Socket socket = new Socket("localhost", 50001);						// TEST
//				socket.connect(adress, 50001);						// TEST
				System.out.println("[Client] Verbunden :)");		// TEST
				socket.close();										//TEST
				return new SimpleChatServerImpl(Executors.newCachedThreadPool(),
						getDecoratedServerSocket(tcpServerSocket), serverGuiInterface);
				
				
			} catch (Exception e) {
				throw new Exception(e);
			}
			
			
//			
//		case TEST:
//			try {
//				System.out.println("[Client] Verbindet zu Server");
//				Socket socket = new Socket();
//				socket.connect(adress, 50001);
//				System.out.println("[Client] Verbunden :)");
//				
//				System.out.println("[Client] Sende Nachricht....");
//				PrintWriter pw = new PrintWriter (new OutputStreamWriter(socket.getOutputStream()));
//				pw.println("");
//				pw.flush();
//				System.out.println("[Client] Nachricht gesendet!!!");
//				
//				pw.close();
//				socket.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
			
			
		default:
			System.out.println("Dezeit nur TCP implementiert!");
			throw new RuntimeException("Unknown type: " + implType);
		}
	}

	private static ServerSocketInterface getDecoratedServerSocket(
			ServerSocketInterface serverSocket) {
		return new DecoratingServerSocket(serverSocket);
	}
	// TEST
//	public void sendMessage(String msg) throws Exception {
//		try {
//		System.out.println("[Client] Sende Nachricht....");
//		PrintWriter pw = new PrintWriter (new OutputStreamWriter(socket.getOutputStream()));
//		pw.println("");
//		pw.flush();
//		System.out.println("[Client] Nachricht gesendet!!!");
//		pw.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Dekoriert Server-Socket mit Logging-Funktionalitaet
	 * 
	 * @author mandl
	 *
	 */
	private static class DecoratingServerSocket implements ServerSocketInterface {

		private final ServerSocketInterface wrappedServerSocket;

		DecoratingServerSocket(ServerSocketInterface wrappedServerSocket) {
			this.wrappedServerSocket = wrappedServerSocket;
		}

		@Override
		public Connection accept() throws Exception {
			return new LoggingConnectionDecorator(wrappedServerSocket.accept());
		}
		
		//TEST
		public void connect(InetSocketAddress adress, int i) {
		}

		@Override
		public void close() throws Exception {
			wrappedServerSocket.close();
		}

		@Override
		public boolean isClosed() {
			return wrappedServerSocket.isClosed();
		}
	}
}
