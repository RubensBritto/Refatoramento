package estacionamento.strategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import estacionamento.exceptions.Exceptions;
import estacionamento.main.Menu;
import estacionamento.util.BuscaId;
import estacionamento.util.Validador;
import estacionamento.veiculos.Caminhao;
import estacionamento.veiculos.Carro;
import estacionamento.veiculos.Moto;
import estacionamento.veiculos.Veiculo;

public class CriarStrategy implements MenuStrategy {
	Scanner input = new Scanner(System.in);
	Validador validador = new Validador();
	Menu menu = new Menu();
	BuscaId busca = new BuscaId();
	Exceptions exceptions = new Exceptions();
	
	@Override
	public void execute(ArrayList<Veiculo> veiculos, ArrayList<Double>valor){
		try {
			System.out.printf("Digite o ID\n");
			int id = exceptions.integerInput();
			int retorno = busca.getIdVeiculos(veiculos, id);
			while(retorno != 1) {
				System.out.printf("Digite o ID\n");
				id = exceptions.integerInput();
				retorno = busca.getIdVeiculos(veiculos, id);
			}
			System.out.println("---------Digite o Modelo do veiculo------------" + "EX: CELTA");
			String modelo = input.nextLine();
			System.out.println("---------Digite a Marca do veiculo------------" + "EX: CHEVROLET");
			String marca = input.nextLine();
			System.out.println(">>>>>>>>> No formato (AAA-9999)<<<<<<<<<<<<<<<<");
			System.out.println("---------Digite a Placa do veiculo------------");
			String placa = input.nextLine();
			boolean retorno1 = validador.validador(placa);
			while(retorno1 != true)
			{
				System.out.println("---------Digite a Placa do veiculo------------");
				placa = input.nextLine();
				retorno1 = validador.validador(placa);
			}
			System.out.println("---------Digite a Cor do veiculo------------" + "EX: PRETO");
			String cor = input.nextLine();
			Date data = new Date();
			System.out.println("---------Escolha o Tipo de veiculo------------\n"+
								"[1] Carro\n" +
								"[2] Moto\n" +
								"[3] Caminhao");
			int tipo = exceptions.integerInput();
			while(tipo < 1 || tipo > 3) {
				System.out.println("---------Escolha o Tipo de veiculo------------\n"+
						"[1] Carro\n" +
						"[2] Moto\n" +
						"[3] Caminhao");
				tipo = exceptions.integerInput();
			}
			if (tipo == 1) {
				System.out.println("---------Digite o preco do carro--------" + "EX: 2,00");
				double preco = exceptions.doubleInput();
				String tipoCarro;
				System.out.println("---------Digite o tipo do Carro------------" + "EX: PASSEIO");
				tipoCarro = input.nextLine();
				veiculos.add(new Carro(id, modelo, marca, placa, "CARRO", cor, preco, data, tipoCarro));
			} else if (tipo == 2) {
				System.out.println("--------------Digite o preco da moto-------------" + "EX: 3,00");
				double preco = exceptions.doubleInput();
				System.out.println("---------Digite a cilindrada da Moto------------" + "EX: 300");
				double cilindrada = exceptions.doubleInput();
				veiculos.add(new Moto(id, modelo, marca, placa, "MOTO", cor, preco, data, cilindrada));
			}else if (tipo == 3){
				System.out.println("--------------Digite o preco do Caminhao------------" + "EX: 5,00");
				double preco = exceptions.doubleInput();
				System.out.println("---------Digite o tipo a Carga que o Caminhão suportar------------" + "EX: 1000");
				double carga = exceptions.doubleInput();
				veiculos.add(new Caminhao(id, modelo, marca, placa, "CAMINHAO", cor, preco, data, carga));
			}
			System.out.println("-----------Cadastro feito com sucesso-------------------");

		}catch (InputMismatchException e) {
			System.out.println("Digite um tipo valido");
			execute(veiculos,valor);
			System.exit(0);
		}
		return;
	}
}
