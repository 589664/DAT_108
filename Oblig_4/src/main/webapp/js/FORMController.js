"use strict"

class FORMController{
	constructor() {
		this.passordValidator = new PassordValidator();
		this.valid = this.valid.bind(this);
		this.sjekkPassordStyrke = this.sjekkPassordStyrke.bind(this);
	  }

	valid(){
		let pass = document.getElementById("pass").value;
		let passRep = document.getElementById("passRep").value;
		
		if(pass == passRep){
			document.getElementById("passRep").setCustomValidity("");
		}
		else{
			document.getElementById("passRep").setCustomValidity("Repetert passord er feil");
		}

		this.sjekkPassordStyrke(document.getElementById("pass"));
	}

	sjekkPassordStyrke(event) {
		const validity = event.validity;
		let passInp = document.getElementById("pass").value.toString();

		if (validity.valid) {
			if (!this.passordValidator.passStr(passInp)) {
				document.getElementById("pass").classList.add("mediumPassword");
			}
			else{
				document.getElementById("pass").classList.remove("mediumPassword");
			}
		}
	}
	
}

const controller = new FORMController();

document.getElementById("pass").addEventListener("input", controller.valid);
document.getElementById("passRep").addEventListener("input", controller.valid);


