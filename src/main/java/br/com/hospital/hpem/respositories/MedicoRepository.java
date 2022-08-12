package br.com.hospital.hpem.respositories;

import br.com.hospital.hpem.models.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Medico findByNome(String nomeMedico);
}
