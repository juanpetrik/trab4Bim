package br.sgm.enums;

public enum Categoria {
	LIMPEZA("Limpeza"),
	FRUTAS("Frutas"),
	ALIMENTAÇÃO("Alimentação");
	
    private String nome;

    private Categoria(String nome) {
      this.nome = nome;
    }
    
    public String getNome() {
       return nome;
    }
}
