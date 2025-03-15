package org.biblioteca;

import java.time.LocalDateTime;
import java.util.*;

public class Biblioteca {

    private Map<String, Livro> livrosMap = new HashMap<>();
    private Map<Integer, Membro> membrosMap = new HashMap<>();
    private Map<Integer, Emprestimo> emprestimoMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void adicionarLivro() {
        try {
            System.out.print("Digite o nome do livro (identificador ou título): ");
            String nomeLivro = scanner.nextLine();

            Livro livro = new Livro(
                    receberDado("Título"),
                    receberDado("Autor"),
                    receberDado("ISBN")
            );

            livrosMap.put(nomeLivro, livro);
            System.out.println("Livro '" + nomeLivro + "' adicionado com sucesso!");
        } catch (Exception ex) {
            System.out.println("Não foi possível adicionar o livro.");
        }
    }

    public void removerLivro() {
        try {
            System.out.print("Digite o nome do livro que deseja remover: ");
            String nomeLivro = scanner.nextLine();

            Livro removido = livrosMap.remove(nomeLivro);

            if (removido != null) {
                System.out.println("Livro '" + nomeLivro + "' removido com sucesso!");
            } else {
                System.out.println("Livro não encontrado para remoção.");
            }
        } catch (Exception ex) {
            System.out.println("Não foi possível remover o livro.");
        }
    }

    public void consultarLivro() {
        try {
            System.out.print("Digite o nome do livro para consulta: ");
            String nomeLivro = scanner.nextLine();

            Livro livro = livrosMap.get(nomeLivro);

            if (livro != null) {
                System.out.println("Livro encontrado!");
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("ISBN: " + livro.getIsbn());
            } else {
                System.out.println("Livro não encontrado.");
            }
        } catch (Exception ex) {
            System.out.println("Não foi possível consultar o livro.");
        }
    }

    public void adicionarMembro() {
        try {
            String nomeMembro = receberDado("Nome");
            System.out.print("Digite o ID do membro: ");
            int idMembro = scanner.nextInt();
            scanner.nextLine();
            String emailMembro = receberDado("Email");

            Membro membro = new Membro(nomeMembro, idMembro, emailMembro);
            membrosMap.put(idMembro, membro);
            System.out.println("Membro '" + nomeMembro + "' adicionado com sucesso!");
        } catch (Exception ex) {
            System.out.println("Não foi possível adicionar o membro.");
        }
    }

    public void removerMembro() {
        try {
            System.out.print("Digite o ID do membro que deseja remover: ");
            int idMembro = scanner.nextInt();
            scanner.nextLine();

            Membro removido = membrosMap.remove(idMembro);

            if (removido != null) {
                System.out.println("Membro '" + removido.getNome() + "' removido com sucesso!");
            } else {
                System.out.println("Membro não encontrado para remoção.");
            }
        } catch (Exception ex) {
            System.out.println("Não foi possível remover o membro.");
        }
    }

    public void consultarMembro() {
        try {
            System.out.print("Digite o ID do membro para consulta: ");
            int idMembro = scanner.nextInt();
            scanner.nextLine();

            Membro membro = membrosMap.get(idMembro);

            if (membro != null) {
                System.out.println("Membro encontrado!");
                System.out.println("Nome: " + membro.getNome());
                System.out.println("ID: " + membro.getId());
                System.out.println("Email: " + membro.getEmail());
            } else {
                System.out.println("Membro não encontrado.");
            }
        } catch (Exception ex) {
            System.out.println("Não foi possível consultar o membro.");
        }
    }

    public void adicionarEmprestimo() {
        try {
            System.out.print("Digite o título do livro para empréstimo: ");
            String tituloLivro = scanner.nextLine();

            Livro livro = livrosMap.get(tituloLivro);
            if (livro == null) {
                System.out.println("Livro não encontrado.");
                return;
            }

            System.out.print("Digite o ID do membro que realizará o empréstimo: ");
            int idMembro = scanner.nextInt();
            scanner.nextLine();

            Membro membro = membrosMap.get(idMembro);
            if (membro == null) {
                System.out.println("Membro não encontrado.");
                return;

            }

            int idEmprestimo = 10000 + random.nextInt(90000);
            LocalDateTime dataEmprestimo = LocalDateTime.now();

            Emprestimo emprestimo = new Emprestimo(idEmprestimo, livro, membro, dataEmprestimo);
            emprestimoMap.put(idEmprestimo, emprestimo);

            System.out.println("Empréstimo realizado com sucesso com o ID " + idEmprestimo);
        } catch (Exception ex) {
            System.out.println("Não foi possível adicionar o empréstimo: " + ex.getMessage());
        }
    }

    public void removerEmprestimo() {
        try {
            System.out.print("Digite o ID do empréstimo que deseja remover: ");
            int idEmprestimo = scanner.nextInt();
            scanner.nextLine();

            Emprestimo emprestimoRemovido = emprestimoMap.remove(idEmprestimo);

            if (emprestimoRemovido != null) {
                System.out.println("Empréstimo removido com sucesso.");
            } else {
                System.out.println("Empréstimo não encontrado no sistema.");
            }
        } catch (Exception ex) {
            System.out.println("Não foi possível realizar a remoção.");
        }
    }

    public void consultarEmprestimo() {
        try {
            System.out.print("Digite o ID do empréstimo que deseja consultar: ");
            int idEmprestimo = scanner.nextInt();
            scanner.nextLine();

            Emprestimo emprestimo = emprestimoMap.get(idEmprestimo);
            if (emprestimo != null) {
                System.out.println("Empréstimo encontrado.");
                System.out.println("Título do livro: " + emprestimo.livro.getTitulo());
                System.out.println("Empréstimo realizado para: " + emprestimo.membro.getNome());
                System.out.println("Data do empréstimo: " + emprestimo.getDataEmprestimo());
            } else {
                System.out.println("Empréstimo não encontrado.");
            }
        } catch (Exception ex) {
            System.out.println("Não foi possível realizar a consulta.");
        }
    }

    private String receberDado(String tipoDado) {
        System.out.print(tipoDado + ": ");
        return scanner.nextLine();
    }

    public void fecharScanner() {
        scanner.close();
    }
}
