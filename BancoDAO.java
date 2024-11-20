import java.util.ArrayList;
import java.util.List;

public class BancoDAO {
    private List<Banco> bancos = new ArrayList<>();

    public void salvar(Banco banco) {
        bancos.add(banco);
    }

    public Banco buscarPorNome(String nome) {
        return bancos.stream().filter(b -> b.getNome().equals(nome)).findFirst().orElse(null);
    }

    public void remover(Banco banco) {
        bancos.remove(banco);
    }
}
