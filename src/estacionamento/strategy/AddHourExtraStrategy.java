package estacionamento.strategy;

import java.util.ArrayList;
import java.util.Scanner;

import estacionamento.financeiro.Preco;
import estacionamento.veiculos.Veiculo;
import estacionamento.exceptions.Exceptions;

public class AddHourExtraStrategy implements MenuStrategy {
	Scanner input = new Scanner(System.in);
	Preco preco = new Preco();
	Exceptions exceptions = new Exceptions();
	@Override
	public void execute(ArrayList<Veiculo> veiculos,ArrayList<Double>valor) {
        System.out.println("---------------Digite a permanencia máx no estacionamento"+ 
                "antes de ser cobrado o valor por horas adicionais (EM MINUTOS)------------------");
        preco.setHoraAdicional(exceptions.integerInput());
        System.out.println("---------Digite o valor do preço das horas adicionais-------" + "EX: 1,00");
        preco.setPriceHoraAdicional(exceptions.doubleInput());
		}
	
	}
