package com.scg.domain;

import com.scg.util.Address;
import java.time.LocalDate;

/**
* Class for invoice header.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-29 
*/
public class InvoiceHeader {
    private final String businessName;
    private final Address businessAddress;
    private ClientAccount client;
    @SuppressWarnings("unused")
	private final  LocalDate invoiceDate;
    private final  LocalDate invoiceForMonth;

    /**
	  * Invoice constructor representing header.  
	  * Street, City, State and Postal may not be null.
	  * @param businessName Business Name,
	  * @param businessAddress Business Address,
	  * @param client Client Name,
	  * @param invoiceDate Invoice Date The date the invoice is printed. ,
	  * @param invoiceForMonth Month of invoice The month for which the invoice is generated,
	  */ 
    public InvoiceHeader(final String businessName,
                         final Address businessAddress,
                         ClientAccount client,
                         final LocalDate invoiceDate,
                         final LocalDate invoiceForMonth) {
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.client = client;
        this.invoiceDate = invoiceDate;
        this.invoiceForMonth = invoiceForMonth;
    }

    /**
	  * return data to be printed in header of the invoice.
	  * @return sb, data for header.
	  */ 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s", businessName)).append("\n");
        sb.append(String.format("%s", businessAddress.toString()));
        sb.append("\n").append("\n");
        sb.append("Invoice for:").append("\n");
        sb.append(String.format("%s", client.getName())).append("\n");
        sb.append("Invoice For Month of: ");
        sb.append(String.format("%tB, %d", invoiceForMonth.getMonth(), invoiceForMonth.getYear())).append("\n");
        sb.append("Invoice Date: ").append(String.format("%tB %d, %d", LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear())).append("\n");
        sb.append("\n");
        return sb.toString();
    }
    
}
