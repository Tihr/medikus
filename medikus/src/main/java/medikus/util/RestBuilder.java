package medikus.util;

import medikus.bl.exception.ProjectException;
import medikus.rs.model.CommonResultResponse;

public class RestBuilder {

	public static CommonResultResponse buildCommonResultResponseOK() {

		return buildCommonResultResponse(ProjectConstants.RestConstants.Result.OK.getCode(),
				ProjectConstants.RestConstants.Result.OK.getMessage(), true);

	}


	public static CommonResultResponse buildCommonResultFromProjectException(ProjectException pe) {
		return buildCommonResultResponse(pe.getResult().getCode(), pe.getResult().getMessage(), false);
	}

	public static CommonResultResponse buildCommonResultFromException(ProjectConstants.RestConstants.Result result, Exception e)
	{
		return buildCommonResultResponse(result.getCode(),e.getMessage(), false);
	}
	public static CommonResultResponse buildCommonResultResponseGenericError() {
		return buildCommonResultResponse(ProjectConstants.RestConstants.Result.GENERIC_ERROR.getCode(), ProjectConstants.RestConstants.Result.GENERIC_ERROR.getMessage(), false);
	}
	public static CommonResultResponse buildCommonResultResponseFromConstant(ProjectConstants.RestConstants.Result result) {
		return buildCommonResultResponse(result.getCode(), result.getMessage(), false);
	}
	public static CommonResultResponse buildCommonResultResponse(String code, String message, boolean success) {
		CommonResultResponse result = new CommonResultResponse();
		result.setCode(code);
		result.setMessage(message);
		result.setResult(success);
		result.setxRequestID(RandomUtils.generateUniqueIdentifier());
		return result;

	}
}
