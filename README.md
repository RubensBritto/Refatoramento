# Sistema de Estacionamento Refatorado
<p>Projeto para a disciplina Projeto de Software, sobre orientação do professor Baldoino Fonseca, como requisito parcial à obtenção de nota. Este projeto consiste em alterar os pontos de código que possuem "Code Smells" e aplicar "Design Patterns". <p/>

## Design Patterns

### 1. Strategy
<p>Utilizado na classe Menu e na interface MenuStrategy.Criando o polimofismo do metodo Execute() e a Classe Enum TypeMenu (funciona como uma list) onde cada posição é uma classe que cria um comando diferente. <p/>

### 2. Chain Constructors
<p>Utilizado em conjunto com o Strategy, na Classe Enum TypeMenu para realizar a retirada dos IF's na classe Menu.<p/>

### 3. Singleton
<p>Utilizado na classe DataSingleton para criar apenas uma instância.
  
### 4. Extrac Class 
<p>Utilizado na classe Veiculo para extrair os atributos e metodos comuns das suas subclasses (carro, moto, caminhao).<p/>

### 5. Replace Array With Object
<p>Utilizado na Criação do ArrayList<Veiculo> e do ArrayList<Double>.<p/>
  
### INSTRUÇÕES DE USO
Caso o estacionamento não cobre horas extras, o sistema assume automaticamente que a opção **[4] do menu** é zero<br/>
O relatório **(opção [7] do menu)** só é atualizado quando realizam a remoção de veiculos **(opção [3] do menu)**

### Desenvolvido no Eclipse (2019-12)
### Compilado no Java JDK 11



  
