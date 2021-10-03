package Oppg_3;

public class Ansatt {
	
	private String navn;
	private String etternavn;
	private Kjonn kjonn;
	private String stilling;
	private int aarslonn;
	
	public Ansatt(String navn, String etternavn, Kjonn kjonn, String stilling, int aarslonn) {
		super();
		this.navn = navn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.stilling = stilling;
		this.aarslonn = aarslonn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public Kjonn getKjonn() {
		return kjonn;
	}

	public void setKjonn(Kjonn kjonn) {
		this.kjonn = kjonn;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getAarslonn() {
		return aarslonn;
	}

	public void setAarslonn(int aarslonn) {
		this.aarslonn = aarslonn;
	}

	@Override
	public String toString() {
		return "Ansatt [navn=" + navn + ", etternavn=" + etternavn + ", kjonn=" + kjonn + ", stilling=" + stilling
				+ ", aarslonn=" + aarslonn + "]";
	}
	
	
	
}
