package org.biblioteca;

public class Membro {

    public String nome;
    public int id;
    public String email;

    public Membro(String nome, int id, String email) {
        this.nome = nome;
        this.id = id;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

}
