package estacionamento.strategy;
import estacionamento.strategy.CriarStrategy;

public enum TypeMenu {
	CRIAR {
		@Override
		public MenuStrategy obterMenu() {
			return new CriarStrategy();
		}
	},
	ALTERAR {
		@Override
		public MenuStrategy obterMenu() {
			return new AlterarStrategy();
		}
	}, 
	REMOVER {
		@Override
		public MenuStrategy obterMenu() {
			return new RemoverStrategy();
		}
	},
	ADDPRICE {
		@Override
		public MenuStrategy obterMenu() {
			return new AddPriceStrategy();
		}
	},
	ALTERPRICE {
		@Override
		public MenuStrategy obterMenu() {
			return new AlterarPrecoStrategy();
		}
	},
	ADDHOUREXTRA {
		@Override
		public MenuStrategy obterMenu() {
			return new AddHourExtraStrategy();
		}
	},
	ALTERHOUREXTRA {
		@Override
		public MenuStrategy obterMenu() {
			return new AlterHourExtraStrategy();
		}
	},
	PRINTESTADOATUAL {
		@Override
		public MenuStrategy obterMenu() {
			return new EstadoAtualStrategy();
		}
	},
	RELATORIO {
		@Override
		public MenuStrategy obterMenu() {
			return new PrintRelatorioStrategy();
		}
	},
	SAIR{
		@Override
		public MenuStrategy obterMenu() {
			return new Exit();
		}
	};
	
 public abstract MenuStrategy obterMenu();
}
