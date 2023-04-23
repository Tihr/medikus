package medikus.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the PATIENT database table.
 * 
 */
@Entity
@Table(name="PATIENT")
@NamedQuery(name="PatientEntity.findAll", query="SELECT p FROM PatientEntity p")
public class PatientEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
    @SequenceGenerator(name = "patientsSequence", sequenceName = "seq_patients", allocationSize = 1, initialValue = 10)
    @GeneratedValue(generator = "patientsSequence")
	private long id;

	@Temporal(TemporalType.DATE)
	private Date birthdate;

	private String fname;

	private String lname;

	private String ssn;

	//bi-directional many-to-one association to VisitEntity
	@OneToMany(mappedBy="patientBean")
	private List<VisitEntity> visits;

	public PatientEntity() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getFname() {
		return this.fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<VisitEntity> getVisits() {
		return this.visits;
	}

	public void setVisits(List<VisitEntity> visits) {
		this.visits = visits;
	}

	public VisitEntity addVisit(VisitEntity visit) {
		getVisits().add(visit);
		visit.setPatientBean(this);

		return visit;
	}

	public VisitEntity removeVisit(VisitEntity visit) {
		getVisits().remove(visit);
		visit.setPatientBean(null);

		return visit;
	}

}