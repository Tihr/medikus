package medikus.rs.api;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import medikus.bl.exception.HandleRequest;
import medikus.bl.service.VisitService;
import medikus.rs.model.DeleteVisitResponse;
import medikus.rs.model.RegisterVisitRequest;
import medikus.rs.model.RegisterVisitResponse;
import medikus.rs.model.RetrieveVisitResponse;
import medikus.rs.model.UpdateVisitRequest;
import medikus.rs.model.UpdateVisitResponse;
@ApplicationScoped
@HandleRequest
public class VisitApiController implements VisitApi {

	@Inject
	VisitService visitService;
	
	@Inject
	EntityManager em;
	
	

	@Override
	public DeleteVisitResponse cancelVisit(String ssn, Long visitId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public RegisterVisitResponse registerVisit(String ssn, @Valid RegisterVisitRequest registerVisitRequest) {
		return visitService.registerVisit(ssn,registerVisitRequest);

	}
	@Override
	public RetrieveVisitResponse retrieveVisit(String ssn, Long visitId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UpdateVisitResponse updateVisit(String ssn, @Valid UpdateVisitRequest updateVisitRequest) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
