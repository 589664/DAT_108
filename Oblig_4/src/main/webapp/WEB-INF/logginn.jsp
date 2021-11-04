<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Logg inn</title>
</head>
<body>
	<h2>Logg inn</h2>
	<p>
		<font color="red">${feilkode == "noAccess" ? 'Det er kun registrerte deltagere som får se deltagerlisten!' : ''}</font>
		<font color="blue">${feilkode == "invalidPassword" ? 'Ugyldig brukernavn og/eller passord' : ''}</font>
		<font color="green">${feilkode == "brukerExists" ? 'Bruker eksisterer allerede, vennligst logg inn!' : ''}</font>
	</p>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="mobil">Mobil:</label> <input type="text" name="mobil" />
			</div>
			<div class="pure-control-group">
				<label for="passord">Passord:</label> <input type="password"
					name="passord" />
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Logg inn</button>
			</div>
		</fieldset>
	</form>

</body>
</html>