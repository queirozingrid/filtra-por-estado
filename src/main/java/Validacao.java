import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.*;

public class Validacao {
    EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("estados");
    EntityManager entitymanager = emfactory.createEntityManager();

    public String validaNome(){
        int i, cont = 0;
        boolean validacaoNome = false;
        Scanner scan;
        String nome = "";
        while (!validacaoNome) {
            System.out.println("Digite seu nome para começarmos");
            scan = new Scanner(System.in);

            nome = scan.next();
            if (nome.isEmpty() || nome.isBlank()) {
                System.out.println("Digite algo!!");
            }
            for (i = 0; i < nome.length(); i++) {
                if (Character.isDigit(nome.charAt(i)) || !Character.isAlphabetic(nome.charAt(i))) {
                    cont++;
                    validacaoNome = false;
                }
                else {
                    validacaoNome = true;
                }
            }
            if(cont>0){
                System.out.println("Digite apenas letras!!");
            }
        }
    return nome;
    }

    public int validaIdade(){
        int idade = -1;
        boolean validaIdade = false;
        Scanner scan;

        while(!validaIdade){
            try{
                System.out.println("Agora digite sua idade");
                scan = new Scanner(System.in);
                idade = scan.nextInt();

                if(idade<0){
                    validaIdade = false;
                    System.out.println("Digite uma idade válida");
                }
                else{
                    validaIdade = true;
                }
            } catch (InputMismatchException e){
                System.out.println("Digite apenas números");
            }
        }
        return idade;
    }

    public Estado validaEstado(){
        boolean validacao = false;
        Estado estado = new Estado();
        while(!validacao){
            System.out.println("Agora digite seu estado");
            Scanner scan = new Scanner(System.in);
            String estadoStr = scan.next();

            String jpql = "select e from Estado e where e.sigla = :sigla";

            Query select = entitymanager.createQuery(jpql, Estado.class).setParameter("sigla", estadoStr.toUpperCase());

            List<Estado> estados = select.getResultList();
            if(estados.size()>0){
                estado = estados.get(0);
                validacao = true;

            }
            else {
                System.out.println("estado inválido!! Vamos tentar novamente!\n");
                validacao = false;
            }

        }
        return estado;


    }

}
