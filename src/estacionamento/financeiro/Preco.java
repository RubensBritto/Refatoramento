package estacionamento.financeiro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Preco {
	Scanner input = new Scanner(System.in);
    private double precoCarro;
    private double precoMoto;
    private double precoCaminhao;
    private int horaAdicional;
    private double priceHoraAdicional;
    
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
    public double getPriceHoraAdicional() {
        return priceHoraAdicional;
    }

    public void setPriceHoraAdicional(double priceHoraAdicional) {
        this.priceHoraAdicional = priceHoraAdicional;
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

}
