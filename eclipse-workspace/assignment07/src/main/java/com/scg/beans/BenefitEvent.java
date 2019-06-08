package com.scg.beans;

import java.time.LocalDate;
import java.util.EventObject;
import java.util.Optional;

import com.scg.domain.Consultant;

/**
* BenefitEvent Class.
*
* @author  Kailash Mehta
* @version 1.0
* @since   2019-04-24 
*/
public class BenefitEvent extends EventObject  {

	

	private static final long serialVersionUID = 2784344112761812313L;
	
	private StaffConsultant consultant;
	private LocalDate effectiveDate;
	private static Optional<Boolean>  medicalStatus;
	private static Optional<Boolean> dentalStatus;
    
	public BenefitEvent(StaffConsultant consultant, LocalDate effectiveDate) {
		super(consultant);
		this.consultant = consultant;
		this.effectiveDate = effectiveDate;
	}

	/**
     * Opt enrollment for a consultant.
     *
     * @param consultant the consultant
     * @param effectiveDate the enrollment date of the consultant
     * @return evt, Benefit Event
     */
	public static BenefitEvent enrollMedical( StaffConsultant consultant, LocalDate effectiveDate ) {
		
		BenefitEvent evt = new BenefitEvent (consultant, effectiveDate);
		BenefitEvent.medicalStatus = Optional.of(true);
		BenefitEvent.dentalStatus = Optional.empty();
		return evt;
	}
	
	/**
     * cancel enrollment for a consultant.
     *
     * @param consultant the consultant
     * @param effectiveDate the enrollment cancel date of the consultant
     * @return evt, Benefit Event
     */
	public static BenefitEvent cancelMedical( StaffConsultant consultant, LocalDate effectiveDate ) {
		BenefitEvent.medicalStatus = Optional.of(false);
		BenefitEvent.dentalStatus = Optional.empty();
		BenefitEvent evt = new BenefitEvent (consultant, effectiveDate);
		return evt;
	}
	
	/**
     * Opt enrollment for a consultant.
     *
     * @param consultant the consultant
     * @param effectiveDate the enrollment date of the consultant
     * @return evt, Benefit Event
     */
	public static BenefitEvent enrollDental( StaffConsultant consultant, LocalDate effectiveDate ) { 
		BenefitEvent.medicalStatus = Optional.empty();
		BenefitEvent.dentalStatus = Optional.of(true);
		BenefitEvent evt = new BenefitEvent (consultant, effectiveDate);
		return evt;
	}
	
	/**
     * cancel enrollment for a consultant.
     *
     * @param consultant the consultant
     * @param effectiveDate the enrollment cancel date of the consultant
     * @return evt, Benefit Event
     */
	public static BenefitEvent cancelDental( StaffConsultant consultant, LocalDate effectiveDate ) {
		BenefitEvent evt = new BenefitEvent (consultant, effectiveDate);
		BenefitEvent.medicalStatus = Optional.empty();
		BenefitEvent.dentalStatus = Optional.of(false);
		return evt;
	}
	
	/**
     * Gets the consultant's dental enrollment status.
    *
    * @return opt - if consultant is enrolled for Benefits or not.
    */
	public Optional<Boolean> dentalStatus(){
		Optional<Boolean>  opt = dentalStatus;
		return opt;
	}
	
	/**
     * Gets the consultant's medical enrollment status.
    *
    * @return opt - if consultant is enrolled for Benefits or not.
    */
	public Optional<Boolean> medicalStatus() {
		Optional<Boolean>  opt = medicalStatus;
		return opt;
	}

	/**
     * Gets the consultant  who is enrolled for Benefits.
    *
    * @return the consultant who is enrolled for Benefits.
    */
	public  Consultant getConsultant() {
		return consultant;
	}
	
	/**
     * Gets the consultant Effective who is enrolled for Benefits.
     *
     * @return the consultant Effective who is enrolled for Benefits.
     */
	public LocalDate getEffectiveDate() {
		return effectiveDate;
	}
}
