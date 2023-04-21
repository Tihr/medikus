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

import medikus.bl.error.ProjectException;
import medikus.db.model.PatientEntity;
import medikus.rs.model.CommonResultResponse;
import medikus.rs.model.Patient;
import medikus.rs.model.PatientResponse;
import medikus.rs.model.RegisterPatientRequest;
import medikus.rs.model.RegisterPatientResponse;
import medikus.rs.model.RetrievePatientResponse;
import medikus.util.ProjectConstants;
import medikus.util.RestBuilder;

@ApplicationScoped
public class PatientService {

	@Inject
	EntityManager em;

	public RegisterPatientResponse registerPatient(@Valid RegisterPatientRequest registerPatientRequest) {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setBirthdate(Date
				.from(registerPatientRequest.getPatientData().getBirthdate().atStartOfDay().toInstant(ZoneOffset.UTC)));
		patientEntity.setFname(registerPatientRequest.getPatientData().getName());
		patientEntity.setLname(registerPatientRequest.getPatientData().getSurname());
		patientEntity.setSsn(registerPatientRequest.getPatientData().getSsn());
		em.persist(patientEntity);
		em.flush();
		Patient patient = new Patient();
		patient.setName(patientEntity.getFname());
		patient.setSurname(patientEntity.getLname());
		patient.setSsn(patientEntity.getSsn());
		patient.setBirthdate(LocalDate.from(registerPatientRequest.getPatientData().getBirthdate()));
		PatientResponse patientResponse = new PatientResponse();
		patientResponse.setPatient(patient);
		patientResponse.setPatientId(patientEntity.getId());
		CommonResultResponse result = RestBuilder.buildCommonResultResponseOK();
		RegisterPatientResponse response = new RegisterPatientResponse();
		response.setPatientData(patientResponse);
		response.setResult(result);
		return response;
	}

	public RetrievePatientResponse retrievePatient(String ssn) throws ProjectException {
		RetrievePatientResponse response = new RetrievePatientResponse();
		try {
			Query patientQuery = em.createNativeQuery("select * from patient where ssn=:ssn", PatientEntity.class);
			patientQuery.setParameter("ssn", ssn);
			PatientEntity patientEntity = (PatientEntity) patientQuery.getSingleResult();
			Patient patient = new Patient();
			patient.setName(patientEntity.getFname());
			patient.setSurname(patientEntity.getLname());
			patient.setSsn(patientEntity.getSsn());

			LocalDate.ofInstant(Instant.ofEpochMilli(patientEntity.getBirthdate().getTime()), ZoneId.systemDefault());
			patient.setBirthdate(LocalDate.ofInstant(Instant.ofEpochMilli(patientEntity.getBirthdate().getTime()), ZoneId.systemDefault()));
		
			PatientResponse patientResponse = new PatientResponse();
			patientResponse.setPatient(patient);
			patientResponse.setPatientId(patientEntity.getId());
			response.setPatientData(patientResponse);
		} catch (javax.persistence.NoResultException nre) {
			throw new ProjectException(ProjectConstants.RestConstants.Result.NOT_FOUND_RECORD, nre);
		} catch (Exception e) {
			throw new ProjectException(ProjectConstants.RestConstants.Result.GENERIC_ERROR, e);
		}
		CommonResultResponse result = RestBuilder.buildCommonResultResponseOK();
		response.setResult(result);
		return response;
	}
}
