import javax.persistence.*;
import java.util.List;

@Entity

@Table(name = "tab_pessoa")


public class Pessoa {

    @Id
    @Column(name = "cpf")
    private int cpf;
    @Column(name = "rg", nullable = false)
    private int rg;
    @Column(name = "idade", nullable = false)
    private int idade;
    @Column(name = "nome", nullable = false)
    private String nome;
    @OneToMany(mappedBy = "p", fetch = FetchType.LAZY)
    private List<Venda> vendas_pessoas;

    public Pessoa() {
    }

    public Pessoa(int cpf, int rg, int idade, String nome) {
        this.cpf = cpf;
        this.rg = rg;
        this.idade = idade;
        this.nome = nome;
    }

    public List<Venda> getVendas_pessoas() {
        return vendas_pessoas;
    }

    public void setVendas_pessoas(List<Venda> vendas_pessoas) {
        this.vendas_pessoas = vendas_pessoas;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getRg() {
        return rg;
    }

    public void setRg(int rg) {
        this.rg = rg;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "cpf=" + cpf + ", rg=" + rg + ", idade=" + idade + ", nome=" + nome + '}';
    }

}