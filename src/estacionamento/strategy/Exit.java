package estacionamento.strategy;

import java.util.ArrayList;

import estacionamento.veiculos.Veiculo;

public class Exit implements MenuStrategy {

	@Override
	public void execute(ArrayList<Veiculo> veiculos, ArrayList<Double>valor) {
		System.exit(0);
		
	}
	
}
