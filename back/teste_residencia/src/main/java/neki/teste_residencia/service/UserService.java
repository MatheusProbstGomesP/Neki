package neki.teste_residencia.service;

import neki.teste_residencia.entities.User;
import neki.teste_residencia.exception.UserException;
import neki.teste_residencia.repository.UserRepository;
import neki.teste_residencia.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;


    public UserVO inserir(UserVO userVO) throws UserException {
        User user = new User();
        user = convertVOParaEntidade(userVO);
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw new UserException("Erro ao adicionar Usuario");
        }
        return convertEntidadeParaVO(user);

    }


    public UserVO updateUser(Integer id, UserVO userVO) throws UserException {
        User user = convertVOParaEntidade(userVO);
        try {
            user.setId(id);
            return convertEntidadeParaVO(userRepository.save(user));
        } catch (Exception e) {
            throw new UserException("Id não encontrado");
        }
    }


    public List<UserVO> findAll() throws UserException {
        try {
            List<User> users = userRepository.findAllByOrderByIdAsc();
            List<UserVO> userVOS = new ArrayList<UserVO>();
            for (User user : users) {
                userVOS.add(convertEntidadeParaVO(user));
            }
            return userVOS;
        } catch (Exception e) {
            throw new UserException("Erro ao listar Usuarios");
        }
    }


    public UserVO findById(Integer id) throws UserException {
        try {
            return convertEntidadeParaVO(userRepository.findById(id).get());
        } catch (Exception e) {
            throw new UserException("Id não encontrado");
        }
    }


    public boolean deletarUser(Integer id){
        if(id != null) {
            userRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }



    private UserVO convertEntidadeParaVO (User user) {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setLogin(user.getLogin());
        userVO.setPassword(user.getPassword());
        userVO.setLast_login_date(user.getLast_login_date());

        return userVO;
    }

    private User convertVOParaEntidade(UserVO userVO) {
        User user = new User();
        user.setId(userVO.getId());
        user.setLogin(userVO.getLogin());
        user.setPassword(userVO.getPassword());
        user.setLast_login_date(userVO.getLast_login_date());

        return user;
    }


}
