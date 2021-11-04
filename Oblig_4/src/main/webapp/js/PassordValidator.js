"use strict"

class PassordValidator{
	constructor() {
		this.passStr = this.passStr.bind(this);
  	}
	
	passStr(passord){
		let matchPattern = passord.match(/\d+/g)
		let styrke = true;

		if  (matchPattern == null && (passord.length >= 4)) {
			styrke = false;
		}

		return styrke;
	}
}




