package com.licio.cursomc.domain;

import javax.persistence.Entity;

import com.licio.cursomc.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Integer numeDeParcelas;

	public PagamentoComCartao() {
	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);
		this.numeDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeDeParcelas() {
		return numeDeParcelas;
	}

	public void setNumeDeParcelas(Integer numeDeParcelas) {
		this.numeDeParcelas = numeDeParcelas;
	}
}

