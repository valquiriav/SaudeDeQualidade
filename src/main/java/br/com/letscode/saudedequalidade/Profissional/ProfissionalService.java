package br.com.letscode.saudedequalidade.Profissional;

import br.com.letscode.saudedequalidade.Exceptions.EspecialidadeProfissionalNaoExistente;
import br.com.letscode.saudedequalidade.Exceptions.ProfissionalNaoDisponivelException;
import br.com.letscode.saudedequalidade.Exceptions.ProfissionalNaoExistenteException;
import br.com.letscode.saudedequalidade.Exceptions.RegiaoProfissionalNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProfissionalService {

    private ProfissionalRepository repository;

    @Autowired
    public ProfissionalService(ProfissionalRepository profissionalRepository){
        repository = profissionalRepository;
    }

    public List<ProfissionalDTO> getProfissionais(){
        return ProfissionalDTO.convertToList(repository.findAll());
    }

    public ProfissionalDTO getProfissionalByID(Long id){
        return ProfissionalDTO.of(repository.findById(id).orElseThrow(ProfissionalNaoExistenteException::new));
    }

    public Profissional saveNewProfissional(Profissional novoProfissional) {
        return repository.save(novoProfissional);
    }

    public List<ProfissionalDTO> findProfissionalByEspecialidade(String especialidade){
        List<ProfissionalDTO> list = ProfissionalDTO.convertToList(repository.findByEspecialidade(especialidade));
        if(!list.isEmpty()){
            return list;
        }
        throw new EspecialidadeProfissionalNaoExistente();
    }

    public List<ProfissionalDTO> findProfissionalByDisponibilidade(String disponibilidade) {
        List<ProfissionalDTO> list = ProfissionalDTO.convertToList(repository.findByDiaDisponivel(disponibilidade));
        if (!list.isEmpty()) {
            return list;
        }
        throw new ProfissionalNaoDisponivelException();
    }

    public List<ProfissionalDTO> findProfissionalByRegiao(String regiao) {
        List<ProfissionalDTO> list = ProfissionalDTO.convertToList(repository.findProfissionalByRegiao(regiao));
        if(!list.isEmpty()){
            return list;
        }
        throw new RegiaoProfissionalNaoEncontrado();
    }
}
