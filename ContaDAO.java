import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    private List<Conta> contas = new ArrayList<>();

    public void salvar(Conta conta) {
        contas.add(conta);
    }

    public Conta buscarPorNumero(String numero) {
        return contas.stream().filter(c -> c.getNumero().equals(numero)).findFirst().orElse(null);
    }

    public void remover(Conta conta) {
        contas.remove(conta);
    }
}
