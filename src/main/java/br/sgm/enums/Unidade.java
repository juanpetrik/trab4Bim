package br.sgm.enums;

public enum Unidade {
	PC("PC"),
	UN("UN"),
	CX("CX");
	
	private String nome;
	
	private Unidade(String nome) {
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
}
