# Refatoramento
<p>Projeto destinado para obtenção de nota para a disciplina Projeto de Software, ministrada pelo professor Baldoino Fonseca<br/>O projeto tem como objeto solucionar "Code Smells" através da aplicação dos "Design Patterns"<p/>

## Design Patterns

### 1. Strategy
<p>Utilizado na classe Menu e a interface MenuStrategy.Criando o polimofismo do metodo Execute() e Criando sempre um novo objeto através da classe enum TypeMenu </p>

#### Classe Menu

![menu](https://user-images.githubusercontent.com/47110177/74048886-d16f6900-49b1-11ea-9a7b-ee40e07315c6.png)

#### Classe Enum TypeMenu

![Doc1_page-0001](https://user-images.githubusercontent.com/47110177/74050594-2791db80-49b5-11ea-8d45-44123aa90aa6.jpg)

### 2. Chain Constructors
<p>Utilizado para desenvolver o Strategy, na classe TypeMenu para realizar a retirada dos IF's na classe Menu</p>

### 3. Extrac Class 
  <p>Utilizado na classe Veiculo para extrair os atributos e metodos comuns das suas subclasses (carro, moto, caminhao)<\p>
  
### 4. Replace Array With Object
<p>Utilizado na Criação dos ArrayList<Veiculo> e ArraList<Double></p> 
