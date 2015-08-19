## CASE
* Lista de compras com suporte a multi-usuários;

## FEATURES
* Crie listas de compras personalizadas como "Supermercado", "Farmácia", "Padaria", etc;
* "Risque" os produtos que você já encontrou;
* Caso queira, informe os valores dos produtos para ter uma noção do valor total da compra;

## ARQUITETURA
* Frontend desenvolvido com **AngularJS**, consumindo serviços **REST** através de autenticação via Toke **JWT** (JSON Web Token);
* Backend desenvolvido em **Java**, rodando em plataforma **Java EE7** (WildFLY 8.2.0 Final).
* Banco de Dados **MySQL5.x**;
* Infraestrutura de **Entrega Contínua**, testando e construindo novas Builds **(Maven)** da aplicação a cada mudança enviada ao repositório **(GitHub)**. Na parte final do processo é realizado o deploy no **Wildfly**;

# MODELO DE DADOS
* A modelagem de dados e os scripts **DDL** e **DML** estão disponíveis na pasta **database**;
* Utilizado o **MySQL Workbench** para modelagem;

# KEYWORDS
AngularJS; VRaptor4; Hibernate; REST; CDI; JSON Web Token (JWT); MySQL5.x; JDK 1.8; WildFLY 8.2.0; AWS Amazon; EC2; RDS; Jenkis; Integração Contínua; Entrega Contínua; Testes Unitários; Java; Java EE7; Java Script; JUnit; Maven; SQL; HQL;