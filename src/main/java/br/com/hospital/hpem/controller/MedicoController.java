package br.com.hospital.hpem.controller;

import br.com.hospital.hpem.models.Medico;
import br.com.hospital.hpem.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
public class MedicoController {
    @Autowired
    MedicoService medicoService;

    @GetMapping("/medicos")
    @Cacheable(value = "listaMedicos")
    public List<Medico> listaMedicos() {

        List<Medico> medicosList = new ArrayList<>();
        medicosList = medicoService.getMedico();
        return medicosList;
    }

    @PostMapping("/post/medicos")
    public ResponseEntity<Object> salvarCadastroMedico (@RequestBody @Valid Medico medico) {

        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.save(medico));

    }

    @DeleteMapping("/delete/medico/{crm}")
    @CacheEvict(value = "listaMedico", allEntries = true)
    public ResponseEntity<Object> removerMedico(@PathVariable Long crm) {
        Optional<Medico> MedicoOptional = medicoService.findById(crm);
        if (MedicoOptional.isPresent()) {
            medicoService.deleteMedico(crm);
            return ResponseEntity.status(HttpStatus.OK).body("Médico removido com successo!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Médico não existe!");

    }

}
