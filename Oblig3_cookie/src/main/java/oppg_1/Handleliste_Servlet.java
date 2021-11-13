package oppg_1;

import static oppg_1.UrlMappings.HANDLELISTE_URL;
import static oppg_1.UrlMappings.LOGIN_URL;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/handleliste")
public class Handleliste_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String escapeHtml(String s) {
		String resultat = s;
		resultat = resultat.replaceAll("<", "&lt;");
		resultat = resultat.replaceAll(">", "&gt;");
		resultat = resultat.replaceAll("\"", "&quot;");
		
		return resultat;
	}
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	if (!LoggInnUtil.isInnlogget(req)) {
			resp.sendRedirect(LOGIN_URL);
		}
    	
    	else {
			Cookie[] cookies = req.getCookies();
			
			List <String> verdi = Stream.of(cookies)
			.filter(x -> x.getValue().equals("ting"))
			.map(x -> x.getName())
			.collect(Collectors.toList())
			;
			
			resp.setContentType("text/html; charset=ISO-8859-1");

			PrintWriter out = resp.getWriter();
			
			out.println(
					"<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "<meta charset=\"ISO-8859-1\">"
					+ "<title>Handleliste</title>"
					+ "</head>"
					+ "<body>"
					+ "<form action=\"\" + HANDLELISTE_URL + \"\" method=\"post\">"
					+ "</table><br/>"
					+ "<fieldset>"
					+ "<legend>Legge til:</legend>"
					+ "<input type=\"text\" name=\"ting\" />\r\n"
					+ "<input type=\"submit\" value=\"Legg til handlelisto\" />"
					+ "<p>Handlelisten:</p>"
					);
			
			verdi.forEach(x -> {
				try {
					out.println("<p><button type=\"submit\" value=\"" + escapeHtml(x) + "\" name=\"slettVaren\"> Slett </button>" + " " + URLDecoder.decode(escapeHtml(x), "ISO-8859-1") + "</p>");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
			});
			
			out.println(
					"</fieldset>"
					+ "</form>"
					+ "</body>"
					+ "</html>"
					);	
		}//else
    }//doget
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	
    	if (!LoggInnUtil.isInnlogget(req)) {
			resp.sendRedirect(LOGIN_URL);
		}
    	
    	else {
			String ting = (String) req.getParameter("ting");
			String slett = req.getParameter("slettVaren");
			
			ting = URLEncoder.encode(escapeHtml(ting), "ISO-8859-1");
			
			if (!ting.isBlank()) {
				Cookie cookie = new Cookie(ting,"ting");
				resp.addCookie(cookie);
			}
			
			
			if (slett != null) {
				Cookie[] cookies = req.getCookies();
				
				Arrays.asList(cookies).forEach(x -> {
					if(x.getName().equals(slett)) {
						x.setMaxAge(0);
						resp.addCookie(x);
					}
				});
				
//				alternativ vanlig:
//				for (Cookie cookie : cookies) {
//					if (cookie.getName().equals(slett)) {
//						cookie.setMaxAge(0);
//						resp.addCookie(cookie);
//					}
//				}	
			}
			
			resp.sendRedirect(HANDLELISTE_URL);
		}
    	
    }//dopost
}//class
