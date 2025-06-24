import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lanchonete {
    private String nome;
    private String endereco;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Cliente> clientes;
    private ArrayList<Produto> cardapio;

    public Lanchonete(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.funcionarios = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.cardapio = new ArrayList<>();
    }

    public void adicionarCliente(Cliente c) {
        clientes.add(c); 
        System.out.println("Cliente " + c.getNome() + " adicionado.\n");
    }

    public void adicionarFuncionario(Funcionario f) {
        funcionarios.add(f);
        System.out.println("Funcionário " + f.getNome() + " adicionado.\n");
    }
    
    public void adicionarProdutoAoCardapio(Produto p) {
        cardapio.add(p);
        System.out.println("Produto " + p.nome + " adicionado ao cardápio.\n");
    }

    public void mostrarCardapio(String nomeArquivo) {
        System.out.println("\n📄 Conteúdo de: " + "Cardapio\n");
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    public ArrayList<Cliente> getClientes() {
     return clientes;
    }
    
    public ArrayList<String> getClientesSalvar() {
        ArrayList<String> clientesSalvar = new ArrayList<>();
        for (Cliente c : clientes) {
            String linha = "Nome: " + c.getNome() + " CPF: " + c.getCpf() + " Tel: " + c.getTelefone();
            clientesSalvar.add(linha);
        }
        return clientesSalvar;
    }

    
    public ArrayList<String> getFuncionariosSalvar() {
        ArrayList<String> funcionariosSalvar = new ArrayList<>();
        for (Funcionario f : funcionarios) {
            String linha = "Nome: " + f.getNome() + " CPF: " + f.getCpf() + " Tel: " + f.getTelefone() + " Função: " + f.getClass().getSimpleName();
            funcionariosSalvar.add(linha);
        }
        return funcionariosSalvar;
    }

    
    public ArrayList<String> getCardapioSalvar() {
        ArrayList<String> cardapioSalvar = new ArrayList<>();
        for (Produto p : cardapio) {
            String linha = "Produto: " + p.getNome() + " | Preço: R$ " + p.getPreco() + " | Tipo: " + p.getClass().getSimpleName();
            cardapioSalvar.add(linha);
        }
        return cardapioSalvar;
    }
    
    public static void lerArquivo(String nomeArquivo) {
        System.out.println("\n📄 Conteúdo de: " + nomeArquivo);
        try (BufferedReader leitor = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("❌ Erro ao ler o arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
    
    public static void salvarListaEmArquivo(String nomeArquivo, List<?> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo, true))) {
            for (Object obj : lista) {
                writer.write(obj.toString());
                writer.newLine();
            }
            System.out.println("✅ Dados salvos em: " + nomeArquivo);
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar " + nomeArquivo + ": " + e.getMessage());
        }
    }
}
