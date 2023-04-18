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

import medikus.rs.model.DeleteVisitResponse;
import medikus.rs.model.RegisterVisitRequest;
import medikus.rs.model.RegisterVisitResponse;
import medikus.rs.model.RetrieveVisitResponse;
import medikus.rs.model.UpdateVisitRequest;
import medikus.rs.model.UpdateVisitResponse;

@Path("/visit")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-04-18T13:48:10.318236100+02:00[Europe/Rome]")public interface VisitApi {

    @DELETE
    @Produces({ "application/json" })
    DeleteVisitResponse cancelVisit(@QueryParam("visitId")    Long visitId);

    @PUT
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    RegisterVisitResponse registerVisit(@Valid RegisterVisitRequest registerVisitRequest);

    @GET
    @Produces({ "application/json" })
    RetrieveVisitResponse retrieveVisit(@QueryParam("visitId")    Long visitId);

    @POST
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    UpdateVisitResponse updateVisit(@Valid UpdateVisitRequest updateVisitRequest);
}
