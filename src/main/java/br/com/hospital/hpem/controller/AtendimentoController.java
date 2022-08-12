package br.com.hospital.hpem.controller;
import br.com.hospital.hpem.dto.PacienteDto;
import br.com.hospital.hpem.models.Medico;
import br.com.hospital.hpem.models.Paciente;
import br.com.hospital.hpem.service.MedicoService;
import br.com.hospital.hpem.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/atendimento")
public class AtendimentoController {

    @Autowired
    PacienteService pacienteService;

    @Autowired
    MedicoService medicoService;


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

    @PostMapping ("/post")
    @Transactional
    public ResponseEntity<Object> salvarCadastro (@RequestBody @Valid Paciente paciente) {

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));

    }



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