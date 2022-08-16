package br.com.hospital.hpem.controller;

import br.com.hospital.hpem.dto.PacienteDto;
import br.com.hospital.hpem.form.PacienteForm;
import br.com.hospital.hpem.models.Paciente;
import br.com.hospital.hpem.service.PacienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/atendimento")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping("/pacientes")
    @Cacheable(value = "listaPacientes")
    public Page<PacienteDto> lista() {

        Page<Paciente> pacienteList;
        pacienteList = (Page<Paciente>) pacienteService.getPacientes();
        return PacienteDto.converter(pacienteList);
    }

    @PostMapping("/post/pacientes")
    public ResponseEntity<Object> salvarCadastroPaciente (@RequestBody @Valid Paciente paciente) {

        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));

    }
    @DeleteMapping("/delete/paciente/{id}")
    @CacheEvict(value = "listaPacientes", allEntries = true)
    public ResponseEntity<Object> removerPaciente(@PathVariable Long id) {
        Optional<Paciente> pacienteOptional = pacienteService.findById(id);
        if (pacienteOptional.isPresent()) {
            pacienteService.deletePaciente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Paciente removido com successo!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não existe!");
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Object> atualizaPacientes (@PathVariable Long id,
                                                      @RequestBody @Valid PacienteForm pacienteForm) {

        Optional<Paciente> pacienteOptional = pacienteService.findById(id);
        if (!pacienteOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Paciente não encontrado");
        }

        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(pacienteForm, paciente);
        paciente.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.save(paciente));
    }

}
