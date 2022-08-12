package br.com.hospital.hpem.respositories;

import br.com.hospital.hpem.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {


    Optional<Paciente> findByNome(String nome);
}
