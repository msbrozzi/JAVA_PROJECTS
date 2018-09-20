package test;

import it.salestaxes.receipt.MainProcessor;

public class RunTest01 {

	public static void main(String[] args) {
		
		// Init
		String[] arguments;
		
		// Test INPUT 01
		arguments = new String[] {"./input/Input01.xml"};
		MainProcessor.main(arguments);
		
	}
	
}
