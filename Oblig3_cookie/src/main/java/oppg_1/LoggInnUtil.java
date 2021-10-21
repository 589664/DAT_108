package oppg_1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoggInnUtil {
	
	public static boolean isGyldigPassord(String passord, String korrektPassord) {
		return passord != null && passord.equals(korrektPassord);
	}

	public static boolean isInnlogget(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session != null && session.getAttribute("innlogget") != null;
	}

	public static void loggInnMedTimeout(HttpServletRequest request, int timeoutISekunder) {

		loggUt(request);
		HttpSession sesjon = request.getSession(true);
		sesjon.setMaxInactiveInterval(timeoutISekunder);
		sesjon.setAttribute("innlogget", "YES_SIR");
	}

	public static void loggUt(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		if (session != null) {
			session.invalidate();
		}
	}

}












