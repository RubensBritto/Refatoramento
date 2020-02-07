package estacionamento.strategy;

import java.util.ArrayList;

import estacionamento.veiculos.Veiculo;

public class EstadoAtualStrategy implements MenuStrategy {

	@Override
	public void execute(ArrayList<Veiculo> veiculos, ArrayList<Double>valor) {
	       for (Veiculo v : veiculos) {
	           System.out.println(v);           
	       }
	       System.out.printf("Total de veiculos dentro do estacionamento: %d\n", veiculos.size());
	    }
		
	}

