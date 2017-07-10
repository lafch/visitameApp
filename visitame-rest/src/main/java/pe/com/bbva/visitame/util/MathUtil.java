package pe.com.bbva.visitame.util;

import java.util.concurrent.ThreadLocalRandom;

public class MathUtil {
	
	public static Integer generateRandom(Integer min , Integer max) {
		int randomNum = ThreadLocalRandom.current().nextInt(min, max + 1);
		return randomNum;
	}
	
}


