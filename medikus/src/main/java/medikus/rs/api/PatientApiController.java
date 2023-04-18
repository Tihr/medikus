package medikus.rs.api;

import javax.validation.Valid;

import medikus.rs.model.CommonResultResponse;
import medikus.rs.model.DeletePatientResponse;
import medikus.rs.model.RegisterPatientRequest;
import medikus.rs.model.RegisterPatientResponse;
import medikus.rs.model.RetrievePatientResponse;
import medikus.rs.model.UpdatePatientRequest;
import medikus.rs.model.UpdatePatientResponse;

public class PatientApiController implements PatientApi {

	@Override
	public DeletePatientResponse deletePatient(Long patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegisterPatientResponse registerPatient(@Valid RegisterPatientRequest registerPatientRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RetrievePatientResponse retrievePatient(String ssn) {
		// TODO Auto-generated method stub
		RetrievePatientResponse response = new RetrievePatientResponse();
		CommonResultResponse result = new CommonResultResponse();
		result.setCode("0000");
		result.setMessage("SUCCESS");
		result.setResult(true);
		result.setxRequestID("aoooaaoaooaoao");
		response.setResult(result);
		return response;
	}

	@Override
	public UpdatePatientResponse updatePatient(@Valid UpdatePatientRequest updatePatientRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
