
public class Garcom extends Funcionario {
    public Garcom(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

    public void levarPedidoMesa() {
        System.out.println(getNome() + " está levando o pedido até a mesa.\n");
    }
}