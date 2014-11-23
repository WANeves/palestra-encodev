package com.algaworks.encodev.model;

import javax.enterprise.inject.Instance;

import com.algaworks.encodev.service.entrega.CalculadoraEntrega;
import com.algaworks.encodev.service.entrega.util.CalculadoraQualifier;

public enum TipoEntrega {

	NORMAL("Normal") {
		@Override
		public CalculadoraEntrega obterCalculadora(Instance<CalculadoraEntrega> calculadoras) {
			return calculadoras.select(new CalculadoraQualifier(NORMAL)).get();
		}
	},
	EXPRESSA("Expressa") {
		@Override
		public CalculadoraEntrega obterCalculadora(Instance<CalculadoraEntrega> calculadoras) {
			return calculadoras.select(new CalculadoraQualifier(EXPRESSA)).get();
		}
	};
	
	private String descricao;
	
	TipoEntrega(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public abstract CalculadoraEntrega obterCalculadora(Instance<CalculadoraEntrega> calculadoras);
	
}
