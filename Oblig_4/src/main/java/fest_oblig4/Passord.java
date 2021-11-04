package fest_oblig4;

import javax.persistence.Embeddable;

@Embeddable
public class Passord {

	private String pass_hash;
    private String pass_salt;
    
	private Passord(String hash, String salt) {
		pass_hash = hash;
		pass_salt = salt;
	}
	
	public Passord() {
	}

	public static Passord lagPassord(String passordKlartekst) {
		String salt = PassordUtil.genererTilfeldigSalt();
		String hash = PassordUtil.hashMedSalt(passordKlartekst, salt);
		return new Passord(hash, salt);
	}
	
	public String getPass_hash() {
		return pass_hash;
	}

	public void setPass_hash(String pass_hash) {
		this.pass_hash = pass_hash;
	}

	public String getPass_salt() {
		return pass_salt;
	}

	public void setPass_salt(String pass_salt) {
		this.pass_salt = pass_salt;
	}

	@Override
	public String toString() {
		return "Passord [pwd_hash=" + pass_hash + ", pwd_salt=" + pass_salt + "]";
	}
}
