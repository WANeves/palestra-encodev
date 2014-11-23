package com.algaworks.encodev.service;

import java.io.Serializable;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.algaworks.encodev.model.Entrega;
import com.algaworks.encodev.repository.Entregas;
import com.algaworks.encodev.service.entrega.CalculadoraEntrega;
import com.algaworks.encodev.service.notificacao.NotificadorCliente;

public class GestaoEntregasService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Entregas entregas;
	
	@Inject @Any
	private Instance<NotificadorCliente> notificadores;
	
	@Inject @Any
	private Instance<CalculadoraEntrega> calculadoras;
	
	public Entrega registrar(Entrega entrega) {
		Integer diasPrevistos = calcularDiasPrevistos(entrega);
		
		entrega.setDiasPrevistos(diasPrevistos);
		
		notificarCliente(entrega);
		
		return entregas.guardar(entrega);
	}

	private Integer calcularDiasPrevistos(Entrega entrega) {
		CalculadoraEntrega calculadoraEntrega = entrega.getTipoEntrega().obterCalculadora(calculadoras);
		Integer diasPrevistos = calculadoraEntrega.calcular(entrega.getDestino().getDistancia());
		return diasPrevistos;
	}

	public void notificarCliente(Entrega entrega) {
		String mensagem = "Entrega " + entrega.getTipoEntrega().getDescricao() + " chegará em " + entrega.getDiasPrevistos() + " dia(s)";
		NotificadorCliente notificadorCliente = entrega.getTipoNotificacao().obterNotificador(notificadores);
		notificadorCliente.notificar(entrega.getDestinatario(), mensagem);
	}

}
