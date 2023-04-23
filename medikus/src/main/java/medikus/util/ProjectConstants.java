package medikus.util;

public class ProjectConstants {

	public static class RestConstants
	{

		
		public static enum Result{
			OK("0000","SUCCESS"),
			NOT_FOUND_RECORD("1404","Record not found."),
			GENERIC_ERROR("1000","Generic error."), DUPLICATE_RECORD("1409","Record already present."),  INTERNAL_ERROR("1500","Internal error."), FORBIDDEN_OPERATION("1403","Operation is not allowed."), BAD_REQUEST("1400","Bad Request");

			private String code;
			private String message;
			Result(String code, String message) {
				this.setCode(code);
				this.setMessage(message);
			}
			public String getMessage() {
				return message;
				
			}
			public void setMessage(String message) {
				this.message = message;
				
			}
			public String getCode() {
				return code;
				
			}
			public void setCode(String code) {
				this.code = code;
				
			}
			
		}

	}
}
