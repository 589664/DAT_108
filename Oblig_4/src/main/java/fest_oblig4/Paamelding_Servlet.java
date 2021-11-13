package fest_oblig4;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Deltager_Servlet", urlPatterns = "/deltagere")
public class Paamelding_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private Deltager_DAO deltager_DAO;
	
	@Override
	public void init() throws ServletException {
	}//init
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		Får tak i feilkode 
		String feilkode = req.getParameter("feilkode");
				
		if (feilkode != null) {
			req.setAttribute("feilkode", feilkode);
		}
		
		//servlet --> paameldingsskjema.jsp
		req.getRequestDispatcher("WEB-INF/paameldingsskjema.jsp").forward(req, resp);
		
		
	}//doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Validator valid = new Validator(req);
		
		String fornavn = req.getParameter("fornavn");
		String etternavn = req.getParameter("etternavn");
		Integer mobil = Integer.valueOf(req.getParameter("mobil"));
		String passordKlarT = req.getParameter("passord");
		String passordRepetert = req.getParameter("passordRepetert");
		List<Deltager> deltaL = deltager_DAO.hente_alle_deltagerer();
		
		boolean finnes = deltaL.stream()
		.map(d -> d.getMobil())
		.anyMatch(m -> m.equals(mobil));
		
		if(finnes) {
			resp.sendRedirect("logginn" + "?feilkode=brukerExists");
		}
		
		else if (!valid.gyldigDeltager(mobil, fornavn, etternavn, passordKlarT, passordRepetert)) {
			valid.feilMeldinger();
			req.getSession().setAttribute("validator", valid);
			resp.sendRedirect("deltagere");
		}
		
		else{
			Passord passord = Passord.lagPassord(passordKlarT);
			Kjonn kjonn = req.getParameter("kjonn").equals("mann") ? Kjonn.mann : Kjonn.kvinne; 
			Deltager deltager = new Deltager(mobil, fornavn, etternavn, kjonn, passord);
			
//			lager attribut for deltager for bruk i bekreftelse 
			req.setAttribute("deltager", deltager);
			
			deltager_DAO.leggTil(deltager);
			
//			logge inn
			LoggInnUtil.loggInnMedTimeout(req, mobil, Integer.parseInt(getServletConfig().getInitParameter("loggInnTimer")));
			
//			servlet --> paameldingsbekreftelse.jsp
			req.getRequestDispatcher("WEB-INF/paameldingsbekreftelse.jsp").forward(req, resp);
		}

		
	}//doGet
	
	
}
