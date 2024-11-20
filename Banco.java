import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Agencia> agencias;

    public Banco(String nome) {
        this.nome = nome;
        this.agencias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void adicionarAgencia(Agencia agencia) {
        agencias.add(agencia);
    }

    public void removerAgencia(Agencia agencia) {
        agencias.remove(agencia);
    }
}
