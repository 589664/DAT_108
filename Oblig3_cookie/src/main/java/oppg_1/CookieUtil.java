package oppg_1;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.stream.Stream;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {

	private final static String CHARACTER_ENCODING = "UTF-8";
	private final static int MAX_AGE_IN_SECONDS = 30;

	public static void addCookieToResponse(HttpServletResponse response, String navn, String verdi) {
		try {
			Cookie cookie = new Cookie(navn, URLEncoder.encode(verdi, CHARACTER_ENCODING));
			cookie.setMaxAge(MAX_AGE_IN_SECONDS);
			response.addCookie(cookie);
		} catch (UnsupportedEncodingException e) {
			// Should never happen
			e.printStackTrace();
		}
	}//addCookieToResponse
	
	public static String getCookieFromRequest(HttpServletRequest request, String navn) {
		
		String verdi = null;
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null) {
			
			verdi = Stream.of(cookies)
					.filter(c -> c.getName().equals(navn))
					.map(Cookie::getValue)
					.findFirst().orElse(null);
			
			try {
				verdi = URLDecoder.decode(verdi, CHARACTER_ENCODING);
			} catch (UnsupportedEncodingException e) {
				// Should never happen
				e.printStackTrace();
			}
		}
		
		return verdi;
	}//getCookieFromRequest
}//class CookieUtil
