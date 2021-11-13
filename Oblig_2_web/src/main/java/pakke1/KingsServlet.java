package pakke1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/king")
public class KingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();

				
		String aarString = req.getParameter("aar");
		
//		validation:
		
		if (!isValidY(aarString)) {
			out.println("Ugyldig Innput!");
			out.println("<input type=\"button\" onclick=\"window.location.href='http://localhost:8080/kissmy.../';\" value=\"Søk igjen!\" />");
		} else {
			
			int aar = Integer.parseInt(aarString);
			
			Konge konge = Konger.norske.stream()
					.filter(x -> x.getKongeFraAar() <= aar && aar <= x.getKongeTilAar())
					.findFirst()
					.orElse(null)
					;
					
			resp.setContentType("text/html");
			
			
			if (konge != null) {
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
		        out.println("<meta charset=\"ISO-8859-1\">");
		        out.println("<h1>Kongen i " + aar + " var " + konge.getNavn() + "</h1>");
		        out.println("</head>");
		        out.println("<body>");
		        out.println("<img src="+ konge.getBilde() + " width=\"400\" height=\"600\">");
		        out.println("<input type=\"button\" onclick=\"window.location.href='http://localhost:8080/kissmy.../';\" value=\"Søk igjen!\"/>");
		        out.println("</body>");
		        out.println("</html>");
			}
			else {
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
		        out.println("<meta charset=\"ISO-8859-1\">");
		        out.println("<p>" + "Finnes ikke konge for denne tidsperioden i systemet bla bla ..." + "</p>");
		        out.println("<input type=\"button\" onclick=\"window.location.href='http://localhost:8080/kissmy.../';\" value=\"Søk igjen!\" />");
		        out.println("</head>");
		        out.println("</html>");
			}
			
		}
		
	}//doGet
	
	public boolean isValidY(String s) {
		return s != null && s.matches("^\\d{4}$");
	}//isValidY
	
}//class
