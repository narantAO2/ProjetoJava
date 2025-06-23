
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lanchonete lanche = new Lanchonete("Lanchonete Bom Sabor", "Rua das Frutas, 123");

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Funcionário");
            System.out.println("3. Adicionar Produto ao Cardápio");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Listar Funcionários");
            System.out.println("6. Listar Cardápio");
            System.out.println("7. Salvar Dados em Arquivo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeC = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpfC = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telC = sc.nextLine();
                    lanche.adicionarCliente(new Cliente(nomeC, cpfC, telC));
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nomeF = sc.nextLine();
                    System.out.print("CPF: ");
                    String cpfF = sc.nextLine();
                    System.out.print("Telefone: ");
                    String telF = sc.nextLine();
                    System.out.print("Função (1-Garçom, 2-Motoboy): ");
                    int funcao = sc.nextInt(); sc.nextLine();
                    Funcionario f = (funcao == 1) ? new Garcom(nomeF, cpfF, telF) : new Motoboy(nomeF, cpfF, telF);
                    lanche.adicionarFuncionario(f);
                    break;
                case 3:
                    System.out.print("Nome do produto: ");
                    String nomeP = sc.nextLine();
                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Tipo (1-Bebida, 2-Lanche, 3-Sobremesa): ");
                    int tipo = sc.nextInt(); sc.nextLine();
                    Produto p;
                    if (tipo == 1) p = new Bebida(nomeP, preco);
                    else if (tipo == 2) p = new Lanche(nomeP, preco);
                    else p = new Sobremesa(nomeP, preco);
                    lanche.adicionarProdutoAoCardapio(p);
                    break;
                case 4:
                    System.out.println("\nClientes:");
                    for (Cliente c : lanche.getClientes())
                        System.out.println(c.getNome() + " - " + c.getCpf());
                    break;
                case 5:
                    System.out.println("\nFuncionários:");
                    for (Funcionario fu : lanche.getFuncionarios())
                        System.out.println(fu.getNome() + " - " + fu.getCpf());
                    break;
                case 6:
                    System.out.println("\nCardápio:");
                    for (Produto prod : lanche.getCardapio())
                        System.out.println(prod.getNome() + " - R$ " + prod.getPreco());
                    break;
                case 7:
                    salvarListaEmArquivo("clientes.txt", lanche.getClientes());
                    salvarListaEmArquivo("funcionarios.txt", lanche.getFuncionarios());
                    salvarListaEmArquivo("cardapio.txt", lanche.getCardapio());
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    public static void salvarListaEmArquivo(String nomeArquivo, List<?> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Object obj : lista) {
                writer.write(obj.toString());
                writer.newLine();
            }
            System.out.println("Dados salvos em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar " + nomeArquivo + ": " + e.getMessage());
        }
    }
}
