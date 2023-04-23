package medikus.bl.exception;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.quarkus.arc.Priority;
import medikus.rs.model.CommonResultResponse;
import medikus.util.ProjectConstants;
import medikus.util.RestBuilder;

@HandleRequest
@Priority(1)
@Interceptor
public class RequestHandler {

	@AroundInvoke
	Object handle(InvocationContext context) throws Exception {
		Object ret = null;
		try {
			ret = context.proceed();
		} catch (ProjectException pe) {
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
					.entity(RestBuilder.buildCommonResultFromProjectException(pe)).build());
		} catch (javax.persistence.NoResultException nre) {
			throw new WebApplicationException(Response.status(Status.NOT_FOUND).entity(RestBuilder
					.buildCommonResultResponseFromConstant(ProjectConstants.RestConstants.Result.NOT_FOUND_RECORD))
					.build());
		} catch (javax.persistence.PersistenceException jpe) {
			if (jpe.getCause() instanceof org.hibernate.exception.ConstraintViolationException)
				throw new WebApplicationException(Response.status(Status.CONFLICT).entity(RestBuilder
						.buildCommonResultResponseFromConstant(ProjectConstants.RestConstants.Result.DUPLICATE_RECORD))
						.build());
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR).entity(RestBuilder
					.buildCommonResultResponseFromConstant(ProjectConstants.RestConstants.Result.INTERNAL_ERROR))
					.build());
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(RestBuilder.buildCommonResultResponseGenericError()).build());
		}
		context.getMethod().getReturnType().getDeclaredMethod("setResult", CommonResultResponse.class).invoke(ret,
				RestBuilder.buildCommonResultResponseOK());
		return ret;
	}

}
