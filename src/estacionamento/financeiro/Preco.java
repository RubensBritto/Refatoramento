package estacionamento.financeiro;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import estacionamento.strategy.DateSingleton;

public class Preco {
	Scanner input = new Scanner(System.in);
	DateSingleton data = DateSingleton.getInstance();

    private int horaAdicional;
    private double priceHoraAdicional;
    
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
        inicio = data.getHoraFormatada(entrou, "mm");
        fim = data.getHoraFormatada(saiu, "mm");
        inicio += 60 * data.getHoraFormatada(entrou, "HH");
        fim += 60 * data.getHoraFormatada(saiu, "HH");
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

//    private static int getHoraFormatada(Date h, String formato) {
//        String fh = new SimpleDateFormat(formato).format(h);
//        return Integer.parseInt(fh);
//    }

}
