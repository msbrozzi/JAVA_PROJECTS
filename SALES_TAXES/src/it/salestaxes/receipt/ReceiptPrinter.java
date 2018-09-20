package it.salestaxes.receipt;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.log4j.Logger;
import it.salestaxes.dto.ProductDTO;
import it.salestaxes.dto.ProductsDTO;

/**
 * @author m.sbrozzi
 * 
 * Execute receipt processing
 * 
 * 20180919: class creation
 */
public class ReceiptPrinter {

	// Logger
	private static Logger logger = Logger.getLogger(ReceiptPrinter.class);
	
	// Constructor
	public ReceiptPrinter() {
		super();
	}
	
	/**
	 * Main receipt printer process
	 * 
	 * @param products
	 * 
	 * @return StringBuffer
	 */
	public StringBuffer process(ProductsDTO products) {
		// Init
		StringBuffer sb = new StringBuffer();
		logger.info("Starting receipt processing...");

		// Process receipt building
		double totalTaxes = 0;
		double totalPrice = 0;
		if (products != null && products.getProducts() != null) {
			for (ProductDTO p : products.getProducts()) {
				// Init values
				int taxesPerc = 0;
				double taxes = 0;
				double price = p.getPrice() * p.getQuantity();
				
				// Check taxes
				if (p.getBasicTaxes()) {
					taxesPerc = taxesPerc + 10;
				}
				if (p.getImportTaxes()) {
					taxesPerc = taxesPerc + 5;
				}
				
				// Update price and taxes
				taxes = price * taxesPerc / 100;
				if (taxes > 0) {
					// Round taxed values
					taxes = Math.round(taxes * 20.0) / 20.0;
				}
				price = price + taxes;
				
				// Update totals
				totalTaxes = totalTaxes + taxes;
				totalPrice = totalPrice + price;
				
				// Append receipt part
				sb.append(formatRigaScontrino(p.getName(), price));
				sb.append(Constants.LINE_SEPARATOR);
			}
			// Finalize receipt with totals
			sb.append(formatRigaScontrino("Sales Taxes", totalTaxes));
			sb.append(Constants.LINE_SEPARATOR);
			sb.append(formatRigaScontrino("Total", totalPrice));
		}
		
		// End and return
		return sb;
	}
	
	/**
	 * Format double values
	 * 
	 * @param d
	 * 
	 * @return String
	 */
	public String formatDouble(Double d) {
		// Init
		String s = "";
		// Check and format value
		if (d != null) {
			NumberFormat formatter = new DecimalFormat("#0.00");     
			s = formatter.format(d);
		}
		// Return converted value
		return s;
	}
	
	/**
	 * Format a receipt line
	 * 
	 * @param label
	 * @param value
	 * 
	 * @return String
	 */
	public String formatRigaScontrino(String label, Double value) {
		// TODO: it is possible to format the receipt differently  
		return label + ": " + formatDouble(value);
	}
	
}
