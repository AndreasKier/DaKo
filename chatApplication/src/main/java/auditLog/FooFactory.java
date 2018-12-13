package auditLog;

import org.apache.commons.logging.Log; 
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;
public class FooFactory {

    private static Log LOG = LogFactory.getLog(FooFactory.class);
    
    public static Foo createFoo(int id, Double value) {
   	 
   	 LOG.debug("Creating a Foo");
   	 
   	 try {
   		 Foo foo = new Foo(id, value.doubleValue());
   		 
   		 LOG.debug("{}");
   		 
   		 return foo;
   		 
   	 } catch (Exception e) {
   		 LOG.error(e.getMessage(), e);
   	 }
   	
   	 return null;
   	
    }
    
    public static void main(String[] args) {
    	PropertyConfigurator.configureAndWatch("log4j.server.properties", 60 * 1000);
		
    	FooFactory.createFoo(1, Double.valueOf(33.0));
    	FooFactory.createFoo(2, null);
       
       }
    
    
    
}