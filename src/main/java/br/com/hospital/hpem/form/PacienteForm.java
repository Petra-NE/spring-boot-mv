package br.com.hospital.hpem.form;

import br.com.hospital.hpem.models.Medico;
import br.com.hospital.hpem.models.Paciente;
import br.com.hospital.hpem.service.MedicoService;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.util.Optional;

public class PacienteForm {

    @NotEmpty @NotNull
    private String nome;
    @NotEmpty @NotNull @Length(min = 11, max = 11)
    private String cpf;
    @NotEmpty @NotNull
    private int idade;
    @NotEmpty @NotNull
    private String nomeMedico;

    public Paciente converte(MedicoService medicoService) {

        Medico medico = medicoService.findByNome(nomeMedico);

        return new Paciente(
                nome,
                cpf,
                idade,
                medico
        );
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }


}
