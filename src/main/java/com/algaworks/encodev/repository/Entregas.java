package com.algaworks.encodev.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.encodev.model.Entrega;
import com.algaworks.encodev.util.jpa.Transactional;

public class Entregas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	@Transactional
	public Entrega guardar(Entrega entrega) {
		return manager.merge(entrega);
	}

}
