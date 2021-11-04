package valid_test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fest_oblig4.PassordUtil;
import fest_oblig4.Validator;

public class Validation_UnitTest {
	
	private static final String RIKTIG_PASSORD = "Bjarte kan gå å henge seg";
	private static final String FEIL_PASSORD = "Livet er bra";
	
	private String salt;
	private String hash;
	
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
		assertTrue(Validator.gyldigNavn("Klarsson Øygard"));
		assertTrue(Validator.gyldigNavn("Klarsson-Øygard"));
		assertFalse(Validator.gyldigNavn("Per"));
		assertFalse(Validator.gyldigNavn("Per!!!!"));
	}
	
	@Test
	void mobilValidator() {
		assertTrue(Validator.gyldigMobil("11223344"));
		assertFalse(Validator.gyldigMobil("1222"));
	}
	
	@Test
	void passValidator() {
		assertTrue(Validator.gyldigPass("!pass123","!pass123"));
		assertFalse(Validator.gyldigPass("!pass123","!pass1234"));
		assertFalse(Validator.gyldigPass("!...pass123","!...pass1234"));
	}
	

}//test class Validation_UnitTest
