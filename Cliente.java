
public class Cliente extends Pessoa{

	public Cliente(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }
	
    public void fazerPedido() {
        System.out.println(getNome() + " está fazendo um pedido...\n");
    }

    public void pagarConta() {
        System.out.println(getNome() + " está pagando a conta.\n");
    }
	
}
