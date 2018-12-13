
package auditLog;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/**
 * @author Andreas
 *
 */
public class Log4 {

	private static final Logger log = Logger.getLogger(Log4.class);
	public static void main(String[] args) {
		PropertyConfigurator.configureAndWatch("log4j.test.properties");
		log.debug("Test Message");
	}

}
