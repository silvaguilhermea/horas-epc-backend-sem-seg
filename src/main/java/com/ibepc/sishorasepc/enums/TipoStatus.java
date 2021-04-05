package com.ibepc.sishorasepc.enums;

public enum TipoStatus {
	
	PLANEJADO(1, "PLANEJADO"),
	EMANDAMENTO(2, "EM ANDAMENTO"),
	EMREVISAO(3, "EM REVISÃO"),
	EMADEQUACAO(4, "EM ADEQUAÇÃO"),
	CONCLUIDO(5, "CONCLUÍDO");
	
	private int cod;
	private String descricao;

	private TipoStatus(int cod, String descricao) {
	 this.cod = cod;
	 this.descricao = descricao;
	 }
	public int getCod() {
	 return cod;
	 }

	public String getDescricao() {
	 return descricao;
	 }

	public static TipoStatus toEnum(Integer id) {

	 if (id == null) {
	 return null;
	 }

	 for (TipoStatus x : TipoStatus.values()) {
	 if (id.equals(x.getCod())) {
	 return x;
	 }
	 }
	 throw new IllegalArgumentException("Id inválido " + id);
	 }
}
