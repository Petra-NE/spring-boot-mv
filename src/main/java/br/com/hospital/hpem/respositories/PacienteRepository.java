package br.com.hospital.hpem.respositories;

import br.com.hospital.hpem.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {


}
