import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CarroController {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configBD");
    private EntityManager em;

    public CarroController() {
        em = emf.createEntityManager();
    }

    public Carro criar(Carro Carro) {
        em.getTransaction().begin();
        em.persist(Carro);
        em.getTransaction().commit();
        return Carro;
    }


    public Carro obter(int id) {
        em.getTransaction().begin();
        Carro Carro = em.find(Carro.class, id);
        em.getTransaction().commit();
        return Carro;
    }


    public Carro atualizar(Carro Carro) {
        em.getTransaction().begin();
        Carro = em.merge(Carro);
        em.getTransaction().commit();
        return Carro;
    }


    public void remover(Carro Carro) {
        em.getTransaction().begin();
        em.remove(Carro);
        em.getTransaction().commit();
    }

    public List<Carro> getAll(){
        List<Carro> lista = em
                .createQuery("SELECT c FROM Carro c")
                .getResultList();
        return lista;
    }

    public List<Carro> getCarroNovo(){
        List<Carro> lista = em
                .createQuery("SELECT c FROM Carro c WHERE c.ano >= 2000")
                .getResultList();
        return lista;
    }

    public void close() {
        emf.close();
    }

}
