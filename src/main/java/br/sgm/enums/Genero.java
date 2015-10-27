package br.sgm.enums;

public enum Genero {
	M("Masculino"),
	F("Feminino");
	
    private String nome;

    private Genero(String nome) {
      this.nome = nome;
    }
    
    public String getNome() {
       return nome;
    }
}
