package classes;

public class OtherMethods {
	public static boolean verificarEmail(String email, String [] dominios) {
		boolean resultado = false;		
		for (int i = 0; i<dominios.length; i++) {
			if(email.contains(dominios[i])) {
				resultado = true;
			}
		}

		return resultado;
	}
	
	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
		
	}
	
	
}