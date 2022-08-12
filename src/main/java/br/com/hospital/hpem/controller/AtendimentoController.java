package br.com.hospital.hpem.controller;
import br.com.hospital.hpem.dto.PacienteDto;
import br.com.hospital.hpem.form.PacienteForm;
import br.com.hospital.hpem.models.Medico;
import br.com.hospital.hpem.models.Paciente;
import br.com.hospital.hpem.respositories.PacienteRepository;
import br.com.hospital.hpem.service.MedicoService;
import br.com.hospital.hpem.service.PacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/v1/atendimento")
public class AtendimentoController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    MedicoService medicoService;

// listar pacientes e médicos funcional
    @GetMapping("/pacientes")
    public List<PacienteDto> lista() {

        List<Paciente> pacienteList = new ArrayList<>();
        pacienteList = pacienteService.getPacientes();
        return PacienteDto.converter(pacienteList);
    }


    @GetMapping("/medicos")
    public List<Medico> listaMedicos() {

        List<Medico> medicosList = new ArrayList<>();
        medicosList = medicoService.getMedico();
        return medicosList;

    }

    @PostMapping
    @Transactional
    public ResponseEntity<Object> cadastrarPaciente (@RequestBody @Valid PacienteForm pacienteForm) {
        Optional<Paciente> optionalPaciente = pacienteService.getPaciente(pacienteForm.getNome());

        if (!optionalPaciente.isPresent()) {
            Paciente paciente = pacienteForm.converte(medicoService);

            return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));

        }      else if (!(Objects.equals(optionalPaciente.get().getMedico().getNome(), pacienteForm.getNomeMedico()))) {
        Paciente paciente = pacienteForm.converte(medicoService);

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));
    }

        return ResponseEntity.status(HttpStatus.CONFLICT).body("Olá, o paciente já esta cadastrado");
}
    

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> atualizar (@PathVariable Long id, @RequestBody @Valid PacienteForm pacienteForm) {

        Optional<Paciente> optionalPaciente = pacienteService.getPacienteById(id);

        if (!optionalPaciente.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não cadastrado!");
        }

        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(pacienteForm, paciente);
        paciente.setMedico(optionalPaciente.get().getMedico());
        paciente.setId(optionalPaciente.get().getId());


        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.save(paciente));
    }



// delete funcional
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> removerPaciente(@PathVariable Long id) {
        Optional<Paciente> pacienteOptional = pacienteService.findById(id);
        if (pacienteOptional.isPresent()) {
            pacienteService.deletePaciente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Paciente removido com successo!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não existe!");

    }
}