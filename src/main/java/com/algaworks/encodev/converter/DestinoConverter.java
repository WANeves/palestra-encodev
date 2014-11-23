package com.algaworks.encodev.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.algaworks.encodev.model.Destino;
import com.algaworks.encodev.repository.Destinos;

@FacesConverter(forClass = Destino.class)
public class DestinoConverter implements Converter {

	@Inject
	private Destinos destinos;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		Destino destino = null;

		if (value != null) {
			destino = this.destinos.peloCodigo(new Long(value));
		}

		return destino;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value != null) {
			Long codigo = ((Destino) value).getCodigo();
			String retorno = (codigo == null ? null : codigo.toString());

			return retorno;
		}

		return "";
	}

}
