import javax.persistence.*;

@Entity
@Table(
        name = "tab_venda",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"c_numero_chassi"})}
)
public class Venda {

    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(foreignKey= @ForeignKey(name="p_cpf"))
    private Pessoa p;
    @OneToOne
    @JoinColumn(foreignKey= @ForeignKey(name="c_numero_chassi"))
    private Carro c;
    private String data_venda;

    public Venda(Pessoa p, Carro c) {
        this.p = p;
        this.c = c;
        this.data_venda = java.time.LocalDate.now().toString();
    }

    public Venda() {
    }

    public Pessoa getP() {
        return p;
    }

    public void setP(Pessoa p) {
        this.p = p;
    }

    public Carro getC() {
        return c;
    }

    public void setC(Carro c) {
        this.c = c;
    }

    public String getData_venda() {
        return data_venda;
    }

    public void setData_venda(String data_venda) {
        this.data_venda = data_venda;
    }

    @Override
    public String toString() {
        return "Venda{" + "p=" + p + ", c=" + c + ", data_venda=" + data_venda + '}';
    }

}
