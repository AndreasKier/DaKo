package auditLog;

import java.io.*;
import java.util.*;

import edu.hm.dako.chat.common.PduType;

import java.text.*;

public class DateiProtocoll {

	public void schreiben(AuditLogPDU pdu) {
		
		FileWriter writer;
		File file;
		
		//File anlegen
		file = new File("ChatProtocoll.txt");
		try {
			
			
			// falls die Datei bereits existiert werden die Bytes an das Ende der Datei geschrieben
			writer = new FileWriter(file, true);
			
			//Daten für das Protokoll
			DateFormat dateTimeInstance = SimpleDateFormat.getDateTimeInstance();
			
			PduType Type = (AuditLogPDU.getPduType());
			String pduType = Type.toString();
			String userName = AuditLogPDU.getUserName();
			String time = dateTimeInstance.format(Calendar.getInstance().getTime());
			String message; 
			if(Type.equals(PduType.CHAT_MESSAGE_EVENT)) {
				message = AuditLogPDU.getMessage();
			} else
				message = ""; 
			
			String formatStr = "%-20s %-20s %-10s %-25s %-8s %-8s";
			writer.write(String.format(formatStr, time, pduType, userName, message, "WTID", "TID"));
			
//			//Zeitstemple
//			writer.write(time+ "\t");
//			
//			//text wird in den Stream geschrieben
//			writer.write(pduType + "\t");
//			//writer.write(System.getProperty("line.separator"));
//			
//			writer.write(userName+ "\t");
//			
//			//if bedingungen: wenn das Event eine Message ist, dann auch die Message ausgeben
//			if(pduType.equals(PduType.CHAT_MESSAGE_EVENT)) {
////			if(AuditLogPDU.getPduType() == PduType.CHAT_MESSAGE_REQUEST) {	
//				writer.write(message + "\t");
//			}
//			else {
//				writer.write(" "+ "\t");
//			}
//			
//			writer.write("WorkerThreadsID\t");
//			
//			writer.write("ThreadID\t");
//			
//			
//			//springt in die nächste Zeile (unabhängig vom System)
//			//writer.write(System.getProperty("line.separator"));
//			
			writer.write(System.getProperty("line.separator"));
			writer.flush();
			
			//schließt FileWriter Stream
			writer.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
