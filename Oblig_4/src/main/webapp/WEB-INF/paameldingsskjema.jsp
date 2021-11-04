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

<title>P�melding</title>
<script defer src="js/PassordValidator.js"></script>
<script defer src="js/FORMController.js"></script>
</head>
<body>
	<h2>P�melding</h2>
	<font color="red">${feilkode == "invalidInnput" ? 'Ugyldig innput' : ''}</font>
	<form method="post" class="pure-form pure-form-aligned">
	
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> 
				<input id="forN" type="text" required 
				placeholder="Ditt fornavn"
				pattern="[A-ZA��][A-Za-z������ -]{2,19}" 
				name="fornavn" value=""
				title="Berre bokstaver er tillatt som fornavn"/>
			</div>
			
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> 
				<input id= "etterN" type="text" 
				required placeholder="Ditt etternavn"
				pattern="[A-ZA��][A-Za-z������ -]{2,19}" 
				name="etternavn" value=""
				title="Berre bokstaver er tillatt som etternavn"/> 
			</div>
			
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> 
				<input id="mob" type="text" 
				placeholder="Mobil"
				required pattern="[0-9]{8}" 
				name="mobil" value=""
				title="Gyldig mobil (norsk) 8 - tall"/>
			</div>
			
			<div class="pure-control-group">
				<label for="password">Passord:</label> 
				<input id="pass" type="password" 
				placeholder="Passord"
				required pattern="(?=.*\w)(?=.*[!@#$%^&*_=+-]).{4,}" 
				name="passord" value="" 
				title="Passord kan inneholde tall og bokstaver, med minste lengde 4"/> 
			</div>
			
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> 
				<input id="passRep" type="password" 
				placeholder="Passord-repetert"
				name="passordRepetert" value=""
				title="Passord repetert m� v�re lik passord!"/> 
			</div>
			
			<div class="pure-control-group">
				<label for="kjonn">Kj�nn:</label> 
				<input type="radio" name="kjonn" value="mann"
				title="Velg kj�nn"
				/>mann
				<input type="radio" name="kjonn" value="kvinne"
				title="Velg kj�nn"/>kvinne
			</div>
			
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld meg p�</button>
			</div>
			
		</fieldset>
		
	</form>
</body>
</html>