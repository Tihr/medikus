package medikus.rs.api;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import medikus.bl.exception.HandleRequest;
import medikus.bl.exception.ProjectException;
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
	@Transactional
	@Override
	public DeleteVisitResponse cancelVisit(String ssn, Long visitId) throws ProjectException {
		// TODO Auto-generated method stub
		return visitService.cancelVisit(ssn, visitId);
	}

	@Transactional
	@Override
	public RegisterVisitResponse registerVisit(String ssn, @Valid RegisterVisitRequest registerVisitRequest)
			throws ProjectException {
		return visitService.registerVisit(ssn, registerVisitRequest);

	}
	@Transactional
	@Override
	public RetrieveVisitResponse retrieveVisit(String ssn, Long visitId) throws ProjectException {
		// TODO Auto-generated method stub
		return visitService.retrieveVisit(ssn, visitId);
	}
	@Transactional
	@Override
	public UpdateVisitResponse updateVisit(String ssn, @Valid UpdateVisitRequest updateVisitRequest)
			throws ProjectException {
		// TODO Auto-generated method stub
		return visitService.updateVisit(ssn, updateVisitRequest);
	}

}
