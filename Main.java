/* Murilox: fazer com que funcionario e cardapio imprima direto do arquivo não do Array -- FEITO
Narantão: fazer com que implemente o resto das funções, personalização e adicionar cliente, funcionario e cardapio no arquivo

					Murilox o case 8 não estou consingo resolver pq eu estava tentando fazer com q o codigo pegasse direto do arquivo
					para imprimir o cardapio e não ta dando e com isso o case 9 bugou tmb no mais é isso; Eu fiz com que o cardapio e
					os produtos salvem direto no arquivo e usei o gpt para dar uma estilizada massa; Mais um erro é que quando vc escreve
					para salver no arquivo ele salva duas vezes a mesma coisa; Eu ainda acho q da pra gente tirar os clientes de hoje.

					    R: nao vi essse erro nõa, nao vou mexer no 8 pq não sei muito do codigo, resolvi a demanda que voce deixou
				
*/
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Lanchonete lanche = new Lanchonete("Lanchonete Bom Sabor", "Rua das Frutas, 123");
        Pedido pedidoAtual = new Pedido();

        int opcao;
        do {
            System.out.println("\n==============================");
            System.out.println("      MENU - BOM SABOR 🍔     ");
            System.out.println("==============================");
            System.out.println("1️  Adicionar Cliente");
            System.out.println("2️  Adicionar Funcionário");
            System.out.println("3️  Adicionar Produto ao Cardápio");
            System.out.println("4️  Listar Clientes de Hoje");
            System.out.println("5️  Listar Funcionários");
            System.out.println("6️  Listar Cardápio");
            System.out.println("7️  Listar Clientes do Mês (arquivo)");
            System.out.println("8️  Fazer Pedido");
            System.out.println("9️  Ver Pedido Atual");
            System.out.println("0️  Sair");
            System.out.print("\nEscolha uma opção: ");
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
                    Cliente cliente = new Cliente(nomeC, cpfC, telC);
                    lanche.adicionarCliente(cliente);
                    pedidoAtual.adicionarCliente(cliente);
                    lanche.salvarListaEmArquivo("clientes.txt", lanche.getClientesSalvar());
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
                    lanche.salvarListaEmArquivo("funcionarios.txt", lanche.getFuncionariosSalvar());
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
                    lanche.salvarListaEmArquivo("cardapio.txt", lanche.getCardapioSalvar());
                    break;

                case 4:
                    System.out.println("\n👥 Clientes de hoje:");
                    for (Cliente cli : lanche.getClientes())
                        System.out.println("- " + cli.getNome() + " | CPF: " + cli.getCpf());
                    break;

                case 5:
                    lanche.lerArquivo("funcionarios.txt");
                    break;
                    
                case 6:
                    lanche.mostrarCardapio("cardapio.txt");
                    break;
                    
                case 7:
                    lanche.lerArquivo("clientes.txt");
                    break;


                case 8:


                    break;

                case 9:
                    pedidoAtual.mostrarPedido();
                    break;

                case 0:
                    System.out.println("\n✅ Encerrando sistema... Até logo!");
                    break;

                default:
                    System.out.println("❌ Opção inválida. Tente novamente!");
            }
        } while (opcao != 0);
    }
}
