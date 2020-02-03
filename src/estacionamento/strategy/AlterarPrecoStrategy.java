package estacionamento.strategy;

import java.util.ArrayList;
import java.util.Scanner;

import estacionamento.financeiro.Preco;
import estacionamento.veiculos.Veiculo;

public class AlterarPrecoStrategy implements MenuStrategy {
	Scanner input = new Scanner(System.in);
	Preco preco = new Preco();
	@Override
	public void execute(ArrayList<Veiculo> veiculos) {
		 System.out.println("Digite a opção desejada\n"+
	                "[1]- Para alterar o valor dos carros\n"+
	                "[2]- Para altera o valor das motos\n"+
	                "[3]- Para alterar o valor dos Caminhões\n");
	        try {
	            int escolha = input.nextInt();
	            if(escolha == 1){
	            	System.out.println("Digie o novo valor para os carros");
	                preco.setPrecoCarro(input.nextDouble());
	                System.out.println("Alteracao feita com sucesso");
	            }
	            else if (escolha == 2) {
	            	System.out.println("Digie o novo valor para as motos");
	                preco.setPrecoMoto(input.nextDouble());
	                System.out.println("Alteracao feita com sucesso");
	            } 
	            else if (escolha == 3) {
	            	System.out.println("Digie o novo valor para os caminhoes");
	                preco.setPrecoMoto(input.nextDouble()); 
	                System.out.println("Alteracao feita com sucesso");
	            }
	            else{
	                System.out.println("Opção invalida");
	                execute(veiculos);
	            }        
	        }catch (NumberFormatException e) {
	            System.out.println("O campo espera um número");
	        }       
	        return;
	}

}
