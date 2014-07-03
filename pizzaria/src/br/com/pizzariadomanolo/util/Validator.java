package br.com.pizzariadomanolo.util;

public class Validator {
	
	public static boolean isFloat(String preco) {
		try {
			Float.parseFloat(preco);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isInteger(String quantidade) {
		try {
			Integer.parseInt(quantidade);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	public static boolean isString(String string) {
		string = string.trim();
		
		if (string.equalsIgnoreCase("") || string.isEmpty()) {
			return false;
		}
		
		return true;

	}

}
