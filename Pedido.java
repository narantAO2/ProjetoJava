import java.util.ArrayList;

public class Pedido {
    Cliente cliente;
    private ArrayList<Produto> prod; 
    String status = "Em preparo";

    public Pedido() {
    	prod = new ArrayList<Produto>();
	}
    
    public void adicionarCliente(Cliente cliente) {
    	this.cliente = cliente;
    }
    
    public void adicionarProduto(Produto p) {
        prod.add(p);
        System.out.println(p.nome + " adicionado ao pedido de " + cliente.getNome() + "\n");
    }

    public String getNome() {
		return cliente.getNome();
	}
    
    public double calcularValorTotal() {
        double total = 0;
        for (Produto p : prod) total += p.preco;
        return total;
    }

    public void mostrarPedido() {
   
        System.out.println("Pedido de " + cliente.getNome() + ":");
        for (Produto p : prod) System.out.println("- " + p.nome + " (R$ " + p.preco + ")");
        System.out.println("Total: R$ " + calcularValorTotal() + "\n");
        System.out.println("Status: " + status + "\n");
    }
}