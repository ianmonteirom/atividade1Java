package restaurante;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Restaurante restaurante = new Restaurante();

    public static void main(String[] args) {
        while (true) {
            String operacao = menuPrincipal();
            if (operacao.equals("sair")) {
                break;
            }
            menuSecundario(operacao);
        }
        restaurante.fecharScanner();
    }

    private static String menuPrincipal() {
        try {
            System.out.println("\nBem-vindo ao sistema de pedidos do restaurante. Por favor, selecione a operação que deseja realizar.");
            System.out.println("""
                    1 - Pratos
                    2 - Pedidos
                    3 - Sair do sistema""");
            System.out.print("Sua escolha: ");
            int escolhaUsuarioMenuPrincipal = scanner.nextInt();
            scanner.nextLine();

            return switch (escolhaUsuarioMenuPrincipal) {
                case 1 -> "prato";
                case 2 -> "pedido";
                case 3 -> "sair";
                default -> {
                    System.out.println("Opção inválida. Tente novamente.");
                    yield menuPrincipal();
                }
            };
        } catch (Exception ex) {
            System.out.println("Por favor, digite uma opção válida!");
            scanner.nextLine();
            return menuPrincipal();
        }
    }

    private static void menuSecundario(String operacao) {
        switch (operacao) {
            case "prato" -> menuPrato();
            case "pedido" -> menuPedido();
            default -> System.out.println("Opção inválida.");
        }
    }

    private static void menuPrato() {
        System.out.println("\nOpções de pratos:");
        System.out.println("1 - Adicionar prato");
        System.out.println("2 - Remover prato");
        System.out.println("3 - Retornar ao menu principal");
        System.out.print("Sua escolha: ");
        int escolhaUsuario = scanner.nextInt();
        scanner.nextLine();

        switch (escolhaUsuario) {
            case 1 -> restaurante.adicionarPrato();
            case 2 -> restaurante.removerPrato();
            case 3 -> {
                return;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private static void menuPedido() {
        System.out.println("\nOpções de pedidos:");
        System.out.println("1 - Adicionar pedido");
        System.out.println("2 - Remover pedido");
        System.out.println("3 - Consultar pedido");
        System.out.println("4 - Retornar ao menu principal");
        System.out.print("Sua escolha: ");
        int escolhaUsuario = scanner.nextInt();
        scanner.nextLine();

        switch (escolhaUsuario) {
            case 1 -> restaurante.adicionarPedido();
            case 2 -> restaurante.removerPedido();
            case 3 -> restaurante.consultarPedido();
            case 4 -> {
                return;
            }
            default -> System.out.println("Opção inválida. Tente novamente.");
        }
    }
}
