package medikus.bl.service;

import java.sql.Timestamp;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.validation.Valid;

import medikus.bl.exception.ProjectException;
import medikus.db.model.PatientEntity;
import medikus.db.model.VisitEntity;
import medikus.rs.model.DeleteVisitResponse;
import medikus.rs.model.Patient;
import medikus.rs.model.RegisterVisitRequest;
import medikus.rs.model.RegisterVisitResponse;
import medikus.rs.model.RetrieveVisitResponse;
import medikus.rs.model.UpdateVisitRequest;
import medikus.rs.model.UpdateVisitResponse;
import medikus.rs.model.Visit;
import medikus.rs.model.Visit.ReasonEnum;
import medikus.rs.model.Visit.TypeEnum;
import medikus.rs.model.VisitResponse;
import medikus.util.ProjectConstants;

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

	public DeleteVisitResponse cancelVisit(String ssn, Long visitId) throws ProjectException {

		DeleteVisitResponse deleteVisitResponse = new DeleteVisitResponse();
		VisitEntity visitEntity = em.find(VisitEntity.class, visitId);
		if (visitEntity == null)
			throw new ProjectException(ProjectConstants.RestConstants.Result.NOT_FOUND_RECORD, null);
		else if (!visitEntity.getPatientBean().getSsn().equals(ssn))
			throw new ProjectException(ProjectConstants.RestConstants.Result.FORBIDDEN_OPERATION, null);
		em.remove(visitEntity);
		return deleteVisitResponse;
	}

	public RetrieveVisitResponse retrieveVisit(String ssn, Long visitId) {
		RetrieveVisitResponse response = new RetrieveVisitResponse();
		VisitEntity visitEntity = em.find(VisitEntity.class, visitId);
		Visit visit = new Visit();
		visit.setAppointment(visitEntity.getAppointment().toLocalDateTime().toLocalDate());
		visit.setHistory(visitEntity.getHistory());
		visit.setReason(ReasonEnum.valueOf(visitEntity.getReason()));
		visit.setType(TypeEnum.valueOf(visitEntity.getType()));
		VisitResponse visitResponse = new VisitResponse();
		visitResponse.setVisit(visit);
		visitResponse.setVisitId(visitEntity.getId());
		response.setVisitData(visitResponse);
		return response;
	}

	public UpdateVisitResponse updateVisit(String ssn, @Valid UpdateVisitRequest updateVisitRequest) {
		UpdateVisitResponse response = new UpdateVisitResponse();
		VisitEntity visitEntity = em.find(VisitEntity.class, updateVisitRequest.getVisitId());
		visitEntity
				.setAppointment(Timestamp.valueOf(updateVisitRequest.getVisitData().getAppointment().atStartOfDay()));
		visitEntity.setHistory(updateVisitRequest.getVisitData().getHistory());
		visitEntity.setReason(updateVisitRequest.getVisitData().getReason().toString());
		visitEntity.setType(updateVisitRequest.getVisitData().getType().toString());
		em.merge(visitEntity);
		VisitResponse visitResponse = new VisitResponse();
		visitResponse.setVisit(updateVisitRequest.getVisitData());
		visitResponse.setVisitId(visitEntity.getId());
		response.setVisitData(visitResponse);
		return response;
	}

}
