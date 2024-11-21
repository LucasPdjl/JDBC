import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numero;
    private double saldo;
    private Agencia agencia;
    private List<Cliente> clientes;

    public Conta(String numero, double saldo, Agencia agencia) {
        this.numero = numero;
        this.saldo = saldo;
        this.agencia = agencia;
        this.clientes = new ArrayList<>();
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
