package restaurante;

import java.time.LocalDateTime;
import java.util.*;

public class Restaurante {

    private Map<String, Prato> pratosMap = new HashMap<>();
    private Map<Integer, Pedido> pedidosMap = new HashMap<>();
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void adicionarPrato() {
        try {
            String nomePrato;
            Prato prato = new Prato(
                    nomePrato = receberDado("Nome"),
                    receberDadoFloat("Preço"),
                    receberDado("Descrição")
            );
            scanner.nextLine();

            pratosMap.put(nomePrato, prato);
            System.out.println("Prato '" + nomePrato + "' adicionado com sucesso!");
        } catch (Exception ex) {
            System.out.println("Não foi possível adicionar o prato.");
        }
    }

    public void removerPrato() {
        try {
            System.out.print("Digite o nome do prato que deseja remover: ");
            String nomePrato = scanner.nextLine();

            Prato removido = pratosMap.remove(nomePrato);

            if (removido != null) {
                System.out.println("Prato '" + nomePrato + "' removido com sucesso!");
            } else {
                System.out.println("Prato não encontrado para remoção.");
            }
        } catch (Exception ex) {
            System.out.println("Não foi possível remover o prato.");
        }
    }

    public void adicionarPedido() {
        try {
            System.out.print("Digite o nome do cliente: ");
            String cliente = scanner.nextLine();

            List<String> listaDePratos = new ArrayList<>();
            float total = 0;
            String nomePrato;

            while (true) {
                System.out.print("Digite o nome do prato (ou 'fim' para concluir o pedido): ");
                nomePrato = scanner.nextLine();
                if (nomePrato.equalsIgnoreCase("fim")) {
                    break;
                }
                Prato prato = pratosMap.get(nomePrato);
                if (prato != null) {
                    listaDePratos.add(nomePrato);
                    total += prato.getPreco();
                } else {
                    System.out.println("Prato não encontrado. Tente novamente.");
                }
            }

            System.out.println("Total do pedido: R$" + total);

            int numeroPedido = 10000 + random.nextInt(90000);
            Pedido pedido = new Pedido(numeroPedido, cliente, listaDePratos, total);
            pedidosMap.put(numeroPedido, pedido);

            System.out.println("Pedido realizado com sucesso! Número do pedido: " + numeroPedido);
        } catch (Exception ex) {
            System.out.println("Não foi possível adicionar o pedido.");
        }
    }

    public void removerPedido() {
        try {
            System.out.print("Digite o número do pedido que deseja remover: ");
            int numeroPedido = scanner.nextInt();
            scanner.nextLine();

            Pedido removido = pedidosMap.remove(numeroPedido);

            if (removido != null) {
                System.out.println("Pedido '" + numeroPedido + "' removido com sucesso!");
            } else {
                System.out.println("Pedido não encontrado para remoção.");
            }
        } catch (Exception ex) {
            System.out.println("Não foi possível remover o pedido.");
        }
    }

    public void consultarPedido() {
        try {
            System.out.print("Digite o número do pedido para consulta: ");
            int numeroPedido = scanner.nextInt();
            scanner.nextLine();

            Pedido pedido = pedidosMap.get(numeroPedido);

            if (pedido != null) {
                System.out.println("Pedido encontrado!");
                System.out.println("Número do Pedido: " + pedido.getNumeroPedido());
                System.out.println("Cliente: " + pedido.getCliente());
                System.out.println("Pratos: " + String.join(", ", pedido.getListaDePratos()));
                System.out.println("Total: R$" + pedido.getTotal());
            } else {
                System.out.println("Pedido não encontrado.");
            }
        } catch (Exception ex) {
            System.out.println("Não foi possível consultar o pedido.");
        }
    }

    private String receberDado(String tipoDado) {
        System.out.print(tipoDado + ": ");
        return scanner.nextLine();
    }

    private float receberDadoFloat(String tipoDado) {
        System.out.print(tipoDado + ": ");
        float valor = scanner.nextFloat();
        scanner.nextLine(); // Consumir quebra de linha
        return valor;
    }

    public void fecharScanner() {
        scanner.close();
    }
}
