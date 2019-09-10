package br.com.bandtec.goalschedule.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Goal {

	//@JsonProperty("titulo")
	@JsonProperty
	private String title;
	
	//@JsonProperty("descricao")
	@JsonProperty
	private String description;
	
	//@JsonProperty("dataMaximaParaExecucao")
	@JsonProperty
	private LocalDate expireIn;
	
	public Goal() {}
	
	public Goal(String title, String description, LocalDate expireIn) {
		super();
		this.title = title;
		this.description = description;
		this.expireIn = expireIn;
	}
        
	public boolean ate(LocalDate data) {
		return expireIn.isBefore(data) || expireIn.isEqual(data);
	}
}
