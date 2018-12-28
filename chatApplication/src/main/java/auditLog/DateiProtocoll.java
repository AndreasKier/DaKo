package auditLog;

import java.io.*;
import java.util.*;
import java.text.*;

public class DateiProtocoll {

	public  void schreiben() {
		
		FileWriter writer;
		File file;
		
		//File anlegen
		file = new File("FileTest.txt");
		try {
			// falls die Datei bereits existiert werden die Bytes an das Ende der Datei geschrieben
			writer = new FileWriter(file, true);
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			
			//Zeitstemple
			writer.write(dateTimeInstance.format(Calendar.getInstance().getTime())+ "\t");
			
			//text wird in den Stream geschrieben
			writer.write(AuditLogPDU.getPduType()+ "\t");
			//writer.write(System.getProperty("line.separator"));
			
			writer.write(AuditLogPDU.getUserName()+ "\t");
			
			//if bedingungen: wenn das Event eine Message ist, dann auch die Message ausgeben
			if(even == messagesent) {
				writer.write(AuditLogPDU.getMessage()+ "\t");
			}
			
			writer.write("WorkerThreadsID\t");
			
			writer.write("ThreadID\t");
			
			
			//springt in die n‰chste Zeile (unabh‰ngig vom System)
			//writer.write(System.getProperty("line.separator"));
			
			writer.write(System.getProperty("line.separator"));
			writer.flush();
			
			//schlieﬂt FileWriter Stream
			writer.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
