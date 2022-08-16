package br.com.hospital.hpem.controller;
import br.com.hospital.hpem.dto.PacienteDto;
import br.com.hospital.hpem.form.PacienteForm;
import br.com.hospital.hpem.models.Atendimento;
import br.com.hospital.hpem.models.Medico;
import br.com.hospital.hpem.models.Paciente;
import br.com.hospital.hpem.service.AtendimentoService;
import br.com.hospital.hpem.service.MedicoService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/v1/atendimento")
public class AtendimentoController {

    @Autowired
    AtendimentoService atendimentoService;


    @GetMapping("/atendimento")
    @Cacheable(value = "listaAtendimentos")
    public List<Atendimento> listaAtendimentos() {

        List<Atendimento> atendimentoList = new ArrayList<>();
        atendimentoList = atendimentoService.getAtendimento();
        return atendimentoList;

    }

    @PostMapping ("/post/atendimento")
    public ResponseEntity<Object> salvarCadastroAtendimento (@RequestBody @Valid Atendimento atendimento) {

        return ResponseEntity.status(HttpStatus.CREATED).body(atendimentoService.save(atendimento));

    }

    @DeleteMapping("/delete/atendimento/{id}")
    @CacheEvict(value = "listaAtendimento", allEntries = true)
    public ResponseEntity<Object> removeratendimento(@PathVariable Long id) {
        Optional<Atendimento> atendimentoOptional = atendimentoService.findById(id);
        if (atendimentoOptional.isPresent()) {
            atendimentoService.deleteAtendimento(id);
            return ResponseEntity.status(HttpStatus.OK).body("Atendimento removido com successo!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Atendimento não existe!");

    }

}

