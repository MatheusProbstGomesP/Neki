package neki.teste_residencia.controller;

import neki.teste_residencia.entities.User;
import neki.teste_residencia.exception.UserException;
import neki.teste_residencia.service.UserService;
import neki.teste_residencia.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserVO>> obterTodos() throws UserException {
        return new ResponseEntity<>(this.userService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserVO> ProcurarPorId(@PathVariable Integer id) throws UserException {
        return new ResponseEntity<>(this.userService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserVO> adicionar(@RequestBody UserVO userVO) throws UserException {
        return new ResponseEntity<>(this.userService.inserir(userVO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserVO> atualizar(@PathVariable(value = "id") Integer id,
                                             @RequestBody UserVO userVO) throws UserException {
        return new ResponseEntity<>(this.userService.updateUser(id, userVO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deletarUser(@PathVariable Integer id){
        HttpHeaders headers = new HttpHeaders();
        boolean isRemoved = userService.deletarUser(id);
        if (isRemoved){
            return new ResponseEntity<>(headers,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(headers,HttpStatus.BAD_REQUEST);

        }

    }


}
