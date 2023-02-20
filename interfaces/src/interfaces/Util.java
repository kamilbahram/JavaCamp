package interfaces;

public class Util {
	
	public static void runLogers(Logger [] loggers, String message) {
		for (Logger logger : loggers) {
			logger.log(message);
		}
	}

}
