package neki.teste_residencia.controller;

import neki.teste_residencia.entities.Skill;
import neki.teste_residencia.exception.SkillException;
import neki.teste_residencia.service.SkillService;
import neki.teste_residencia.vo.SkillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping
    public ResponseEntity<List<SkillVO>> obterTodos() throws SkillException {
        return new ResponseEntity<>(this.skillService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkillVO> ProcurarPorId(@PathVariable Integer id) throws SkillException {
        return new ResponseEntity<>(this.skillService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SkillVO> adicionar(@RequestBody SkillVO skillVO) throws SkillException {
        return new ResponseEntity<>(this.skillService.inserir(skillVO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkillVO> atualizar(@PathVariable(value = "id") Integer id,
                                            @RequestBody SkillVO skillVO) throws SkillException {
        return new ResponseEntity<>(this.skillService.updateSkill(id, skillVO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Skill> deletarSkill(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = skillService.deletarSkill(id);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }

}
