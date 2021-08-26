import antlr.MismatchedCharException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    public void escolher(){
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        boolean validaOpcao = false;

        System.out.println("*************** MENU ***************");
        System.out.println("Digite a opção que deseja realizar");
        System.out.println("1. Inserir cadastro");
        System.out.println("2. Remover cadastro");
        System.out.println("3. Atualizar cadastro");
        System.out.println("4. Visualizar todos os cadastros");
        System.out.println("5. Sair");

        while (!validaOpcao){
            try{
                scan = new Scanner(System.in);
                opcao = scan.nextInt();
                validaOpcao = true;
            } catch (InputMismatchException e){
                System.out.println("Digite um número!!!");
            }
        }
        if(opcao < 1 || opcao > 5){
            System.out.println("Opção inválida!!");
            Menu menu = new Menu();
            menu.escolher();
        }
        else if(opcao==1){
            PessoaOperacoes op = new PessoaOperacoes();
            op.cadastrarPessoa();
        }
        else if(opcao==2){
            PessoaOperacoes op = new PessoaOperacoes();
            op.removerPessoa();
        }

    }
}
