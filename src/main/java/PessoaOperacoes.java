import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

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

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setIdade(idade);
        pessoa.setEstado(estado);


        entitymanager.getTransaction().begin();
        entitymanager.persist(pessoa);
        entitymanager.getTransaction().commit();

        entitymanager.close();

    }

    public void removerPessoa(){
        int opcao;
        int opcaoRemover = 0;
        boolean validaOpcao = false;

        String jpql = "select p from Pessoa p";
        Query select = entitymanager.createQuery(jpql, Pessoa.class);
        List<Pessoa> pessoas = select.getResultList();

        for (Pessoa p: pessoas) {
            System.out.println(p.getId() + ". " + p.getNome() + ", " + p.getIdade() + " anos, Estado: " + p.getEstado().getSigla());
        }

        Validacao validacao = new Validacao();
        List<Pessoa> pessoas1 = null;

        while (!validaOpcao){
            System.out.println("Escolha pelo número da pessoa que deseja remover");
            opcaoRemover = validacao.validaOpcao();
            Query remove = entitymanager.createQuery("select p from Pessoa p where p.id =:opcao").
                    setParameter("opcao", opcaoRemover);

            pessoas1 = remove.getResultList();

            if(pessoas1.size()<1){
                System.out.println("Opção inválida!!!");
                validaOpcao = false;
            }
            else {
                validaOpcao = true;
            }
        }

        System.out.println("Tem certeza que deseja remover " + pessoas1.get(0).getNome() + " permanentemente do banco?");
        System.out.println("1. Para sim");
        System.out.println("2. Para não");

        Validacao validacao1 = new Validacao();
        opcao = validacao1.validaOpcao();
        validaOpcao = false;

        while (!validaOpcao){
            if(opcao<1 || opcao>2){
                System.out.println("Opção inválida!!!");
                validaOpcao = false;
            }
            else {
                validaOpcao = true;
            }
        }
        if(opcao==1){
            try{
                entitymanager.getTransaction().begin();
                entitymanager.remove(entitymanager.find(Pessoa.class, opcaoRemover));
                entitymanager.getTransaction().commit();
                System.out.println("Cadastro removido com sucesso!");

            } catch (Exception e){
                System.out.println("Ocorreu um erro, tente novamente mais tarde");
                e.printStackTrace();
                entitymanager.getTransaction().rollback();
            } finally {
                entitymanager.close();
            }
        }
        else if(opcao==2) {
            System.out.println("### Cancelando operação ... ###");
        }

    }
    public void atualizarCadastro(){

    }
}
