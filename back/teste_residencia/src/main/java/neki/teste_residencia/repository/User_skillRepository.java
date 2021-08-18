package neki.teste_residencia.repository;

import neki.teste_residencia.entities.Skill;
import neki.teste_residencia.entities.User_skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface User_skillRepository extends JpaRepository<User_skill,Integer> {

    List<User_skill> findAllByOrderByIdAsc();

}
