import javax.persistence.*;

@Entity
@Table(name = "tab_carro")

@NamedQueries({
        @NamedQuery(name = "Carro.maiorIgualAno", query = "SELECT c from Carro c WHERE c.ano >= :param_ano")
})

public class Carro {

    @Id
    private int numero_chassi;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "cor", nullable = false)
    private String cor;
    @Column(name = "ano", nullable = false)
    private int ano;
    @Column(name = "potencia", nullable = false)
    private int potencia_cv;
    @Column(name = "valor", nullable = false)
    private double valor;

    public Carro() {
    }

    public Carro(int numero_chassi, String nome, String cor, int ano, int potencia_cv, double valor) {
        this.numero_chassi = numero_chassi;
        this.nome = nome;
        this.cor = cor;
        this.ano = ano;
        this.potencia_cv = potencia_cv;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getNumero_chassi() {
        return numero_chassi;
    }

    public void setNumero_chassi(int numero_chassi) {
        this.numero_chassi = numero_chassi;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPotencia_cv() {
        return potencia_cv;
    }

    public void setPotencia_cv(int potencia_cv) {
        this.potencia_cv = potencia_cv;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Carro{" + "numero_chassi=" + numero_chassi + ", nome=" + nome + ", cor=" + cor + ", ano=" + ano + ", potencia_cv=" + potencia_cv + ", valor=" + valor + '}';
    }

}