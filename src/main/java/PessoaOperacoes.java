import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class PessoaOperacoes {
    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("estados");
    EntityManager entitymanager = emfactory.createEntityManager();

    public void cadastrarPessoa(){

        Estado estado;
        String nome;
        int idade;

        Validacao validacao = new Validacao();
        nome = validacao.validaNome();

        idade = validacao.validaIdade();

        estado = validacao.validaEstado();

        Pessoa pessoa = new Pessoa(nome, estado, idade);


        entitymanager.getTransaction().begin();
        entitymanager.persist(pessoa);
        entitymanager.getTransaction().commit();

        entitymanager.close();

    }

    public void removerPessoa(){
        System.out.println("cheguei");
        String jpql = "select p from Pessoa p";
        Query select = entitymanager.createQuery(jpql, Pessoa.class);
        List<Pessoa> pessoas = select.getResultList();

        for (Pessoa p: pessoas) {
            System.out.println(p.getId() + ". " + p.getNome() + " " + p.getIdade() + " Estado: " + p.getEstado());
        }

    }
}
