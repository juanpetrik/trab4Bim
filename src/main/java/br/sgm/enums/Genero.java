package br.sgm.enums;

public enum Genero {
	M("M"),
	F("F");
	
    private String nome;

    private Genero(String nome) {
      this.nome = nome;
    }
    
    public String getNome() {
       return nome;
    }
}
