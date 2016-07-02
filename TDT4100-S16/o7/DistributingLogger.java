package o7;

public class DistributingLogger implements ILogger{
	FilteringLogger errorLogger;
	FilteringLogger warningLogger;
	FilteringLogger infoLogger;
	
	public DistributingLogger(ILogger errorLogger, ILogger warningLogger, ILogger infoLogger){
		this.errorLogger = new FilteringLogger(errorLogger);
		this.errorLogger.setIsLogging("error", true);
		
		this.warningLogger = new FilteringLogger(warningLogger);
		this.warningLogger.setIsLogging("warning", true);
		
		this.infoLogger = new FilteringLogger(infoLogger);
		this.infoLogger.setIsLogging("info", true);
	}
	
	public void setLogger(String severity, ILogger logger){
		if(severity.equals(ERROR)){
			this.errorLogger = new FilteringLogger(logger);
			this.errorLogger.setIsLogging("error", true);
		}
		else if(severity.equals(WARNING)){
			this.warningLogger = new FilteringLogger(logger);
			this.warningLogger.setIsLogging("warning", true);
		}
		else if(severity.equals(INFO)){
			this.infoLogger = new FilteringLogger(logger);
			this.infoLogger.setIsLogging("info", true);
		}
	}

	@Override
	public void log(String severity, String message, Exception exception) {
		if(severity.equals(ERROR)){
			errorLogger.log(severity, message, exception);
		}
		else if(severity.equals(WARNING)){
			warningLogger.log(severity, message, exception);
		}
		else if(severity.equals(INFO)){
			infoLogger.log(severity, message, exception);
		}
	}
}
