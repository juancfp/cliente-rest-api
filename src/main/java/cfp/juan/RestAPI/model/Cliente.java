package cfp.juan.RestAPI.model;


import javax.persistence.*;

@Entity
public class Cliente {
    @Id
    public Long id;
    public String nome;
    @ManyToOne
    public Endereco endereco;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
