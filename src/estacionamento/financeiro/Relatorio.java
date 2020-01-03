package estacionamento.financeiro;

import java.util.ArrayList;

public class Relatorio {
	  ArrayList<Double> valores = new ArrayList<>();

	    public void addRelatorio(double valor){
	        valores.add(valor);
	    }
	    public void printarRelatorio(){
	        double valor = 0;
	        for(int i = 0; i < valores.size(); i++){
	            valor+= valores.get(i);
	        }
	        System.out.printf("Total de veiculos que entraram no estacionamento: %d\n", valores.size());
	        System.out.printf("Total em dinheiro: %2f\n", valor);

	    }
}
