package fest_oblig4;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggInnUtil {
	
	public static boolean isGyldigPassord(String passord, Passord korrektPassord) {
		return passord != null && PassordUtil.validerMedSalt(passord, korrektPassord.getPass_salt(), korrektPassord.getPass_hash());
	}

	public static boolean isInnlogget(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("innlogget") != null;
	}

	public static void loggInnMedTimeout(HttpServletRequest request, Integer mobil, int timeoutISekunder) {

		loggUt(request);
		HttpSession sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(timeoutISekunder);
		sesjon.setAttribute("innlogget", "YES_SIR");
		sesjon.setAttribute("hvem_innlogget", mobil);
	}

	public static void loggUt(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}












