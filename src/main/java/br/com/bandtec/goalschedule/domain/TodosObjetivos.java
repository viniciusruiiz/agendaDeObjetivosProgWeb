package br.com.bandtec.goalschedule.domain;

import static java.util.stream.Collectors.toList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class TodosObjetivos {

	private final List<Objetivo> objetivos;
	
	public TodosObjetivos() {
		this.objetivos = new ArrayList<>();
	}
	
	public void salvar(Objetivo objetivo) {
		this.objetivos.add(objetivo);
		System.out.println("Objetivo " +objetivo+ " cadastrado com sucesso");
	}

	public List<Objetivo> ate(LocalDate data) {
		return objetivos.stream()
				.filter(o -> o.ate(data))
				.collect(toList());
	}

}
