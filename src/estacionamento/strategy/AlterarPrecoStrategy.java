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
	                "[3]- Para alterar o valor dos Caminhões\n"+
	                "[4]- Para alterar o valor das horas adicionais");
	        try {
	            int escolha = input.nextInt();
	            if(escolha == 1){
	                preco.setPrecoCarro(input.nextDouble()); 
	            }
	            else if (escolha == 2) {
	                preco.setPrecoMoto(input.nextDouble()); 
	            } 
	            else if (escolha == 3) {
	                preco.setPrecoMoto(input.nextDouble()); 
	            }
	            else if (escolha== 4) {
	                preco.setHoraAdicional(input.nextInt()); 
	            }
	            else{
	                System.out.println("Opção invalida");
	                execute(veiculos);
	            }        
	        }catch (NumberFormatException e) {
	            System.out.println("O campo espera um número");
	        }       

	}

}
