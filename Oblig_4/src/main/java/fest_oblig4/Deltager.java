package fest_oblig4;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "fest_oblig4")
public class Deltager {
	
	@Id
	private Integer mobil;
	
	private String fornavn;
	private String etternavn;
	
	@Enumerated(EnumType.STRING)
	private Kjonn kjonn;
	
//	Samansatt passord av hash og salt er embedded
	@Embedded
    private Passord passord;
	
	public Deltager() {
	}

	public Deltager(Integer mobil, String fornavn, String etternavn, Kjonn kjonn, Passord passord) {
		this.mobil = mobil;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.kjonn = kjonn;
		this.passord = passord;
	}
	
	public Integer getMobil() {
		return mobil;
	}
	public void setMobil(Integer mobil) {
		this.mobil = mobil;
	}
	public String getFornavn() {
		return fornavn;
	}
	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}
	public String getEtternavn() {
		return etternavn;
	}
	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}
	public Passord getPassord() {
		return passord;
	}
	public void setPassord(Passord passord) {
		this.passord = passord;
	}
	public Kjonn getKjonn() {
		return kjonn;
	}
	public void setKjonn(Kjonn kjonn) {
		this.kjonn = kjonn;
	}
	
	@Override
	public String toString() {
		return "Deltager [mobil=" + mobil + ", fornavn=" + fornavn + ", etternavn=" + etternavn + ", passord=" + passord
				+ ", kjonn=" + kjonn + "]";
	}
	
}//class Deltager
