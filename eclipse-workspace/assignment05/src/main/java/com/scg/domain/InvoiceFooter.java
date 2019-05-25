package com.scg.domain;

/**
* Class for invoice footer.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-29 
*/
public class InvoiceFooter {
    private final String businessName;
    private int pageNumber = 1;

    /**
	  * Invoice constructor representing footer.  
	  * Street, City, State and Postal may not be null.
	  * @param businessName Business Name The name of the Small Consulting Group,
	  */ 
    public InvoiceFooter(final String businessName) {
        this.businessName = businessName;
    }

    /**
	  * Increment the page no.
	  */ 
    public void incrementPageNumber() {
        pageNumber++;
    }

    /**
	  * return data to be printed in footer of the invoice.
	  */ 
    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append(String.format("%-70s Page:%4d", businessName, pageNumber)).append("\n");
        sb.append(paddingForReport("=", 80));
        sb.append("\n");
        return sb.toString();
    }
    
    /**
	  * return string used for padding in invoice.
	  * @param string, string to be formatted
	  * @param count, no of tabs for formatting
	  * @return string, formatted string.
	  */
    public static String paddingForReport(String string, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(string);
        }

        return sb.toString();
    }
}
