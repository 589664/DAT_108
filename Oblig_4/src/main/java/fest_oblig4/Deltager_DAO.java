package fest_oblig4;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Deltager_DAO {
	
	private static List<Deltager> deltagere = new ArrayList<>();
	
	@PersistenceContext(name = "deltagerPU")
    private EntityManager em;
	
	public void leggTil(Deltager nydeltager) {
		em.persist(nydeltager);
	}
	
	public Deltager hentDeltager(Integer mobil) {
		return em.find(Deltager.class, mobil);
	}
	
	public List<Deltager> hente_alle_deltagerer() {
		return em.createQuery("SELECT d FROM Deltager d ORDER BY d.fornavn ASC, d.etternavn ASC", Deltager.class).getResultList();
	}
	
}//class Deltager_DAO
