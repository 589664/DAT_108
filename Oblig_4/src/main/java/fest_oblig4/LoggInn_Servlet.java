package fest_oblig4;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logginn")
public class LoggInn_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Deltager_DAO deltager_DAO;
       
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String feilkode = req.getParameter("feilkode");
    	
    	if (feilkode != null) {
			req.setAttribute("feilkode", feilkode);
		}
    	
    	req.getRequestDispatcher("WEB-INF/logginn.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	Integer mobilINP = Integer.valueOf(req.getParameter("mobil"));

    	List<Deltager> list = deltager_DAO.hente_alle_deltagerer();
    	
    	Integer mobil = list.stream()
    	.map(d -> d.getMobil())
    	.filter(m -> m.equals(mobilINP))
    	.findAny().orElse(null);
    	
    	if (mobil == null) {
    		resp.sendRedirect("logginn" + "?feilkode=invalidPassword");
		}
    	
    	else {
    		String passord = req.getParameter("passord");
        	
        	Passord riktigPassord = deltager_DAO.hentDeltager(mobil).getPassord();
        	
        	if (!LoggInnUtil.isGyldigPassord(passord, riktigPassord)) {
    			resp.sendRedirect("logginn" + "?feilkode=invalidPassword");
    		}
        	
        	else {
        		LoggInnUtil.loggInnMedTimeout(req, mobil, Integer.parseInt(getServletContext().getInitParameter("loggInnTimer")));
        		resp.sendRedirect("liste");
    		}
		}
    	
    }

}
