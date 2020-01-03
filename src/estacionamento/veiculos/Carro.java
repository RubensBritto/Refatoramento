package estacionamento.veiculos;

import java.util.Date;

public class Carro extends Veiculo {
	private String tipoCarro;

	
	public Carro(int id, String modelo, String marca, String placa, String tipo, String cor, Double preco,
			Date dataVeiculo, String tipoCarro) {
		super(id, modelo, marca, placa, tipo, cor, preco, dataVeiculo);
		this.tipoCarro = tipoCarro;
	}
	public Carro(){
		
	}
	
	public String getTipoCarro() {
		return tipoCarro;
	}
	public void setTipoCarro(String tipoCarro) {
		this.tipoCarro = tipoCarro;
	}

	@Override
	public String toString() {
		return super.toString() +"[Tipo de carro]--" + getTipoCarro();
	}

}
