# trab4Bim

- Para configurar o sistema, é só pegar o script "SCRIPT.sql" que está no resources, e rodá-lo no seu banco de dados.
- Em seguida deverá configurar a conexão com o banco de dados, que se encontra na classe "ConexaoMySQL", configurando
  senha, usuário e tudo mais.
- Foi utilizado o padrão singleton na conexão do banco de dados, pois este padrão impede que sejam criadas várias instâncias,
  e como temos somente um banco de dados para ser acessado, não tem necessidade de deixar com que seja instanciado várias conexões.