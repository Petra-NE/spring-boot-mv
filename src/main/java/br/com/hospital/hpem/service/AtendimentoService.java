package br.com.hospital.hpem.service;

import br.com.hospital.hpem.models.Atendimento;
import br.com.hospital.hpem.models.Paciente;
import br.com.hospital.hpem.respositories.AtendimentoRepository;
import br.com.hospital.hpem.respositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AtendimentoService {

    @Autowired
    AtendimentoRepository atendimentoRepository;

    public List<Atendimento> getAtendimento(){
        return atendimentoRepository.findAll();

    }

    @Transactional
    public Object save(Atendimento atendimento) {
        System.out.println(atendimentoRepository.save(atendimento));
        return atendimentoRepository.save(atendimento);
    }

    public Optional<Atendimento> findById(Long id) {
        return atendimentoRepository.findById(id);

    }
    @Transactional
    public void deleteAtendimento(Long id) {
            atendimentoRepository.deleteById(id);
        }
    }



