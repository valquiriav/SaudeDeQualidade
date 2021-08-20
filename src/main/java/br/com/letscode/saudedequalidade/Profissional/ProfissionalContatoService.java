package br.com.letscode.saudedequalidade.Profissional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfissionalContatoService {

    private final ProfissionalContatoRepository repository;

    @Autowired
    public ProfissionalContatoService(ProfissionalContatoRepository prepository){
        repository = prepository;
    }


    public List<ProfissionalContatoDTO> findProfissionalContatoByidProfissional(Profissional profissional){
        List<ProfissionalContato> list = repository.findProfissionalContatoByIdProfissional(profissional);
        return list
                .stream()
                .map(ProfissionalContatoDTO::of)
                .collect(Collectors.toList());
    }

    public ProfissionalContato createContatoProfissional(ProfissionalContato profissional) {
        return repository.save(profissional);
    }

    public List<ProfissionalContato> findContatos() {
        return repository.findAll();
    }
}
