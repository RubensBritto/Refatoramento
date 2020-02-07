package estacionamento.strategy;

import java.util.ArrayList;
import java.util.Scanner;

import estacionamento.exceptions.Exceptions;
import estacionamento.financeiro.Preco;
import estacionamento.veiculos.Veiculo;

public class AlterHourExtraStrategy implements MenuStrategy {
	Scanner input = new Scanner(System.in);
	Preco preco = new Preco();
	Exceptions exceptions = new Exceptions();

	@Override
	public void execute(ArrayList<Veiculo> veiculos, ArrayList<Double> valor) {
		System.out.println("Digite a opção desejada\n" + 
							"[1]- Para altera o tempo máx de permancencia\n" + 
							"[2]- Para altera o valor das horas adicionas\n");
		try {
			int escolha = exceptions.integerInput();
			if (escolha == 1) {
				System.out.println("-----Digie as novas horas adicionais(EM MINUTOS)----" + "EX: 120");
				preco.setHoraAdicional(exceptions.integerInput());
				System.out.println("Alteração feita com sucesso");
			} else if (escolha == 2) {
				System.out.println("------Digie o novo valor para as horas adicionais------" + "EX: 4,00");
				preco.setPriceHoraAdicional(exceptions.doubleInput());
				System.out.println("Alteração feita com sucesso");
			} else {
				System.out.println("Opção invalida");
				execute(veiculos, valor);
			}
		} catch (NumberFormatException e) {
			System.out.println("O campo espera um número");
		}
	}

}
