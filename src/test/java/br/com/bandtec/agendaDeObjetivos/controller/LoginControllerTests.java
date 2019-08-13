package br.com.bandtec.agendaDeObjetivos.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTests {
	
	private LoginController controller;
	
	@Before
	public void setUp(){
		//Arrange
		controller = new LoginController();
	}
	
	@Test
	public void login_loginAndPasswordValid_returnsStatusCode200() {
		//Act
		ResponseEntity<String> response = controller.authenticate(new Credential("username", "password"));
		
		//Assert
		assertEquals(response.getStatusCode(), HttpStatus.OK);
		assertSame(response.getBody(), "Sucesso");
	}
}
