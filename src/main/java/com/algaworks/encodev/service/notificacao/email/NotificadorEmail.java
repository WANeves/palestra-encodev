package com.algaworks.encodev.service.notificacao.email;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.algaworks.encodev.model.TipoNotificacao;
import com.algaworks.encodev.service.notificacao.NotificacaoException;
import com.algaworks.encodev.service.notificacao.NotificadorCliente;
import com.algaworks.encodev.service.notificacao.util.Notificador;
import com.microtripit.mandrillapp.lutung.MandrillApi;
import com.microtripit.mandrillapp.lutung.view.MandrillMessage;
import com.microtripit.mandrillapp.lutung.view.MandrillMessage.Recipient;

@Notificador(TipoNotificacao.EMAIL)
public class NotificadorEmail implements NotificadorCliente {

	private static final Logger logger = Logger.getLogger(NotificadorEmail.class);
	
	@Override
	public void notificar(String destinatario, String mensagem) {
		System.out.println("Notificador e-mail");
		/*MandrillApi mandrillApi = new MandrillApi("G42AOXcttO146hsxNEvtpg");
		
		MandrillMessage message = new MandrillMessage();
		message.setSubject("Encomenda registrada");
		message.setHtml(mensagem);
		message.setAutoText(true);
		message.setFromEmail("algaworks@algaworks.com");
		message.setFromName("AlgaWorks");
	
		ArrayList<Recipient> recipients = new ArrayList<Recipient>();
		Recipient recipient = new Recipient();
		recipient.setEmail(destinatario);
		recipients.add(recipient);
	
		message.setTo(recipients);
		try {
			mandrillApi.messages().send(message, false);
		} catch (Exception e) {
			logger.error("Erro enviando e-mail", e);
			throw new NotificacaoException("Erro enviando email");
		}*/
	}

}
