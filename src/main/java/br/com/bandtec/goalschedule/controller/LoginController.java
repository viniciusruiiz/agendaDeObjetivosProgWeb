package br.com.bandtec.goalschedule.controller;

import br.com.bandtec.goalschedule.Credential;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/")
    public ResponseEntity authenticate(@RequestBody Credential credential) {

        String failureMessage = "invalid credentials";
        String successMessage = "success authentication";

        if (credential.getUsername() == null || credential.getPassword() == null){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureMessage);
        }
        
        if (credential.getUsername().isEmpty() || credential.getPassword().isEmpty() ) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureMessage);
        }

        if (!credential.getPassword().equals(credential.getUsername())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failureMessage);
        }

        return ResponseEntity.status(HttpStatus.OK).body(successMessage);
    }
}
