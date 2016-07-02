package o7;

public class FilteringLogger implements ILogger{
	private boolean error;
	private boolean warning;
	private boolean info;
	
	ILogger logger;

	public FilteringLogger(ILogger logger, String... severities){
		this.logger = logger;
		for (int i = 0; i < severities.length; i++) {
			setIsLogging(severities[i], true);
		}
	}
	public boolean isLogging(String severity) throws IllegalArgumentException{
		if(severity.equals(ERROR)){
			return error;
		}
		else if(severity.equals(WARNING)){
			return warning;
		}
		else if(severity.equals(INFO)){
			return info;
		}
		else{
			throw new IllegalArgumentException("That's not a valid severity.");
		}
	}
	public void setIsLogging(String severity, boolean value) {
		if(severity.equals(ERROR)){
			error = value;
		}
		else if(severity.equals(WARNING)){
			warning = value;
		}
		else if(severity.equals(INFO)){
			info = value;
		}
	}
	
	@Override
	public void log(String severity, String message, Exception exception) {
		// TODO Auto-generated method stub
		if(isLogging(severity)){
			logger.log(severity, message, exception);
		}
	}
}
