package estacionamento.strategy;

import java.util.ArrayList;

import estacionamento.veiculos.Veiculo;

public class EstadoAtualStrategy implements MenuStrategy {

	@Override
	public void execute(ArrayList<Veiculo> veiculos) {
	       for (Veiculo v : veiculos) {
	           System.out.println(v);           
	       } 		
	}

}
