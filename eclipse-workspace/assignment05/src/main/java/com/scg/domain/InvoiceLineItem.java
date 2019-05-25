package com.scg.domain;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
* Class for invoice line item.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-29 
*/
public class InvoiceLineItem {
    private final  LocalDate date;
    private final Consultant consultant;
    private final Skill skill;
    private final int hours;


    /**
     * InvoiceLineItem constructor representing Invoice Line Items.
     * @param date - The date of this line item.
     * @param consultant - Consultant for this line item.
     * @param skill - Skill for this line item.
     * @param hours - Hours for this line item.
     */
    public InvoiceLineItem(final LocalDate date, final Consultant consultant, final Skill skill, final int hours) {
        this.date = date;
        this.consultant = consultant;
        this.skill = skill;
        this.hours = hours;
    }

    /**
	  * Getter for date.
	  * @return date, date property.
	  */ 
    public LocalDate getDate() {
        return date;
    }

    /**
	  * Getter for consultant.
	  * @return consultant, consultant name.
	  */ 
    public Consultant getConsultant() {
        return consultant;
    }

    /**
	  * Getter for skill.
	  * @return skill, skill of the consultant.
	  */ 
    public Skill getSkill() {
        return skill;
    }

    /**
	  * Getter for hours.
	  * @return hours, hours worked.
	  */ 
    public int getHours() {
        return hours;
    }

    /**
	  * returns the charge associated with this line item.
	  * @return the charge associated with this line item.
	  */ 
    public int getCharge() {
        return skill.getRate() * hours;
    }

    /**
	  * return data to be printed in the invoice.
	  * @return sb, data for invoice.
	  */ 
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();

        final Calendar cal = new GregorianCalendar();
        Date invoiceLinedate = Date.from(date.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        cal.setTime(invoiceLinedate);
        sb.append(String.format("%1$tm/%1$td/%1$tY  %2$-29s  %3$-18s  %4$5d  %5$,10.2f",
                cal, consultant, skill.toString(), hours, new Float(getCharge())));

        return sb.toString();
    }
}
