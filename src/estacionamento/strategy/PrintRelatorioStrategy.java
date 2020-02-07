package estacionamento.strategy;

import java.util.ArrayList;

import estacionamento.veiculos.Veiculo;

public class PrintRelatorioStrategy implements MenuStrategy {
	double valorFinal = 0;
	@Override
	public void execute(ArrayList<Veiculo> veiculos,ArrayList<Double>valor){
		for (Double double1 : valor) {
			valorFinal += double1;
		}
		System.out.println("Total de carros que sairam do estacionamento: "+valor.size());
		System.out.println("Total de lucros: " +valorFinal);
		
	
	}

}
