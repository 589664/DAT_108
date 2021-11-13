<%@page import="javax.validation.Valid"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<link type="text/css" rel="stylesheet" href="ramme.css">

<title>Påmelding</title>
<script defer src="js/PassordValidator.js"></script>
<script defer src="js/FORMController.js"></script>
</head>
<body>
	<h2>Påmelding</h2>
	<form method="post" class="pure-form pure-form-aligned">
	
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> 
				<input id="forN" type="text" required 
				placeholder="Ditt fornavn"
				pattern="[A-ZAØÅ][A-Za-zÆØÅæøå -]{2,19}" 
				name="fornavn" 
				value="${validator.navn}"
				title="Fornavn begynner med storbokstav og skal inneholde berre bokstaver"
				/>
				<font color="red">${validator.feil_navn}</font>
			</div>
			
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> 
				<input id= "etterN" type="text" 
				required placeholder="Ditt etternavn"
				pattern="[A-ZAØÅ][A-Za-zÆØÅæøå -]{2,19}" 
				name="etternavn"
				value="${validator.etterN}"
				title="Etternavn begynner med storbokstav og skal inneholde berre bokstaver"/>
				<font color="red">${validator.feil_etternavn}</font> 
			</div>
			
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> 
				<input id="mob" type="text" 
				placeholder="Mobil"
				required pattern="[0-9]{8}" 
				name="mobil"
				value="${validator.mobil}"
				title="Gyldig mobil (norsk) 8 - tall"/>
				<font color="red">${validator.feil_mobil}</font> 
			</div>
			
			<div class="pure-control-group">
				<label for="password">Passord:</label> 
				<input id="pass" type="password" 
				placeholder="Passord"
				required pattern="(?=.*\w)(?=.*[!@#$%^&*_=+-]).{4,}" 
				name="passord"
				value="${validator.pass}"
				title="Passord kan inneholde tall og bokstaver, med minste lengde 4"/>
				<font color="red">${validator.feil_pass}</font>  
			</div>
			
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> 
				<input id="passRep" type="password" 
				placeholder="Passord-repetert"
				name="passordRepetert"
				value="${validator.passRep}"
				title="Passord repetert må være lik passord!"/>
				<font color="red">${validator.feil_pass_rep}</font> 
			</div>
			
			<div class="pure-control-group">
				<label for="kjonn">Kjønn:</label>
				 
				<input type="radio" name="kjonn" 
				${validator.kjonn == "mann" ? 'checked=\"checked\"':''}
				value="mann" required
				title="Velg kjønn"
				/>mann
				
				<input type="radio" name="kjonn"
				${validator.kjonn == "kvinne" ? 'checked=\"checked\"':''}
				value="kvinne"
				title="Velg kjønn"
				/>kvinne
				
				<font color="red">${validator.feil_kjonn}</font> 
			</div>
			
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld meg på</button>
			</div>
			
		</fieldset>
		
	</form>
</body>
</html>