package oppg_1;

import static oppg_1.UrlMappings.HANDLELISTE_URL;
import static oppg_1.UrlMappings.LOGIN_URL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = UrlMappings.LOGIN_URL, urlPatterns = "/login")
public class LoggInnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String po = req.getParameter("passord");
    	
			if (!LoggInnUtil.isGyldigPassord(po, getServletConfig().getInitParameter("riktig_passord"))) {
				resp.sendRedirect(LOGIN_URL + "?feilkode=invalidPassword");
			}
				
			else {
				LoggInnUtil.loggInnMedTimeout(req, Integer.parseInt(getServletConfig().getInitParameter("loggInnTimer")));
	    		resp.sendRedirect(HANDLELISTE_URL);
			}
    	
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String feilmelding = "";
    	String feilkode = req.getParameter("feilkode");
    	if (feilkode != null && feilkode.equals("invalidPassword")) {
    		feilmelding = "Passordet du gav inn var feil. Prøv igjen:";
    	}
    	
    	resp.setContentType("text/html; charset=ISO-8859-1");

        PrintWriter out = resp.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Login</title>");
        out.println("</head>");
        out.println("<body>");
        
        out.println(feilmelding);

        out.println("<form action=\"" + UrlMappings.LOGIN_URL + "\" method=\"post\">");
        out.println("  <fieldset>");
        out.println("    <legend>Login</legend>");
        out.println("<p>Passord: <input type=\"password\" name=\"passord\" /></p>\r\n"
        		   +"<p><input type=\"submit\" value=\"Logg inn\" /></p>");
        out.println("  </fieldset>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }

}
