package org.openmrs.module.orderexpansion.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.util.Date;

import org.openmrs.BaseFormRecordableOpenmrsData;
import org.openmrs.Concept;
import org.openmrs.Encounter;
import org.openmrs.Location;
import org.openmrs.Order;
import org.openmrs.Patient;
import org.openmrs.User;

@Entity
@Table(name = "medical_supply_dispense")
public class MedicalSupplyDispense extends BaseFormRecordableOpenmrsData {
	
	public enum MedicalSupplyStatus {
		PREPARATION,
		IN_PROGRESS,
		DECLINED,
		ON_HOLD,
		STOPPED,
		COMPLETED
	}
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "medical_supply_dispense_id")
	private Integer medicalSupplyDispenseId;
	
	@ManyToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name = "encounter_id")
	private Encounter encounter;
	
	@ManyToOne
	@JoinColumn(name = "medical_supply_order_id")
	private Order medicalSupplyOrder;
	
	@ManyToOne
	@JoinColumn(name = "concept")
	private Concept concept;
	
	@Column(name = "date_dispensed")
	private Date dateDispensed;
	
	@ManyToOne
	@JoinColumn(name = "dispenser")
	private User dispenser;
	
	@Column(name = "quantity")
	private Double quantity;
	
	@ManyToOne
	@JoinColumn(name = "quantity_units")
	private Concept quantityUnits;
	
	@Enumerated(EnumType.STRING)
	private MedicalSupplyStatus status;
	
	@ManyToOne
	@JoinColumn(name = "status_reason")
	private Concept statusReason;
	
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	public Integer getMedicalSupplyDispenseId() {
		return medicalSupplyDispenseId;
	}
	
	public void setMedicalSupplyDispenseId(Integer medicalSupplyDispenseId) {
		this.medicalSupplyDispenseId = medicalSupplyDispenseId;
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Encounter getEncounter() {
		return encounter;
	}
	
	public void setEncounter(Encounter encounter) {
		this.encounter = encounter;
	}
	
	public Order getMedicalSupplyOrder() {
		return medicalSupplyOrder;
	}
	
	public void setMedicalSupplyOrder(Order medicalSupplyOrder) {
		this.medicalSupplyOrder = medicalSupplyOrder;
	}
	
	public Concept getConcept() {
		return concept;
	}
	
	public void setConcept(Concept concept) {
		this.concept = concept;
	}
	
	public Date getDateDispensed() {
		return dateDispensed;
	}
	
	public void setDateDispensed(Date dateDispensed) {
		this.dateDispensed = dateDispensed;
	}
	
	public MedicalSupplyStatus getStatus() {
		return status;
	}
	
	public void setStatus(MedicalSupplyStatus status) {
		this.status = status;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Concept getStatusReason() {
		return statusReason;
	}
	
	public void setStatusReason(Concept statusReason) {
		this.statusReason = statusReason;
	}
	
	public Double getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	
	public Concept getQuantityUnits() {
		return this.quantityUnits;
	}
	
	public void setQuantityUnits(Concept quantityUnits) {
		this.quantityUnits = quantityUnits;
	}
	
	public User getDispenser() {
		return this.dispenser;
	}
	
	public void setDispenser(User dispenser) {
		this.dispenser = dispenser;
	}
	
	@Override
	public Integer getId() {
		return getMedicalSupplyDispenseId();
	}
	
	@Override
	public void setId(Integer integer) {
		setMedicalSupplyDispenseId(integer);
	}
	
}
