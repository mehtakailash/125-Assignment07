package com.scg.domain;

import com.scg.util.Address;
import com.scg.util.StateCode;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

/**
* Class for invoice.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-29 
*/
public final class Invoice {
    /**
     * property business info.
     */
    public static final String PROP_FILE_NAME = "invoice.properties";

    /**
     * Property for business name.
     */
    public static final String BUSINESS_NAME_PROP = "business.name";

    /**
     * Property for business street address.
     */
    public static final String BUSINESS_STREET_PROP = "business.street";


    /**
     * Property for business city.
     */
    public static final String BUSINESS_CITY_PROP = "business.city";

    /**
     * Property for business state.
     */
    public static final String BUSINESS_STATE_PROP = "business.state";

    /**
     * Property for business zip.
     */
    public static final String BUSINESS_ZIP_PROP = "business.zip";
    
    private final int maxItemsPerPage = 5;


    private final ClientAccount client;
    private final Month invoiceMonth;
    private final int invoiceYear;

    private List<InvoiceLineItem> lineItems = new ArrayList<InvoiceLineItem>();
    private final Properties invoiceProperties = new Properties();

    /**
     * Construct an Invoice. 
     * @param client - Client to be Invoiced. 
     * @param invoiceMonth - Month for which this Invoice is being created. 
     * @param invoiceYear - Year for which this Invoice is being created.
     */
    public Invoice(final ClientAccount client, final Month invoiceMonth, final int invoiceYear) {
        this.client = client;
        this.invoiceMonth = invoiceMonth;
        this.invoiceYear = invoiceYear;

        try {
            invoiceProperties.load(this.getClass().getClassLoader().getResourceAsStream(PROP_FILE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get client name  for this Invoice.
     * @return client - client name.
     */
    public ClientAccount getClientAccount() {
    	return client;
    }

    /**
     * Get the invoice month. This is the 0-based month number.
     * @return - 0-based invoice month.
     */
    public Month getInvoiceMonth() {
        return invoiceMonth;
    }
    
    /**https://www.geeksforgeeks.org/how-to-read-and-print-an-integer-value-in-java/
     * Get the invoice month. This is the 0-based month number.
     * @return - 0-based invoice month.
     */
    public int getInvoiceYear() {
        return invoiceYear;
    }

	 /**
	  * Get the start date for this Invoice.
	  * @return - start date.
	  */
	 public LocalDate getStartDate()  {
	     return LocalDate.of(invoiceYear,invoiceMonth,01);
	 }

    /**
     * Get the total charges for this Invoice.
     * @return charges - Total charges
     */
    public int getTotalCharges() {
        int charges = 0;
        for (InvoiceLineItem lineItem : lineItems) {
            charges += lineItem.getCharge();
        }
        return charges;
    }
    
    /**
     * Get the total hours for this Invoice.
     * @return hours - Total hours
     */
    public int getTotalHours() {
        int hours = 0;
        for (InvoiceLineItem lineItem : lineItems) {
            hours += lineItem.getHours();
        }
        return hours;
    }
    
    /**
     * Add lineitem to the Invoice.
     * @param item - item to be added
     */
    public void addLineItem( InvoiceLineItem item ) {
    	lineItems.add(item);
    }

    /**
     * Extract the billable hours for this Invoice
     * @param timeCard - TimeCard .
     */
    public void extractLineItems( TimeCard timeCard ) {
        final List<ConsultantTime> consultantTimes = timeCard.getBillableHoursForClient(client.getName());
        for (ConsultantTime time : consultantTimes) {
            InvoiceLineItem lineItem = new InvoiceLineItem(
                    time.getDate(),
                    timeCard.getConsultant(),
                    time.getSkill(),
                    time.getHours());
      
            if (invoiceMonth==time.getDate().getMonth() && invoiceYear == time.getDate().getYear()) {
            	lineItems.add(lineItem);
            }

        }
    }

    /**
     * Create a formatted string containing the printable invoice. Prints a header and footer on each page.
     * @return - The formatted invoice as a string.
     */
    public String toReportString() {

        final Address addr = new Address(invoiceProperties.getProperty(BUSINESS_STREET_PROP),
                invoiceProperties.getProperty(BUSINESS_CITY_PROP),
                StateCode.valueOf(invoiceProperties.getProperty(BUSINESS_STATE_PROP)),
                invoiceProperties.getProperty(BUSINESS_ZIP_PROP));

        final InvoiceHeader invoiceHeader = new InvoiceHeader(
                invoiceProperties.getProperty(BUSINESS_NAME_PROP),
                addr,
                client,
                getStartDate(),
                LocalDate.of(invoiceYear,invoiceMonth,01));

        final InvoiceFooter footer = new InvoiceFooter(invoiceProperties.getProperty(BUSINESS_NAME_PROP));

        StringBuilder sb = new StringBuilder();
        sb.append(invoiceHeader.toString());

        int itemCount = 1;
        for (InvoiceLineItem lineItem : lineItems) {
//            sb.append(lineItem.toString()).append("\n");
            if (itemCount++ > maxItemsPerPage) {
                sb.append("\n");
                
                sb.append(footer.toString());
                
                sb.append(invoiceHeader.toString());
                
                footer.incrementPageNumber();
                
                itemCount = 0;
            }
           sb.append(lineItem.toString()).append("\n");
        }

        sb.append("\n");
        sb.append(String.format("Total: %61d  %,10.2f", getTotalHours(), (float) getTotalCharges())).append("\n");

        sb.append(footer);

        return sb.toString();
    }
    
    @Override
    public String toString() {

    	 StringBuilder sb = new StringBuilder();

         sb.append("client=").append(String.format("%s", client.getName())).append(",");
         sb.append(String.format("invoiceYear=%d", invoiceYear)).append(",");
         sb.append(String.format("invoiceMonth%tB", invoiceMonth)).append("\n");
        return sb.toString();
    } 

}