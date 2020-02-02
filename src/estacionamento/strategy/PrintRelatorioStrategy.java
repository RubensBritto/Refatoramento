package estacionamento.strategy;

import java.util.ArrayList;

import estacionamento.financeiro.Relatorio;
import estacionamento.veiculos.Veiculo;

public class PrintRelatorioStrategy implements MenuStrategy {
	Relatorio relatorio = new Relatorio();
	@Override
	public void execute(ArrayList<Veiculo> veiculos) {
		   relatorio.printarRelatorio();		
	}

}
