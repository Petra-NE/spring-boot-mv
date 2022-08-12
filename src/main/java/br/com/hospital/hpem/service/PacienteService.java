package br.com.hospital.hpem.service;

import br.com.hospital.hpem.models.Paciente;
import br.com.hospital.hpem.respositories.MedicoRepository;
import br.com.hospital.hpem.respositories.PacienteRepository;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    public List<Paciente> getPacientes(){
        return pacienteRepository.findAll();

    }

    public Optional<Paciente> findById(Long id) {
        return pacienteRepository.findById(id);
    }


    public void deletePaciente(Long id) {
        pacienteRepository.deleteById(id);


    }


    @Transactional
    public Object save(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }


}

