import java.util.ArrayList;
import java.util.List;

public class Agencia {
    private String codigo;
    private Banco banco;
    private List<Conta> contas;

    public Agencia(String codigo, Banco banco) {
        this.codigo = codigo;
        this.banco = banco;
        this.contas = new ArrayList<>();
        banco.adicionarAgencia(this);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
    }
}
