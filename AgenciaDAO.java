import java.util.ArrayList;
import java.util.List;

public class AgenciaDAO {
    private List<Agencia> agencias = new ArrayList<>();

    public void salvar(Agencia agencia) {
        agencias.add(agencia);
    }

    public Agencia buscarPorCodigo(String codigo) {
        return agencias.stream().filter(a -> a.getCodigo().equals(codigo)).findFirst().orElse(null);
    }

    public void remover(Agencia agencia) {
        agencias.remove(agencia);
    }
}
