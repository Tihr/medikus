package medikus.bl.service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

import medikus.bl.exception.ProjectException;
import medikus.db.model.PatientEntity;
import medikus.db.model.VisitEntity;
import medikus.rs.model.Patient;
import medikus.rs.model.PatientResponse;
import medikus.rs.model.RegisterPatientRequest;
import medikus.rs.model.RegisterPatientResponse;
import medikus.rs.model.RetrievePatientResponse;
import medikus.rs.model.Visit;
import medikus.rs.model.Visit.ReasonEnum;
import medikus.rs.model.Visit.TypeEnum;
import medikus.rs.model.VisitResponse;
import medikus.util.ProjectConstants;

@ApplicationScoped
public class PatientService {

	@Inject
	EntityManager em;

	public RegisterPatientResponse registerPatient(@Valid RegisterPatientRequest registerPatientRequest)
			throws ProjectException {
		PatientResponse patientResponse = new PatientResponse();
		PatientEntity patientEntity = new PatientEntity();

		patientEntity.setBirthdate(Date
				.from(registerPatientRequest.getPatientData().getBirthdate().atStartOfDay().toInstant(ZoneOffset.UTC)));
		patientEntity.setFname(registerPatientRequest.getPatientData().getName());
		patientEntity.setLname(registerPatientRequest.getPatientData().getSurname());
		patientEntity.setSsn(registerPatientRequest.getPatientData().getSsn());
		patientResponse.setPatient(registerPatientRequest.getPatientData());
		em.persist(patientEntity);
		em.flush();

		RegisterPatientResponse response = new RegisterPatientResponse();
		response.setPatientData(patientResponse);
		patientResponse.setPatientId(patientEntity.getId());
		return response;
	}

	public RetrievePatientResponse retrievePatient(String ssn) throws ProjectException {
		RetrievePatientResponse response = new RetrievePatientResponse();

		Query patientQuery = em.createNativeQuery(
				"select * from patient p left outer join visit v ON p.id=v.patient where ssn=:ssn",
				PatientEntity.class);
		patientQuery.setParameter("ssn", ssn);
		PatientEntity patientEntity = (PatientEntity) patientQuery.getSingleResult();
		Patient patient = new Patient();
		patient.setName(patientEntity.getFname());
		patient.setSurname(patientEntity.getLname());
		patient.setSsn(patientEntity.getSsn());
		LocalDate.ofInstant(Instant.ofEpochMilli(patientEntity.getBirthdate().getTime()), ZoneId.systemDefault());
		patient.setBirthdate(LocalDate.ofInstant(Instant.ofEpochMilli(patientEntity.getBirthdate().getTime()),
				ZoneId.systemDefault()));

		PatientResponse patientResponse = new PatientResponse();
		patientResponse.setPatient(patient);
		patientResponse.setPatientId(patientEntity.getId());

		for (VisitEntity visitEntity : patientEntity.getVisits()) {
			Visit visit = new Visit();
			visit.setAppointment(visitEntity.getAppointment().toLocalDateTime().toLocalDate());
			visit.setHistory(visitEntity.getHistory());
			visit.setReason(ReasonEnum.valueOf(visitEntity.getReason()));
			visit.setType(TypeEnum.valueOf(visitEntity.getType()));
			VisitResponse visitResponse = new VisitResponse();
			visitResponse.setVisit(visit);
			visitResponse.setVisitId(visitEntity.getId());
			response.getVisits().add(visitResponse);
		}

		response.setPatientData(patientResponse);

		return response;
	}
}
