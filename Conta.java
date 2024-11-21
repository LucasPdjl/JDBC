import java.util.ArrayList;
import java.util.List;

public class Conta {
    private String numero; // Número da conta
    private double saldo;  // Saldo da conta
    private Agencia agencia; // Agência associada à conta
    private List<Cliente> clientes; // Lista de clientes associados à conta

    public Conta(String numero, double saldo, Agencia agencia) {
        this.numero = numero;
        this.saldo = saldo;
        this.agencia = agencia;
        this.clientes = new ArrayList<>();
    }

    // Getter para saldo
    public double getSaldo() {
        return saldo;
    }

    // Setter para saldo
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Getter para número da conta
    public String getNumero() {
        return numero;
    }

    // Setter para número da conta
    public void setNumero(String numero) {
        this.numero = numero;
    }

    // Getter para agência
    public Agencia getAgencia() {
        return agencia;
    }

    // Setter para agência
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    // Adicionar cliente à conta
    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    // Getter para clientes
    public List<Cliente> getClientes() {
        return clientes;
    }
}
