import java.util.*;

public class Validacao {

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
}
