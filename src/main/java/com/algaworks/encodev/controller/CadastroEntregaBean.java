package com.algaworks.encodev.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.encodev.model.Destino;
import com.algaworks.encodev.model.Entrega;
import com.algaworks.encodev.model.TipoEntrega;
import com.algaworks.encodev.model.TipoNotificacao;
import com.algaworks.encodev.repository.Destinos;
import com.algaworks.encodev.service.GestaoEntregasService;
import com.algaworks.encodev.service.notificacao.NotificacaoException;
import com.algaworks.encodev.util.jsf.FacesMessages;

@Named
@ViewScoped
public class CadastroEntregaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Destinos destinos;

	private List<Destino> todosDestinos;
	
	@Inject
	private FacesMessages facesMessages;

	private Entrega entrega;
	
	@Inject
	private GestaoEntregasService gestaoEntregasService;
	
	public CadastroEntregaBean() {
		entrega = new Entrega();
	}
	
	public void inicializar() {
		todosDestinos = destinos.todos();
	}

	public void salvar() {
		try {
			entrega = gestaoEntregasService.registrar(entrega);
			
			facesMessages.info("Encomenda registrada com sucesso. Serão " + entrega.getDiasPrevistos() + " dia(s).");
			entrega = new Entrega();
		} catch (NotificacaoException e) {
			facesMessages.error(e.getMessage());
		}
	}

	public List<Destino> getTodosDestinos() {
		return todosDestinos;
	}

	public TipoEntrega[] getTiposEntregas() {
		return TipoEntrega.values();
	}

	public TipoNotificacao[] getTiposNotificacoes() {
		return TipoNotificacao.values();
	}

	public Entrega getEntrega() {
		return entrega;
	}
	
}
