package br.com.hospital.hpem.service;
import br.com.hospital.hpem.models.Medico;
import br.com.hospital.hpem.models.Paciente;
import br.com.hospital.hpem.respositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Transactional
    public void deleteMedico(Long id) {
        medicoRepository.deleteById(id);
    }

    public  Optional<Medico> findById(Long id) {
        return medicoRepository.findById(id);
    }

    public List<Medico> getMedico(){
        return medicoRepository.findAll();
    }

    public Medico findByNome(String nomeMedico) {
        return medicoRepository.findByNome(nomeMedico);
    }

    @Transactional
    public Object save(Medico medico) {
        return medicoRepository.save(medico);
    }
}


