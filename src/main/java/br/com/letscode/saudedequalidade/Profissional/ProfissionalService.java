package br.com.letscode.saudedequalidade.Profissional;

import br.com.letscode.saudedequalidade.Exceptions.EspecialidadeProfissionalNaoExistente;
import br.com.letscode.saudedequalidade.Exceptions.ProfissionalNaoExistenteException;
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

    public List<Profissional> getProfissionais(){
        return repository.findAll();
    }

    public Profissional getProfissionalByID(Long id){
        return repository.findById(id).orElseThrow(ProfissionalNaoExistenteException::new);
    }

    public Profissional saveNewProfissional(Profissional novoProfissional) {
        return repository.save(novoProfissional);
    }

    public List<Profissional> findProfissionalByEspecialidade(String especialidade){
        return repository.findByEspecialidade(especialidade);
    }

    public List<Profissional> findProfissionalByDisponibilidade(String disponibilidade) {
        return repository.findByDiaDisponivel(disponibilidade);
    }
}
