package estacionamento.strategy;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    Veiculo veiculos = new Veiculo();


	@Override
	public void execute(ArrayList<Veiculo> veiculos) {
		 try{
	            int retorno = busca.getIdVeiculos(veiculos);
	            int id = retorno;
	            System.out.println(retorno);
	            if(retorno != -1){
	                while(true){
	                    System.out.println("Digite o número da operação\n"+
	                                    "[1] Alterar modelo\n"+
	                                    "[2] Alterar marca\n"+
	                                    "[3] Alterar placa\n"+
	                                    "[4] Alterar o tipo\n"+
	                                    "[5] Alterar cor\n"+
	                                    "[6] Encerrar operação\n");
	                    String indice = input.nextLine();
	                    if(indice.equals("1")){
	                        System.out.println("------------Insira o novo modelo------------------");
	                        veiculos.get(id).setModelo(input.nextLine());
	                    }
	                    else if(indice.equals("2")){
	                        System.out.println("---------------Insira a nova marca-----------------");
	                        veiculos.get(id).setMarca(input.nextLine());
	                    }
	                    else if(indice.equals("3")){
	                        System.out.println("------------------Insira a nova placa----------------");
	                        System.out.println(">>>>>>>>> No formato (AAA-9999)<<<<<<<<<<<<<<<<");
	                        String placa = input.nextLine();
	                        boolean retorno2 = false;
	                        while (retorno2 != true) {
		                        retorno2 = validador.validador(placa);
		                        if(retorno2 == true){
		                            System.out.println("-----------------------Placa aceita--------------------");
		                            veiculos.get(id).setPlaca(placa);
		                        }
		                        else{
		                            System.out.println("----------------Placa invalida, comece o cadastro novamente----------------");
		                        }
	                        }
	                    }
	                    else if(indice.equals("4")){
	                        System.out.println("------------------Insira o novo Tipo---------------");
	                        if("Carro".equalsIgnoreCase(veiculos.get(id).getTipo())){
	                            String tipo = input.nextLine();
	                            System.out.println("---------Digite o tipo do carro------------");
	                            String tipoCarro = input.nextLine();
	                            Carro aux = new Carro(veiculos.get(id).getId(), veiculos.get(id).getModelo(), veiculos.get(id).getMarca(), veiculos.get(id).getPlaca(), tipo, veiculos.get(id).getCor(), veiculos.get(id).getPreco(), veiculos.get(id).getDataVeiculo(), tipoCarro);
	                            veiculos.set(id, aux);
	                        }
	                        else if("Caminhao".equalsIgnoreCase(veiculos.get(id).getTipo())){
	                            String tipo = input.nextLine();
	                            System.out.println("---------Digite o tipo a Carga que o Caminhão suportar------------");
	                            Double carga = input.nextDouble();
	                            Caminhao aux = new Caminhao(veiculos.get(id).getId(), veiculos.get(id).getModelo(), veiculos.get(id).getMarca(), veiculos.get(id).getPlaca(), tipo, veiculos.get(id).getCor(), veiculos.get(id).getPreco(), veiculos.get(id).getDataVeiculo(), carga);
	                            veiculos.set(id, aux);
	                        }
	                        else if("Moto".equalsIgnoreCase(veiculos.get(id).getTipo())){
	                            String tipo = input.nextLine();
	                            Double cilindrada = input.nextDouble();
	                            System.out.println("---------Digite a cilindrada da moto------------");
	                            Moto aux = new Moto(veiculos.get(id).getId(), veiculos.get(id).getModelo(), veiculos.get(id).getMarca(), veiculos.get(id).getPlaca(), tipo, veiculos.get(id).getCor(), veiculos.get(id).getPreco(), veiculos.get(id).getDataVeiculo(), cilindrada);
	                            veiculos.set(id, aux);
	                        }
	                    }
	                    else if(indice.equals("5")){
	                        System.out.println("------------------Insira a nova Cor---------------");
	                        veiculos.get(id).setCor(input.nextLine());
	                    }
	                    else if(indice.equals("6")){
	                        return;
	                    }
	                }
	        
	            }else{
	                System.out.println("-----------ID não existe-----------------------");
	                menu.start();
	            }
	            return;
	            
	        }catch(InputMismatchException e){
	            System.out.println("Tipo invalido");
	        }
		
	}

}
