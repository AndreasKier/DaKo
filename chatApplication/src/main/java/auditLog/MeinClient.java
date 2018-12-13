package auditLog;

import java.io.IOException; 
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MeinClient {

	public static void main(String[]args) {
		MeinClient client = new MeinClient();
//		client.
//		client.sendMessage("ENDE");
	}
	
//	private InetSocketAddress adress;
	private ObjectInputStream  oIn;
	private ObjectOutputStream oOut;
	private boolean         IsItOpen = false; 
	private Socket socket;
	 
	
	 public void openCom( String sServerName, int iPortNumber ) throws UnknownHostException,IOException  {
		try {
		
			socket = new Socket(sServerName, iPortNumber);
//			socket.connect(sServerName, iPortNumber);   
			
			oOut = new ObjectOutputStream( socket.getOutputStream() );     
			
			oIn = new ObjectInputStream( socket.getInputStream());
			
			IsItOpen = true;
			} catch ( java.net.UnknownHostException e ) {
			System.err.println( "(openCom:)Don't know about host: "+sServerName );
			IsItOpen = false;
			throw( e );                                         
			} catch ( java.io.IOException e ) {
			System.err.println("(openCom:)Couldn't get I/O for the connection to: "+ sServerName );
			IsItOpen = false;
			throw( e );         
			}               
		}
	 
	 public boolean isItOpen()
	    {
	      return IsItOpen;
	    } 
	
	public void getServerData( MeinePDU tServData ) throws IOException
    {
       
        tServData.comData = "";
                
        try {
           tServData.copy( (MeinePDU) oIn.readObject() );
        }   
        catch ( ClassNotFoundException e ) {
            System.out.println( "Class Not Found" );
        } 
        System.out.println( "Server: " + tServData.comData );
        if ( tServData.comData.equals("BYE.") )
        {
            tServData.bExit = true;
        }        
     return;
    }
	
	 public void sendDataToServer( MeinePDU tServData ) throws IOException
	    {
	       
	        System.out.println( "Send: " + tServData.comData );
	        oOut.writeObject( tServData );
	     return;
	    } 
	   
	    public void closeCom() throws IOException
	    {
	        oOut.close();
	        oIn.close();
	        socket.close();
	        IsItOpen = false;
	    }    
	    
	    
		
//	public void sendMessage(String msg) {
//		
//		try {
//			System.out.println("[Client] Verbindet zu Server");
//			Socket socket = new Socket();
//			socket.connect(adress, 50001);
//			System.out.println("[Client] Verbunden :)");
//			
//			System.out.println("[Client] Sende Nachricht....");
//			PrintWriter pw = new PrintWriter (new OutputStreamWriter(socket.getOutputStream()));
//			pw.println(msg);
//			pw.flush();
//			System.out.println("[Client] Nachricht gesendet!!!");
//			
//			pw.close();
//			socket.close();
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
