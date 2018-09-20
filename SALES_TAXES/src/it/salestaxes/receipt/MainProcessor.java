package it.salestaxes.receipt;

import it.salestaxes.dto.ProductsDTO;
import java.io.File;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * @author m.sbrozzi
 *
 * Main process
 * 
 * 20180919: class creation
 */
public class MainProcessor {
	
	// Logger
	private static Logger logger = Logger.getLogger(MainProcessor.class);
	
	/**
	 * Main process method
	 * 
	 * @param args
	 * 
	 * @return int
	 */
	public int execute(String[] args) {
		// Init
		StringBuffer receipt;
		ProductsDTO products;
		
		try {
			// Getting input parameters
			logger.info("Checking input parameters...");
			if (args != null && args.length > 0) {
				logger.info("Input parameter detected: ");
				for (int i=0; i<args.length; i++) {
					logger.debug("*** [" + i + "] " + args[i]);
				}
			}
			
			// Run for each input file
			int processed = 0;
			int success = 0;
			int errors = 0;
			for (int i=0; i<args.length; i++) {
				// Get current file
				processed++;
				String filename = args[i];
				logger.info("Processing input file: " + filename);
				
				// Checking input parameters
				logger.info("Checking input file...");
				File file = new File(filename);
				if (file == null || !file.exists() || !file.isFile() || !file.canRead()) {
					errors++;
					logger.warn("Input file not valid, skipped!");
					break;
				}
				
				// Open xml file
				logger.info("Processing input file...");
				FileImporter fi = new FileImporter();
				products = fi.importFile(new File(filename));
				logger.debug("*** PRODUCTS: " + Constants.LINE_SEPARATOR + products);
				
				// Process xml file
				logger.info("Processing output receipt...");
				ReceiptPrinter rp = new ReceiptPrinter();
				receipt = rp.process(products);
				logger.debug("*** RECEIPT: " + Constants.LINE_SEPARATOR + receipt);
				success++;
			}

			// End
			logger.info("Total file processed: " + processed + ", success: " + success + ", errors: " + errors);
		} catch (Exception e) {
			// Return errors
			logger.error("Errors occured in main process: " + e);
			return 1;
		}
		
		// Return ok
		return 0;
	}
	
	/**
	 * START MAIN
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Log
		long start = new Date().getTime();
		logger.info("Main process started!");

		// Launch main process
		MainProcessor mp = new MainProcessor();
		int result = mp.execute(args);
		
		// End
		long stop = new Date().getTime();
		logger.info("Main process ended in " + (stop-start) + " milliseconds, with result code: " + result);
	}
	
}
