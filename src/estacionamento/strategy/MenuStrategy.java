package estacionamento.strategy;

import java.util.ArrayList;

import estacionamento.veiculos.Veiculo; 

public interface MenuStrategy {
	public void execute(ArrayList<Veiculo>veiculos, ArrayList<Double>valor);
}
