package br.com.bandtec.agendaDeObjetivos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PresentationController {

	@RequestMapping("/")
	public String index() {
		return "Hello World";
	}
	
}
