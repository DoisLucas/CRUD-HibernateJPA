import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaController {


    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configBD");
    private EntityManager em;

    public PessoaController() {
        em = emf.createEntityManager();
    }

    public Pessoa criar(Pessoa Pessoa) {
        em.getTransaction().begin();
        em.persist(Pessoa);
        em.getTransaction().commit();
        return Pessoa;
    }


    public Pessoa obter(int id) {
        em.getTransaction().begin();
        Pessoa Pessoa = em.find(Pessoa.class, id);
        em.getTransaction().commit();
        return Pessoa;
    }


    public Pessoa atualizar(Pessoa Pessoa) {
        em.getTransaction().begin();
        Pessoa = em.merge(Pessoa);
        em.getTransaction().commit();
        return Pessoa;
    }


    public void remover(Pessoa Pessoa) {
        em.getTransaction().begin();
        em.remove(Pessoa);
        em.getTransaction().commit();
    }

    public List<Pessoa> getAll(){
        List<Pessoa> lista = em
                .createQuery("SELECT p FROM Pessoa p")
                .getResultList();
        return lista;
    }

    public List<Venda> mostrar_meus_carros(int cpf){
        List<Venda> lista = em
                .createQuery("SELECT v FROM Venda v WHERE v.p.cpf = :param_cpf").setParameter("param_cpf", cpf)
                .getResultList();
        return lista;
    }

}
