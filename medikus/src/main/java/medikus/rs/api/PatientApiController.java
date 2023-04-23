package medikus.rs.api;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import medikus.bl.exception.HandleRequest;
import medikus.bl.exception.ProjectException;
import medikus.bl.service.PatientService;
import medikus.rs.model.DeletePatientResponse;
import medikus.rs.model.RegisterPatientRequest;
import medikus.rs.model.RegisterPatientResponse;
import medikus.rs.model.RetrievePatientResponse;
import medikus.rs.model.UpdatePatientRequest;
import medikus.rs.model.UpdatePatientResponse;
@ApplicationScoped
@HandleRequest
public class PatientApiController implements PatientApi {

	@Inject
	PatientService patientService;

	
	
	@Override
	public DeletePatientResponse deletePatient(Long patientId) {
		// TODO AuOsto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public RegisterPatientResponse registerPatient(@Valid RegisterPatientRequest registerPatientRequest) throws ProjectException {
		// TODO Auto-generated method stub
		return patientService.registerPatient(registerPatientRequest);
	}

	@Override
	public RetrievePatientResponse retrievePatient(String ssn) throws ProjectException {

		return patientService.retrievePatient(ssn);
	}

	@Override
	public UpdatePatientResponse updatePatient(@Valid UpdatePatientRequest updatePatientRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
