package br.com.bandtec.goalschedule.controller;

import br.com.bandtec.goalschedule.domain.Objetivo;
import br.com.bandtec.goalschedule.domain.TodosObjetivos;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ObjetivosController {

    private final TodosObjetivos objetivosRepository;

    @Autowired
    public ObjetivosController(TodosObjetivos objetivosRepository) {
        this.objetivosRepository = objetivosRepository;
    }

    @GetMapping("/objetivos/data/{data}")
    public ResponseEntity<List<Objetivo>> getByDate(@PathVariable("data") String ate) {
        List<Objetivo> retVal = this.objetivosRepository.ate(LocalDate.parse(ate));

        if (retVal.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(retVal);
    }

    @PostMapping("/objetivos")
    public ResponseEntity<String> getByDate(@RequestBody Objetivo objetivo) {

        try {
            this.objetivosRepository.salvar(objetivo);

            return ResponseEntity.ok("Salvo com sucesso");
        } catch(Exception e)  {
            return ResponseEntity.unprocessableEntity().body("Erro ao processar a request");
        }
    }
}
