package estacionamento.strategy;

import java.util.ArrayList;
import java.util.Scanner;

import estacionamento.financeiro.Preco;
import estacionamento.veiculos.Veiculo;

public class AlterHourExtraStrategy implements MenuStrategy {
	Scanner input = new Scanner(System.in);
	Preco preco = new Preco();
	
	@Override
	public void execute(ArrayList<Veiculo> veiculos) {
		 System.out.println("Digite a op��o desejada\n"+
			        "[1]- Para alterar das horas extras\n"+
			        "[2]- Para altera o tempo m�x de permancencia\n");
			        try {
			            int escolha = input.nextInt();
			            if(escolha == 1){
			            	System.out.println("Digie a nova hora adicional");
			                preco.setHoraAdicional(input.nextInt());
			            	System.out.println("Altera��o feita com sucesso");
			            }
			            else if (escolha == 2) {
			            	System.out.println("Digie o novo valor para a hora adicional");
			                preco.setPriceHoraAdicional(input.nextDouble());
			            	System.out.println("Altera��o feita com sucesso");
			            } 
			            else{
			                System.out.println("Op��o invalida");
			                execute(veiculos);
			            }         
			        }catch (NumberFormatException e) {
			            System.out.println("O campo espera um n�mero");
			        }   
	}
	
}
