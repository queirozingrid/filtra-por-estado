import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PessoaOperacoes {
    public void cadastrarPessoa(Pessoa pessoa){

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("estados");
        EntityManager entitymanager = emfactory.createEntityManager();

        entitymanager.getTransaction().begin();
        entitymanager.persist(pessoa);
        entitymanager.getTransaction().commit();

        entitymanager.close();

    }
}
