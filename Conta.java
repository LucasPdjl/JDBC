import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numero;
    private Agencia agencia;
    private List<Cliente> clientes;

    public Conta(String numero, Agencia agencia) {
        this.numero = numero;
        this.agencia = agencia;
        this.clientes = new ArrayList<>();
        agencia.adicionarConta(this);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void removerCliente(Cliente cliente) {
        clientes.remove(cliente);
    }
}
