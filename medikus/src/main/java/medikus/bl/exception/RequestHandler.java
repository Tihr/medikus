package medikus.bl.exception;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.quarkus.arc.Priority;
import io.quarkus.narayana.jta.QuarkusTransaction;
import medikus.rs.model.CommonResultResponse;
import medikus.util.ProjectConstants;
import medikus.util.RestBuilder;

@HandleRequest
@Priority(1)
@Interceptor
public class RequestHandler {

	Object handleError(InvocationContext context) throws Exception {
		Object ret = null;
		try {
			ret = context.proceed();
			context.getMethod().getReturnType().getDeclaredMethod("setResult", CommonResultResponse.class).invoke(ret,
					RestBuilder.buildCommonResultResponseOK());
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
		} catch (io.quarkus.hibernate.validator.runtime.jaxrs.ResteasyReactiveViolationException rrve) {
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST)
					.entity(RestBuilder
							.buildCommonResultFromException(ProjectConstants.RestConstants.Result.BAD_REQUEST, rrve))
					.build());
		} catch (io.quarkus.narayana.jta.QuarkusTransactionException qte) {
			if (qte.getCause() instanceof javax.transaction.RollbackException) {
				if (qte.getCause().getCause() instanceof javax.persistence.PersistenceException)
					if (qte.getCause().getCause()
							.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
						throw new WebApplicationException(Response.status(Status.CONFLICT)
								.entity(RestBuilder.buildCommonResultResponseFromConstant(
										ProjectConstants.RestConstants.Result.DUPLICATE_RECORD))
								.build());
					}
			}
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(RestBuilder.buildCommonResultResponseGenericError()).build());

		} catch (javax.transaction.RollbackException re) {

			if (re.getCause() instanceof javax.persistence.PersistenceException)
				if (re.getCause().getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
					throw new WebApplicationException(
							Response.status(Status.CONFLICT).entity(RestBuilder.buildCommonResultResponseFromConstant(
									ProjectConstants.RestConstants.Result.DUPLICATE_RECORD)).build());
				}
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(RestBuilder.buildCommonResultResponseGenericError()).build());
		} catch (Exception e) {
			throw new WebApplicationException(Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(RestBuilder.buildCommonResultResponseGenericError()).build());
		}
		return ret;
	}

	@AroundInvoke
	Object handleTransaction(InvocationContext context) throws Exception {
		Object ret = null;

		ret = handleError(context);

		return ret;
	}

}
