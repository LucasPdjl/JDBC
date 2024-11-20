public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco("Banco Central");
        
        
        Agencia agencia1 = new Agencia("Agência 1");
        Agencia agencia2 = new Agencia("Agência 2");
        
        Cliente cliente1 = new Cliente("João Silva");
        Cliente cliente2 = new Cliente("Maria Oliveira");
        Cliente cliente3 = new Cliente("Carlos Santos");

        Conta conta1 = new Conta(1, 5000);
        conta1.adicionarCliente(cliente1);
        
        Conta conta2 = new Conta(2, -200);
        conta2.adicionarCliente(cliente2);
        
        Conta conta3 = new Conta(3, 10000);
        conta3.adicionarCliente(cliente3);

        agencia1.adicionarConta(conta1);
        agencia1.adicionarConta(conta2);
        agencia2.adicionarConta(conta3);

        banco.adicionarAgencia(agencia1);
        banco.adicionarAgencia(agencia2);

        // metodos da atividade 6
        System.out.println("Clientes com saldo negativo:");
        banco.listarClientesComSaldoNegativo().forEach(cliente -> System.out.println(cliente.getNome()));

        System.out.println("\nSaldo por agência:");
        banco.calcularSaldoPorAgencia().forEach((agencia, saldo) ->
                System.out.println(agencia.getNome() + ": " + saldo));

        System.out.println("\nTop 3 clientes com maior saldo:");
        banco.listarTop3ClientesComMaiorSaldo().forEach(cliente -> System.out.println(cliente.getNome()));

        System.out.println("\nContas acima de R$ 5000:");
        banco.listarContasAcimaDe(5000).forEach(conta ->
                System.out.println("Conta ID: " + conta.getId() + " - Saldo: " + conta.getSaldo()));

        System.out.println("\nContas do cliente João Silva:");
        banco.listarContasPorCliente(cliente1).forEach(conta ->
                System.out.println("Conta ID: " + conta.getId() + " - Saldo: " + conta.getSaldo()));
    }
}
