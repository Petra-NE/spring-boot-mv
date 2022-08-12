package br.com.hospital.hpem.models;
import javax.persistence.*;
@Entity
@Table(name="MEDICO_TABLE")
public class Medico {

    @Id
    private Long crm;
    @Column (nullable = false, unique = true)
    private String nome;
    @Column (nullable = false, unique = true)
    private String especialidade;


    public Medico () {

    }

    public Long getCrm() {
        return crm;
    }

    public void setCrm(Long crm) {
        this.crm = crm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomeMedico) {
        this.nome = nomeMedico;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
