
public class Motoboy extends Funcionario {
    public Motoboy(String nome, String cpf, String telefone) {
        super(nome, cpf, telefone);
    }

    public void entregarPedido() {
        System.out.println(getNome() + " está entregando o pedido.\n");
    }
}