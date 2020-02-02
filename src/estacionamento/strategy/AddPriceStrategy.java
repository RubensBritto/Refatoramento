package estacionamento.strategy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import estacionamento.financeiro.Preco;
import estacionamento.veiculos.Veiculo;

public class AddPriceStrategy implements MenuStrategy {
	Scanner input = new Scanner(System.in);
	Preco preco = new Preco();

	@Override
	public void execute(ArrayList<Veiculo> veiculos) {
        try{
            System.out.println("-----------------Digite o valor do preço dos Carros--------------");
            preco.setPrecoCarro(input.nextDouble());
            System.out.println("---------------------Digite o valor do preço das motos----------------");
            preco.setPrecoMoto(input.nextDouble());
            System.out.println("--------------------Digite o valor do preço dos Caminhoes--------------");
            preco.setPrecoCaminhao(input.nextDouble());
        }catch (InputMismatchException e) {
            System.out.println("O campo espera um número");
            System.exit(0);
        }
	}
	

}
