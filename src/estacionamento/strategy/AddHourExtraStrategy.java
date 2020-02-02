package estacionamento.strategy;

import java.util.ArrayList;
import java.util.Scanner;

import estacionamento.financeiro.Preco;
import estacionamento.veiculos.Veiculo;

public class AddHourExtraStrategy implements MenuStrategy {
	Scanner input = new Scanner(System.in);
	Preco preco = new Preco();
	@Override
	public void execute(ArrayList<Veiculo> veiculos) {
        System.out.println("---------------Digite a permanencia máx no estacionamento"+ 
                "antes de ser cobrado o valor por horas adicionais------------------");
        preco.setHoraAdicional(input.nextInt());
        System.out.println("Digite o valor do preço das horas adicionais");
        preco.setPriceHoraAdicional(input.nextDouble());
		}
	
	}
