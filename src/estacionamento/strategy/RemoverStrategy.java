package estacionamento.strategy;

import java.util.ArrayList;
import java.util.Date;

import estacionamento.financeiro.Preco;
import estacionamento.financeiro.Relatorio;
import estacionamento.util.Busca;
import estacionamento.veiculos.Veiculo;

public class RemoverStrategy implements MenuStrategy {
    Busca busca = new Busca();
    Relatorio relatorio = new Relatorio();

	@Override
	public void execute(ArrayList<Veiculo> veiculos,ArrayList<Double>valor) {
		int retorno = busca.getIdVeiculos(veiculos);
        int id = retorno;
        double valPHora;
        Preco p = new Preco();
        if(retorno != -1){
            valPHora = veiculos.get(id).getPreco();
            double valorAPagar = p.calcularPagamento(veiculos.get(id).data, new Date(), valPHora);
            System.out.printf("Total a pagar: %2f\n", valorAPagar);
            valor.add(valorAPagar);
            veiculos.remove(id);
            System.out.println("---------Veiculo removido com sucesso----------------");
        }else{
            System.out.println("-----------ID não cadastrado-----------------");
        }
        return;
     
    }
}

