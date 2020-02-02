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
	public void execute(ArrayList<Veiculo> veiculos) {
		int retorno = busca.getIdVeiculos(veiculos);
        int id = retorno;
        double valPHora;
        Preco p = new Preco();
        if(retorno != -1){
            if("Carro".equalsIgnoreCase(veiculos.get(id).getTipo())){
                //qtdCarro-=1;
                valPHora = p.getPrecoCarro();
            }else if("Caminhao".equalsIgnoreCase((veiculos.get(id).getTipo()))) {
                //qtdCaminhao-=1;
                valPHora = p.getPrecoCaminhao();
            }else{
                //qtdMoto-=1;        
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
}

