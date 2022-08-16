package br.com.hospital.hpem.models;
import javax.persistence.*;
@Entity
@Table(name="PACIENTE_TABLE")
public class Paciente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (nullable = false)
    private String nome;
    @Column (nullable = false, unique = true, length = 11)
    private String cpf;
    @Column (nullable = false)
    private int idade;
    @Column (nullable = false)
    private String endereco;


    public Paciente() {
    }

    public Paciente(String nome, String cpf, int idade, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

   // public Atendimento getAtendimento() {
     //   return atendimento;
    //}

  //  public void setAtendimento(Atendimento atendimento) {
     //   this.atendimento = atendimento;
    //}
}
