package org.biblioteca;
import java.util.*;

public class Livro {

    public Scanner scanner = new Scanner(System.in);

    public String titulo;
    public String autor;
    public String isbn;

    public Livro(String titulo, String autor, String ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

}
