package estacionamento.main;

import java.util.Scanner;

import estacionamento.administrador.Adm;
import estacionamento.financeiro.Preco;
import estacionamento.financeiro.Relatorio;

public class Menu {
	  public Scanner input = new Scanner(System.in);
	    Adm adm = new Adm();
	    Preco price = new Preco();
	    Relatorio relatorio = new Relatorio();

	    public void start(){
	        try{
	            System.out.println("----------------------Digite o que deseja fazer-------------\n"+
	            "[1] Adiconar Veiculo ao Estacionamento\n"+
	            "[2] Alterar Dados do Veiculo\n"+
	            "[3] Remover Veiculo do Estacionamento\n"+
	            "[4] Adicionar os Valores dos Veiculos\n"+
	            "[5] Altera os valores dos Veiculos\n"+
	            "[6] Adicionar o Valor das horas extras e tempo máx de permanencia\n"+
	            "[7] Alterar horas extras e/ou tempo de permanencia\n"+
	            "[8] Mostrar estado atual\n"+
	            "[9] Relatorio Financeiro\n");
	            int escolha = input.nextInt();
	            if(escolha == 1){
	                System.out.println("------------------Cadastro de veiculos------------");
	                adm.criarVeiculo();
	                start();
	            }
	            else if(escolha == 2){
	                System.out.println("------------------Alteração de veiculos------------");
	                adm.alterarVeiculo();
	                start();
	            }
	            else if(escolha == 3){
	                System.out.println("------------------Remoção de veiculos-----------------");
	                adm.removerVeiculo();
	                start();
	            }
	            else if(escolha == 4){
	                System.out.println("------------------Criação dos preços do estacionamento------------");
	                price.addPreco();
	                start(); 
	            }
	            else if(escolha == 5){
	                System.out.println("------------------Alteração dos preços do estacionamento------------");
	                price.alterarPreco();
	                start(); 
	            }
	            else if(escolha == 6){
	                System.out.println("------------------Adicionar o valor da hora extra do estacionamento e o"+
	                                    "tempo max dentro do estacionamento antes da hora extra------------------------");
	                price.addHorarioExtra();
	                start();
	            }
	            else if(escolha == 7){
	                System.out.println("------------------Alterar horas extras e/ou tempo de permanencia------------");
	                price.alterarHorarioExtra();
	                start();
	            }
	            else if(escolha == 8){
	                System.out.println("------------------Mostrar estado atual--------------");
	                adm.estadoAtual(adm.veiculos);
	                start();
	               
	            }
	            else if(escolha == 9){
	                System.out.println("-----------------Relatorio Financeiro-----------------------");
	                adm.printarRelatorio();
	                start();
	            }
	            else{
	                System.out.println("Digite uma opção valida");
	                start();
	            }
	        }catch(NumberFormatException e){
	            System.out.println("O sistema espera um numero");
	            start();
	            return;
	        }

	    }

}
