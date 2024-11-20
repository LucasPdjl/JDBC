import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();

    public void salvar(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente buscarPorNome(String nome) {
        return clientes.stream().filter(c -> c.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void remover(Cliente cliente) {
        clientes.remove(cliente);
    }
}
