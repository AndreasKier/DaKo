package edu.hm.dako.chat.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hm.dako.chat.connection.Connection;
import edu.hm.dako.chat.connection.ConnectionTimeoutException;
import edu.hm.dako.chat.connection.EndOfFileException;
import io.netty.handler.codec.serialization.ObjectDecoderInputStream;
import io.netty.handler.codec.serialization.ObjectEncoderOutputStream;

public class TcpConnectionAudit implements Connection{
	private ObjectEncoderOutputStream out;
	private ObjectDecoderInputStream in;
	private Socket socket;
	private static Log log = LogFactory.getLog(TcpConnectionAudit.class);
	

	public TcpConnectionAudit(Socket socket,
			boolean keepAlive, boolean TcpNoDelay) {
		this.socket = socket;

		log.debug(Thread.currentThread().getName()
				+ ": Verbindung mit neuem Client aufgebaut, Remote-TCP-Port " + socket.getPort());

		try {
			
			out = new ObjectEncoderOutputStream(socket.getOutputStream());
			in = new ObjectDecoderInputStream(socket.getInputStream());

			// out = new ObjectOutputStream(socket.getOutputStream());
			// in = new ObjectInputStream(socket.getInputStream());

			log.debug("Standardgroesse des Empfangspuffers der Verbindung: "
					+ socket.getReceiveBufferSize() + " Byte");
			log.debug("Standardgroesse des Sendepuffers der Verbindung: "
					+ socket.getSendBufferSize() + " Byte");
			
			log.debug("Eingestellte Groesse des Empfangspuffers der Verbindung: "
					+ socket.getReceiveBufferSize() + " Byte");
			log.debug("Eingestellte Groesse des Sendepuffers der Verbindung: "
					+ socket.getSendBufferSize() + " Byte");

			// TCP-Optionen einstellen
			socket.setTcpNoDelay(TcpNoDelay);
			// socket.setTcpNoDelay(false);
			socket.setKeepAlive(keepAlive);

			// TCP-Optionen ausgeben
			if (socket.getKeepAlive()) {
				log.debug("KeepAlive-Option ist fuer die Verbindung aktiviert");
			} else {
				log.debug("KeepAlive-Option ist fuer die Verbindung nicht aktiviert");
			}

			if (socket.getTcpNoDelay()) {
				log.debug("Nagle-Algorithmus ist fuer die Verbindung aktiviert");
			} else {
				log.debug("Nagle-Algorithmus ist fuer die Verbindung nicht aktiviert");
			}

		} catch (SocketException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	@Override
	public Serializable receive(int timeout)
			throws Exception, ConnectionTimeoutException, EndOfFileException {

		if (!socket.isConnected()) {
			log.debug("Empfangsversuch, obwohl Verbindung nicht mehr steht");
			throw new EndOfFileException(new Exception());
		}

		socket.setSoTimeout(timeout);

		try {
			Object message = in.readObject();
			socket.setSoTimeout(0);
			return (Serializable) message;

		} catch (java.net.SocketTimeoutException e) {
			throw new ConnectionTimeoutException(e);
		} catch (java.io.EOFException e) {
			log.debug("End of File beim Empfang");
			throw new EndOfFileException(e);
		} catch (Exception e) {
			log.debug("Vermutlich SocketException: " + e);
			throw new EndOfFileException(e);
		}
	}

	@Override
	public Serializable receive() throws Exception {

		if (!socket.isConnected()) {
			log.debug("Empfangsversuch, obwohl Verbindung nicht mehr steht");
			throw new EndOfFileException(new Exception());
		}
		try {
			socket.setSoTimeout(0);
			Object message = in.readObject();
			return (Serializable) message;
		} catch (Exception e) {
			log.debug("Exception beim Empfang " + socket.getInetAddress());
			log.debug(e.getMessage());
			throw new IOException();
		}
	}

	@Override
	public void send(Serializable message) throws Exception {

		if (socket.isClosed()) {
			log.debug("Sendeversuch, obwohl Socket geschlossen ist");
			throw new IOException();
		}
		if (!socket.isConnected()) {
			log.debug("Sendeversuch, obwohl Verbindung nicht mehr steht");
			throw new IOException();
		}

		try {
			out.writeObject(message);
			out.flush();
		} catch (Exception e) {
			log.debug("Exception beim Sendeversuch an " + socket.getInetAddress());
			log.debug(e.getMessage());
			throw new IOException();
		}
	}

	@Override
	public synchronized void close() throws IOException {
		try {
			out.flush();
			log.debug("Verbindungssocket wird geschlossen, lokaler Port: "
					+ socket.getLocalPort() + ", entfernter Port: " + socket.getPort());
			socket.close();
		} catch (Exception e) {
			log.debug("Exception beim Verbindungsabbau " + socket.getInetAddress());
			log.debug(e.getMessage());
			throw new IOException(new IOException());
		}
	}
		
}
