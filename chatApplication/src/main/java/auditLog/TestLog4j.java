package auditLog;
import java.io.IOException; 
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;



public class TestLog4j {
	private static final Logger log = Logger.getLogger(TestLog4j.class.getName());
	
		public static void main( String[] args ) throws IOException{
			PropertyConfigurator.configureAndWatch("log4j.test.properties");
			log.debug("Server gestartet");
		}
}
