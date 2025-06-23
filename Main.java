
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Lanchonete lanche = new Lanchonete("Lanchonete Bom Sabor", "Rua das Frutas, 123");

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Adicionar Funcionário");
            System.out.println("3. Adicionar Produto ao Cardápio");
            System.out.println("4. Listar Clientes de Hoje");
            System.out.println("5. Listar Funcionários");
            System.out.println("6. Listar Cardápio");
            System.out.println("7. Listar Clientes do Mês");

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
                    salvarListaEmArquivo("clientes.txt", lanche.getClientesSalvar());

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
                    salvarListaEmArquivo("funcionarios.txt", lanche.getFuncionarios());

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
                    salvarListaEmArquivo("cardapio.txt", lanche.getCardapio());

                    break;
                case 4:
                    System.out.println("\nClientes:");
                    for (Cliente f2 : lanche.getClientes())
                        System.out.println("Cliente: " + f2.getNome() + "cpf: " + f2.getCpf());

                    break;
                case 5:
                    System.out.println("\nFuncionários:");
                    for (Funcionario f2 : lanche.getFuncionarios())
                        System.out.println("Funcionário: " + f2.getNome());
                    break;
                case 6:
                    System.out.println("\nCardápio:");
                    for (Produto prod : lanche.getCardapio())
                        System.out.println(prod.getNome() + " - R$ " + prod.getPreco());
                    break;
                case 7:
                    BufferedReader reader = new BufferedReader(new FileReader("clientes.txt"));
                    String linha;
                    System.out.println("--------------Clientes do mês atual--------");
                    while ((linha = reader.readLine()) != null) {
                        System.out.println(linha);
                    }
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
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo,true))) {
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

/* fazer com que funcionario e cardapio imprima direto do arquivo não do Array e chamar outras funções não usadas*/
