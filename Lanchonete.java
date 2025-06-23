import java.util.ArrayList;

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

    public void mostrarCardapio() {
        System.out.println("\n--- Cardápio " + nome + " ---");
        for (Produto p : cardapio) System.out.println(p.nome + " - R$ " + p.preco);
        System.out.println("--- --- --- --- --- ---\n");
    }

    public ArrayList<Cliente> getClientes() {
     return clientes;
    }
    public ArrayList getClientesSalvar() {
        ArrayList clientesSalvar = new ArrayList();

        for (Cliente c : clientes) {

            String linhas = "Nome: " + c.getNome() + " CPF: " + c.getCpf()+ " Tel: " + c.getTelefone() + "\n";

            clientesSalvar.add(linhas);


        }
        return clientesSalvar;

    }

    public ArrayList<Funcionario> getFuncionarios() {
       return funcionarios;
    }

    public ArrayList<Produto> getCardapio() {
       return cardapio;
    }
}
