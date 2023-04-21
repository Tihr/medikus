package medikus.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the VISIT database table.
 * 
 */
@Entity
@Table(name="VISIT")
@NamedQuery(name="VisitEntity.findAll", query="SELECT v FROM VisitEntity v")
public class VisitEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "visitsSequence", sequenceName = "seq_visits", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "visitsSequence")	private long id;

	private Timestamp appointment;

	private String history;

	private String reason;

	@Column(name="\"TYPE\"")
	private String type;

	//bi-directional many-to-one association to PatientEntity
	@ManyToOne
	@JoinColumn(name="PATIENT")
	private PatientEntity patientBean;

	public VisitEntity() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Timestamp getAppointment() {
		return this.appointment;
	}

	public void setAppointment(Timestamp appointment) {
		this.appointment = appointment;
	}

	public String getHistory() {
		return this.history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PatientEntity getPatientBean() {
		return this.patientBean;
	}

	public void setPatientBean(PatientEntity patientBean) {
		this.patientBean = patientBean;
	}

}