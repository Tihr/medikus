package medikus.bl.exception;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

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
			Object response = context.getMethod().getReturnType().getDeclaredConstructor().newInstance();
			context.getMethod().getReturnType().getDeclaredMethod("setResult", CommonResultResponse.class)
					.invoke(response, RestBuilder.buildCommonResultFromProjectException(pe));
			return response;
		} catch (javax.persistence.NoResultException nre) {
			Object response = context.getMethod().getReturnType().getDeclaredConstructor().newInstance();
			context.getMethod().getReturnType().getDeclaredMethod("setResult", CommonResultResponse.class)
					.invoke(response, RestBuilder.buildCommonResultResponseFromConstant(
							ProjectConstants.RestConstants.Result.NOT_FOUND_RECORD));
			return response;
		} catch (javax.persistence.PersistenceException jpe) {
			Object response = context.getMethod().getReturnType().getDeclaredConstructor().newInstance();
			if (jpe.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
				context.getMethod().getReturnType().getDeclaredMethod("setResult", CommonResultResponse.class)
						.invoke(response, RestBuilder.buildCommonResultResponseFromConstant(
								ProjectConstants.RestConstants.Result.DUPLICATE_RECORD));
			}
			context.getMethod().getReturnType().getDeclaredMethod("setResult", CommonResultResponse.class)
					.invoke(response, RestBuilder.buildCommonResultResponseFromConstant(
							ProjectConstants.RestConstants.Result.INTERNAL_ERROR));
			return response;
		} catch (Exception e) {
			Object response = context.getMethod().getReturnType().getDeclaredConstructor().newInstance();
			context.getMethod().getReturnType().getDeclaredMethod("setResult", CommonResultResponse.class)
					.invoke(response, RestBuilder.buildCommonResultResponseGenericError());
			return response;
		}

		context.getMethod().getReturnType().getDeclaredMethod("setResult", CommonResultResponse.class).invoke(ret,
				RestBuilder.buildCommonResultResponseOK());
		return ret;
	}

}
