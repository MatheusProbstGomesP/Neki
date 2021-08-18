package neki.teste_residencia.controller;

import neki.teste_residencia.entities.Skill;
import neki.teste_residencia.entities.User_skill;
import neki.teste_residencia.exception.SkillException;
import neki.teste_residencia.exception.User_skillException;
import neki.teste_residencia.service.User_skillService;
import neki.teste_residencia.vo.SkillVO;
import neki.teste_residencia.vo.User_skillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user_skill")
public class User_skillController {

    @Autowired
    User_skillService user_skillService;

    @GetMapping
    public ResponseEntity<List<User_skillVO>> obterTodos() throws User_skillException {
        return new ResponseEntity<>(this.user_skillService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User_skillVO> ProcurarPorId(@PathVariable Integer id) throws User_skillException {
        return new ResponseEntity<>(this.user_skillService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User_skillVO> adicionar(@RequestBody User_skillVO user_skillVO) throws User_skillException {
        return new ResponseEntity<>(this.user_skillService.inserir(user_skillVO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User_skillVO> atualizar(@PathVariable(value = "id") Integer id,
                                             @RequestBody User_skillVO user_skillVO) throws User_skillException {
        return new ResponseEntity<>(this.user_skillService.updateUserSkill(id, user_skillVO), HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<User_skill> deletarSkill(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = user_skillService.deletarUserSkill(id);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }
}
