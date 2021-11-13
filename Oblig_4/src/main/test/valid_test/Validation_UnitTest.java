package valid_test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fest_oblig4.PassordUtil;
import fest_oblig4.Validator;

public class Validation_UnitTest {
	
	private static final String RIKTIG_PASSORD = "Hei";
	private static final String FEIL_PASSORD = "Nei";
	
	private String salt;
	private String hash;
	Validator valid = new Validator();
	
	@BeforeEach
	void setup() {
        salt = PassordUtil.genererTilfeldigSalt();
        hash = PassordUtil.hashMedSalt(RIKTIG_PASSORD, salt);
	}
	
	@Test
	void riktigPassordVirker() {
        assertTrue(PassordUtil.validerMedSalt(RIKTIG_PASSORD, salt, hash));
	}
	
	@Test
	void feilPassordVirkerIkke() {
        assertFalse(PassordUtil.validerMedSalt(FEIL_PASSORD, salt, hash));
	}
	
	@Test
	void navnValidator() {
		assertTrue(valid.gyldigNavn("Klarsson Øygard"));
		assertTrue(valid.gyldigNavn("Klarsson-Øygard"));
		assertFalse(valid.gyldigNavn("Per"));
		assertFalse(valid.gyldigNavn("Per!!!!"));
	}
	
	@Test
	void mobilValidator() {
		assertTrue(valid.gyldigMobil("11223344"));
		assertFalse(valid.gyldigMobil("1222"));
	}
	
	@Test
	void passValidator() {
		assertTrue(valid.gyldigPass("!pass123"));
		assertTrue(valid.gyldigPass("!pass $"));
		assertFalse(valid.gyldigPass("!...pass123"));
		assertTrue(valid.gyldigPassRep("pass", "pass"));
		assertFalse(valid.gyldigPassRep("pass", "pass1"));
	}
	
	@Test
	void kjonn() {
		assertTrue(valid.gyldigKjonn("mann"));
		assertTrue(valid.gyldigKjonn("kvinne"));
		assertFalse(valid.gyldigKjonn("menneske"));
	}
	

}//test class Validation_UnitTest
