package br.sgm.enums;

public enum UF {
    AC("AC"),
    AL("AL"),
    AM("AM"),
    AP("AP"),
    BA("BA"),
    CE("CE"),
    DF("DF"),
    ES("ES"),
    GO("GO"),
    MA("MA"),
    MG("MG"),
    MT("MT"),
    MS("MS"),
    PA("PA"),
    PB("PB"),
    PE("PE"),
    PI("PI"),
    PR("PR"),
    RJ("RJ"),
    RN("RN"),
    RO("RO"),
    RR("RR"),
    RS("RS"),
    SC("SC"),
    SE("SE"),
    SP("SP"),
    TO("TO");
    
    private String nome;

    private UF(String nome) {
      this.nome = nome;
    }
    
    public String getNome() {
       return nome;
    }
}
