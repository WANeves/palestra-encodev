package com.algaworks.encodev.service.entrega.expressa;

import com.algaworks.encodev.model.TipoEntrega;
import com.algaworks.encodev.service.entrega.CalculadoraEntrega;
import com.algaworks.encodev.service.entrega.util.Calculadora;

@Calculadora(TipoEntrega.EXPRESSA)
public class CalculadoraEntregaExpressa implements CalculadoraEntrega {

	@Override
	public Integer calcular(Integer distancia) {
		float tempoPorKmEmMin = 0.12f;
		float tempoParaEntregaEmMin = distancia * tempoPorKmEmMin;
		
		float tempoParaEntregaEmHoras = tempoParaEntregaEmMin / 24;
		int margemSegurancaEmHoras = 24;
		tempoParaEntregaEmHoras += margemSegurancaEmHoras;
		
		return (int) Math.floor(tempoParaEntregaEmHoras) / 24;
	}
	
}
