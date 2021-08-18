package neki.teste_residencia.service;

import neki.teste_residencia.entities.Skill;
import neki.teste_residencia.entities.User;
import neki.teste_residencia.exception.SkillException;
import neki.teste_residencia.exception.UserException;
import neki.teste_residencia.repository.SkillRepository;
import neki.teste_residencia.vo.SkillVO;
import neki.teste_residencia.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    @Autowired
    SkillRepository skillRepository;


    public SkillVO inserir(SkillVO skillVO) throws SkillException {
        Skill skill = new Skill();
        skill = convertVOParaEntidade(skillVO);
        try {
            skillRepository.save(skill);
        } catch (Exception e) {
            throw new SkillException("Erro ao adicionar Skill");
        }
        return convertEntidadeParaVO(skill);

    }



    public SkillVO updateSkill(Integer id, SkillVO skillVO) throws SkillException {
        Skill skill = convertVOParaEntidade(skillVO);
        try {
            skill.setId(id);
            return convertEntidadeParaVO(skillRepository.save(skill));
        } catch (Exception e) {
            throw new SkillException("Id não encontrado");
        }
    }




    public List<SkillVO> findAll() throws SkillException {
        try {
            List<Skill> skills = skillRepository.findAll();
            List<SkillVO> skillVOS = new ArrayList<SkillVO>();
            for (Skill skill : skills) {
                skillVOS.add(convertEntidadeParaVO(skill));
            }
            return skillVOS;
        } catch (Exception e) {
            throw new SkillException("Erro ao listar Skills");
        }
    }


    public SkillVO findById(Integer id) throws SkillException {
        try {
            return convertEntidadeParaVO(skillRepository.findById(id).get());
        } catch (Exception e) {
            throw new SkillException("Id não encontrado");
        }
    }



    public boolean deletarSkill(Integer id){
        if(id != null) {
            skillRepository.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }


    private SkillVO convertEntidadeParaVO (Skill skill) {
        SkillVO skillVO = new SkillVO();
        skillVO.setId(skill.getId());
        skillVO.setName(skill.getName());
        skillVO.setDescription(skill.getDescription());
        skillVO.setVersion(skill.getVersion());
        skillVO.setImage_url(skill.getImage_url());


        return skillVO;
    }

    private Skill convertVOParaEntidade(SkillVO skillVO) {
        Skill skill = new Skill();
        skill.setId(skillVO.getId());
        skill.setName(skillVO.getName());
        skill.setDescription(skillVO.getDescription());
        skill.setVersion(skillVO.getVersion());
        skill.setImage_url(skillVO.getImage_url());

        return skill;
    }


}
