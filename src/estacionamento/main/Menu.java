package estacionamento.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import estacionamento.strategy.MenuStrategy;
import estacionamento.strategy.TypeMenu;
import estacionamento.veiculos.Veiculo;

public class Menu {
	  public Scanner input = new Scanner(System.in);
	  public ArrayList<Veiculo>veiculos = new ArrayList<Veiculo>();

	    public void start(){
	        try{
	            System.out.println("----------------------Digite o que deseja fazer-------------\n"+
	            "[1] Adiconar Veiculo ao Estacionamento\n"+
	            "[2] Alterar Dados do Veiculo\n"+
	            "[3] Remover Veiculo do Estacionamento\n"+
	            "[4] Adicionar os Valores dos Veiculos\n"+
	            "[5] Altera os valores dos Veiculos\n"+
	            "[6] Adicionar o Valor das horas extras e tempo m�x de permanencia\n"+
	            "[7] Alterar horas extras e/ou tempo de permanencia\n"+
	            "[8] Mostrar estado atual\n"+
	            "[9] Relatorio Financeiro\n"+
	            "[10] Sair");
	            int escolha = input.nextInt();
	            while(escolha < 0 || escolha >= 11) {
	            	System.out.println("Digite um numero entre 1 e 10");
	            	escolha = input.nextInt();
	            }
	            TypeMenu typeMenu = TypeMenu.values()[escolha - 1];
	            
	            MenuStrategy menuStrategy = typeMenu.obterMenu();
	            menuStrategy.execute(veiculos);
	            start();
	            
	        	}catch(NumberFormatException e){
	            System.out.println("O sistema espera um numero");
	            return;
	        }catch(InputMismatchException e){
	            System.out.println("O sistema espera um numero");
	            return;
	        }
	    }
}
