package com.algaworks.encodev.service.notificacao.sms;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.algaworks.encodev.model.TipoNotificacao;
import com.algaworks.encodev.service.notificacao.NotificacaoException;
import com.algaworks.encodev.service.notificacao.NotificadorCliente;
import com.algaworks.encodev.service.notificacao.util.Notificador;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

@Notificador(TipoNotificacao.SMS)
public class NotificadorSms implements NotificadorCliente {

	private static final Logger logger = Logger.getLogger(NotificadorSms.class);
	
	@Override
	public void notificar(String destinatario, String mensagem) {
		System.out.println("Notificador sms");
		/*String ACCOUNT_SID = "AC2f9a8975401091325e41c17cfc0c8f49";
		String AUTH_TOKEN = "cc11c1a2f5937b66529d716232457f48";
		
		TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);
		 
	    List<NameValuePair> params = new ArrayList<>();
	    params.add(new BasicNameValuePair("Body", mensagem));
	    params.add(new BasicNameValuePair("To", "+55" + destinatario));
	    params.add(new BasicNameValuePair("From", "+16176489004"));
	 
	    MessageFactory messageFactory = client.getAccount().getMessageFactory();
	    Message message;
		try {
			message = messageFactory.create(params);
			message.getSid();
		} catch (TwilioRestException e) {
			logger.error("Erro enviando SMS", e);
			throw new NotificacaoException("Erro enviando SMS");
		}*/
	}

}
