package org.biblioteca;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Biblioteca biblioteca = new Biblioteca();

    public static void main(String[] args) {

        while (true) {
            String operacao = menuPrincipal();
            if (operacao.equals("sair")) {
                break;
            }
            menuSecundario(operacao);
        }

        biblioteca.fecharScanner();
    }

    private static String menuPrincipal() {
        try {
            System.out.println("\nBem-vindo ao sistema da biblioteca. Por favor, selecione a operação que deseja realizar.");
            System.out.println("""
                    1 - Livros
                    2 - Membros
                    3 - Empréstimos
                    4 - Sair do sistema""");
            System.out.print("Sua escolha: ");
            int escolhaUsuarioMenuPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (escolhaUsuarioMenuPrincipal) {
                case 1:
                    return "livro";
                case 2:
                    return "membro";
                case 3:
                    return "emprestimo";
                case 4:
                    return "sair";
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    return menuPrincipal();
            }
        } catch (Exception ex) {
            System.out.println("Por favor, digite uma opção válida!");
            scanner.nextLine();
            return menuPrincipal();
        }
    }

    private static void menuSecundario(String operacao) {
        switch (operacao) {
            case "livro":
                menuLivro();
                break;
            case "membro":
                menuMembro();
                break;
            case "emprestimo":
                menuEmprestimo();
                break;
            default:
                System.out.println("Opção inválida.");
        }
    }

    private static void menuLivro() {
        System.out.println("\nOpções de livros:");
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Remover livro");
        System.out.println("3 - Consultar livro");
        System.out.println("4 - Retornar ao menu principal");
        System.out.print("Sua escolha: ");
        int escolhaUsuario = scanner.nextInt();

        switch (escolhaUsuario) {
            case 1:
                biblioteca.adicionarLivro();
                break;
            case 2:
                biblioteca.removerLivro();
                break;
            case 3:
                biblioteca.consultarLivro();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void menuMembro() {
        System.out.println("\nOpções de membros:");
        System.out.println("1 - Adicionar membro");
        System.out.println("2 - Remover membro");
        System.out.println("3 - Consultar membro");
        System.out.println("4 - Retornar ao menu principal");
        System.out.print("Sua escolha: ");
        int escolhaUsuario = scanner.nextInt();

        switch (escolhaUsuario) {
            case 1:
                biblioteca.adicionarMembro();
                break;
            case 2:
                biblioteca.removerMembro();
                break;
            case 3:
                biblioteca.consultarMembro();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void menuEmprestimo() {
        System.out.println("\nOpções de empréstimos:");
        System.out.println("1 - Adicionar empréstimo");
        System.out.println("2 - Remover empréstimo");
        System.out.println("3 - Consultar empréstimo");
        System.out.println("4 - Retornar ao menu principal");
        System.out.print("Sua escolha: ");
        int escolhaUsuario = scanner.nextInt();

        switch (escolhaUsuario) {
            case 1:
                biblioteca.adicionarEmprestimo();
                break;
            case 2:
                biblioteca.removerEmprestimo();
                break;
            case 3:
                biblioteca.consultarEmprestimo();
                break;
            case 4:
                return;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
