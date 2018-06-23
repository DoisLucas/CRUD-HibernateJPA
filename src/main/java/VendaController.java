import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class VendaController {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configBD");
    private EntityManager em;

    public VendaController() {
        em = emf.createEntityManager();
    }

    public Venda criar(Venda Venda) {
        em.getTransaction().begin();
        em.persist(Venda);
        em.getTransaction().commit();
        return Venda;
    }


    public Venda obter(int id) {
        em.getTransaction().begin();
        Venda Venda = em.find(Venda.class, id);
        em.getTransaction().commit();
        return Venda;
    }


    public Venda atualizar(Venda Venda) {
        em.getTransaction().begin();
        Venda = em.merge(Venda);
        em.getTransaction().commit();
        return Venda;
    }


    public void remover(Venda Venda) {
        em.getTransaction().begin();
        em.remove(Venda);
        em.getTransaction().commit();
    }

    public List<Venda> getAll(){
        List<Venda> lista = em
                .createQuery("SELECT v FROM Venda as v")
                .getResultList();
        return lista;
    }

}
