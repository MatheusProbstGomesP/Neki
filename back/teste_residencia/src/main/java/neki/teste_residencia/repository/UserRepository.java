package neki.teste_residencia.repository;

import neki.teste_residencia.entities.User;
import neki.teste_residencia.entities.User_skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findAllByOrderByIdAsc();

}
