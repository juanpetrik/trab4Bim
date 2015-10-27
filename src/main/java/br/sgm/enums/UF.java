package br.sgm.enums;

public enum UF {
    AC("Acre"),
    AL("Alagoas"),
    AM("Amazonas"),
    AP("Amapa"),
    BA("Bahia"),
    CE("Ceara"),
    DF("Distrito Federal"),
    ES("Espirito Santo"),
    GO("Goias"),
    MA("Maranhao"),
    MG("Minas Gerais"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    PA("Para"),
    PB("Paraiba"),
    PE("Pernambuco"),
    PI("Piaui"),
    PR("Parana"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RO("Rondonia"),
    RR("Roraima"),
    RS("Rio Grande do Sul"),
    SC("Santa Catarina"),
    SE("Sergipe"),
    SP("Sao Paulo"),
    TO("Tocantins");
    
    private String nome;

    private UF(String nome) {
      this.nome = nome;
    }
    
    public String getNome() {
       return nome;
    }
}
