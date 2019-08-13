package br.com.bandtec.agendaDeObjetivos.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	//@RequestMapping("/user/login")
	//public String login() {
	//	return("Logou kkkkkk");
	//}

	public ResponseEntity<String> authenticate(Credential credential) {
		return ResponseEntity.ok("Sucesso");
	}
}
