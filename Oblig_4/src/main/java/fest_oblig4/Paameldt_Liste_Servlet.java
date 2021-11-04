package fest_oblig4;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Deltager_Liste
 */
@WebServlet("/liste")
public class Paameldt_Liste_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Deltager_DAO deltager_DAO;
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		if (!LoggInnUtil.isInnlogget(req)) {
			resp.sendRedirect("logginn" + "?feilkode=noAccess");
		}
		
		else {
			List<Deltager> deltagerer = deltager_DAO.hente_alle_deltagerer();
			
			req.setAttribute("deltagerer", deltagerer);
			
//			får tak i hvem som er innlogget
			HttpSession sesjon = req.getSession(true);
			req.setAttribute("hvem_innlogget", sesjon.getAttribute("hvem_innlogget"));
			
			req.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		servlet --> paameldingsbekreftelse.jsp
//		req.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(req, resp);
	}

}
