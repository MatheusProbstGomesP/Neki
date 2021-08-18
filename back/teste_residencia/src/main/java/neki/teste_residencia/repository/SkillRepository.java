package neki.teste_residencia.repository;

import neki.teste_residencia.entities.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository extends JpaRepository<Skill,Integer> {

    List<Skill> findAllByOrderByIdAsc();
}
