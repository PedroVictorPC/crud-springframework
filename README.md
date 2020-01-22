# crud-springframework

Aplicação CRUD usando jsf e spring boot

Projeto para criar uma aplicação CRUD que permite adicionar, remover ou atualizar Tasks. Nesse projeto foram usadas as seguintes ferramentas/bibliotecas:

 - Java 8
 - Ecplise JEE (IDE de desenvolvimento usada)
 - JSF 2 (item A do desafio)
 - PostgreSQL (item B do desafio)
 - Spring Boot 2 (item D)
 - Hibernate e JPA (item C)
 - Primefaces 6.2 (item F)
 - Apache Tomcat 9
 
O projeto foi gerado através do spring initializer pelo link https://start.spring.io/, e então importado no Eclipse como um projeto Maven. Foram então adicionados as dependencias para o tomcat, primefaces e jsf, além do arquivo de configuração para o jsf (faces-config.xml).

Para rodar o projeto, seguir os passos:

1) Baixar a pasta CRUD

2) Instalar JRE 1.8 caso não tenha (obs.: Essa é a versão do Java na qual o projeto foi implementado. Outras versões não foram testadas)

3) Instalar o Eclipse JEE

4) Após abrir o Eclipse, importar a pasta CRUD como um Projeto Maven (File > Import > Maven > Existing Maven Projects)

5) Instalar o Apache Tomcat 9. (obs.: preferencialmente, instalá-lo no diretório raiz C:/)

6) Adicionar o servidor Tomcat 9 no Eclipse. Para isso, clicar em File > New > Other > Server > Server e selecione Apache > Tomcat v9.0 Server. Após clicar em Next, em "Tomcat intallation directory", selecionar a pasta de instalação do tomcat 9 (Ex.: C:/apache-tomcat-9.0.16) e em JRE selecionar o jre 1.8 (no caso 1.8 pois é a versão instalada).

7) Adicionar o projeto no servidor. Ainda na janela do passo anterior, após o Next, selecionar o projeto CRUD e clicar em Add e depois em Finish. Caso já tenha adicionado o servidor sem adicionar o projeto, basta ir na aba Server do Eclipse, clicar com o botão direito no server do Tomcat 9 e clicar em "Add and Remove".

8) Instalar o PostgreSQL

9) Abrir o PostgreSQL e criar um novo database com o nome que desejar. Pode também usar um que já exista, porém a aplicação irá criar uma nova tabela chamada Tasks nesse banco.

10) Configurar o arquivo "application.properties" do projeto com as informações do banco. Por exemplo, no arquivo, onde tem:
      spring.datasource.url= jdbc:postgresql://localhost:5432/MyDatabase
      spring.datasource.username=postgres
      spring.datasource.password=123456
"localhost:5432" é o endereço e a porta para o servidor do Postgres, "MyDatabase" é o nome do database, "postgres" é o usário e "123456" é a senha de acesso ao banco.

11) Executar a projeto no servidor. No Eclipse, basta clicar com o botão direito no projeto e ir em Run as > Run on Server.

12) Por fim, abrir o navegador e ir em localhost:8080/CRUD/

Ao executar, abrirá uma página onde se poderá ver as tasks já existentes, adicionar novas, remover ou atualizar o estado de uma task.
