package auditLog;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MeinThread extends Thread {
	
	private Socket socket = null;
    MeinePDU tDataFromClient;
    MeinePDU tDataToClient; 
    ObjectInputStream oIn;
    ObjectOutputStream oOut;
    
    public MeinThread( Socket socket )
    {
       super( "MeinServerThread" );
       this.socket = socket;
    } 
    
    public void run()
    {
       try {
    
          oOut = new ObjectOutputStream( socket.getOutputStream() );
          
          oIn  = new ObjectInputStream( socket.getInputStream() );
         
          MeinProtokoll comp = new MeinProtokoll();
          
          tDataToClient  = comp.processInput( null );
          sendDataToClient( tDataToClient, oOut );
         
          while ( true )
          {
             try {
                tDataFromClient = getDataFromClient( oIn );
                
                tDataToClient = comp.processInput( tDataFromClient );
                
                sendDataToClient( tDataToClient, oOut );
             }
             catch ( EOFException e ) {
                System.out.println( "Client Disconnected, Bye, Bye" );
                break;
             }
           
             if ( tDataToClient.bExit )
             {
                System.out.println( "Client said Bye. Bye" );
                break;
             }
          }
         
          
          oOut.close();
          oIn.close();
          socket.close();
       } catch ( IOException e ) {
        e.printStackTrace();
       }
    } 
    private static MeinePDU getDataFromClient( ObjectInputStream oIn ) throws IOException                                                                         
    {
        MeinePDU  tDataFromClient = null;         
        
          tDataFromClient = new MeinePDU();
        while ( tDataFromClient == null )
        {
           try {
             
              tDataFromClient = (MeinePDU) oIn.readObject();
           } catch ( ClassNotFoundException e ) {
               System.out.println( "ClassNotFound" );
           }
        }
        System.out.println( "Get: " + tDataFromClient.comData );
     return tDataFromClient;
    } 
    private static void sendDataToClient(MeinePDU tDataToClient,
                                           ObjectOutputStream  oOut ) throws IOException
    {         
        System.out.println( "Sent: " + tDataToClient.comData );
        oOut.writeObject( tDataToClient );
      return;
    } 

}
