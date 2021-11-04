package fest_oblig4;

import java.util.regex.Pattern;

public class Validator {
	
	private boolean containsOnlyDigits(String s) {
		boolean result = true;
		for (int i=0; i<s.length(); i++) {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				result = false;
				break;
			}
		}
		return result;
	}//containsOnlyDigits
	
	public boolean isValidStudentId(String s) {
		
		return s != null 
				&& s.length() == 7 
				&& s.startsWith("h") 
				&& containsOnlyDigits(s.substring(1));
	}//isValidStudentId
	
	public static boolean gyldigDeltager(Integer mob, String fornavn, String etternavn, String pass, String gyldigpass) {
		return gyldigMobil(String.valueOf(mob)) && gyldigNavn(fornavn) && gyldigNavn(etternavn) && gyldigPass(pass, gyldigpass);
	}//gyldigDeltager
	
	public static boolean gyldigMobil(String mob) {
		return mob.matches("[0-9]+") && mob != null && mob.length() == 8;
	}//gyldigMobil
	
	public static boolean gyldigNavn(String fornavn) {
		return fornavn.matches("([a-zA-ZÆØÅæøå -]+)") && !fornavn.isEmpty() && fornavn != null && fornavn.length() >= 5;
	}//gyldigNavn
	
	public static boolean gyldigPass(String pass, String rep_pass) {
		return Pattern.matches("[A-Za-z0-9!@#$%^&*_=+-]+" , pass) && (!pass.isEmpty() || !rep_pass.isEmpty()) && (pass != null || rep_pass != null) && pass.equals(rep_pass); 
	}//gyldigPass
	
	
}
