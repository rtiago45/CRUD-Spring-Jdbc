package io.github.rtiago.domain.entity;

public class Cliente {

    private Integer id;
    private String nome;

    //construtor
    public Cliente(){

    }

    //construtor
    public Cliente(String nome) {
        this.nome = nome;
    }

    //construtor ID
    public Cliente(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
