package nLayeredDemo.core;

import nLayeredDemo.jLoger.JLogerManeger;

public class JLogerManagerAdapter implements JLogerService {

	@Override
	public void logToSystem(String message) {
		JLogerManeger jLogerManeger= new JLogerManeger();
		jLogerManeger.log(message);
		
	}

}
