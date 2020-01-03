package estacionamento.administrador;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.management.InvalidAttributeValueException;

import estacionamento.financeiro.Preco;
import estacionamento.financeiro.Relatorio;
import estacionamento.util.Busca;
import estacionamento.util.Validador;
import estacionamento.veiculos.Caminhao;
import estacionamento.veiculos.Carro;
import estacionamento.veiculos.Moto;
import estacionamento.veiculos.Veiculo;

public class Adm {
    public ArrayList<Veiculo> veiculos = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    Validador validador = new Validador();
    Preco price = new Preco();
    Busca busca = new Busca();
    Relatorio relatorio;


    private int qtdCarro;
    private int qtdCaminhao;
    private int qtdMoto;
    public int qtdTotal;
    private static final int maxQt = 1000;
    private boolean [] postionID = new boolean [maxQt];

    private void PreencherPosition(){
        for(int i = 0; i < this.postionID.length; i++)
        this.postionID[i] = false;
    }
     
    public Adm(){
        PreencherPosition();
        relatorio = new Relatorio();
    }
    
    public void criarVeiculo(){        
        try{
            int id = getFreeId();
            if (id <= -1){
                throw new InvalidAttributeValueException();
            }
            postionID[id] = true;
            System.out.printf("O ID do veiculo é: %d\n",id);
            System.out.println("---------Digite o Modelo do veiculo------------");
            String modelo = input.nextLine();
            System.out.println("---------Digite a Marca do veiculo------------");
            String marca = input.nextLine();
            System.out.println("---------Digite a Placa do veiculo------------");
            System.out.println(">>>>>>>>> No formato (AAA-9999)<<<<<<<<<<<<<<<<");
            String placa = input.nextLine();
            boolean retorno = validador.validador(placa);
            if(retorno == true){
                System.out.println("-----------------------Placa aceita--------------------");
            }
            else{
                System.out.println("----------------Placa invalida, comece o cadastro novamente----------------");
                criarVeiculo();
            }
            System.out.println("---------Digite a Cor do veiculo------------");
            String cor = input.nextLine();
            System.out.println("---------Digite o tipo do veiculo------------");
            String tipo = input.nextLine();
            Date data = new Date();

            if("Carro".equalsIgnoreCase(tipo)){
                Double preco = price.getPrecoCarro();
                String tipoCarro;
                System.out.println("---------Digite o tipo do carro------------");
                tipoCarro = input.nextLine();

                veiculos.add(new Carro(id, modelo, marca, placa, tipo, cor, preco, data,tipoCarro));
                qtdCarro +=1;
            }
            else if("Caminhao".equalsIgnoreCase(tipo)){
                Double preco = price.getPrecoCaminhao();
                System.out.println("---------Digite o tipo a Carga que o Caminhão suportar------------");
                Double carga = input.nextDouble();
                veiculos.add(new Caminhao(id, modelo, marca, placa, tipo, cor, preco,data,carga));
                qtdCaminhao +=1;
            }
            else if("Moto".equalsIgnoreCase(tipo)){
                Double preco = price.getPrecoMoto();
                System.out.println("---------Digite a cilindrada da moto------------");
                Double cilindrada = input.nextDouble();
                veiculos.add(new Moto(id, modelo, marca, placa, tipo, cor, preco, data,cilindrada));
                qtdMoto +=1;
            }
            else{
                System.out.println("--------Veiculo invalido---------------");
                criarVeiculo();
            }
            qtdTotal = qtdCaminhao+qtdCarro+qtdMoto;
            System.out.println("-----------Cadastro feito com sucesso-------------------");
            
            
        }catch(InvalidAttributeValueException e) {
            System.out.println("Estacionamento cheio.");
            criarVeiculo();
            System.exit(0);
        }catch(InputMismatchException e){
            System.out.println("Digite um tipo valido");
            criarVeiculo();
            System.exit(0);
        }
        return;
    }

    private int getFreeId() {
        for(int i= 1; i < postionID.length; i++){
            if (this.postionID[i] != true)
                return i;
        }
        return -1;
    }
    public void removerVeiculo(){
        int retorno = busca.getIdVeiculos(veiculos);
        int id = retorno;
        double valPHora;
        Preco p = new Preco();
        if(retorno != -1){
            if("Carro".equalsIgnoreCase(veiculos.get(id).getTipo())){
                qtdCarro-=1;
                valPHora = p.getPrecoCarro();
            }else if("Caminhao".equalsIgnoreCase((veiculos.get(id).getTipo()))) {
                qtdCaminhao-=1;
                valPHora = p.getPrecoCaminhao();
            }else{
                qtdMoto-=1;        
                valPHora = p.getPrecoMoto();
            }
            double valorAPagar = p.calcularPagamento(veiculos.get(id).data, new Date(), valPHora);
            System.out.printf("Total a pagar: %2f\n", valorAPagar);
            relatorio.addRelatorio(valorAPagar);
            veiculos.remove(id);
            System.out.println("---------Veiculo removido com sucesso----------------");
        }else{
            System.out.println("-----------ID não cadastrado-----------------");
        }
        return;
     
    }
    public void alterarVeiculo(){
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
                        boolean retorno2 = validador.validador(placa);
                        if(retorno2 == true){
                            System.out.println("-----------------------Placa aceita--------------------");
                            veiculos.get(id).setPlaca(placa);
                        }
                        else{
                            System.out.println("----------------Placa invalida, comece o cadastro novamente----------------");
                            alterarVeiculo();
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
            }
            return;
            
        }catch(InputMismatchException e){
            System.out.println("Tipo invalido");
        }
    }

    public void estadoAtual(ArrayList<Veiculo> veiculos){
       for (Veiculo v : veiculos) {
           System.out.println(v);           
       }            
    }

    public void printarRelatorio() {
        relatorio.printarRelatorio();
    }
}
