package it.salestaxes.receipt;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import org.apache.log4j.Logger;
import it.salestaxes.dto.ProductsDTO;

/**
 * @author m.sbrozzi
 * 
 * Execute xml file import
 * 
 * 20180919: class creation
 */
public class FileImporter {
	
	// Logger
	private static Logger logger = Logger.getLogger(FileImporter.class);
	
	// Constructor
	public FileImporter() {
		
	}

	/**
	 * Main file import process
	 * 
	 * @param input
	 * 
	 * @return ProductsDTO
	 */
	public ProductsDTO importFile(File input) {
		// Init
		ProductsDTO p = new ProductsDTO();
		
		try {
			// Try to import
			logger.info("Importing input file...");
			JAXBContext jaxbContext = JAXBContext.newInstance(ProductsDTO.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			logger.info("Unmarshalling file content...");
			p = (ProductsDTO) jaxbUnmarshaller.unmarshal(input);
		} catch (Exception e) {
			// Ops, something goes wrong
			logger.error("Errors occured while opening/processing input file: " + e);
		}
		
		// Return
		return p;
	}
	
}
