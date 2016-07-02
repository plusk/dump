package o7;

import java.io.OutputStream;
import java.io.PrintWriter;

public class StreamLogger implements ILogger{
	private OutputStream stream;
	private String formatString = "%s: %s (%s)";
	
	public StreamLogger(OutputStream stream){
		this.stream = stream;
	}
	
	@Override
	public void log(String severity, String message, Exception exception) {
		PrintWriter writer = new PrintWriter(stream);
		String logMessage = String.format(formatString, severity, message, exception);
		writer.println(logMessage);
		writer.flush();
	}

	public void setFormatString(String formatString) {
		this.formatString = formatString;
	}
}
