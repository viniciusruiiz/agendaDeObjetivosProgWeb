package br.com.bandtec.golaschedule.repository;

import br.com.bandtec.goalschedule.domain.Goal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository {
	public void save(Goal objetivo);

	public List<Goal> ate(LocalDate data);
}
