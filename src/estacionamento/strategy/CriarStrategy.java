package estacionamento.strategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

import estacionamento.financeiro.Preco;
import estacionamento.main.Menu;
import estacionamento.util.Validador;
import estacionamento.veiculos.Caminhao;
import estacionamento.veiculos.Carro;
import estacionamento.veiculos.Moto;
import estacionamento.veiculos.Veiculo;

public class CriarStrategy implements MenuStrategy {
	Scanner input = new Scanner(System.in);
	Validador validador = new Validador();
	Preco price = new Preco();
	Menu menu = new Menu();
	
	private int qtdCarro;
	private int qtdCaminhao;
	private int qtdMoto;
	public int qtdTotal;
	private static final int maxQt = 1000;
	private boolean[] postionID = new boolean[maxQt];

	public CriarStrategy(){
		PreencherPosition();
	}

	private void PreencherPosition() {
		for (int i = 0; i < this.postionID.length; i++)
			this.postionID[i] = false;
	}

	private int getFreeId() {
		for (int i = 1; i < postionID.length; i++) {
			if (this.postionID[i] != true)
				return i;
		}
		return -1;
	}
	@Override
	public void execute(ArrayList<Veiculo> veiculos){
		try {
			int id = getFreeId();
			if (id <= -1) {
				throw new InvalidAttributeValueException();
			}
			postionID[id] = true;
			System.out.printf("O ID do veiculo é: %d\n", id);
			System.out.println("---------Digite o Modelo do veiculo------------");
			String modelo = input.nextLine();
			System.out.println("---------Digite a Marca do veiculo------------");
			String marca = input.nextLine();
			System.out.println(">>>>>>>>> No formato (AAA-9999)<<<<<<<<<<<<<<<<");
			System.out.println("---------Digite a Placa do veiculo------------");
			String placa = input.nextLine();
			boolean retorno = validador.validador(placa);
			if (retorno == true) {
				System.out.println("-----------------------Placa aceita--------------------");
			} else {
				System.out.println("----------------Placa invalida, comece o cadastro novamente----------------");
				postionID[id] = false;
				execute(veiculos);
			}
			System.out.println("---------Digite a Cor do veiculo------------");
			String cor = input.nextLine();
			System.out.println("---------Digite o tipo do veiculo------------");
			String tipo = input.nextLine();
			Date data = new Date();

			if ("Carro".equalsIgnoreCase(tipo)) {
				Double preco = price.getPrecoCarro();
				String tipoCarro;
				System.out.println("---------Digite o tipo do carro------------");
				tipoCarro = input.nextLine();

				veiculos.add(new Carro(id, modelo, marca, placa, tipo, cor, preco, data, tipoCarro));
				qtdCarro += 1;
			} else if ("Caminhao".equalsIgnoreCase(tipo)) {
				Double preco = price.getPrecoCaminhao();
				System.out.println("---------Digite o tipo a Carga que o Caminhão suportar------------");
				Double carga = input.nextDouble();
				veiculos.add(new Caminhao(id, modelo, marca, placa, tipo, cor, preco, data, carga));
				qtdCaminhao += 1;
			} else if ("Moto".equalsIgnoreCase(tipo)) {
				Double preco = price.getPrecoMoto();
				System.out.println("---------Digite a cilindrada da moto------------");
				Double cilindrada = input.nextDouble();
				veiculos.add(new Moto(id, modelo, marca, placa, tipo, cor, preco, data, cilindrada));
				qtdMoto += 1;
			} else {
				System.out.println("--------Veiculo invalido---------------");
				postionID[id] = false;
				execute(veiculos);
			}
			qtdTotal = qtdCaminhao + qtdCarro + qtdMoto;
			System.out.println("-----------Cadastro feito com sucesso-------------------");

		} catch (InvalidAttributeValueException e) {
			System.out.println("Estacionamento cheio.");
			execute(veiculos);
			System.exit(0);
		} catch (InputMismatchException e) {
			System.out.println("Digite um tipo valido");
			execute(veiculos);
			System.exit(0);
		}
		return;
	}
}
