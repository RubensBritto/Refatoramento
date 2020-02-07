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
	  public ArrayList<Double>valor = new ArrayList<Double>();

	    public void start(){
	        try{
	            System.out.println("----------------------Digite o que deseja fazer-------------\n"+
	            "[1] Adiconar Veiculo ao Estacionamento\n"+
	            "[2] Alterar Dados do Veiculo\n"+
	            "[3] Remover Veiculo do Estacionamento\n"+
	            "[4] Adicionar o Valor das horas extras e tempo máx de permanencia\n"+
	            "[5] Alterar horas extras e/ou tempo de permanencia\n"+
	            "[6] Mostrar estado atual\n"+
	            "[7] Relatorio Financeiro\n"+
	            "[8] Sair");
	            int escolha = input.nextInt();
	            while(escolha < 0 || escolha >= 9) {
	            	System.out.println("Digite um numero entre 1 e 8");
	            	escolha = input.nextInt();
	            }
	            TypeMenu typeMenu = TypeMenu.values()[escolha - 1];
	            
	            MenuStrategy menuStrategy = typeMenu.obterMenu();
	            menuStrategy.execute(veiculos,valor);
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
