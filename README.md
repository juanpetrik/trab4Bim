# trab4Bim

- Para configurar o sistema, � s� pegar o script "SCRIPT.sql" que est� no resources, e rod�-lo no seu banco de dados.
- Em seguida dever� configurar a conex�o com o banco de dados, que se encontra na classe "ConexaoMySQL", configurando
  senha, usu�rio e tudo mais.
- Foi utilizado o padr�o singleton na conex�o do banco de dados, pois este padr�o impede que sejam criadas v�rias inst�ncias,
  e como temos somente um banco de dados para ser acessado, n�o tem necessidade de deixar com que seja instanciado v�rias conex�es.