import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Banco banco = new Banco("Banco do Puyol");
        ncias
        Agencia agencia1 = new Agencia("001", banco);
        Agencia agencia2 = new Agencia("002", banco);
 
        Cliente cliente1 = new Cliente("Jemaf");
        Cliente cliente2 = new Cliente("El Maia");
        Cliente cliente3 = new Cliente("Wellington");

        Conta conta1 = new Conta("1001", 600.0, agencia1);
        Conta conta2 = new Conta("1002", -200.0, agencia1);
        Conta conta3 = new Conta("2001", 1500.0, agencia2);
        Conta conta4 = new Conta("2002", 300.0, agencia2);

        conta1.adicionarCliente(cliente1);
        conta2.adicionarCliente(cliente2);
        conta3.adicionarCliente(cliente3);
        conta4.adicionarCliente(cliente1);
        conta4.adicionarCliente(cliente2);

        agencia1.adicionarConta(conta1);
        agencia1.adicionarConta(conta2);
        agencia2.adicionarConta(conta3);
        agencia2.adicionarConta(conta4);

        System.out.println("\n1 - Clientes com saldo negativo:");
        List<Cliente> clientesComSaldoNegativo = banco.listarClientesComSaldoNegativo();
        clientesComSaldoNegativo.forEach(cliente -> System.out.println(cliente.getNome()));

        System.out.println("\n2 - Total de saldo por agência:");
        Map<Agencia, Double> saldoPorAgencia = banco.calcularSaldoPorAgencia();
        saldoPorAgencia.forEach((agencia, saldo) ->
                System.out.println("Agência " + agencia.getCodigo() + ": R$ " + saldo));

        System.out.println("\n3 - Clientes com maiores saldos:");
        List<Cliente> clientesComMaiorSaldo = banco.listarClientesComMaiorSaldo(2);
        clientesComMaiorSaldo.forEach(cliente -> System.out.println(cliente.getNome()));

        System.out.println("\n4 - Contas com saldo acima de R$ X:");
        List<Conta> contasAcimaDe = banco.listarContasAcimaDe(500);
        contasAcimaDe.forEach(conta -> System.out.println("Conta " + conta.getNumero()));

        System.out.println("\n5 - Contas do cliente X:");
        List<Conta> contasDoCliente = banco.listarContasPorCliente(cliente1);
        contasDoCliente.forEach(conta -> System.out.println("Conta " + conta.getNumero()));
    }
}
