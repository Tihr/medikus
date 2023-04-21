package medikus.bl.error;

import org.jboss.logging.Logger;

import medikus.util.ProjectConstants;

public class ProjectException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final Logger LOG = Logger.getLogger(ProjectException.class);

	private ProjectConstants.RestConstants.Result result;

	public ProjectException(ProjectConstants.RestConstants.Result result, Throwable rootCause) {
		super(result.getMessage(), rootCause);
		this.setResult(result);
		LOG.error(result.getMessage(), rootCause);
	}

	public ProjectConstants.RestConstants.Result getResult() {
		return result;
		
	}

	public void setResult(ProjectConstants.RestConstants.Result result) {
		this.result = result;
		
	}

	
	
}
