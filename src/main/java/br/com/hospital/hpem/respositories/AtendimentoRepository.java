package br.com.hospital.hpem.respositories;

import br.com.hospital.hpem.models.Atendimento;
import br.com.hospital.hpem.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {
}

