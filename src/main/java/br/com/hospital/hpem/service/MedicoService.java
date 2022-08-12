package br.com.hospital.hpem.service;
import br.com.hospital.hpem.models.Medico;
import br.com.hospital.hpem.respositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    public List<Medico> getMedico(){
        return medicoRepository.findAll();

    }

    public Medico findByNome(String nomeMedico) {
        return medicoRepository.findByNome(nomeMedico);
    }
}

