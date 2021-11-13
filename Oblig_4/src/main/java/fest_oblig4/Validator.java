package fest_oblig4;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class Validator {
	
	public static final String HVASOMHELST_BOKSTAV_MED_MELLOMROM = "[a-zA-ZæøåÆØÅ -]";
    public static final String HVASOMHELSTBOKSTAV = "[a-zA-ZæøåÆØÅ-]";
    public static final String STORBOKSTAV = "[A-ZÆØÅ]";
    public static final String ANY_DIGIT = "[0-9]";

    public static final String ZERO_OR_MORE_TIMES = "*";
    public static final String MINST_2_TIL_15_GONGER = "{2,15}";
    public static final String MINST_5_GONGER = "{5,}";
	
	//det som må sjekkast
	private String navn;
	private String etterN;
	private String mobil;
	private String pass;
	private String passRep;
	private String kjonn;
	
	//feilmeldinger
	private String feil_navn;
	private String feil_etternavn;
	private String feil_mobil;
	private String feil_pass;
	private String feil_pass_rep;
	private String feil_kjonn;
	
	public Validator() {
	}
	
	public Validator(HttpServletRequest req) {
		this.navn = req.getParameter("fornavn");
		this.etterN = req.getParameter("etternavn");
		this.mobil = req.getParameter("mobil");
		this.pass = req.getParameter("passord");	
		this.passRep = req.getParameter("passordRepetert");
		this.kjonn = req.getParameter("kjonn");
	}
	
	public void feilMeldinger() {
		
		if (!gyldigMobil(mobil)) {
			mobil = "";
			feil_mobil = "Ugyldig mobil!";
		}
		if (!gyldigNavn(navn)) {
			navn = "";
			feil_navn = "Ugyldig fornavn!";
		}
		
		if (!gyldigNavn(etterN)) {
			etterN = "";
			feil_etternavn = "Ugyldig etternavn!";
		}
		
		if (!gyldigPass(pass)) {
			pass = "";
			feil_pass = "Ugyldig passord!";
		}
		
		if (!gyldigPassRep(pass, passRep)) {
			passRep = "";
			feil_pass_rep = "Passorda må vera like!";
		}
		
		if (!gyldigKjonn(kjonn)) {
			kjonn = "";
			feil_kjonn = "Må oppgi kjønn!";
		}
		
	}//feilMeldinger
	
	public boolean gyldigDeltager(Integer mob, String fornavn, String etternavn, String pass, String gyldigpass) {
		return gyldigMobil(String.valueOf(mob)) && gyldigNavn(fornavn) && gyldigNavn(etternavn) && gyldigPass(pass) && gyldigPassRep(pass, passRep);
	}//gyldigDeltager
	
	//eksempel bruk av regex + vanlig
	public boolean gyldigMobil(String mob) {
		return mob.matches("[0-9]+") && mob != null && mob.length() == 8;
	}//gyldigMobil
	
	//eksempel bruk av regex
	public boolean gyldigNavn(String fornavn) {
		return fornavn.matches("^" + STORBOKSTAV + HVASOMHELST_BOKSTAV_MED_MELLOMROM + MINST_5_GONGER + "$") && !fornavn.isEmpty() && fornavn != null;
	}//gyldigNavn
	
	public boolean gyldigPass(String pass) {
		return Pattern.matches("[A-Za-z0-9!@#$%^&*_=+ -]+" , pass) && !(pass.isEmpty()) && (pass != null); 
	}//gyldigPass
	
	public boolean gyldigPassRep(String pass, String passRep) {
		return passRep.equals(pass);
	}//gyldigPassRep
	
	public boolean gyldigKjonn(String kjonn) {
        return kjonn != null && (kjonn.equals("mann") || kjonn.equals("kvinne"));
    }//gyldigKjonn

	public String getNavn() {
		return navn;
	}

	public String getEtterN() {
		return etterN;
	}

	public String getMobil() {
		return mobil;
	}

	public String getPass() {
		return pass;
	}

	public String getPassRep() {
		return passRep;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getFeil_navn() {
		return feil_navn;
	}

	public String getFeil_etternavn() {
		return feil_etternavn;
	}

	public String getFeil_mobil() {
		return feil_mobil;
	}

	public String getFeil_pass() {
		return feil_pass;
	}

	public String getFeil_pass_rep() {
		return feil_pass_rep;
	}

	public String getFeil_kjonn() {
		return feil_kjonn;
	}

}//class Validator
