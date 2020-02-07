package estacionamento.strategy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import estacionamento.exceptions.Exceptions;
import estacionamento.main.Menu;
import estacionamento.util.Busca;
import estacionamento.util.Validador;
import estacionamento.veiculos.Caminhao;
import estacionamento.veiculos.Carro;
import estacionamento.veiculos.Moto;
import estacionamento.veiculos.Veiculo;

public class AlterarStrategy implements MenuStrategy {
	Busca busca = new Busca();
	Scanner input = new Scanner(System.in);
	Validador validador = new Validador();
	Menu menu = new Menu();

	@Override
	public void execute(ArrayList<Veiculo> veiculos, ArrayList<Double> valor) {
		Exceptions exceptions = new Exceptions();
		try {
			int retorno = busca.getIdVeiculos(veiculos);
			int id = retorno;
			if (retorno != -1) {
				while (true) {
					System.out.println("Digite o número da operação\n" + 
									"[1] Alterar modelo\n" + 
									"[2] Alterar marca\n" + 
									"[3] Alterar placa\n" + 
									"[4] Alterar o tipo\n" + 
									"[5] Alterar cor\n"	+ 
									"[6] Alterar preços\n" + 
									"[7] Encerrar operação\n");
					int indice = exceptions.integerInput();
					if (indice == 1) {
						System.out.println("------------Insira o novo modelo------------------" + "EX: ARGO");
						veiculos.get(id).setModelo(input.nextLine());
					} else if (indice == 2) {
						System.out.println("---------------Insira a nova marca-----------------" + "EX:FIAT");
						veiculos.get(id).setMarca(input.nextLine());
					} else if (indice == 3) {
						System.out.println(">>>>>>>>> No formato (AAA-9999)<<<<<<<<<<<<<<<<");
						System.out.println("---------Digite a Placa do veiculo------------");
						String placa = input.nextLine();
						boolean retorno2 = validador.validador(placa);
						while (retorno2 != true) {
							System.out.println("---------Digite a Placa do veiculo------------");
							placa = input.nextLine();
							retorno2 = validador.validador(placa);
						}
					} else if (indice == 4) {
						if ("Carro".equalsIgnoreCase(veiculos.get(id).getTipo())) {
							System.out.println("---------Digite o tipo do carro------------" + "EX: SUV");
							String tipoCarro = input.nextLine();
							Carro aux = new Carro(veiculos.get(id).getId(), veiculos.get(id).getModelo(),
									veiculos.get(id).getMarca(), veiculos.get(id).getPlaca(), "CARRO",
									veiculos.get(id).getCor(), veiculos.get(id).getPreco(),
									veiculos.get(id).getDataVeiculo(), tipoCarro);
							veiculos.set(id, aux);
						} else if ("Moto".equalsIgnoreCase(veiculos.get(id).getTipo())) {
							double cilindrada = exceptions.doubleInput();
							System.out.println("---------Digite a cilindrada da moto------------" + "EX: 500");
							Moto aux = new Moto(veiculos.get(id).getId(), veiculos.get(id).getModelo(),
									veiculos.get(id).getMarca(), veiculos.get(id).getPlaca(), "MOTO",
									veiculos.get(id).getCor(), veiculos.get(id).getPreco(),
									veiculos.get(id).getDataVeiculo(), cilindrada);
							veiculos.set(id, aux);
						} else if ("Caminhao".equalsIgnoreCase(veiculos.get(id).getTipo())) {
							System.out.println(
									"---------Digite o tipo a Carga que o Caminhão suportar------------ " + "EX: 5000");
							double carga = exceptions.doubleInput();
							Caminhao aux = new Caminhao(veiculos.get(id).getId(), veiculos.get(id).getModelo(),
									veiculos.get(id).getMarca(), veiculos.get(id).getPlaca(), "CAMINHAO",
									veiculos.get(id).getCor(), veiculos.get(id).getPreco(),
									veiculos.get(id).getDataVeiculo(), carga);
							veiculos.set(id, aux);
						}
					} else if (indice == 5) {
						System.out.println("------------------Insira a nova Cor---------------" + "EX: PRETO");
						veiculos.get(id).setCor(input.nextLine());
					} else if (indice == 6) {
						System.out.println("----------Digite o novo preço------" + "EX: 7,00");
						veiculos.get(id).setPreco(exceptions.doubleInput());
					} else if (indice == 7) {
						return;
					}
				}

			} else {
				System.out.println("--------------------ID não existe----------------------");
			}
		} catch (InputMismatchException e) {
			System.out.println("Tipo invalido");
		}

	}

}
