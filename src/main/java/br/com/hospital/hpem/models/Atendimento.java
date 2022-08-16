package br.com.hospital.hpem.models;

import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.naming.Name;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Entity
@Table(name="ATENDIMENTO_TABLE")
public class Atendimento {

    @Id @GeneratedValue
    private Long numeroAtendimento;

    @OneToOne @NotNull
    private Medico medico;
    @OneToOne @NotNull
    private Paciente paciente;
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date dataAtendimento = new Date();

    public Atendimento() {
    }

    public Atendimento(Medico medico, Paciente paciente) {
        this.medico = medico;
        this.paciente = paciente;
    }

    public Long getNumeroAtendimento() {
        return numeroAtendimento;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }
}
