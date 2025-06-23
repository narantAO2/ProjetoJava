
public abstract class Funcionario extends Pessoa {
	
    public Funcionario(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

    public void atenderCliente() {
        System.out.println(getNome() + " está atendendo o cliente.\n");
    }
}