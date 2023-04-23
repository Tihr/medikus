package medikus.bl.service;

import java.sql.Timestamp;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

import medikus.db.model.PatientEntity;
import medikus.db.model.VisitEntity;
import medikus.rs.model.Patient;
import medikus.rs.model.RegisterVisitRequest;
import medikus.rs.model.RegisterVisitResponse;
import medikus.rs.model.VisitResponse;

@ApplicationScoped
public class VisitService {

	@Inject
	EntityManager em;

	public RegisterVisitResponse registerVisit(String ssn, @Valid RegisterVisitRequest registerVisitRequest) {
		RegisterVisitResponse response = new RegisterVisitResponse();

		Query patientQuery = em.createNativeQuery("select * from patient where ssn=:ssn", PatientEntity.class);
		patientQuery.setParameter("ssn", ssn);
		PatientEntity patientEntity = (PatientEntity) patientQuery.getSingleResult();
		Patient patient = new Patient();
		patient.setName(patientEntity.getFname());
		patient.setSurname(patientEntity.getLname());
		patient.setSsn(patientEntity.getSsn());

		VisitEntity visitEntity = new VisitEntity();
		visitEntity
				.setAppointment(Timestamp.valueOf(registerVisitRequest.getVisitData().getAppointment().atStartOfDay()));
		visitEntity.setHistory(registerVisitRequest.getVisitData().getHistory());
		visitEntity.setReason(registerVisitRequest.getVisitData().getReason().toString());
		visitEntity.setType(registerVisitRequest.getVisitData().getType().toString());
		visitEntity.setPatientBean(patientEntity);
		em.persist(visitEntity);
		em.flush();
		VisitResponse visitResponse = new VisitResponse();
		visitResponse.setVisit(registerVisitRequest.getVisitData());
		visitResponse.setVisitId(visitEntity.getId());
		response.setVisitData(visitResponse);
		return response;
	}

}
