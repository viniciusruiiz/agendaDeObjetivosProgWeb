package br.com.bandtec.goalschedule.controller;

import br.com.bandtec.goalschedule.Credential;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class LoginControllerTests {
    private LoginController controller;
    private final String successMessage = "success authentication";
    private final String failureMessage = "invalid credentials";
    
    @Before
    public void setUp(){
        controller = new LoginController();
    }
    
    @Test
    public void authenticate_withValidCredentials_returnsHttpOK(){
        Credential credential = new Credential("admin", "admin");
        
        ResponseEntity response = controller.authenticate(credential);
        
        assertTrue(response.getStatusCode().equals(HttpStatus.OK));
        assertTrue(successMessage.equals(response.getBody()));
    }
    
    @Test
    public void authenticate_withInvalidCredentials_returnsHttpUnauthorized(){
        Credential credential = new Credential("admin", "123");
        
        ResponseEntity response = controller.authenticate(credential);
        
        assertTrue(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
        assertTrue(failureMessage.equals(response.getBody()));
    }
    
    @Test
    public void authenticate_withEmptyUsernameAndEmptyPassword_returnsHttpUnauthorized(){
        Credential credential = new Credential("", "123");
        
        ResponseEntity response = controller.authenticate(credential);
        
        assertTrue(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
        assertTrue(failureMessage.equals(response.getBody()));
    }
    
    @Test
    public void authenticate_withEmptyUsernameAndSomePassword_returnsHttpUnauthorized(){
        Credential credential = new Credential("", "123");
        
        ResponseEntity response = controller.authenticate(credential);
        
        assertTrue(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
        assertTrue(failureMessage.equals(response.getBody()));
    }
    
    @Test
    public void authenticate_withSomeUsernameAndEmptyPassword_returnsHttpUnauthorized(){
        Credential credential = new Credential("admin", "");
        
        ResponseEntity response = controller.authenticate(credential);
        
        assertTrue(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
        assertTrue(failureMessage.equals(response.getBody()));
    }
    
    @Test
    public void authenticate_withNullCredential_returnsHttpUnauthorized(){
        Credential credential = new Credential(null, null);
        
        ResponseEntity response = controller.authenticate(credential);
        
        assertTrue(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
        assertTrue(failureMessage.equals(response.getBody()));
    }
    
    @Test
    public void authenticate_withNullUsernameAndSomePassword_returnsHttpUnauthorized(){
        Credential credential = new Credential(null, "123");
        
        ResponseEntity response = controller.authenticate(credential);
        
        assertTrue(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
        assertTrue(failureMessage.equals(response.getBody()));
    }
    
    @Test
    public void authenticate_withSomeUsernameAndNullPassword_returnsHttpUnauthorized(){
        Credential credential = new Credential("admin", null);
        
        ResponseEntity response = controller.authenticate(credential);
        
        assertTrue(response.getStatusCode().equals(HttpStatus.UNAUTHORIZED));
        assertTrue(failureMessage.equals(response.getBody()));
    }
}
