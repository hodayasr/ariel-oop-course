package singleton;

import java.util.*;

/**
 * A singleton class with factory method (lazy initialization).
 * 
 * @author erelsgl
 */
public final class Translator3 {
	private static volatile Translator3 INSTANCE = null;

	public static final Translator3 getInstance() {
		if (INSTANCE==null) {
			synchronized(Translator3.class) {
				if (INSTANCE==null) {
					INSTANCE = new Translator3();
				}
			}
		}
		return INSTANCE;
	}

	public String translateToEnglish(String hebrew) {
		return dictionary.get(hebrew);
	}
	
	private Translator3() {
		this.dictionary = new HashMap<>();
		dictionary.put("פרה", "cow");
		dictionary.put("כבש", "lamb");
		// ...
	}
	
	private Map<String,String> dictionary;
}
