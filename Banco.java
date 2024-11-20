import java.util.*;
import java.util.stream.Collectors;

public class Banco {
    private String nome;
    private List<Agencia> agencias;

    public Banco(String nome) {
        this.nome = nome;
        this.agencias = new ArrayList<>();
    }
     public void adicionarAgencia(Agencia agencia) {
        agencias.add(agencia);
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }
// *****
    
   

    // 1 - Listar clientes com nome sujo
    public List<Cliente> listarClientesComSaldoNegativo() {
        return agencias.stream()
                .flatMap(agencia -> agencia.getContas().stream())
                .filter(conta -> conta.getSaldo() < 0)
                .flatMap(conta -> conta.getClientes().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    // 2 - Total de saldo em cada agencia
    public Map<Agencia, Double> calcularSaldoPorAgencia() {
        return agencias.stream()
                .collect(Collectors.toMap(
                        agencia -> agencia,
                        agencia -> agencia.getContas().stream()
                                .mapToDouble(Conta::getSaldo)
                                .sum()
                ));
    }

    // 3 - lista clientes com os maiores saldos
   public List<Cliente> listarClientesComMaiorSaldo(int numClientes) {
    return agencias.stream() 
            .flatMap(agencia -> agencia.getContas().stream()) 
            .flatMap(conta -> conta.getClientes().stream() 
                    .map(cliente -> new AbstractMap.SimpleEntry<>(cliente, conta.getSaldo()))) 
            .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.summingDouble(Map.Entry::getValue)))
            .entrySet().stream()
            .sorted(Map.Entry.<Cliente, Double>comparingByValue().reversed()) 
            .limit(numClientes) 
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
}

    // 4 - Lista contas com saldo > q
    public List<Conta> listarContasAcimaDe(double saldoMinimo) {
        return agencias.stream()
                .flatMap(agencia -> agencia.getContas().stream())
                .filter(conta -> conta.getSaldo() > saldoMinimo)
                .collect(Collectors.toList());
    }

    // 5  - Lista as contas de um cliente
    public List<Conta> listarContasPorCliente(Cliente cliente) {
        return agencias.stream()
                .flatMap(agencia -> agencia.getContas().stream())
                .filter(conta -> conta.getClientes().contains(cliente))
                .collect(Collectors.toList());
    }
}
