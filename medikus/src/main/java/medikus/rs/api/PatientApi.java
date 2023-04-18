package medikus.rs.api;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import medikus.rs.model.DeletePatientResponse;
import medikus.rs.model.RegisterPatientRequest;
import medikus.rs.model.RegisterPatientResponse;
import medikus.rs.model.RetrievePatientResponse;
import medikus.rs.model.UpdatePatientRequest;
import medikus.rs.model.UpdatePatientResponse;

@Path("/patient")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-18T13:48:10.318236100+02:00[Europe/Rome]")public interface PatientApi {

    @DELETE
    @Produces({ "application/json" })
    DeletePatientResponse deletePatient(@QueryParam("patientId")    Long patientId);

    @PUT
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    RegisterPatientResponse registerPatient(@Valid RegisterPatientRequest registerPatientRequest);

    @GET
    @Produces({ "application/json" })
    RetrievePatientResponse retrievePatient(@QueryParam("ssn")    String ssn);

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    UpdatePatientResponse updatePatient(@Valid UpdatePatientRequest updatePatientRequest);
}
