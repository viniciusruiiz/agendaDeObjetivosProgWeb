package br.com.bandtec.goalschedule.controller;

import br.com.bandtec.goalschedule.domain.Goal;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.bandtec.golaschedule.repository.GoalRepository;

@RestController
public class ObjetivosController {

    private final GoalRepository objetivosRepository;

    @Autowired
    public ObjetivosController(GoalRepository objetivosRepository) {
        this.objetivosRepository = objetivosRepository;
    }

    @GetMapping("/objetivos/data/{expiresIn}")
    public ResponseEntity<List<Goal>> getByExpirationDate(@PathVariable("expiresIn") String expiresIn) {
        List<Goal> goals = this.objetivosRepository.ate(LocalDate.parse(expiresIn));

        if (goals.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(goals);
    }

    @PostMapping("/objetivos")
    public ResponseEntity<String> addGoal(@RequestBody Goal goal) {

        try {
            this.objetivosRepository.save(goal);

            return ResponseEntity.ok("Sucesso");
        } catch(Exception e)  {
            return ResponseEntity.unprocessableEntity().body("Erro ao processar a request");
        }
    }
}
