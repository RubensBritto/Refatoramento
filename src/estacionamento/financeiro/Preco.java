package estacionamento.financeiro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Preco {
	Scanner input = new Scanner(System.in);
    private double precoCarro;
    private double precoMoto;
    private double precoCaminhao;
    private int horaAdicional;
    private double priceHoraAdicional;

    public void addPreco(){
        try{
            System.out.println("-----------------Digite o valor do preço dos Carros--------------");
            setPrecoCarro(input.nextDouble());
            System.out.println("---------------------Digite o valor do preço das motos----------------");
            setPrecoMoto(input.nextDouble());
            System.out.println("--------------------Digite o valor do preço dos Caminhoes--------------");
            setPrecoCaminhao(input.nextDouble());
        }catch (InputMismatchException e) {
            System.out.println("O campo espera um número");
            System.exit(0);
        }
              
    }
    public void alterarPreco(){
        System.out.println("Digite a opção desejada\n"+
                "[1]- Para alterar o valor dos carros\n"+
                "[2]- Para altera o valor das motos\n"+
                "[3]- Para alterar o valor dos Caminhões\n"+
                "[4]- Para alterar o valor das horas adicionais");
        try {
            int escolha = input.nextInt();
            if(escolha == 1){
                setPrecoCarro(input.nextDouble()); 
            }
            else if (escolha == 2) {
                setPrecoMoto(input.nextDouble()); 
            } 
            else if (escolha == 3) {
                setPrecoMoto(input.nextDouble()); 
            }
            else if (escolha== 4) {
                setHoraAdicional(input.nextInt()); 
            }
            else{
                System.out.println("Opção invalida");
                alterarPreco();
            }        
        }catch (NumberFormatException e) {
            System.out.println("O campo espera um número");
        }       

    }
    public double getPrecoCarro() {
        return precoCarro;
    }

    public void setPrecoCarro(double precoCarro) {
        this.precoCarro = precoCarro;
    }

    public double getPrecoMoto() {
        return precoMoto;
    }

    public void setPrecoMoto(double precoMoto) {
        this.precoMoto = precoMoto;
    }

    public double getPrecoCaminhao() {
        return precoCaminhao;
    }

    public void setPrecoCaminhao(double precoCaminhao) {
        this.precoCaminhao = precoCaminhao;
    }


     public int getHoraAdicional() {
        return horaAdicional;
    }

    public void setHoraAdicional(int horaAdicional) {
        this.horaAdicional = horaAdicional;
    }

    public void addHorarioExtra(){
        System.out.println("---------------Digite a permanencia máx no estacionamento"+ 
                            "antes de ser cobrado o valor por horas adicionais------------------");
        setHoraAdicional(input.nextInt());
        System.out.println("Digite o valor do preço das horas adicionais");
        setPriceHoraAdicional(input.nextDouble());
    }

    public void alterarHorarioExtra(){
        System.out.println("Digite a opção desejada\n"+
        "[1]- Para alterar das horas extras\n"+
        "[2]- Para altera o tempo máx de permancencia\n");
        try {
            int escolha = input.nextInt();
            if(escolha == 1){
                setHoraAdicional(input.nextInt()); 
            }
            else if (escolha == 2) {
                setPriceHoraAdicional(input.nextDouble()); 
            } 
            else{
                System.out.println("Opção invalida");
                alterarHorarioExtra();
            }         
        }catch (NumberFormatException e) {
            System.out.println("O campo espera um número");
        }      
    }

    public double calcularPagamento(Date entrou, Date saiu, double valPHora) {
        int inicio, fim, tempoDecorrido;
        inicio = getHoraFormatada(entrou, "mm");
        fim = getHoraFormatada(saiu, "mm");
        inicio += 60 * getHoraFormatada(entrou, "HH");
        fim += 60 * getHoraFormatada(saiu, "HH");
        tempoDecorrido = fim - inicio;
        if (tempoDecorrido < 0) {
            tempoDecorrido = (tempoDecorrido - 24 * 60) * -1;
        }
        double asw = (tempoDecorrido/60) * valPHora;
        double hourextras = getHoraAdicional() * 60 ;
        
        
        if(tempoDecorrido < 60)
            return valPHora;
        else if(tempoDecorrido < hourextras)
            return asw;
        else {
            double adicional = tempoDecorrido - (getHoraAdicional() * getPriceHoraAdicional());
            adicional = (adicional >= getPriceHoraAdicional()) ? adicional : getPriceHoraAdicional();
            return asw + adicional;
        }
    }


    private static int getHoraFormatada(Date h, String formato) {
        String fh = new SimpleDateFormat(formato).format(h);
        return Integer.parseInt(fh);
    }

    public double getPriceHoraAdicional() {
        return priceHoraAdicional;
    }

    public void setPriceHoraAdicional(double priceHoraAdicional) {
        this.priceHoraAdicional = priceHoraAdicional;
    }

}
