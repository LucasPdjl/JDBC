public class Main {
    public static void main(String[] args) {
        // Criando o banco
        Banco banco = new Banco("Banco Puyol");

        // Criando agências
        Agencia agencia1 = new Agencia("001", banco);
        Agencia agencia2 = new Agencia("002", banco);

        // Criando clientes
        Cliente cliente1 = new Cliente("Elmaia");
        Cliente cliente2 = new Cliente("Jemaf");

        Conta conta1 = new Conta("203", agencia1);
        Conta conta2 = new Conta("1111", agencia2);

        conta1.adicionarCliente(cliente1);
        conta1.adicionarCliente(cliente2);
        conta2.adicionarCliente(cliente2);

        cliente1.adicionarConta(conta1);
        cliente2.adicionarConta(conta1);
        cliente2.adicionarConta(conta2);

        System.out.println("Banco: " + banco.getNome());
        for (Agencia agencia : banco.getAgencias()) {
            System.out.println("  Agência: " + agencia.getCodigo());
            for (Conta conta : agencia.getContas()) {
                System.out.println("    Conta: " + conta.getNumero());
                for (Cliente cliente : conta.getClientes()) {
                    System.out.println("      Cliente: " + cliente.getNome());
                }
            }
        }
    }
}
