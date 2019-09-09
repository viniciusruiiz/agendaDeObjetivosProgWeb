package br.com.bandtec.goalschedule.controller;

import br.com.bandtec.goalschedule.domain.User;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    private List<User> users;
    
    public UserController(){
        this.users = this.userList();
    }
    
    @GetMapping("/users/search/name/{username}")
    public ResponseEntity<List<User>> GetUsersByName(@PathVariable("username") String username){
        
        List<User> usersFiltredByName = this.users.stream().filter(x -> username.equals(x.getName())).collect(Collectors.toList());
        
        if(usersFiltredByName.isEmpty())
            return ResponseEntity.noContent().build();
        
        return ResponseEntity.ok(usersFiltredByName);
    }
    
    @GetMapping("/users/search/age/{userAge}")
    public ResponseEntity<List<User>> GetUsersByAge(@PathVariable("userAge") int age){
        
        List<User> usersFiltredByAge = this.users.stream().filter(x -> age == x.getAge()).collect(Collectors.toList());
        
        if(usersFiltredByAge.isEmpty())
            return ResponseEntity.noContent().build();
        
        return ResponseEntity.ok(usersFiltredByAge);
    }
    
    private List<User> userList(){
        return Arrays.asList(new User("Vinicius", 20), new User("Vinicius", 25), new User("Yudi", 15));
    }
}
