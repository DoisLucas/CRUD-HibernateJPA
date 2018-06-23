import java.util.Scanner;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        Main m = new Main();
        m.menu();
    }

    public Scanner getScanner() {
        return new Scanner(System.in);
    }

    public void menu() {

        System.out.println("1) Cadastrar Carro");
        System.out.println("2) Listar Todos Carros");
        System.out.println("3) Excluir Carro");
        System.out.println("4) Alterar Carro");
        System.out.println("5) Cadastrar Pessoa");
        System.out.println("6) Listar Todas Pessoas");
        System.out.println("7) Excluir Pessoa");
        System.out.println("8) Alterar Pessoa");
        System.out.println("9) Realizar Venda");
        System.out.println("10) Mostar Vendas");
        System.out.println("11) Listar Carro de Pessoa");
        System.out.println("12) Listar Carro com ano igual ou superior: ");
        System.out.println("13) Sair");
        System.out.print("Opção: ");
        int op = getScanner().nextInt();

        switch (op) {

            case 1:
                add_carro();
            case 2:
                listar_carro();
            case 3:
                excluir_carro();
            case 4:
                alterar_carro();
            case 5:
                add_pessoa();
            case 6:
                listar_pessoa();
            case 7:
                excluir_pessoa();
            case 8:
                alterar_pessoa();
            case 9:
                realizar_venda();
            case 10:
                mostrar_vendas();
            case 11:
                listar_carro_pessoa();
            case 12:
                mostrar_carro_ano();
            case 13:
                System.exit(0);
            default:
                System.out.println("Digite uma opção valida!");
                menu();
        }
    }

    private void add_carro() {

        System.out.print("\nDigite o numero do chassi do carro: ");
        int chassi = getScanner().nextInt();
        System.out.print("Digite o nome do carro: ");
        String nome = getScanner().nextLine();
        System.out.print("Digite a cor do carro: ");
        String cor = getScanner().next();
        System.out.print("Digite o ano do carro: ");
        int ano = getScanner().nextInt();
        System.out.print("Digite a potencia do carro: ");
        int potencia = getScanner().nextInt();
        System.out.print("Digite o valor do carro: ");
        float valor = getScanner().nextFloat();
        System.out.print("\n");

        Carro c = new Carro(chassi, nome, cor, ano, potencia, valor);

        CarroController cc = new CarroController();
        cc.criar(c);
        menu();

    }

    public void listar_carro() {

        CarroController cc = new CarroController();

        if (cc.getAll().size() == 0) {
            System.out.println("\nNão possuimos nenhum carro na base de dados para listar!\n");
            menu();
        } else {

            System.out.println("\t\n--- Todos os Carros ---\n");

            for (Carro c : cc.getAll()) {
                System.out.println("Numero do Chassi: " + c.getNumero_chassi());
                System.out.println("Nome: " + c.getNome());
                System.out.println("Cor: " + c.getCor());
                System.out.println("Ano: " + c.getAno());
                System.out.println("Potência (CV): " + c.getPotencia_cv());
                System.out.println("Valor do carro: " + c.getValor() + "\n");
            }
            menu();

        }
    }

    public void excluir_carro() {

        CarroController cc = new CarroController();

        if (cc.getAll().size() == 0) {
            System.out.println("\nNão possuimos nenhum carro na base de dados para realizar a exclusão!\n");
            menu();
        } else {

            System.out.print("\nDigite o número do chassi do carro para excluir: ");
            int numero_chassi = getScanner().nextInt();
            System.out.print("\n");

            cc.remover(cc.obter(numero_chassi));
            menu();
        }

    }

    public void alterar_carro() {

        CarroController cc = new CarroController();

        if (cc.getAll().size() == 0) {
            System.out.println("\nNão possuimos nenhum carro na base de dados para realizar a alteração!\n");
            menu();
        } else {
            System.out.print("\nDigite o número do chassi do carro para alterar: ");
            int numero_chassi = getScanner().nextInt();

            Carro c = cc.obter(numero_chassi);

            System.out.println("\nAlterando Informações do Carro: \n");
            System.out.println("Numero do Chassi: " + c.getNumero_chassi());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Cor: " + c.getCor());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Potência (CV): " + c.getPotencia_cv());
            System.out.println("Valor do carro: " + c.getValor() + "\n");

            System.out.println("Digite as novas informações: \n");

            System.out.print("Nome: ");
            c.setNome(getScanner().next());

            System.out.print("Cor: ");
            c.setCor(getScanner().next());

            System.out.print("Ano: ");
            c.setAno(getScanner().nextInt());

            System.out.print("Potencia (CV): ");
            c.setPotencia_cv(getScanner().nextInt());

            System.out.print("Valor do carro: ");
            c.setValor(getScanner().nextDouble());
            cc.atualizar(c);
            menu();
        }
    }

    public void add_pessoa() {

        System.out.print("\nDigite o nome da Pessoa: ");
        String nome = getScanner().nextLine();
        System.out.print("Digite o CPF da Pessoa: ");
        int cpf = getScanner().nextInt();
        System.out.print("Digite o RG da Pessoa: ");
        int rg = getScanner().nextInt();
        System.out.print("Digite a idade da Pessoa: ");
        int idade = getScanner().nextInt();
        System.out.print("\n");

        Pessoa p = new Pessoa(cpf, rg, idade, nome);

        PessoaController pc = new PessoaController();
        pc.criar(p);
        menu();
    }

    public void listar_pessoa() {

        PessoaController pc = new PessoaController();

        if (pc.getAll().size() == 0) {
            System.out.println("\nNão possuimos nenhum cliente na base de dados para listar!\n");
            menu();
        } else {

            System.out.println("\t\n--- Todas as Pessoas ---\n");

            for (Pessoa p : pc.getAll()) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("CPF: " + p.getCpf());
                System.out.println("RG: " + p.getRg());
                System.out.println("Idade: " + p.getIdade() + "\n");
            }
            menu();
        }
    }

    public void excluir_pessoa() {

        PessoaController pc = new PessoaController();

        if (pc.getAll().size() == 0) {
            System.out.println("\nNão possuimos nenhum cliente na base de dados para excluir!\n");
            menu();
        } else {
            System.out.print("\nDigite o CPF da pessoa para remove-lá: ");
            System.out.print("\n");

            int cpf = getScanner().nextInt();
            pc.remover(pc.obter(cpf));
            menu();
        }

    }

    public void alterar_pessoa() {

        PessoaController pc = new PessoaController();

        if (pc.getAll().size() == 0) {
            System.out.println("\nNão possuimos nenhum cliente na base de dados para listar!\n");
            menu();
        } else {

            System.out.print("\nDigite o CPF da pessoa para alterar: ");
            int cpf = getScanner().nextInt();

            Pessoa p = pc.obter(cpf);

            System.out.println("\nAlterando Informações da Pessoa: \n");
            System.out.println("Nome: " + p.getNome());
            System.out.println("CPF: " + p.getCpf());
            System.out.println("RG: " + p.getCpf());
            System.out.println("Idade: " + p.getIdade() + "\n");

            System.out.println("Digite as novas informações: \n");

            System.out.print("Nome: ");
            p.setNome(getScanner().nextLine());
            System.out.print("Idade: ");
            p.setIdade(getScanner().nextInt());

            pc.atualizar(p);
            menu();
        }
    }

    public void realizar_venda() {

        PessoaController pc = new PessoaController();
        CarroController cc = new CarroController();

        if (pc.getAll().size() == 0) {
            System.out.println("\nNão possuimos nenhum carro na base de dados para realizar a venda!\n");
            menu();
        } else if (cc.getAll().size() == 0) {
            System.out.println("\nNão possuimos nenhum cliente na base de dados para realizar a venda!\n");
            menu();
        }

        System.out.print("\nDigite o CPF do comprador: ");
        int cpf = getScanner().nextInt();
        System.out.print("Digite o número do chassi do carro: ");
        int chassi = getScanner().nextInt();


        Pessoa p = pc.obter(cpf);
        Carro c = cc.obter(chassi);

        Venda v = new Venda(p, c);

        System.out.println("\nResumo da Venda: \n");
        System.out.println("Comprador: " + p.getCpf() + " - " + p.getNome());
        System.out.println("Carro: " + c.getNumero_chassi() + " - " + c.getNome());
        System.out.println("Valor: " + c.getValor());
        System.out.println("Data da venda: " + v.getData_venda());
        System.out.print("Finalizar venda? 1-(Sim) 0-(Não): ");
        int escolha = getScanner().nextInt();
        System.out.print("\n");

        if (escolha == 1) {
            VendaController vc = new VendaController();
            vc.criar(v);
            menu();
        } else {
            System.out.print("\n");
            menu();
        }
    }

    public void mostrar_vendas() {

        VendaController vc = new VendaController();

        System.out.print("\n");

        for (Venda v : vc.getAll()) {
            System.out.println("Comprador: " + v.getP().getNome());
            System.out.println("Carro: " + v.getC().getNumero_chassi() + " - " + v.getC().getNome());
            System.out.println("Valor: " + v.getC().getValor());
            System.out.println("Data: " + v.getData_venda() + "\n");
        }

        menu();
    }

    public void listar_carro_pessoa() {
        System.out.print("\nDigite o CPF da pessoa para listar os carros: ");
        int cpf = getScanner().nextInt();

        System.out.print("\n");

        PessoaController pc = new PessoaController();

        for (Venda v : pc.mostrar_meus_carros(cpf)) {
            System.out.println("Carro: " + v.getC().getNumero_chassi() + " - " + v.getC().getNome());
        }

        System.out.print("\n");

        menu();
    }

    public void mostrar_carro_ano() {

        System.out.print("\nDigite o ano minimo para listar os carros: ");
        int ano = getScanner().nextInt();
        System.out.print("\n");

        CarroController cc = new CarroController();

        for (Carro c : cc.getCarroNovo(ano)) {
            System.out.println("Numero do Chassi: " + c.getNumero_chassi());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Cor: " + c.getCor());
            System.out.println("Ano: " + c.getAno());
            System.out.println("Potência (CV): " + c.getPotencia_cv());
            System.out.println("Valor do carro: " + c.getValor() + "\n");
        }

        menu();


    }

}

