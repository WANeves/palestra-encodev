package com.algaworks.encodev.service.entrega.util;

import javax.enterprise.util.AnnotationLiteral;

import com.algaworks.encodev.model.TipoEntrega;

public class CalculadoraQualifier extends AnnotationLiteral<Calculadora> implements Calculadora {

	private static final long serialVersionUID = 1L;
	
	private TipoEntrega value;
	
	public CalculadoraQualifier(TipoEntrega value) {
		this.value = value;
	}
	
	@Override
	public TipoEntrega value() {
		return value;
	}

}
