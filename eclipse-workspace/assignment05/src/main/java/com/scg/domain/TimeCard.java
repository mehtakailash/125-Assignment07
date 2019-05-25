package com.scg.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

/**
* Class to billable and non billable time.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-11 
*/
public class TimeCard implements Comparable<TimeCard>, Serializable {

	private static final long serialVersionUID = 6022478432642985502L;
	Consultant consultant;
	LocalDate weekStartingDate;
	ConsultantTime time;
	private final ArrayList<ConsultantTime> consultantTimeHours = new ArrayList<ConsultantTime>();
	private ArrayList<ConsultantTime> consultantTimeNonBillableHours = new ArrayList<ConsultantTime>();
	private int totalBillableHours = 0;
	private int totalNonBillableHours = 0;
	
	/**
	  * TimeCard constructor representing Consultant and start date.  
	  * Consultant Name and Starting date. 
	  * @param consultant.
	  * @param weekStartingDate.
	  */
	public TimeCard( Consultant consultant, LocalDate weekStartingDate ) {
		this.consultant = consultant;
		this.weekStartingDate = weekStartingDate;
	}

	/**
	 * Returns consultant.
	 * @return consultant
	 */
	public Consultant getConsultant() {
		return consultant;
	}
	
	/**
	 * Returns startDate.
	 * @return weekStartingDate
	 */
	public LocalDate getWeekStartingDate() {
		return weekStartingDate;
	}
	
	public void addConsultantTime( ConsultantTime consultantTime ) {
		 if (consultantTime.isBillable()) {
			consultantTimeHours.add(consultantTime);
            totalBillableHours = totalBillableHours + consultantTime.getHours();
        } else {
        	consultantTimeNonBillableHours.add(consultantTime);
            totalNonBillableHours = totalNonBillableHours + consultantTime.getHours();
        }
	}
	
	/**
	 * Returns Total Billable Hours.
	 * @return totalBillableHours
	 */
	public int getTotalBillableHours() {
		
		return totalBillableHours;
	}
	
	/**
	 * Returns Total Non Billable Hours.
	 * @return totalNonBillableHours
	 */
	public int getTotalNonBillableHours() {
		
		return totalNonBillableHours;
	}
	

	public int getTotalHours() {
		return totalBillableHours + totalNonBillableHours;
	}
	
	public ArrayList<ConsultantTime> getConsultingHours() {
		return consultantTimeHours;
	}
	
	public ArrayList<ConsultantTime> getBillableHoursForClient( String clientName ) {
		ArrayList<ConsultantTime> billableClientHours = new ArrayList<ConsultantTime>();
		
		for (final ConsultantTime consultantTime : consultantTimeHours) {
            if (clientName.equals(consultantTime.getAccount().getName())) {
                if (consultantTime.isBillable()) {
                	billableClientHours.add(consultantTime);
                }
            }
        }
		return billableClientHours;
	}
	
	public static String paddingForReport(String string, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(string);
        }

        return sb.toString();
    }
	
	public String toReportString() {
		StringBuilder sb = new StringBuilder();
        sb.append("====================================================================").append("\n");
        Calendar cal = new GregorianCalendar();
        Date date = Date.from(weekStartingDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
        cal.setTime(date);
        sb.append(String.format("Consultant: %-18s %10s Week Starting: %3$tb %3$te, %3$tY",
                consultant.toString(), " ", cal)).append("\n");
        sb.append("\n");
        sb.append("Billable Time:\n");
        sb.append(String.format("%-26s  %-10s  %-5s  %-20s", "Account", "Date", "Hours", "Skill")).append("\n");
        sb.append(paddingForReport("-", 26)).append("  ")
                .append(paddingForReport("-", 10)).append("  ")
                .append(paddingForReport("-", 5)).append("  ")
                .append(paddingForReport("-", 20))
                .append("\n");
        for (ConsultantTime hours : consultantTimeHours) {
            if (hours.isBillable()) {
                sb.append( String.format("%-26s  %2$tY-%2$tm-%2$td  %3$5d  %4$s%n", hours.getAccount().getName(), hours.getDate(), hours.getHours(), hours.getSkill()));
            }
        }

        if (!consultantTimeNonBillableHours.isEmpty()) {
            sb.append("\n");
            sb.append("Non-billable Time:\n");
            sb.append(String.format("%-26s  %-10s  %-5s ", "Account", "Date", "Hours")).append("\n");
            sb.append(paddingForReport("-", 26)).append("  ")
            .append(paddingForReport("-", 10)).append("  ")
            .append(paddingForReport("-", 5)).append("  ")
            .append("\n");
            for (ConsultantTime hours : consultantTimeNonBillableHours) {
                if (!hours.isBillable()) {
                    sb.append( String.format("%-26s  %2$tY-%2$tm-%2$td  %3$5d%n", hours.getAccount().getName(), hours.getDate(), hours.getHours()));
                }
            }
        }
        sb.append("\n");
        sb.append("Summary: \n");
        sb.append(String.format("Total %s: %29d\n", "Billable", totalBillableHours));
        sb.append(String.format("Total Non-Billable: %25d\n", totalNonBillableHours));
        sb.append(String.format("Total Hours: %32d\n", getTotalHours()));
        sb.append("====================================================================").append("\n");
        return sb.toString();
	}
	
	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
	@Override
	public String toString() {
		StringBuilder   bldr    = new StringBuilder();
        bldr.append( consultant.getName() ).append( " " );
        bldr.append( weekStartingDate );
        return bldr.toString();
	}

	public int compareTo( TimeCard other ) {
		if(other == null) 
			throw new NullPointerException( "null argument not allowed" );
		int comparrissionValue = Comparator.comparing( TimeCard::getConsultant)
					.thenComparing(TimeCard::getWeekStartingDate)
					.thenComparing(TimeCard::getTotalBillableHours)
					.thenComparing(TimeCard::getTotalNonBillableHours)
					.compare( this, other );
		return comparrissionValue;
	}
	
	//ToDo: @KailashM Delete before submit
//	public static void main (String[] args)
//	{
//		PersonalName pName = new PersonalName("First","Last","Middle");
//		Consultant a = new Consultant( pName);
//		LocalDate date = LocalDate.now();
//		TimeCard  timeCard = new TimeCard(a, date);
//		System.out.println(timeCard.toString());
//		System.out.println(timeCard.toReportString()); 
//	}
}
