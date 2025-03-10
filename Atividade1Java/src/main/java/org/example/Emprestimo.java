package org.example;

import java.time.LocalDateTime;
import java.util.*;

public class Emprestimo {

    public int id;
    public Livro livro;
    public Membro membro;
    public LocalDateTime dataEmprestimo;

    public Emprestimo(int id, Livro livro, Membro membro, LocalDateTime dataEmprestimo) {
        this.id = id;
        this.livro = livro;
        this.membro = membro;
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getId() {
        return id;
    }

    public Livro getLivro() {
        return livro;
    }

    public Membro getMembro() {
        return membro;
    }

    public LocalDateTime getDataEmprestimo() {
        return dataEmprestimo;
    }

}
