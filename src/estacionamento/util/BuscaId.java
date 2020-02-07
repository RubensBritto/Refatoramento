package estacionamento.util;

import java.util.ArrayList;
import estacionamento.veiculos.Veiculo;

public class BuscaId {
	public int getIdVeiculos(ArrayList<Veiculo> veiculos, int id) {
		for (int aux = 0; aux < veiculos.size(); aux++) {
			if (id == veiculos.get(aux).getId()){
				return -1;
			}
		}
		return 1;
	}

}
