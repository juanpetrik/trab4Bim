package br.sgm.enums;

public enum Unidade {
	PC("Pe�a"),
	UN("Unidade"),
	CX("Caixa");
	
	private String nome;
	
	private Unidade(String nome) {
		this.nome = nome;
	}
	
	public String getNome(){
		return nome;
	}
}
