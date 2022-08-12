package br.com.hospital.hpem.dto;
import br.com.hospital.hpem.models.Paciente;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;
public class PacienteDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotBlank
    private int idade;
    @NotBlank
    private String endereco;
    public PacienteDto(Paciente paciente) {
        this.nome = paciente.getNome();
        this.cpf = paciente.getCpf();
        this.idade = paciente.getIdade();
        this.endereco = paciente.getEndereco();
    }

    public PacienteDto() {

    }


    public static List<PacienteDto> converter(List<Paciente> asList) {
        return asList.stream().map(PacienteDto::new).collect(Collectors.toList());
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public String getEndereco() {
        return endereco;
    }
}