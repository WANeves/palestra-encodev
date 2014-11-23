package com.algaworks.encodev.service.notificacao.util;

import javax.enterprise.util.AnnotationLiteral;

import com.algaworks.encodev.model.TipoNotificacao;

public class NotificadorQualifier extends AnnotationLiteral<Notificador> implements Notificador {

	private static final long serialVersionUID = 1L;
	
	private TipoNotificacao value;
	
	public NotificadorQualifier(TipoNotificacao value) {
		this.value = value;
	}
	
	@Override
	public TipoNotificacao value() {
		return value;
	}

}
