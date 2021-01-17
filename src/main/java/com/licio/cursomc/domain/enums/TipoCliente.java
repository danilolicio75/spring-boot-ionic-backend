package com.licio.cursomc.domain.enums;

public enum TipoCliente {
	
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Juridica");

	private int cod;
	private String descrição;
	
	private TipoCliente(int cod, String descrição) {
		this.cod = cod;
		this.descrição = descrição;
	}

	public int getCod() {
		return cod;
	}

	public String getDescrição() {
		return descrição;
	}
	
	public static TipoCliente toEnum(Integer id) {

		if (id == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
			if (id.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido " + id);
	}
}
