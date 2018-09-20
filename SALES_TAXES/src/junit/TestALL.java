package junit;

import static org.junit.Assert.assertEquals;
import it.salestaxes.receipt.MainProcessor;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author m.sbrozzi
 * 
 * JUnit test
 * 
 * 20180919: class creation
 */
public class TestALL {
	
	// Logger
	private static Logger logger = Logger.getLogger(TestALL.class);

	@Test
    public void processTest01() {
		
		// Init
		int result;
        String[] arguments;
        
		// Test INPUT 01
        arguments = new String[] {"./input/Input01.xml", "./input/Input02.xml", "./input/Input03.xml"};
		result = new MainProcessor().execute(arguments);
        assertEquals(result, 0);
        logger.info("***** TEST01 OK!");

		// Test INPUT 02
        arguments = new String[] {"./input/Input02.xml"};
		result = new MainProcessor().execute(arguments);
        assertEquals(result, 0);
        logger.info("***** TEST02 OK!");

		// Test INPUT 03
        arguments = new String[] {"./input/Input03.xml"};
		result = new MainProcessor().execute(arguments);
        assertEquals(result, 0);
        logger.info("***** TEST03 OK!");

    }
	
}
