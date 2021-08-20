package br.com.letscode.saudedequalidade.Consulta;

import br.com.letscode.saudedequalidade.Exceptions.ConsultaNaoExiste;
import br.com.letscode.saudedequalidade.Paciente.PacienteService;
import br.com.letscode.saudedequalidade.Profissional.ProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService {

    private ConsultaRepository repository;
    private PacienteService pacienteService;
    private ProfissionalService profissionalService;

    @Autowired
    public ConsultaService(ConsultaRepository consultaRepository, PacienteService paciente, ProfissionalService profissional){
        repository = consultaRepository;
        pacienteService = paciente;
        profissionalService = profissional;
    }


    public List<Consulta> getConsultas(){
        return repository.findAll();
    }

    public Consulta getConsultaByID(Long id){
        return repository.findById(id).orElseThrow(ConsultaNaoExiste::new);
    }

    public Consulta saveNewConsulta(IDs novaConsulta) {
        Consulta consulta = new Consulta();
        consulta.setIdPaciente(pacienteService.getPacienteByID(novaConsulta.getIdPaciente()));
        consulta.setIdProfissional(profissionalService.getProfissionalByID(novaConsulta.getIdProfissional()));
        return repository.save(consulta);
    }

    public List<Consulta> getConsultaByPacienteId(Long id){
        if(!repository.findByIdPaciente(id).isEmpty()){
            return repository.findByIdPaciente(id);
        }
        throw new ConsultaNaoExiste();
    }

    public List<Consulta> getConsultaByProfissionalId(Long id){
        if(!repository.findByIdProfissional(id).isEmpty()){
            return repository.findByIdProfissional(id);
        }
       throw new ConsultaNaoExiste();
    }

    public void deleteConsultaById(Long id){
        repository.deleteById(id);
    }

}
