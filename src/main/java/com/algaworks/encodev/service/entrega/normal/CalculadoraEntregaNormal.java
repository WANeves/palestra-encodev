package com.algaworks.encodev.service.entrega.normal;

import com.algaworks.encodev.model.TipoEntrega;
import com.algaworks.encodev.service.entrega.CalculadoraEntrega;
import com.algaworks.encodev.service.entrega.util.Calculadora;

@Calculadora(TipoEntrega.NORMAL)
public class CalculadoraEntregaNormal implements CalculadoraEntrega {

	@Override
	public Integer calcular(Integer distancia) {
		float tempoPorKmEmMin = 0.95f;
		float tempoParaEntregaEmMin = distancia * tempoPorKmEmMin;

		float tempoParaEntregaEmHoras = tempoParaEntregaEmMin / 24;
		int margemSegurancaEmHoras = 48;
		tempoParaEntregaEmHoras += margemSegurancaEmHoras;

		return (int) Math.ceil(tempoParaEntregaEmHoras) / 24;
	}
	
}
