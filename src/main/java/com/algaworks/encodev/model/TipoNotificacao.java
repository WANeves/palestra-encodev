package com.algaworks.encodev.model;

import javax.enterprise.inject.Instance;

import com.algaworks.encodev.service.notificacao.NotificadorCliente;
import com.algaworks.encodev.service.notificacao.util.NotificadorQualifier;

public enum TipoNotificacao {

	EMAIL("e-mail") {
		@Override
		public NotificadorCliente obterNotificador(Instance<NotificadorCliente> notificadores) {
			return notificadores.select(new NotificadorQualifier(EMAIL)).get();
		}
	},
	SMS("SMS") {
		@Override
		public NotificadorCliente obterNotificador(Instance<NotificadorCliente> notificadores) {
			return notificadores.select(new NotificadorQualifier(SMS)).get();
		}
	};
	
	private String descricao;
	
	private TipoNotificacao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public abstract NotificadorCliente obterNotificador(Instance<NotificadorCliente> notificadores);
}
