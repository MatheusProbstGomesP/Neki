package neki.teste_residencia.service;

import neki.teste_residencia.entities.Skill;
import neki.teste_residencia.entities.User;
import neki.teste_residencia.entities.User_skill;
import neki.teste_residencia.exception.SkillException;
import neki.teste_residencia.exception.User_skillException;
import neki.teste_residencia.repository.SkillRepository;
import neki.teste_residencia.repository.UserRepository;
import neki.teste_residencia.repository.User_skillRepository;
import neki.teste_residencia.vo.SkillVO;
import neki.teste_residencia.vo.User_skillVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class User_skillService {

    @Autowired
    User_skillRepository user_skillRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SkillRepository skillRepository;





    public User_skillVO inserir(User_skillVO user_skillVO) throws User_skillException {
        User_skill user_skill = new User_skill();
        user_skill = convertVOParaEntidade(user_skillVO);
        try {
            user_skillRepository.save(user_skill);
        } catch (Exception e) {
            throw new User_skillException("Erro ao adicionar User Skill");
        }
        return convertEntidadeParaVO(user_skill);

    }


    public User_skillVO updateUserSkill(Integer id, User_skillVO user_skillVO) throws User_skillException {
        User_skill user_skill = convertVOParaEntidade(user_skillVO);
        try {
            user_skill.setId(id);
            return convertEntidadeParaVO(user_skillRepository.save(user_skill));
        } catch (Exception e) {
            throw new User_skillException("Id não encontrado");
        }
    }



    public List<User_skillVO> findAll() throws User_skillException {
        try {
            List<User_skill> user_skills = user_skillRepository.findAllByOrderByIdAsc();
            List<User_skillVO> user_skillVOS = new ArrayList<User_skillVO>();
            for (User_skill user_skill : user_skills) {
                user_skillVOS.add(convertEntidadeParaVO(user_skill));
            }
            return user_skillVOS;
        } catch (Exception e) {
            throw new User_skillException("Erro ao listar Users Skills");
        }
    }


    public User_skillVO findById(Integer id) throws User_skillException {
        try {
            return convertEntidadeParaVO(user_skillRepository.findById(id).get());
        } catch (Exception e) {
            throw new User_skillException("Id não encontrado");
        }
    }

    public boolean deletarUserSkill(Integer id){
        if(id != null) {
            user_skillRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }




    private User_skillVO convertEntidadeParaVO(User_skill us) {
        User_skillVO usVO = new User_skillVO();
        usVO.setId(us.getId());
        usVO.setKnowledge_level(us.getKnowledge_level());
        usVO.setCreated_at(us.getCreated_at());
        usVO.setUpdated_at(us.getUpdated_at());
        usVO.setSkill(us.getSkill());
        usVO.setUser(us.getUser());

        return usVO;
    }


    private User_skill convertVOParaEntidade(User_skillVO usVO) {
        User_skill us = new User_skill();
        us.setId(usVO.getId());
        us.setKnowledge_level(usVO.getKnowledge_level());
        us.setCreated_at(usVO.getCreated_at());
        us.setUpdated_at(usVO.getUpdated_at());


        Optional<User> user = userRepository.findById(usVO.getUserId());
        us.setUser(user.get());

        Optional<Skill> skill = skillRepository.findById(usVO.getSkillId());
        us.setSkill(skill.get());

        return us;


    }
}
