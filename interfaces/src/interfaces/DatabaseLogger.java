package interfaces;

public class DatabaseLogger implements Logger{

	@Override
	public void log(String message) {
		
		System.out.println("database ile giriş yapıldı. : " + message);
		
	}

}
