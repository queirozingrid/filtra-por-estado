import javax.persistence.*;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Estado estado;

        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("estados");
        EntityManager entitymanager = emfactory.createEntityManager();


        Validacao validacao = new Validacao();
        String nome = validacao.validaNome();

        int idade;
        idade = validacao.validaIdade();



        System.out.println("Agora digite seu estado");
        String estadoStr = scan.next();


        String jpql = "select e from Estado e where e.sigla = :sigla";

        Query select = entitymanager.createQuery(jpql, Estado.class).setParameter("sigla", estadoStr.toUpperCase());

        List<Estado> estados = select.getResultList();
        if(estados.size()>0){
            estado = estados.get(0);
            Pessoa pessoa = new Pessoa(nome, estado, idade);
            PessoaOperacoes op = new PessoaOperacoes();
            op.cadastrarPessoa(pessoa);

        }
        else {
            System.out.println("estado inválido!!");
        }


    }
}
