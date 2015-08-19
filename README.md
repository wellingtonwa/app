## CASE
* Lista de compras com suporte a multi-usuários;

## FEATURES
* Crie listas de compras personalizadas como "Supermercado", "Farmácia", "Padaria", etc...;
* "Risque" os produtos que você já encontrou;
* Informe os valores dos produtos para ter uma noção do valor total da compra;

## ARQUITETURA
* FrontEnd desenvolvido com Angular, consumindo serviços REST através de autenticação via Toke (JWT);
* Backend desenvolvido em Java, hospedado em plataforma Java EE7 (WildFLY 8.2.0 Final), utilizados Framework Web MVC VRaptor;
* Banco de Dados MySQL5;
* Infraestrutura de Entrega Contínua, disparando build e testes pelo Jenkins a partir dos "push"'s realizados no GitHub, e posteriormente realizado deploy no Wildfly;

# MODELO DE DADOS
* A modelagem de dados e os scripts **DDL** e **DML** estão disponíveis na pasta **database**;
* Utilizado o MySQL Workbench para modelagem;

# KEYWORDS
AngularJS, VRaptor, Hibernate, REST, CDI, JSON Web Token (JWT), MySQL5.x, JDK 1.8, WildFLY 8.2, AWS Amazon, EC2, RDS, Jenkis, Integração Contínua, Entrega Contínua, Testes Unitários, Java, Java EE7, Java Script, JUnit, Maven, SQL, HQL