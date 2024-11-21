import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Conta implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public void salvarContaEmArquivo() {
        String nomeArquivo = "a" + this.agencia.getCodigo() + "-" + this.numero + ".ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(this);
        } catch (IOException e) {
            System.err.println("Erro ao salvar a conta: " + e.getMessage());
        }
    }

    public static Conta carregarContaDeArquivo(String codigoAgencia, String numeroConta) {
        String nomeArquivo = "a" + codigoAgencia + "-" + numeroConta + ".ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            return (Conta) ois.readObject();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + nomeArquivo);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar a conta: " + e.getMessage());
        }
        return null;
    }
}
